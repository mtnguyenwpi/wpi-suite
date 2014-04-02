package edu.wpi.cs.wpisuitetng.modules.planningpoker.controller;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import edu.wpi.cs.wpisuitetng.janeway.config.ConfigManager;
import edu.wpi.cs.wpisuitetng.modules.core.models.User;
import edu.wpi.cs.wpisuitetng.network.Network;
import edu.wpi.cs.wpisuitetng.network.Request;
import edu.wpi.cs.wpisuitetng.network.models.HttpMethod;

/**
 * This class controls the sending of email notifications
 * The code for sending emails was based on code at
 * http://www.mkyong.com/java/javamail-api-sending-email-via-gmail-smtp-example/
 * 
 * @author nfbrown, szhou, dcwethern
 * 
 */
public class EmailController {    
    private UserRequestObserver observer;
    private User[] users;
    
    private String username = "team9wpi@gmail.com";  // GMail user name (just the part before "@gmail.com")
    private String password = "team9ftw"; // GMail password
    private String body;
    private String subject;
    private String to;
    
    /**
     * Creates a new EmailController class
     */
    public EmailController() {
        body = ConfigManager.getConfig().getUserName()
                + " has created a new Planning Poker game. Please open Janeway and make your estimates!";
        subject = "A planning poker game is about to begin";
        observer = new UserRequestObserver(this);
    }
    
    public void sendNotifications() {
        requestUsers();
    }
    
    /**
     * Sends an email to all users that are not the creator of the game
     */
    private void sendEmails() {
        System.out.println("Email addresses: " + this.to);  
                
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
            
            Message message = new MimeMessage(session);   
            try {
                message.setFrom(new InternetAddress(username));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(this.to));
                message.setSubject(subject);
                message.setText(body);
                
                Transport.send(message);
            } catch (MessagingException e) {
                System.err.println("Email notifications failed to send");
            }
    }
    
    
    /**
     * Requests query of all users related to the project
     */
    private void requestUsers() {
        final Request request = Network.getInstance().makeRequest("core/user",
                HttpMethod.GET);
        request.addObserver(observer); // add an observer to process the response
        request.send(); // send the request
    }
    
    /**
     * Sets the users list to the users received by the network
     * 
     * @param users
     *        The list of users received by UserRequestController
     */
    public void receivedUsers(User[] users) {
        if (users != null) {
            this.users = users;
            System.out.printf("Received %d users\n", users.length);
            parseEmailAddresses();
            sendEmails();
        }
        else {
            System.err.println("Users not received properly");
        }
    }
    
    /**
     * Sets the "to" field for the notification email with
     * the email addresses of all users that are not the creator of the game
     */
    private void parseEmailAddresses() {
        String s = "";
        int i;
        for (i = 0; i < users.length - 1; i++) {
            if (users[i].getEmail() != null
                    && !users[i].getUsername().equals(
                            ConfigManager.getConfig().getUserName())) {
                s += users[i].getEmail() + ",";
            }
        }
        if (users[i].getEmail() != null) {
            s += users[i].getEmail();
        }
        this.to = s;
    }
    
}

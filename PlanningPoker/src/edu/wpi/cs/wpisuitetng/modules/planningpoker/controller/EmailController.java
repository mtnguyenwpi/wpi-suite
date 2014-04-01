package edu.wpi.cs.wpisuitetng.modules.planningpoker.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class EmailController implements ActionListener {
    
    private UserRequestObserver observer;
    private User[] users;
    
    private String username = "team9wpi@gmail.com";  // GMail user name (just the part before "@gmail.com")
    private String password = "team9ftw"; // GMail password
    private String body;
    private String subject;
    private String to;
    
    public EmailController() {
        body = ConfigManager.getConfig().getUserName()
                + " has created a new Planning Poker game. Please open Janeway and make your estimates!";
        subject = "A planning poker game is about to begin";
        observer = new UserRequestObserver(this);
        requestUsers();
        parseEmails();
    }
    
    public void send() {
        
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
        
        try {
            
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("team9wpi@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);
            
            Transport.send(message);
            
            System.out.println("Done");
            
        }
        catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
    private void requestUsers() {
        final Request request = Network.getInstance().makeRequest("core/user",
                HttpMethod.GET);
        request.addObserver(observer); // add an observer to process the response
        request.send(); // send the request
    }
    
    public void receivedUsers(User[] users) {
        if (users != null) {
            this.users = users;
        }
        else {
            // TODO: error handling
        }
    }
    
    private void parseEmails() {
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
        to = s;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        send();
    }
    
}

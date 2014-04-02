/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.cs.wpisuitetng.modules.planningpoker.view.main;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;

import edu.wpi.cs.wpisuitetng.modules.planningpoker.model.GameModel;
import edu.wpi.cs.wpisuitetng.modules.planningpoker.model.GameRequirementModel;

/**
 * 
 * @author nfbrown
 */
public class VotePanel extends javax.swing.JPanel {
    
    private final static SimpleDateFormat date_format = new SimpleDateFormat(
            "MM/dd/yyyy hh:mm a");
    
    /**
     *
     */
    private static final long serialVersionUID = 6053116033835102214L;
    
    /**
     * Creates new form VotePanel
     */
    public VotePanel() {
        initComponents();
    }
    
    public void setRequirement(GameModel parent_game, GameRequirementModel req) {
        reqDescriptionTextArea.setText(req.getDescription());
        setRequirementName(req.getName());
        setRequirementType(req.getType());
        setEndDate(parent_game.getEndTime());
        // setRequirementProgress();
        
        
        ArrayList<String> deck = new ArrayList<>();
        deck.add("0.5");
        deck.add("1");
        deck.add("2");
        deck.add("3");
        deck.add("5");
        deck.add("10");
        
        estimateCardsPanel.removeAll();
        for (String estimate : deck) {
            JButton estimate_card = new JButton();
            // TODO: set card background image
            
            estimate_card.setText(estimate);
            estimate_card.setPreferredSize(new Dimension(80, 120));
            estimate_card.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    selectEstimateCard((JButton) e.getSource());
                }
            });
            
            estimateCardsPanel.add(estimate_card);
        }
        validate();
        repaint();
    }
    
    private void selectEstimateCard(JButton selected_card_button) {
        // TODO: submit estimate based on selected card
        for (Component c : estimateCardsPanel.getComponents()) {
            ((JButton) c).setEnabled(false);
        }
    }
    
    protected void setEndDate(Date date) {
        setEndTimeFieldText(VotePanel.date_format.format(date));
    }
    
    protected void setRequirementProgress(int num_completed, int total) {
        setCompletedVotesText(num_completed + "/" + total);
        setVotesProgressBarValue((int) (100f * num_completed / total));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed"
    // desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        
        estimateLabel = new javax.swing.JLabel();
        voteField = new javax.swing.JLabel();
        completedVotesField = new javax.swing.JLabel();
        endsLabel = new javax.swing.JLabel();
        endTimeField = new javax.swing.JLabel();
        votesProgressBar = new javax.swing.JProgressBar();
        
        estimateLabel.setText("Estimate:");
        
        voteField.setText("Votes:");
        
        completedVotesField.setText("0/0");
        
        endsLabel.setText("Ends at:");
        
        JLabel lblRequirement = new JLabel("Requirement:");
        
        JScrollPane scrollPane = new JScrollPane();
        
        JScrollPane scrollPane_1 = new JScrollPane();
        
        requirementNameLabel = new JLabel("");
        
        JLabel lblDescription = new JLabel("Description:");
        
        JLabel lblType = new JLabel("Type:");
        
        requirementType = new JLabel("");
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(layout
                .createParallelGroup(Alignment.TRAILING)
                .addGroup(
                        layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(
                                        layout.createParallelGroup(
                                                Alignment.LEADING)
                                                .addGroup(
                                                        Alignment.TRAILING,
                                                        layout.createSequentialGroup()
                                                                .addGroup(
                                                                        layout.createParallelGroup(
                                                                                Alignment.TRAILING)
                                                                                .addComponent(
                                                                                        scrollPane,
                                                                                        Alignment.LEADING,
                                                                                        GroupLayout.DEFAULT_SIZE,
                                                                                        585,
                                                                                        Short.MAX_VALUE)
                                                                                .addComponent(
                                                                                        scrollPane_1,
                                                                                        Alignment.LEADING,
                                                                                        GroupLayout.DEFAULT_SIZE,
                                                                                        585,
                                                                                        Short.MAX_VALUE)
                                                                                .addGroup(
                                                                                        Alignment.LEADING,
                                                                                        layout.createSequentialGroup()
                                                                                                .addComponent(
                                                                                                        endsLabel)
                                                                                                .addPreferredGap(
                                                                                                        ComponentPlacement.UNRELATED)
                                                                                                .addComponent(
                                                                                                        endTimeField))
                                                                                .addGroup(
                                                                                        Alignment.LEADING,
                                                                                        layout.createSequentialGroup()
                                                                                                .addComponent(
                                                                                                        lblRequirement)
                                                                                                .addGroup(
                                                                                                        layout.createParallelGroup(
                                                                                                                Alignment.LEADING)
                                                                                                                .addGroup(
                                                                                                                        layout.createSequentialGroup()
                                                                                                                                .addPreferredGap(
                                                                                                                                        ComponentPlacement.RELATED)
                                                                                                                                .addComponent(
                                                                                                                                        requirementNameLabel))
                                                                                                                .addGroup(
                                                                                                                        layout.createSequentialGroup()
                                                                                                                                .addGap(249)
                                                                                                                                .addComponent(
                                                                                                                                        lblType)
                                                                                                                                .addPreferredGap(
                                                                                                                                        ComponentPlacement.RELATED)
                                                                                                                                .addComponent(
                                                                                                                                        requirementType))))
                                                                                .addComponent(
                                                                                        estimateLabel,
                                                                                        Alignment.LEADING)
                                                                                .addComponent(
                                                                                        lblDescription,
                                                                                        Alignment.LEADING))
                                                                .addContainerGap())
                                                .addGroup(
                                                        layout.createSequentialGroup()
                                                                .addComponent(
                                                                        voteField)
                                                                .addPreferredGap(
                                                                        ComponentPlacement.RELATED)
                                                                .addComponent(
                                                                        votesProgressBar,
                                                                        GroupLayout.PREFERRED_SIZE,
                                                                        160,
                                                                        GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        ComponentPlacement.RELATED)
                                                                .addComponent(
                                                                        completedVotesField)))));
        layout.setVerticalGroup(layout
                .createParallelGroup(Alignment.LEADING)
                .addGroup(
                        layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(
                                        layout.createParallelGroup(
                                                Alignment.BASELINE)
                                                .addComponent(lblRequirement)
                                                .addComponent(
                                                        requirementNameLabel)
                                                .addComponent(lblType)
                                                .addComponent(requirementType))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(lblDescription)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(scrollPane,
                                        GroupLayout.PREFERRED_SIZE, 83,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(
                                        layout.createParallelGroup(
                                                Alignment.TRAILING)
                                                .addGroup(
                                                        layout.createParallelGroup(
                                                                Alignment.BASELINE)
                                                                .addComponent(
                                                                        voteField)
                                                                .addComponent(
                                                                        completedVotesField))
                                                .addComponent(
                                                        votesProgressBar,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE,
                                                        GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(
                                        layout.createParallelGroup(
                                                Alignment.BASELINE)
                                                .addComponent(endsLabel)
                                                .addComponent(endTimeField))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(estimateLabel)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(scrollPane_1,
                                        GroupLayout.DEFAULT_SIZE, 203,
                                        Short.MAX_VALUE).addContainerGap()));
        
        estimateCardsPanel = new JPanel();
        scrollPane_1.setViewportView(estimateCardsPanel);
        estimateCardsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        reqDescriptionTextArea = new JTextArea();
        reqDescriptionTextArea.setEditable(false);
        scrollPane.setViewportView(reqDescriptionTextArea);
        setLayout(layout);
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel completedVotesField;
    private javax.swing.JLabel endTimeField;
    private javax.swing.JLabel endsLabel;
    private javax.swing.JLabel estimateLabel;
    private javax.swing.JLabel voteField;
    private javax.swing.JProgressBar votesProgressBar;
    private JTextArea reqDescriptionTextArea;
    private JPanel estimateCardsPanel;
    private JLabel requirementNameLabel;
    private JLabel requirementType;
    
    protected void setRequirementName(String text) {
        requirementNameLabel.setText(text);
    }
    
    protected void setRequirementType(String text_1) {
        requirementType.setText(text_1);
    }
    
    protected String getCompletedVotesText() {
        return completedVotesField.getText();
    }
    
    protected void setCompletedVotesText(String text_2) {
        completedVotesField.setText(text_2);
    }
    
    protected int getVotesProgressBarValue() {
        return votesProgressBar.getValue();
    }
    
    protected void setVotesProgressBarValue(int value) {
        votesProgressBar.setValue(value);
    }
    
    protected String getEndTimeFieldText() {
        return endTimeField.getText();
    }
    
    protected void setEndTimeFieldText(String text_3) {
        endTimeField.setText(text_3);
    }
}
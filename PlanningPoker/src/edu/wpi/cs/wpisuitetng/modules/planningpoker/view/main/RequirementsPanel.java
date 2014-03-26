/**
 * *****************************************************************************
 * Copyright (c) 2013 -- WPI Suite
 * <p>
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * <p>
 *****************************************************************************
 */
package edu.wpi.cs.wpisuitetng.modules.planningpoker.view.main;

import edu.wpi.cs.wpisuitetng.modules.planningpoker.model.GameModel;

/**
 * The requirements panel of the planning poker GUI
 * <p>
 * 
 * @author llhunker, dbtrue
 */
public class RequirementsPanel extends javax.swing.JPanel {
    
    /**
     *
     */
    private static final long serialVersionUID = 7579915917240962935L;
    
    /**
     * Creates new form NewJPanel
     */
    public RequirementsPanel() {
        initComponents();
    }
    
    private GameModel game;
    
    public GameModel getGame() {
        return game;
    }
    
    public void setGame(GameModel game) {
        this.game = game;
        nameField.setText(game.getRequirement().getName());
        descriptionPane.setText(game.getRequirement().getDescription());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed"
    // desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        
        nameLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        descriptionLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionPane = new javax.swing.JTextPane();
        typeLabel = new javax.swing.JLabel();
        type = new javax.swing.JLabel();
        
        nameLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        nameLabel.setText("Name:");
        
        nameField.setEditable(false);
        nameField.setBackground(new java.awt.Color(255, 255, 255));
        
        descriptionLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        descriptionLabel.setText("Description:");
        
        descriptionPane.setEditable(false);
        jScrollPane1.setViewportView(descriptionPane);
        
        typeLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        typeLabel.setText("Type: ");
        typeLabel.setToolTipText("");
        
        type.setText("User Story");
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(
                        layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(
                                        layout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(
                                                        jScrollPane1,
                                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(nameField)
                                                .addGroup(
                                                        layout.createSequentialGroup()
                                                                .addGroup(
                                                                        layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(
                                                                                        nameLabel)
                                                                                .addComponent(
                                                                                        descriptionLabel)
                                                                                .addGroup(
                                                                                        layout.createSequentialGroup()
                                                                                                .addComponent(
                                                                                                        typeLabel)
                                                                                                .addPreferredGap(
                                                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(
                                                                                                        type)))
                                                                .addGap(0,
                                                                        343,
                                                                        Short.MAX_VALUE)))
                                .addContainerGap()));
        layout.setVerticalGroup(layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(
                        layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(nameLabel)
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameField,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(descriptionLabel)
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        165, Short.MAX_VALUE)
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(
                                        layout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(typeLabel)
                                                .addComponent(type))
                                .addContainerGap()));
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JTextPane descriptionPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel type;
    private javax.swing.JLabel typeLabel;
    // End of variables declaration//GEN-END:variables
}

package edu.wpi.cs.wpisuitetng.modules.planningpoker.view.main;

import javax.swing.table.DefaultTableModel;

import edu.wpi.cs.wpisuitetng.modules.planningpoker.model.GameModel;
import edu.wpi.cs.wpisuitetng.modules.planningpoker.model.GameRequirementModel;

/**
 * 
 * @author Sam Carlberg <slcarlberg@wpi.edu>
 */
public class CompletedRequirementPanel extends javax.swing.JPanel {
    
    /**
     * 
     */
    private static final long serialVersionUID = -7702704328142908459L;
    
    /**
     * Creates new form DetailPanel
     */
    public CompletedRequirementPanel() {
        // setup tablemodel (using autogenerted netbeans code)
        initComponents();
    }
    
    public void setRequirement(GameModel parent_game, GameRequirementModel req) {
        meanValueLabel.setText(String.format("%1.1f", req.getEstimateMean()));
        medianValueLabel
                .setText(String.format("%1.1f", req.getEstimateMedian()));
        // TODO: set vote results table values
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed"
    // desc="Generated Code">//GEN-BEGIN:initComponents
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private void initComponents() {
        
        jSeparator1 = new javax.swing.JSeparator();
        meanLabel = new javax.swing.JLabel();
        medianLabel = new javax.swing.JLabel();
        tableScrollPane = new javax.swing.JScrollPane();
        voteResultTable = new javax.swing.JTable();
        meanValueLabel = new javax.swing.JLabel();
        medianValueLabel = new javax.swing.JLabel();
        
        meanLabel.setText("Mean:");
        
        medianLabel.setText("Median:");
        
        tableScrollPane.setBackground(new java.awt.Color(153, 0, 102));
        
        voteResultTable.setModel(new DefaultTableModel(new Object[][] { { null,
                null }, }, new String[] { "User", "Estimate" }) {
            /**
             * 
             */
            private static final long serialVersionUID = -8613174878148410098L;
            Class[] columnTypes = new Class[] { String.class, String.class };
            
            @Override
            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });
        voteResultTable.getColumnModel().getColumn(0).setPreferredWidth(253);
        voteResultTable.getColumnModel().getColumn(1).setResizable(false);
        voteResultTable.getColumnModel().getColumn(1).setPreferredWidth(50);
        tableScrollPane.setViewportView(voteResultTable);
        
        meanValueLabel.setText("XYZ");
        
        medianValueLabel.setText("ABC");
        
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
                                                .addGroup(
                                                        layout.createSequentialGroup()
                                                                .addGap(16, 16,
                                                                        16)
                                                                .addGroup(
                                                                        layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(
                                                                                        meanLabel)
                                                                                .addComponent(
                                                                                        medianLabel))
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(
                                                                        layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                false)
                                                                                .addComponent(
                                                                                        medianValueLabel,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        30,
                                                                                        Short.MAX_VALUE)
                                                                                .addComponent(
                                                                                        meanValueLabel,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        Short.MAX_VALUE)))
                                                .addComponent(jSeparator1)
                                                .addComponent(
                                                        tableScrollPane,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        375, Short.MAX_VALUE))
                                .addContainerGap()));
        layout.setVerticalGroup(layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(
                        layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tableScrollPane,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        284, Short.MAX_VALUE)
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        10,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(
                                        layout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(meanLabel)
                                                .addComponent(meanValueLabel))
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(
                                        layout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(medianLabel)
                                                .addComponent(medianValueLabel))
                                .addGap(13, 13, 13)));
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel meanLabel;
    private javax.swing.JLabel meanValueLabel;
    private javax.swing.JLabel medianLabel;
    private javax.swing.JLabel medianValueLabel;
    private javax.swing.JScrollPane tableScrollPane;
    private javax.swing.JTable voteResultTable;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.cs.wpisuitetng.modules.planningpoker.view.main;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import edu.wpi.cs.wpisuitetng.modules.planningpoker.controller.SimpleListObserver;
import edu.wpi.cs.wpisuitetng.modules.planningpoker.model.GameListModel;

/**
 * 
 * @author Sonaxaton
 */
public class GamesListPanel extends javax.swing.JPanel {
    
    /**
     *
     */
    private static final long serialVersionUID = 4257983013648294131L;
    
    /**
     * Creates new form GamesListPanel
     */
    public GamesListPanel(GameListModel gameList) {
        initComponents();
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
        
        this.gameList = gameList;
        gameList.addListListener(new SimpleListObserver() {
            
            @Override
            public void listUpdated() {
                updateTable(GamesListPanel.this.gameList);
            }
        });
    }
    
    private GameListModel gameList;
    
    public GameListModel getGameList() {
        return gameList;
    }

    public void setGameList(GameListModel gameList) {
        this.gameList = gameList;
    }

    public JTable getGamesTable() {
        return jTable1;
    }
    
    private void updateTable(GameListModel gameList) {
        DefaultTableModel m = (DefaultTableModel) jTable1.getModel();
        for (int i = m.getRowCount(); i >= 0; i--) {
            m.removeRow(i);
        }
        for (int i = 0; i < gameList.getNumGames(); i++) {
            m.addRow(new Object[] { gameList.getStatuses()[i].name(),
                    gameList.getGames()[i].getName() });
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed"
    // desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                
                }, new String[] { "", "Game" }) {
            /**
             * 
             */
            private static final long serialVersionUID = 3706659002343757832L;
            Class[] types = new Class[] { java.lang.Object.class,
                    java.lang.String.class };
            boolean[] canEdit = new boolean[] { false, false };
            
            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
            
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(30);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(30);
            jTable1.getColumnModel().getColumn(1).setMinWidth(100);
        }
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 465,
                Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 320,
                Short.MAX_VALUE));
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

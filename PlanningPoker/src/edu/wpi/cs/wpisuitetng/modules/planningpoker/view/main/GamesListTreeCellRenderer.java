package edu.wpi.cs.wpisuitetng.modules.planningpoker.view.main;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import edu.wpi.cs.wpisuitetng.modules.planningpoker.model.GameModel;
import edu.wpi.cs.wpisuitetng.modules.planningpoker.view.ImageLoader;

public class GamesListTreeCellRenderer extends DefaultTreeCellRenderer {
    
    /**
     * 
     */
    private static final long serialVersionUID = -2728918517590604079L;
    
    public GamesListTreeCellRenderer() {
    }
    
    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value,
            boolean sel, boolean expanded, boolean leaf, int row,
            boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf,
                row, hasFocus);
        
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
        
        if (node.getUserObject() instanceof GameModel) {
            ImageIcon icon = null;
            
            GameModel game = (GameModel) node.getUserObject();
            
            switch (game.getStatus()) {
                case COMPLETE:
                    icon = new ImageIcon(
                            ImageLoader.getImage("GameCompleted.png"));
                    break;
                case PENDING:
                    icon = new ImageIcon(
                            ImageLoader.getImage("GameInProgress.png"));
                    break;
            }
            
            if (icon != null) {
                setIcon(icon);
            }
        }
        
        return this;
    }
    
}

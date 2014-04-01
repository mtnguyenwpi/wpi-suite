package edu.wpi.cs.wpisuitetng.modules.planningpoker.view.main;

import java.awt.Component;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import edu.wpi.cs.wpisuitetng.modules.planningpoker.model.GameModel;

public class GamesListTreeCellRenderer extends DefaultTreeCellRenderer {
    
    /**
     * 
     */
    private static final long serialVersionUID = -2728918517590604079L;
    
    private ImageIcon test_icon;
    
    public GamesListTreeCellRenderer(ImageIcon test_icon) {
        this.test_icon = test_icon;
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
            
            // TODO: set game status icon
            
            icon = test_icon;
            
            if (icon != null) {
                setIcon(icon);
            }
        }
        
        return this;
    }
    
}

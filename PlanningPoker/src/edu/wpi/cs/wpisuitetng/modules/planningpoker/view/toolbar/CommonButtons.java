/*******************************************************************************
 * Copyright (c) 2013 -- WPI Suite
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * TODO: Contributors' names
 ******************************************************************************/

package edu.wpi.cs.wpisuitetng.modules.planningpoker.view.toolbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import edu.wpi.cs.wpisuitetng.janeway.gui.container.toolbar.ToolbarGroupView;
import edu.wpi.cs.wpisuitetng.modules.planningpoker.PlanningPoker;
import edu.wpi.cs.wpisuitetng.modules.planningpoker.view.ImageLoader;

/**
 * this is an example of buttons
 * 
 * @author llhunker, blammeson, nfbrown
 * 
 */
public class CommonButtons extends ToolbarGroupView {
    /**
     * 
     */
    private static final long serialVersionUID = -2589339467561118867L;
    
    private JButton newGameButton;
    
    private final JPanel contentPanel = new JPanel();
    
    public CommonButtons() {
        super(""); // not sure if this is needed
        
        newGameButton = new JButton("<html>Create<br/>Game</html>");
        newGameButton.setIcon(ImageLoader.getIcon("NewGame.png"));
        
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));
        setPreferredWidth(175);
        // Adding functionality to new game button, not sure if this is where
        // this should go --nfbrown
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlanningPoker.getViewController().addNewGameTab();
            }
        });
        
        newGameButton.setHorizontalAlignment(SwingConstants.CENTER);
        
        contentPanel.add(newGameButton);
        contentPanel.setOpaque(false);
        
        this.add(contentPanel);
    }
    
}

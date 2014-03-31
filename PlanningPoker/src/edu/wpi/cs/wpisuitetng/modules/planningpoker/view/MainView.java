/*******************************************************************************
 * Copyright (c) 2013 -- WPI Suite
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    TODO: Contributors' names
 ******************************************************************************/
package edu.wpi.cs.wpisuitetng.modules.planningpoker.view;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JTabbedPane;

import edu.wpi.cs.wpisuitetng.modules.planningpoker.view.main.AllGamesViewPanel;
import edu.wpi.cs.wpisuitetng.modules.planningpoker.view.main.EditGamePanel;
import edu.wpi.cs.wpisuitetng.modules.requirementmanager.view.ClosableTabComponent;
import edu.wpi.cs.wpisuitetng.modules.requirementmanager.view.iterations.IterationOverviewPanel;
import edu.wpi.cs.wpisuitetng.modules.requirementmanager.view.overview.OverviewPanel;

/**
 * This is the main panel of the planning poker GUI
 * 
 * @author llhunker, blammeson, nfbrown, dbeckwith
 * 
 */
public class MainView extends JTabbedPane {
    /**
     * 
     */
    private static final long serialVersionUID = 7802378837976895569L;
    
    
    public MainView() {
        AllGamesViewPanel mainPanel = new AllGamesViewPanel();
        
        addTab("Games", null, mainPanel, null);
        
    }
    
    
}

package edu.wpi.cs.wpisuitetng.modules.planningpoker.view.main;

import java.awt.CardLayout;

import javax.swing.JPanel;

import edu.wpi.cs.wpisuitetng.modules.requirementmanager.models.Requirement;

public class RequirementDescriptionPanel extends JPanel {
    
    /**
     * 
     */
    private static final long serialVersionUID = 6869910614623975734L;
    
    /**
     * Create the panel.
     */
    public RequirementDescriptionPanel() {
        setLayout(new CardLayout(0, 0));
        
        VotePanel votePanel = new VotePanel();
        add(votePanel, "vote");
        
        CompletedRequirementPanel completedPanel = new CompletedRequirementPanel();
        add(completedPanel, "complete");
        
    }
    
    public void showPanel(Requirement req) {
        switch (req.getStatus()) {
            case COMPLETE:
                ((CardLayout) getLayout()).show(getParent(), "complete");
                break;
            case INPROGRESS:
                ((CardLayout) getLayout()).show(getParent(), "vote");
                break;
            default:
                break;
        }
    }
    
}

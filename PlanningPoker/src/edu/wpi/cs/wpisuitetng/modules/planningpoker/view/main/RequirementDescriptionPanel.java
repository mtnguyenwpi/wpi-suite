package edu.wpi.cs.wpisuitetng.modules.planningpoker.view.main;

import java.awt.CardLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import edu.wpi.cs.wpisuitetng.modules.core.models.User;
import edu.wpi.cs.wpisuitetng.modules.planningpoker.model.Estimate;
import edu.wpi.cs.wpisuitetng.modules.planningpoker.model.GameRequirementModel;
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
        
        //TODO temporary dummy change to test Completed Requirement Panel
        ArrayList<Estimate> e = new ArrayList<Estimate>();
        e.add(new Estimate(new User("joe", "joe", "password", 1), 25));
        e.add(new Estimate(new User("bob", "bob", "password", 2), 30));
        e.add(new Estimate(new User("frank", "frank", "password", 1), 20));
        GameRequirementModel g = new GameRequirementModel(-1,
                "Sample rquirement", "Sample description", "A type", e);
        CompletedRequirementPanel completedPanel = new CompletedRequirementPanel(
                g);
        add(completedPanel, "complete");
        
    }
    
    public void showPanel(Requirement req) {
        switch (req.getStatus()) {
            case COMPLETE:
                ((CardLayout) getLayout()).show(this, "complete");
                break;
            case INPROGRESS:
                ((CardLayout) getLayout()).show(this, "vote");
                break;
            default:
                break;
        }
    }
    
}

package edu.wpi.cs.wpisuitetng.modules.planningpoker.view.main;

import java.awt.CardLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import edu.wpi.cs.wpisuitetng.modules.core.models.User;
import edu.wpi.cs.wpisuitetng.modules.planningpoker.model.Estimate;
import edu.wpi.cs.wpisuitetng.modules.planningpoker.model.GameRequirementModel;

public class RequirementDescriptionPanel extends JPanel {
    
    /**
     * 
     */
    private static final long serialVersionUID = 6869910614623975734L;
    private VotePanel votePanel;
    private CompletedRequirementPanel completedPanel;
    
    /**
     * Create the panel.
     */
    public RequirementDescriptionPanel() {
        setLayout(new CardLayout(0, 0));
        
        votePanel = new VotePanel();
        add(votePanel, "vote");
        
        // TODO temporary dummy change to test Completed Requirement Panel
        ArrayList<Estimate> e = new ArrayList<Estimate>();
        e.add(new Estimate(new User("joe", "joe", "password", 1), 25));
        e.add(new Estimate(new User("bob", "bob", "password", 2), 30));
        e.add(new Estimate(new User("frank", "frank", "password", 1), 20));
        GameRequirementModel g = new GameRequirementModel(-1,
                "Sample rquirement", "Sample description", "A type", e);
        completedPanel = new CompletedRequirementPanel(g);
        add(completedPanel, "complete");
        
    }
    
    public void showPanel(GameRequirementModel req) {
        /*
         * switch (req.) { case COMPLETE: ((CardLayout) getLayout()).show(this,
         * "complete"); break; case INPROGRESS: ((CardLayout)
         * getLayout()).show(this, "vote"); break; default: break; }
         */
        // TODO: need a way of telling if a requirement is completed
    }
    
    public VotePanel getVotePanel() {
        return votePanel;
    }
    
    public CompletedRequirementPanel getCompletedPanel() {
        return completedPanel;
    }
    
}

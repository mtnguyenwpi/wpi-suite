/**
 * 
 */
package edu.wpi.cs.wpisuitetng.modules.planningpoker.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import edu.wpi.cs.wpisuitetng.modules.core.models.User;
import edu.wpi.cs.wpisuitetng.modules.planningpoker.model.Estimate;
import edu.wpi.cs.wpisuitetng.modules.planningpoker.model.GameListModel;
import edu.wpi.cs.wpisuitetng.modules.planningpoker.model.GameModel;
import edu.wpi.cs.wpisuitetng.modules.planningpoker.model.GameModel.GameStatus;
import edu.wpi.cs.wpisuitetng.modules.planningpoker.model.GameModel.GameType;
import edu.wpi.cs.wpisuitetng.modules.planningpoker.model.GameRequirementModel;
import edu.wpi.cs.wpisuitetng.network.Network;
import edu.wpi.cs.wpisuitetng.network.Request;
import edu.wpi.cs.wpisuitetng.network.models.HttpMethod;

/**
 * This handles requests for games
 * 
 * @author Brett Ammeson, Andrew Han
 */
public class GetGamesController implements ActionListener {
    private GetGamesRequestObserver observer;
    private static GetGamesController instance;
    
    /**
     * Constructs the controller given a GameModel
     */
    private GetGamesController() {
        
        observer = new GetGamesRequestObserver(this);
    }
    
    /**
     * @return the instance of the GetGameController or creates one if it does
     *         not exist.
     */
    public static GetGamesController getInstance() {
        if (GetGamesController.instance == null) {
            GetGamesController.instance = new GetGamesController();
        }
        
        return GetGamesController.instance;
    }
    
    /**
     * Sends an HTTP request to store a game when the update button is pressed
     * 
     * @param e
     *            ActionEvent
     * 
     * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Send a request to the core to save this game
        final Request request = Network.getInstance().makeRequest(
                "planningpoker/game", HttpMethod.GET); // GET == read
        request.addObserver(observer); // add an observer to process the
                                       // response
        request.send(); // send the request
    }
    
    /**
     * Sends an HTTP request to retrieve all games
     */
    public void retrieveGames() {
        final Request request = Network.getInstance().makeRequest(
                "planningpoker/game", HttpMethod.GET); // GET == read
        request.addObserver(observer); // add an observer to process the
                                       // response
        request.send(); // send the request
    }
    
    /**
     * Add the given games to the local model (they were received from the
     * core). This method is called by the GetGamesRequestObserver
     * 
     * @param games
     *            array of games received from the server
     */
    public void receivedGames(GameModel[] games) {
        // Empty the local model to eliminate duplications
        GameListModel.getInstance().emptyModel();
        
        // Make sure the response was not null
        if (games != null) {
            //if (games[0].getID() != -1) {
                // add the games to the local model
                for (GameModel singleGame : games) {
                    GameListModel.getInstance().addGame(singleGame);
                }
           // }
        }

		// test completed game
		ArrayList<GameRequirementModel> testReqs = new ArrayList<GameRequirementModel>() {
			{
				add(new GameRequirementModel(0, "Test Requirement 1",
						"The cow", "User story"));
				add(new GameRequirementModel(1, "Test Requirement 2",
						"Elepahnt", "User story"));
				add(new GameRequirementModel(2, "Test Requirement 3", "queso",
						"User story"));
			}
		};
        GameModel testGame = new GameModel(90, "Test Complete Game", "Our test", testReqs, new Date(), GameType.DISTRIBUTED, GameStatus.COMPLETE);
        User a = new User("User A", "AAA", "Yes", 0);
        User b = new User("User B", "BBB", "Yes", 0);
        User c = new User("Elephant", "EEE", "Yes", 0);
        User d = new User("Cheese", "CCC", "Yes", 0);
        testGame.addEstimate(new Estimate(b, 32), 0);
        testGame.addEstimate(new Estimate(c, 45), 0);
        testGame.addEstimate(new Estimate(a, 31), 0);

        testGame.addEstimate(new Estimate(c, 3), 1);
        testGame.addEstimate(new Estimate(b, 2), 1);
        testGame.addEstimate(new Estimate(a, 99), 2);
        testGame.addEstimate(new Estimate(d, 8), 1);     

        testGame.addEstimate(new Estimate(a, 3), 2);
        testGame.addEstimate(new Estimate(b, 2), 2);
        testGame.addEstimate(new Estimate(c, 99), 2);
        testGame.addEstimate(new Estimate(d, 8), 2);        
        
        GameListModel.getInstance().addGame(testGame);
        
    }
}

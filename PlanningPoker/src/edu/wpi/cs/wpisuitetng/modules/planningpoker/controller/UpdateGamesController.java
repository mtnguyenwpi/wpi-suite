/**
 * Controller for updating games
 * 
 * @author Brett Ammeson
 * 
 */

package edu.wpi.cs.wpisuitetng.modules.planningpoker.controller;

import edu.wpi.cs.wpisuitetng.modules.planningpoker.model.GameListModel;
import edu.wpi.cs.wpisuitetng.network.Network;
import edu.wpi.cs.wpisuitetng.network.Request;
import edu.wpi.cs.wpisuitetng.network.models.HttpMethod;

public class UpdateGamesController {
    
    private static UpdateGamesController instance;
    private UpdateGamesRequestObserver observer;
    
    /**
     * Construct an UpdateGamesController for the given model, view pair
     */
    private UpdateGamesController() {
        observer = new UpdateGamesRequestObserver(this);
    }
    
    /**
     * 
     * @return the instance of the UpdateGamesController or creates one if it
     *         does not exist.
     */
    public static UpdateGamesController getInstance() {
        if (UpdateGamesController.instance == null) {
            UpdateGamesController.instance = new UpdateGamesController();
        }
        
        return UpdateGamesController.instance;
    }
    
    /**
     * This method updates a game on the server.
     * 
     * @param newGame
     *            is the game to be updated on the server.
     */
    public void updateGame(GameListModel newGame) {
        Request request = Network.getInstance().makeRequest(
                "planningpoker/game", HttpMethod.POST); // POST == update
        // request.setBody(newGame.toJSON()); // put the new game in the body of
        // the request
        request.addObserver(observer); // add an observer to process the
                                       // response
        request.send();
    }
}

package edu.wpi.cs.wpisuitetng.modules.planningpoker.controller;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import edu.wpi.cs.wpisuitetng.modules.planningpoker.model.GameListModel;
import edu.wpi.cs.wpisuitetng.modules.planningpoker.model.GameModel;
import edu.wpi.cs.wpisuitetng.modules.planningpoker.model.GameModel.GameStatus;
import edu.wpi.cs.wpisuitetng.modules.planningpoker.model.GameModel.GameType;

public class GetGamesControllerTest {
    
    static GetGamesController instance;
    static GameModel nullGame;
    static GameModel game1;
    static GameModel game2;
    static GameModel game3;
    static GameModel game4;
    static GameListModel list;
    static GameModel[] gamesToAdd;
    
    @BeforeClass
    static public void setUpBeforeClass(){
        instance = GetGamesController.getInstance();
        nullGame = new GameModel();
        game1 = new GameModel(1, "Test Game 1", "Live Game that just ended", null, new Date(), GameType.LIVE, GameStatus.COMPLETE);
        game2 = new GameModel(2, "Test Game 2", "Distributed Game that will end in 5 seconds", null, new Date(System.currentTimeMillis()+5000), GameType.DISTRIBUTED, GameStatus.PENDING);
        game3 = new GameModel(3, "Test Game 3", "Live Game with end time in 10 seconds, but already manually ended", null, new Date(System.currentTimeMillis()+10000), GameType.LIVE, GameStatus.COMPLETE);
        game4 = new GameModel(4, "Test Game 4", "Distributed Game that has end time 10 seconds ago but hasn't been updated to be complete yet", null, new Date(System.currentTimeMillis()-10000), GameType.DISTRIBUTED, GameStatus.PENDING);
        list = GameListModel.getInstance();
        gamesToAdd = new GameModel[] {game1, game2, game3, game4};
    }
    
    @Test
    public void testGetInstance() {
        assertEquals("A new instance is not the same as the previous instance", instance, GetGamesController.getInstance());
    }
    
    @Test
    public void testReceivedGames() {
        instance.receivedGames(new GameModel[] {game1, game2, game3, game4});
        assertTrue(GameListModel.getInstance().getGames().contains(game1));
        assertTrue(GameListModel.getInstance().getGames().contains(game2));
        assertTrue(GameListModel.getInstance().getGames().contains(game3));
        assertTrue(GameListModel.getInstance().getGames().contains(game4));
    }
    
}

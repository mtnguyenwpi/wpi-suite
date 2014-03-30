package edu.wpi.cs.wpisuitetng.modules.planningpoker.view;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import edu.wpi.cs.wpisuitetng.modules.planningpoker.model.GameListModel;
import edu.wpi.cs.wpisuitetng.modules.planningpoker.model.GameModel;
import edu.wpi.cs.wpisuitetng.modules.planningpoker.model.GameModel.GameStatus;
import edu.wpi.cs.wpisuitetng.modules.planningpoker.model.GameModel.GameType;
import edu.wpi.cs.wpisuitetng.modules.planningpoker.view.main.GamesListPanel;

public class GamesListPanelTest {
    
    GamesListPanel panel;
    GameListModel model;
    
    @Before
    public void setup() {
        model = new GameListModel();
        model.addGame(new GameModel(23, "Test Game", "This game is a test",
                null, new Date(), GameType.LIVE, GameStatus.PENDING));
        model.addGame(new GameModel(25, "Test Game 2",
                "This game is also a test", null, new Date(),
                GameType.DISTRIBUTED, GameStatus.COMPLETE));
        panel = new GamesListPanel();
    }
    
    @Test
    public void testSetGameList() {
        panel.setGameList(model);
    }
    
}

package edu.wpi.cs.wpisuitetng.modules.planningpoker.model;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import edu.wpi.cs.wpisuitetng.modules.planningpoker.controller.SimpleListObserver;
import edu.wpi.cs.wpisuitetng.modules.planningpoker.view.main.GamesListPanel;

public class GameListModelTest {
    static GameListModel instance;
    
    @BeforeClass
    static public void setUpBefore(){
        instance = GameListModel.getInstance();
    }
    
    @Test
    public void testGetInstance() {
        assertEquals("A new instance is not the same as the previous instance", instance, GameListModel.getInstance());
    }
    
    @Test
    public void testAddListListener(){
        SimpleListObserver slo = new SimpleListObserver() {  
            @Override
            public void listUpdated() {}
        };
        instance.addListListener(slo);
        assertTrue(instance.getObservers().contains(slo));
    }
}

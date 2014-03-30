package edu.wpi.cs.wpisuitetng.modules.planningpoker.model;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import edu.wpi.cs.wpisuitetng.Session;
import edu.wpi.cs.wpisuitetng.exceptions.NotFoundException;
import edu.wpi.cs.wpisuitetng.exceptions.WPISuiteException;
import edu.wpi.cs.wpisuitetng.modules.core.models.Project;
import edu.wpi.cs.wpisuitetng.modules.core.models.Role;
import edu.wpi.cs.wpisuitetng.modules.core.models.User;
import edu.wpi.cs.wpisuitetng.modules.planningpoker.model.GameModel.GameStatus;
import edu.wpi.cs.wpisuitetng.modules.planningpoker.model.GameModel.GameType;

public class GameEntityManagerTest {
    
    MockData db;
    User existingUser;
    GameModel existingGame;
    Session defaultSession;
    String mockSsid;
    GameEntityManager manager;
    GameModel newGame;
    User bob;
    Session adminSession;
    Project testProject;
    Project otherProject;
    
    @Before
    public void setUp() {
        User admin = new User("admin", "admin", "1234", 27);
        admin.setRole(Role.ADMIN);
        testProject = new Project("test", "1");
        otherProject = new Project("other", "2");
        mockSsid = "abc123";
        adminSession = new Session(admin, testProject, mockSsid); 
        existingUser = new User("joe", "joe", "1234", 2);       
        existingGame = new GameModel(1, "Existing Game", "something", null, new Date(System.currentTimeMillis() - 100000), GameType.DISTRIBUTED, GameStatus.PENDING);       
        defaultSession = new Session(existingUser, testProject, mockSsid);
        newGame = new GameModel(-1, "New Game", "A new game", null, new Date(System.currentTimeMillis() - 100000), GameType.DISTRIBUTED, GameStatus.PENDING);  
        
        db = new MockData(new HashSet<Object>());
        db.save(existingGame, testProject);
        db.save(existingUser);
        db.save(admin);
        manager = new GameEntityManager(db);
    }
    
    @Test
    public void testMakeEntity() throws WPISuiteException {
        GameModel created = manager.makeEntity(defaultSession, newGame.toJSON());
        assertEquals(2, created.getID()); // IDs are unique across projects
        assertEquals("New Game", created.getName());
        assertSame(db.retrieve(GameModel.class, "id", 2).get(0), created);
    }
    
    @Test
    public void testGetEntity() throws NotFoundException {
        GameModel[] games = manager.getEntity(defaultSession, "1");
        assertSame(existingGame, games[0]);
    }
    
}

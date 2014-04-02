package edu.wpi.cs.wpisuitetng.modules.planningpoker.controller;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * @author Andrew
 *
 */
public class AddGameControllerTest {
    
    static AddGameController instance;
    
    @BeforeClass
    static public void setUpBeforeClass(){
        instance = AddGameController.getInstance();
    }
    
    @Test
    public void testGetInstance() {
        assertEquals("A new instance is not the same as the previous instance", instance, AddGameController.getInstance());
    }
    
}

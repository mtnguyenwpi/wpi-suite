package edu.wpi.cs.wpisuitetng.modules.planningpoker.controller;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

import edu.wpi.cs.wpisuitetng.modules.planningpoker.model.GameListModel;
import edu.wpi.cs.wpisuitetng.modules.planningpoker.model.GameModel;
import edu.wpi.cs.wpisuitetng.modules.planningpoker.model.MockNetwork;
import edu.wpi.cs.wpisuitetng.modules.planningpoker.view.MainView;
import edu.wpi.cs.wpisuitetng.modules.planningpoker.view.ToolbarView;
import edu.wpi.cs.wpisuitetng.modules.planningpoker.view.main.NewGamePanel;
import edu.wpi.cs.wpisuitetng.network.Network;
import edu.wpi.cs.wpisuitetng.network.configuration.NetworkConfiguration;

public class ViewControllerTest {
    
    @Test
    public void testAddNewGameTab() {
        MainView mv = new MainView();
        ViewController vc = new ViewController(mv, new ToolbarView());
        int before = mv.getTabCount();
        vc.addNewGameTab();
        Assert.assertEquals(before+1, mv.getTabCount());
        Assert.assertSame("New Game", mv.getTitleAt(before));
    }
    
    @Test
    public void testSaveNewGame() {
        Network.initNetwork(new MockNetwork());
        Network.getInstance().setDefaultNetworkConfiguration(
                new NetworkConfiguration("http://wpisuitetng"));
        MainView mv = new MainView();
        ViewController vc = new ViewController(mv, new ToolbarView());
        int index = mv.getTabCount();
        vc.addNewGameTab();
        NewGamePanel ngp = (NewGamePanel) mv.getComponentAt(index);
        GetGamesController ggc = GetGamesController.getInstance();
        
        ngp.getGameDescription().nameField.setText("VC Test");
        ngp.getGameDescription().descriptionField.setText("VC Test description");
        vc.saveNewGame(ngp);
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ggc.retrieveGames();
        boolean VCName = false;
        for(GameModel i:GameListModel.getInstance().getGames()){
            System.out.println(i.getName());
            if (i.getName() == "VC Test") VCName = true;
        }
        
        Assert.assertTrue(VCName);
    }
    
}

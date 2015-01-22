package game.game;

import gameframework.game.Game;
import gameframework.game.GameConfiguration;
import gameframework.game.GameData;
import gameframework.game.GameDefaultImpl;
import gameframework.gui.GameWindow;

public class SurvivalGame {
	private Game game;
	private GameData data;
	private GameConfiguration config;
	private GameWindow window;
	
public SurvivalGame(){
	this.config = new GameConfiguration(18, 31, 32, 3);
	this.data = new GameData(this.config);
	this.window = new GameWindow(this.data.getCanvas(),this.config,this.data.getLife(),this.data.getScore());
	this.game = new GameSurvival(this.data);
}
public void start(){
	this.window.createGUI();
	this.game.start();
}
}

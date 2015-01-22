package game.game;

import gameframework.game.Game;
import gameframework.game.GameData;
import gameframework.game.GameDefaultImpl;
public class GameSurvival extends GameDefaultImpl{

	public GameSurvival(GameData data) {
		super(data);
		this.data.addLevel(new Level1(this.data));
	}

}

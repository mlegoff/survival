package game.game;

import java.net.URL;

import gameframework.drawing.GameUniverseViewPortDefaultImpl;
import gameframework.game.GameData;

public class SurvivalGameBoard extends GameUniverseViewPortDefaultImpl {

	public SurvivalGameBoard(GameData data) {
		super(data);
		// TODO Auto-generated constructor stub
	}
	@Override
	protected URL backgroundImage() {
		return backgroundImage("/images/background_image.gif");
	}


}

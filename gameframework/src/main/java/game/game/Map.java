package game.game;

import java.awt.Graphics;

import gameframework.drawing.Drawable;
import gameframework.drawing.GameCanvas;
import gameframework.game.GameEntity;
import gameframework.motion.blocking.MoveBlockerChecker;
import gameframework.motion.blocking.MoveBlockerCheckerDefaultImpl;

public abstract class Map implements GameEntity, Drawable {
	
	protected Case[][] map;
	protected MoveBlockerChecker blocker = new MoveBlockerCheckerDefaultImpl();
	protected abstract void init(int[][] map, int size, GameCanvas canvas);

	public void draw(Graphics g) {
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				map[i][j].draw(g);
			}
		}

}
	
}
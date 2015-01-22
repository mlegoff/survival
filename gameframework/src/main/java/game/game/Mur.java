package game.game;

import java.awt.Rectangle;

import gameframework.drawing.GameCanvas;
import gameframework.game.GameEntity;
import gameframework.motion.blocking.MoveBlocker;

public class Mur extends Case implements MoveBlocker,GameEntity {

	public Mur(int x, int y, GameCanvas canvas, String filename) {
		super(x, y, filename, canvas);
	}

	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(this.x,this.y,RENDERING_SIZE,RENDERING_SIZE);
	}

}

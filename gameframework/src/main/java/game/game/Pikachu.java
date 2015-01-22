package game.game;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Point2D;


import gameframework.drawing.Drawable;
import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.motion.overlapping.Overlappable;
import gameframework.game.GameEntity;
import gameframework.drawing.SpriteManagerDefaultImpl;
import gameframework.motion.GameMovable;
import gameframework.drawing.SpriteManager;

public class Pikachu extends GameMovable implements Drawable, GameEntity,
Overlappable{
	protected final SpriteManager spriteManager;
	public static final int RENDERING_SIZE = 16;
	protected boolean ismoving= true;
	
	public Pikachu(GameCanvas canvas){
		spriteManager = new SpriteManagerDefaultImpl(new DrawableImage("/images/pika.gif",canvas),RENDERING_SIZE,6);
		spriteManager.setTypes(
				"up", "left", "right",
				"down","static");
		
	}

	@Override
	public Rectangle getBoundingBox() {
		int a = RENDERING_SIZE/2;
		return (new Rectangle((int)getPosition().getX()+a, (int)getPosition().getY()+a, 1, 1));
	}

	@Override
	public void draw(Graphics g) {
		String spriteType = "";
		Point2D tmp = getSpeedVector().getDirection();
		if (tmp.getX() == 1) {
			spriteType += "right";
		} else if (tmp.getX() == -1) {
			spriteType += "left";
		} else if (tmp.getY() == 1) {
			spriteType += "down";
		} else if (tmp.getY() == -1) {
			spriteType += "up";
		} else {
			spriteType = "static";
			spriteManager.reset();
			this.ismoving = false;
		}
		spriteManager.setType(spriteType);
		int a = RENDERING_SIZE/2;
		g.drawRect((int)getPosition().getX()+a-2, (int)getPosition().getY()+a-2, 3, 3);
		Point2D p = getPosition();
		spriteManager.draw(g, new Point((int)p.getX(),(int)p.getY()));
	}

	@Override
	public void oneStepMoveAddedBehavior() {
		if (this.ismoving) {
			spriteManager.increment();
		}
		
	}
}

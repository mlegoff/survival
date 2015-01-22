package gameframework.base;

import gameframework.motion.GameMovable;
import gameframework.motion.GameMovableDriver;

import java.awt.Point;
import java.awt.Rectangle;

public class ObservableMovable extends GameMovable {
	
	public ObservableMovable(GameMovableDriver driver, Point position) {
		super(driver);
		this.setPosition(position);
	}

	public Rectangle getBoundingBox() {
		return new Rectangle(10,10,10,10);
	}

	public void oneStepMoveAddedBehavior() {
		
	}

}

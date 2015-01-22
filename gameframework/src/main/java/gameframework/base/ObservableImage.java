package gameframework.base;

import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;

import java.awt.Graphics;
import java.awt.Point;

public class ObservableImage extends DrawableImage{

	private Point position;
	
	public ObservableImage(String filename, GameCanvas canvas, Point position) {
		super(filename, canvas);
		this.position = position;
	}
	
	public void draw(Graphics graphics) {
		canvas.drawImage(graphics, image, (int)this.position.getX(), (int)this.position.getY());
	}
	
	public void setPosition(Point position) {
		this.position = (Point)position.clone();
	}

}

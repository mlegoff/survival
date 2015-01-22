package game.game;

import java.awt.Graphics;

import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;

public abstract class Case {
	
	protected DrawableImage image;
	protected int x,y;
	public static final int RENDERING_SIZE = 16;
	public Case(int x, int y, String filename, GameCanvas canvas) {
		this.x = x;
		this.y = y;
		this.image = new DrawableImage(filename, canvas,x,y);
	}
	
	public void draw(Graphics g) {
		this.image.draw(g);
	}
	
	

}

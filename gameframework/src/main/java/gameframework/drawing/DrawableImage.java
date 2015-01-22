package gameframework.drawing;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Point;
import java.awt.Toolkit;
import java.net.URL;

public class DrawableImage implements Drawable {
	protected Image image;
	protected GameCanvas canvas;
	protected Point point;

	public DrawableImage(URL imageUrl, GameCanvas gameCanvas) {
		this.point = new Point(0,0);
		this.canvas = gameCanvas;
		if (imageUrl == null) {
			throw new IllegalArgumentException("Null imageUrl parameter");
		}
		handleImage(imageUrl);
	}
	public DrawableImage(URL imageUrl, GameCanvas gameCanvas,int x,int y) {
		this.point = new Point(x,y);
		this.canvas = gameCanvas;
		if (imageUrl == null) {
			throw new IllegalArgumentException("Null imageUrl parameter");
		}
		handleImage(imageUrl);
	}
	public DrawableImage(URL imageUrl, GameCanvas gameCanvas,Point p) {
		this.point = p;
		this.canvas = gameCanvas;
		if (imageUrl == null) {
			throw new IllegalArgumentException("Null imageUrl parameter");
		}
		handleImage(imageUrl);
	}
	
	/**
	 * Use a MediaTracker to load the image in the canvas, and throw an
	 * exception if there is a problem
	 * 
	 * @param imageUrl
	 *            is the path to the image
	 */
	protected void handleImage(URL imageUrl) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		image = toolkit.createImage(imageUrl);
		MediaTracker tracker = canvas.createMediaTracker();
		tracker.addImage(image, 0);
		try {
			tracker.waitForAll();
			if (tracker.isErrorAny()) {
				throw new IllegalArgumentException(
						"Problem while loading an image " + imageUrl);
			}
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public DrawableImage(String filename, GameCanvas canvas) {
		this(DrawableImage.class.getResource(filename), canvas);
	}
	public DrawableImage(String filename, GameCanvas canvas,int x,int y) {
		
		this(DrawableImage.class.getResource(filename), canvas,x,y);
	}
	public DrawableImage(String filename, GameCanvas canvas,Point p) {
		
		this(DrawableImage.class.getResource(filename), canvas,(int)p.getX(),(int)p.getY());
	}
	public Image getImage() {
		return image;
	}

	@Override
	public void draw(Graphics graphics) {
		canvas.drawImage(graphics, image,(int)point.getX(), (int)point.getY());
	}

	public int getWidth() {
		return getImage().getWidth(null);
	}

	public int getHeight() {
		return getImage().getHeight(null);
	}
	public void setPosition(Point p){
		this.point = p;
	}
	public void setPosition(int x, int y){
		this.point = new Point(x,y);
	}
}

package drawingTool;

import java.awt.Color;
import java.awt.Point;

public class Ostrich implements LocatedRectangle {
	private Head ostrichHead;
	private Body ostrichBody;
	private Point location;
	private Color outer;
	private int bodySize;

// instanciate with a location	
	public Ostrich(int size, int x, int y, Color skin, Color inner, Color outer) {
		location = new Point(x, y);
		bodySize = size;
		this.outer = outer;
		ostrichHead = new Head(size / 3, skin);
		ostrichBody = new Body(size, skin, inner, outer);

	}

// instanciate with a point
	public Ostrich(int size, Point location, Color skin, Color inner, Color outer) {
		this.location = location;
		bodySize = size;
		this.outer = outer;
		ostrichHead = new Head(size / 3, skin);
		ostrichBody = new Body(size, skin, inner, outer);

	}

// no location provided
	public Ostrich(int size, Color skin, Color inner, Color outer) {
		location = null;
		bodySize = size;
		this.outer = outer;
		ostrichHead = new Head(size / 3, skin);
		ostrichBody = new Body(size, skin, inner, outer);

	}

	public void addHat(Hat hat) {
		hat.drawRegular();
	}

	public void drawAt(int x, int y) {
		ostrichHead.drawAt(x, y);
		ostrichBody.drawAt(x + bodySize / 3, y + (bodySize * 3 / 2 - bodySize / 5));

	}

	public Color getOuterColor() {
		return outer;
	}

	@Override
	public Point address() {
		// TODO Auto-generated method stub
		return location;
	}

	@Override
	public int width() {
		return ostrichBody.width() + ostrichHead.getWidth();
	}

	@Override
	public int height() {
		return ostrichHead.getHeight() + ostrichBody.getHeight();
	}

	@Override
	public void draw() {
		this.drawAt(location.x, location.y);

	}

}

package drawingTool;

public class OvalShape {
	private int width, height;
	
	public OvalShape(int width, int height) {
			this.width = width;
			this.height = height;
		
	}
	
	public int width() {
		return width;
	}
	
	public void drawAt(int x, int y) {
		
		Drawing.pen().fillOval(x, y, width, height);
		
	}

	public int getHeight() {
		return height;
	}
	

}

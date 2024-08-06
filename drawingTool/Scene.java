package drawingTool;
import graphicState.State;

import java.awt.Dimension;
import java.util.ArrayList;



import java.awt.Point;
import java.awt.Toolkit;

public class Scene {
	//settings
	private final int maxSize = 150; // > 150 colission detection hangs the program
	private int minSize, sizeOffset;
	// object array
	private ArrayList<Ostrich> ostriches;
	private int ostrichNum;
	// object properties
	private int size;
	private Point location; 
	SkinColors skinColor; 
	FeatherColorsOuter outerColor;
	FeatherColorsInner innerColor;
	// screen parameters
	private Dimension resolution;
	int xBorder, yBorder;
	// state
	private static State sceneState; 

	public Scene(int objectNumber) {
		ostriches = new ArrayList<Ostrich>();
		ostrichNum = objectNumber;
		resolution = Toolkit.getDefaultToolkit().getScreenSize();
		if(ostrichNum > 15) {
			sizeOffset = maxSize/(ostrichNum/10);
			minSize = 20;
		}
		else 
			sizeOffset = maxSize;
			minSize = 50;
		 
		for(int i = 0; i < ostrichNum; i++) {
			Ostrich generated; 
			// generate a new object until there is no intersection in between
			do {
				// generate size and position
				size = RandomNumber.between(minSize, sizeOffset); // def min 50
				xBorder = (int)resolution.getWidth();
				yBorder = (int)resolution.getHeight(); 
				location = new Point(RandomNumber.between(60,xBorder-(sizeOffset*5/3 + ostrichNum)),RandomNumber.between(0,yBorder-(sizeOffset*3+sizeOffset/4+ostrichNum)));
				// randomly select colors from color sets
				skinColor = SkinColors.values()[RandomNumber.between(0, SkinColors.values().length - 1)];
				innerColor = FeatherColorsInner.values()[RandomNumber.between(0, FeatherColorsInner.values().length - 1)];
				outerColor = FeatherColorsOuter.values()[RandomNumber.between(0, FeatherColorsOuter.values().length - 1)];
				generated = new Ostrich(size, location, skinColor.getColor(), innerColor.getColor(), outerColor.getColor()); 
				
			} while(!doesNotIntersect(generated));
			ostriches.add(generated); 
		}
		sceneState = null; 
		
	}

	public boolean doesNotIntersect(Ostrich comparedOstrich) {
		for (Ostrich ostrich : ostriches) {
			if (ostrich.intersects(comparedOstrich, 0)) { //  / 2 works153
				return false;
			}
		}
		return true;
	}

	public Scene resetScene() {
		ostriches = new ArrayList<Ostrich>();
		if(ostrichNum > 15) {
			sizeOffset = maxSize/(ostrichNum/10);
			minSize = 20;
		}
		else 
			sizeOffset = maxSize;
			minSize = 50;
		 
		for(int i = 0; i < ostrichNum; i++) {
			Ostrich generated; 
			// generate a new object until there is no intersection in between
			do {
				// generate size and position
				size = RandomNumber.between(minSize, sizeOffset); // def min 50
				xBorder = (int)resolution.getWidth();
				yBorder = (int)resolution.getHeight(); 
				location = new Point(RandomNumber.between(60,xBorder-(sizeOffset*5/3 + ostrichNum)),RandomNumber.between(0,yBorder-(sizeOffset*3+sizeOffset/4+ostrichNum)));
				// randomly select colors from color sets
				skinColor = SkinColors.values()[RandomNumber.between(0, SkinColors.values().length - 1)];
				innerColor = FeatherColorsInner.values()[RandomNumber.between(0, FeatherColorsInner.values().length - 1)];
				outerColor = FeatherColorsOuter.values()[RandomNumber.between(0, FeatherColorsOuter.values().length - 1)];
				generated = new Ostrich(size, location, skinColor.getColor(), innerColor.getColor(), outerColor.getColor()); 
				
			} while(!doesNotIntersect(generated));
			ostriches.add(generated); 
		}
		sceneState = null;
		
		return this; 
		
	}
	public void drawScene() {
		for (Ostrich ostrich : ostriches) {
			ostrich.draw();
		}
	}
	
	public void addHatsRegular() {
		for (Ostrich ostrich : ostriches) {
			Hat hat = new Hat(ostrich, ostrich.getOuterColor());
			hat.drawRegular();
		}
	}
	
	public void addHatsBaseball() {
		for (Ostrich ostrich : ostriches) {
			Hat hat = new Hat(ostrich, ostrich.getOuterColor());
			hat.drawBaseball();
		}
	}
	
	public void addHatsMix() {
		int parameter; 
		for (Ostrich ostrich : ostriches) {
			parameter = RandomNumber.between(0, 1);
			if(parameter == 1) {
				Hat hat = new Hat(ostrich, ostrich.getOuterColor());
				hat.drawBaseball();
			} else {
				Hat hat = new Hat(ostrich, ostrich.getOuterColor());
				hat.drawRegular();	
			}
		}
			
	}
	
	public void setState (State state) {
		sceneState = state; 
	}
	
	public void toggleState() {
		sceneState.toggleState();
	}


}

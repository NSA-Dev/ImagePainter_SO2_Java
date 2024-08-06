/**
 * Provides a panel which can be used for drawing.
 * 
 * @author Björn Gottfried
 * @version 1.0
 */

// min size w 10 h 10

package drawingTool;

import java.awt.Graphics;
import javax.swing.JPanel;

import graphicState.BaseballState;
import graphicState.HatlessState;
import graphicState.MixState;
import graphicState.RegularState;

public class DrawingArea extends JPanel {
	private static final long serialVersionUID = 1L;

	private Scene testScene; // = new Scene(12);
	
	public DrawingArea() {
		testScene = new Scene(12); 
	}

	protected void paintComponent(Graphics pen) {
		super.paintComponent(pen);

		
		Drawing.set(pen);
		testScene.toggleState();
		
		

	}
	
	public void toggleDraw() {
		testScene.setState(HatlessState.getInstance(testScene));
		
	}

	public void toggleBBHats() {
		testScene.setState(BaseballState.getInstance(testScene));
		
	}

	public void toggleRegularHats() {
		testScene.setState(RegularState.getInstance(testScene));
		
	}
	
	public void toggleMixHats() {
		testScene.setState(MixState.getInstance(testScene));
		
	}
	
	public void toggleClear() {
		testScene = testScene.resetScene();
	}


}

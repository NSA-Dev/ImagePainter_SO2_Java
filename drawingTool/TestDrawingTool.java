/**
 * Provides a test application window with a panel.
 * 
 * @author Björn Gottfried
 * 
 * @version 1.0
 */

package drawingTool;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestDrawingTool implements ActionListener {
	private JFrame applicationFrame;
	private DrawingArea drawingArea;
	private Dimension screenSize;
	private JPanel panelButton;
	private GUI painterUI; 
	private JButton buttonExit, buttonDraw, buttonClear, buttonRegularHats, buttonBaseBallHats, buttonMixHats;

	public TestDrawingTool(String title) {

		
		//GUI 
		painterUI = new GUI(20, 10, 6);
		panelButton = painterUI.createPanel();
		buttonExit = painterUI.createButton("Exit", this);
		buttonDraw = painterUI.createButton("Draw", this); 
		buttonClear = painterUI.createButton("Clear", this); 
		buttonRegularHats = painterUI.createButton("Regular Hats", this);
		buttonBaseBallHats = painterUI.createButton("Baseball Hats", this);
		buttonMixHats = painterUI.createButton("Mix", this);

		// add buttons to the panel
		panelButton.add(buttonDraw);
		panelButton.add(buttonClear);
		panelButton.add(buttonRegularHats);
		panelButton.add(buttonBaseBallHats);
		panelButton.add(buttonMixHats);
		panelButton.add(buttonExit); 
		
		// frame
		applicationFrame = new JFrame(title);
		applicationFrame.setLayout(null);
		screenSize = applicationFrame.getToolkit().getScreenSize();
		applicationFrame.setBounds(0, 0, screenSize.width, screenSize.height);
		applicationFrame.add(panelButton); 
		applicationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		applicationFrame.setVisible(true);
		
		//test
		drawingArea = new DrawingArea(); 

	}

	public static void main(String[] args) {
		new TestDrawingTool("ImagePainter"); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonExit) {
			applicationFrame.dispose();
		} else if (e.getSource() == buttonDraw) {
			if (this.hasDrawingArea()) {
				applicationFrame.remove(drawingArea);
				drawingArea = new DrawingArea();
				drawingArea.setBounds(0, 70, screenSize.width, screenSize.height - 70);
				drawingArea.toggleDraw();
				applicationFrame.add(drawingArea);
				applicationFrame.revalidate(); 
				applicationFrame.repaint();
			} else {
				drawingArea.setBounds(0, 70, screenSize.width, screenSize.height - 70);
				drawingArea.toggleDraw();
				applicationFrame.add(drawingArea);
				applicationFrame.revalidate(); 
				applicationFrame.repaint();
			}
		} else if (e.getSource() == buttonClear) {
			if (this.hasDrawingArea()) {
				applicationFrame.remove(drawingArea);
				applicationFrame.revalidate(); 
				applicationFrame.repaint();
				drawingArea.toggleClear();
			}
		} else if (e.getSource() == buttonRegularHats) {
			if (!this.hasDrawingArea()) {
				;
			} else {
				drawingArea.toggleRegularHats();
				applicationFrame.revalidate(); 
				applicationFrame.repaint();
			}
		} else if (e.getSource() == buttonBaseBallHats) {
			if (!this.hasDrawingArea()) {
				;
			} else {
				drawingArea.toggleBBHats();
				applicationFrame.revalidate(); 
				applicationFrame.repaint();
			}
		} else if (e.getSource() == buttonMixHats) {
			if (!this.hasDrawingArea()) {
				;
			} else {
				drawingArea.toggleMixHats();
				applicationFrame.revalidate(); 
				applicationFrame.repaint();
			}
		}

	}

	private boolean hasDrawingArea() {
		for (var component : applicationFrame.getContentPane().getComponents()) {
			if (component instanceof DrawingArea) {
				return true;
			}
		}
		return false;
	}
}

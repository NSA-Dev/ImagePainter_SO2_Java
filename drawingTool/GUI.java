package drawingTool;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JPanel;

public class GUI implements ActionListener {

	// panel settings
	private int panelX;
	private int panelY;
	private int panelWidth;
	private final int panelHeight = 50;
	private final Color panelColor = new Color(147, 225, 249, 50);
	// button settings
	private int buttonX, buttonOffset;
	private int buttonY;
	private final int buttonWidth = 100;
	private final int buttonHeight = 50;

	public GUI(int panelX, int panelY, int buttonNumber) {
		this.panelX = panelX;
		this.panelY = panelY; 
		panelWidth = buttonWidth * buttonNumber;
		buttonX = panelX;
		buttonY = panelY;
		buttonOffset = 0;
		

	}

	public JPanel createPanel() {
		JPanel panel = new JPanel();
		panel.setBounds(panelX, panelY, panelWidth, panelHeight);
		panel.setBackground(panelColor);
		return panel;

	}

	public JButton createButton(String buttonText, TestDrawingTool painterInstance) {
		JButton button = new JButton();
		button.setBounds(buttonX+buttonOffset, buttonY, buttonWidth, buttonHeight);
		button.addActionListener(painterInstance);
		button.setText(buttonText);
		button.setFocusable(false);
		buttonOffset += 100; 
		return button;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}

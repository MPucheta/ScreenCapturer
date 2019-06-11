package shephardmp.screencapturer.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *  <p>
 * Class responsible for giving a insight to the user that a "screen capturing" process is going on.
 * As of 1.1, it doesn't have a legend and a background color, as it's too distracting when drawing a selection border.
 * </p>
 * <p> It's expected to add a class implementing MouseListener to it, to allow a mouse capture.</p>
 * <p> It's expected to add a class implementing MouseMouseListener to it, to allow a drawing of the selection border</p>
 * @author      Mauro Pucheta - "ShephardMP"
 * @version     1.1           
 * @since       1.0      
 * @see MouseCapturer
 */

public class Background extends JFrame {

	/**
	 * serial for the JFrame 
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * Background constructor
	 * <p>
	 * It creates an overhaul that occupies all the screen to signal that a screen capture process is taking place.
	 * </p>
	 * 
	 */
	public Background() {

		super();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screenSize);
		
		/*
		JLabel legend = new JLabel("Select Screen");
		legend.setForeground(new Color(255,26, 152, 255));
		legend.setFont(new Font("arial", Font.BOLD, 55));
		 */
		JPanel background = new JPanel();
		background.setOpaque(false);
		background.setPreferredSize(screenSize);
		//background.add(legend); //add legend to JPanel
		this.add(background); // adds panel to frame

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true); // this allows fullscreen
		this.setBackground(new Color(0,0,0,1)); // color in RGBA. It's required that alpha is at least 1 for capturing

		this.pack();
		this.setVisible(true);

	}
	
	


}

package shephardmp.screencapturer.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author      Mauro Pucheta - "ShephardMP"
 * @version     1.0.1            
 * @since       1.0      
 * 
 */

public class Background extends JFrame {

	/**
	 * serial for the JFrame 
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * Background constructor
	 * <p>
	 * It creates an overhaul that occupies all the screen with a legend "Select Screen" 
	 * to signal that you are indeed capturing the screen. 
	 * </p>
	 * 
	 */
	public Background() {

		super();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screenSize);
		JLabel legend = new JLabel("Select Screen");
		legend.setForeground(new Color(255,26, 152, 255));
		legend.setFont(new Font("arial", Font.BOLD, 55));

		JPanel background = new JPanel();
		background.setOpaque(false);
		background.setPreferredSize(screenSize);
		background.add(legend);
		this.add(background); // adds panel to frame

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true); // this allows fullscreen
		this.setBackground(new Color(26, 255, 244, 50)); // color in RGBA.

		this.pack();
		this.setVisible(true);

	}


}

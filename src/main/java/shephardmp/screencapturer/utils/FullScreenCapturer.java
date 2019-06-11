package shephardmp.screencapturer.utils;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;


/**
 * 
 * <p>
 * Captures the full screen.
 * </p> 
 * @author Mauro Pucheta - "ShephardMP"
 * @version 1.0
 * @serial 1.0
 
 */
public class FullScreenCapturer implements IScreenCapturer {

	/**
	 * 
	 * @see shephardmp.screencapturer.utils.IScreenCapturer#captureScreen()
	 */
	public Rectangle captureScreen() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //gets screen dimensions based on the device running this app.
		return new Rectangle(0, 0, screenSize.width, screenSize.height);
	}

}

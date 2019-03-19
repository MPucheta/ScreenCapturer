package shephardmp.screencapturer;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;


/**
 * 
 * 
 * @author Mauro Pucheta - "ShephardMP"
 * @version 1.0
 * @serial 1.0
 * <p>
 * Captures all the screen.
 * </p>
 */
public class FullScreenCapturer implements IScreenCapturer {

	/**
	 * 
	 * @see shephardmp.screencapturer.IScreenCapturer#captureScreen()
	 */
	public Rectangle captureScreen() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //gets screen dimensions based on the device running this app.
		return new Rectangle(0, 0, screenSize.width, screenSize.height);
	}

}

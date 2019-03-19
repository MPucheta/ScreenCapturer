package shephardmp.screencapturer;

import java.awt.Rectangle;


/**
 * 
 * @author Mauro Pucheta - "ShephardMP"
 * @version 1.0
 * @since 1.0
 * 
 */
public interface IScreenCapturer {
	
	/**
	 * <p>
	 * interface methods that describes that all implementing subclasses must, in one way or another, capture a Rectangle that describes a part of the screen.
	 * </p>
	 * @return a rectangle that describes a portion of the screen
	 */
	public Rectangle captureScreen();

}

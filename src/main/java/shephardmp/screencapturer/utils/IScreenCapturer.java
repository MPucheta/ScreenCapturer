package shephardmp.screencapturer.utils;

import java.awt.Rectangle;


/**
 * <p>Interface for differents ways to capture the screen. For example, a section of the screen or the full screen.</p> 
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

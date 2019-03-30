package shephardmp.screencapturer.utils;

import java.awt.Rectangle;

/**
 * 
 * 
 * @author Mauro Pucheta - "ShephardMP"
 * @version 1.0.1
 * @since 1.0
 * <p>
 * Captures a portion of the screen. 
 * </p>
 */
public class PartialScreenCapturer implements IScreenCapturer {

	/**
	 * 
	 * @see IScreenCapturer#captureScreen()
	 * <p>
	 * Apart from the contract with the interface. This method facilitates a manual mechanism to select a portion of the screen </p>
	 * <p>{@link MouseCapturer}</p>
	 * <p>{@link Background}k</p>
	 *
	 */
	public Rectangle captureScreen() {
	
		Rectangle capturedScreen=new Rectangle();
		Background spaceToCapture= new Background(); //it's necessary to create a "frame" to add a mouseCapturer. 
		boolean[] endCapture= {false}; //mutable boolean, which gets modified by MouseCapturer when you click and drag a rectangle to capture
	
		spaceToCapture.addMouseListener(new MouseCapturer(capturedScreen,endCapture));
		while(!endCapture[0]) {			
			//waiting for MouseCapturer to modify endCapture. It's necessary to induce some wait here. It probably isn't a problem
			//but i could do this using a mutex instead of a "busy waiting".
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		spaceToCapture.dispose(); //manual cleanup
		return capturedScreen;
	}

}

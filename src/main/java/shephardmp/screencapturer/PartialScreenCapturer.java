package shephardmp.screencapturer;

import java.awt.Rectangle;

import shephardmp.screencapturer.utils.Background;
import shephardmp.screencapturer.utils.MouseCapturer;

/**
 * 
 * 
 * @author Mauro Pucheta - "ShephardMP"
 * @version 1.0
 * @serial 1.0
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
			System.out.println(capturedScreen.toString() );	
		}
		
		System.out.println(capturedScreen.toString());
		spaceToCapture.dispose(); //manual cleanup
		return capturedScreen;
	}

}

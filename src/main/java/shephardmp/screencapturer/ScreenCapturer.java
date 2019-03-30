package shephardmp.screencapturer;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import shephardmp.screencapturer.utils.FullScreenCapturer;
import shephardmp.screencapturer.utils.IScreenCapturer;
import shephardmp.screencapturer.utils.ImageTransferable;
import shephardmp.screencapturer.utils.PartialScreenCapturer;

/**
 * 
 * @author Mauro Pucheta - "ShephardMP"
 * @version 1.0
 * @since 1.0
 * 
 * <p> An unified interface to use the library as a static class.</p>
 * 
 * <p>It allows the user to capture the screen as a Rectangle, as a BufferedImage or directly into de clipboard. </p>
 * 
 */

public class ScreenCapturer {

	/**
	 * A robot that captures the screen from a Rectangle.
	 */
	private static Robot imageCapturer=initRobot();
	

	private static Robot initRobot(){
		Robot out=null;
		try {
			out= new Robot();
		} catch (AWTException e) {
			System.out.println("An error occurred when trying to initialize capturer");
			e.printStackTrace();
		}
		return out;
	}
	
	
	/**
	 * Allows to manually capture a part of the screen
	 * @return A rectangle which represents the selection. The rectangle has absolute (x,y) coordinates.
	 */
	public static Rectangle captureScreen() {
		
		IScreenCapturer capturer= new PartialScreenCapturer();
		return capturer.captureScreen();
	} 
	
	/**
	 * Allows to capture the whole screen
	 * @return A rectangle which represents the selection. The rectangle starts at (0,0) and has the width and height according to the device's current resolution
	 */
	
	public static Rectangle captureFullScreen() {
			
		IScreenCapturer capturer= new FullScreenCapturer();
		return capturer.captureScreen();
		} 
	
	
	/**
	 * Allows to get an image from a Rectangle.
	 * <p>
	 * It's intended that the Rectangle comes from {@link ScreenCapturer#captureScreen()} or {@link ScreenCapturer#captureFullScreen()}
	 * </p>
	 * @param portionOfScreen a Rectangle that describes a part of the screen
	 * @return an Image to further process or save to disk.
	 * @see ImageIO#write(java.awt.image.RenderedImage, String, File)
	 */
	public static BufferedImage captureImageFromRectangle(Rectangle portionOfScreen) {
		
			
			BufferedImage img= imageCapturer.createScreenCapture(portionOfScreen);
			return img;
	}
	
	/**
	 * Allows to manually capture an image from the screen
	 * @return an Image to further process or save to disk.
	 * @see ImageIO#write(java.awt.image.RenderedImage, String, File)
	 */
	public static BufferedImage captureImageFromScreen() {
		

		BufferedImage img= imageCapturer.createScreenCapture(captureScreen());
		return img;
	}
	
	/**
	 * Allows to get a screenshot
	 * @return an Image to further process or save to disk.
	 * @see ImageIO#write(java.awt.image.RenderedImage, String, File)
	 */
	public static BufferedImage captureImageFromFullScreen() {
		
		
		BufferedImage img= imageCapturer.createScreenCapture(captureFullScreen());
		return img;
	}

	/**
	 * Allows to manually capture an image from the screen into the <a href="https://en.wikipedia.org/wiki/Clipboard_(computing)"> CLIPBOARD </a>
	 */
	public static void captureImageFromScreenToClipboard() {
		
		Clipboard clipBoard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipBoard.setContents(new ImageTransferable(captureImageFromScreen()), null);
		
	}
	
	/**
	 * Gets a Screenshot to the <a href="https://en.wikipedia.org/wiki/Clipboard_(computing)"> CLIPBOARD </a>
	 */
	public static void captureImageFromFullScreenToClipboard() {
		
		Clipboard clipBoard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipBoard.setContents(new ImageTransferable(captureImageFromFullScreen()), null);
		
	}
	
}

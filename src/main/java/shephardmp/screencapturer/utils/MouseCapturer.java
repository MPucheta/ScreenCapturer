package shephardmp.screencapturer.utils;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 * 
 * 
 * @author Mauro Pucheta - "ShephardMP"
 * @version 1.0
 * @since 1.0
 *
 * <p>
 * A MouseCapturer has the responsibility of capturing a portion of the screen with the mouse. 
 * It works by setting the (x,y) coordinates that defines a Rectangle when pressing and releasing a mouse button
 * </p>
 */
public class MouseCapturer implements MouseListener{

	/**
	 * The rectangle which represents a portion of screen to be selected. 
	 * It's meant to be a reference to an external {@link Rectangle} which bounds are modified by MouseCapturer.
	 */
	private Rectangle selected;
	
	/**
	 * starting upper-left X coordinate of the selected screen.
	 */
	private int startingX;
	/**
	 * starting upper-left Y coordinate of the selected screen. 
	 * 
	 */
	private int startingY;
	
	/**
	 * A work-around for a mutable boolean. It's intended to be true after
	 * a single click or a complete left-click, drag and drop sequence.
	 * 
	 */
	private boolean[] endCapture;
	
	/**
	 * Constructs a MouseCapturer object which will modify the state and values of the parameters (AS SIDE EFFECTS)
	 * @param r which's {@link Rectangle#height Rectangle#width} will be modified
	 * @param endCapture Mutable boolean to signal the end of the mouse capturing sequence.
	 */
	public MouseCapturer(Rectangle r,boolean[] endCapture) {
		super();
		this.selected=r; 
		this.endCapture=endCapture;
		
	}
	
	/**
	 * Method that activates whenever ANY mouse button is "clicked" (press and release in quick manner)
	 * <p>
	 * A click event fires this method which establishes that the selection is a 1-pixel wide square
	 * (Which starts at the (X,Y) coordinates that were clicked.
	 * </p>
	 * @param e A mouse event (left,middle or right click)
	 * 
	 */
	
	public void mouseClicked(MouseEvent e) {
		
		startingX=e.getX();
		startingY=e.getY();
		selected.setBounds(startingX, startingY, 1, 1);
		endCapture[0]=true;
	}

	
	/**
	 * {@inheritDoc}
	 */
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * {@inheritDoc}
	 */
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Method that activates whenever ANY mouse button is pressed 
	 * <p>
	 * Sets the starting (x,y) at the corresponding pixel.
	 * </p>
	 * @param e A mouse event (left,middle or right click press)
	 * 
	 */
	public void mousePressed(MouseEvent e) {
		startingX=e.getX();
		startingY=e.getY();
		selected.setLocation(startingX, startingY);
			
	}

	/**
	 * Method that activates whenever a mouse button is released.
	 * <p>
	 * When a button is released this method is executed and sets the bounds of the Rectangle that describes the portion of selected screen.
	 * </p>
	 * @param e A mouse event (left,middle or right button release)
	 * 
	 */
	public void mouseReleased(MouseEvent e) {
		//we have to do a change of coordinates in case that the starting (X,Y) happens to be the lower-right
		//section of the rectangle that represents the selected screen. We have to make it that the starting (x,y) are the top-left coordinates.
		int newX=0,newY=0;
		int mouseReleasedOnX=e.getX();
		int mouseReleasedOnY=e.getY();
		if(mouseReleasedOnX<startingX) { //this allows the rectangle to change regardless of it's starting point
			newX=startingX;
			startingX=mouseReleasedOnX;
		}else {
			newX=mouseReleasedOnX;
			
		}
		if(mouseReleasedOnY<startingY) {
			newY=startingY;
			startingY=mouseReleasedOnY;
		}else {
			newY=mouseReleasedOnY;
		}
		selected.setBounds(startingX, startingY,newX-startingX,newY-startingY);
		endCapture[0]=true;
	}
	
	

}

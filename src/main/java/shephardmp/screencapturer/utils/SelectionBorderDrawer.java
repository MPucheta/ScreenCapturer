package shephardmp.screencapturer.utils;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

/**
 * Class responsible for drawing the rectangle that represents the selected part of the screen
 * @author Mauro Pucheta - "ShephardMP"
 * @version 1.1
 * @since 1.1
 */
public class SelectionBorderDrawer implements MouseMotionListener,MouseListener {

	private static final Cursor CROSSHAIR_CURSOR = new Cursor(Cursor.CROSSHAIR_CURSOR);
	private static final Cursor DEFAULT_CURSOR = new Cursor(Cursor.DEFAULT_CURSOR);
	/**
	 * X coordinates of the first click
	 */
	private int startingX;
	/**
	 * Y coordinates of the first click
	 */
	private int startingY;
	
	/**
	 * the main frame in which we are drawing the rectangle
	 */
	private JFrame frameToDraw;
	/**
	 * the rectangle itself, which is the selected part of the screen. It's a subclass of JPanel
	 */
	private SelectionBorder selectionBorder;
	
	/**
	 * Creates a new SelectionBorderDrawer and sets the surface in which a rectangle will be drawn when dragging the mouse
	 * @param frameToDraw the surface to draw the rectangle
	 */
	public SelectionBorderDrawer(JFrame frameToDraw) {
		this.frameToDraw=frameToDraw;
		this.selectionBorder= new SelectionBorder(0,0,0,0);	
		this.frameToDraw.add(this.selectionBorder);
		frameToDraw.getContentPane().setCursor(CROSSHAIR_CURSOR);
	}

	
	/**
	 * Method called when mouse is dragged. It's responsible for drawing a rectangle when dragging occurs. It makes use of {@link SelectionBorder}
	 * @param e MouseEvent that represents a dragging action.
	 * 
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		
		int currentX=e.getX();
		int currentY=e.getY();
		
		int drawFromX,drawFromY,drawToX,drawToY;
		
		if(currentX<startingX) {
			drawFromX=currentX;
			drawToX=startingX;
		}else {
			drawFromX=startingX;
			drawToX=currentX;
		}
		
		if(currentY<startingY) {
			drawFromY=currentY;
			drawToY=startingY;
		}else {
			drawFromY=startingY;
			drawToY=currentY;
		}
		
		selectionBorder.redraw(drawFromX, drawFromY, drawToX, drawToY);
		frameToDraw.revalidate();
		frameToDraw.repaint();
	}

	

		
	
	/**
	 * sets x,y coordinates of the first click
	 */
	@Override
	public void mousePressed(MouseEvent e) {
	
		startingX=e.getX();
		startingY=e.getY();
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		frameToDraw.getContentPane().setCursor(DEFAULT_CURSOR);
		
	}

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void mouseEntered(MouseEvent e) {}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void mouseExited(MouseEvent e) {}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void mouseMoved(MouseEvent e) {}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void mouseClicked(MouseEvent e) {}

}

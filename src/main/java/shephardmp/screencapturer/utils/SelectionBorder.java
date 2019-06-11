package shephardmp.screencapturer.utils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class SelectionBorder extends JPanel {
	
	/**
	 * Serial UID for the JPanel
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * LeftTop x coordinate of the rectangle that represents the selection.
	 */
	private int X;
	/**
	 * LeftTop y coordinate of the rectangle that represents the selection.
	 */
	private int Y;
	/**
	 * width of the rectangle that represents the selection.
	 */
	private int WIDTH;
	/**
	 * height of the rectangle that represents the selection.
	 */
	private int HEIGHT;
	
	/**
	 * sets JPanel internals. Otherwise it's a blank panel that occupies the whole screen
	 */
	private void setupPanel() {
		setOpaque(false);
		setBackground(new Color(0, 0, 0, 0));
	}
	
	/**
	 * helper function to set width and height.
	 * @param fromX 
	 * @param fromY
	 * @param toX
	 * @param toY
	 */
	
	private void setWidthAndHeight(int fromX, int fromY, int toX, int toY) {
		this.WIDTH= Math.abs(toX-fromX);
		this.HEIGHT= Math.abs(toY-fromY);
	}
	
	/**
	 * Creates a new SelectionBorder, describing a portion of the screen. It's commonly initialized with 0's in all the parameters.
	 * @param fromX
	 * @param fromY
	 * @param toX
	 * @param toY
	 */
	public SelectionBorder(int fromX, int fromY, int toX, int toY) {
		setupPanel();
		X = fromX;
		Y = fromY;
		setWidthAndHeight(fromX, fromY, toX, toY);
		
	}
	
	/**
	 * Creates a new rectangle based on the values of the parameters, and redraws.
	 * @param fromX
	 * @param fromY
	 * @param toX
	 * @param toY
	 */
	public void redraw(int fromX, int fromY, int toX, int toY) {
		this.X=fromX;
		this.Y=fromY;
		setWidthAndHeight(fromX, fromY, toX, toY);
		repaint();
	
	}
	
	/**
	 * paints a rectangle based on the left-top coordinates (X,Y), a width and a height.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
	    super.paintComponent(g);
	    g2.setColor(Color.RED);
		g2.drawRect(X, Y, WIDTH, HEIGHT);

	}

}

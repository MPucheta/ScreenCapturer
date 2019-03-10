package shephardmp.screencapturer.utils;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class MouseHandler implements MouseListener {

	private Rectangle seleccionado;
	private int xComienzo,yComienzo;
	private boolean[] fin;
	public MouseHandler(Rectangle r,boolean[] fin) {
		super();
		this.seleccionado=r;
		this.fin=fin;
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
		xComienzo=e.getX();
		yComienzo=e.getY();
		seleccionado.setBounds(xComienzo, yComienzo, 1, 1);
		fin[0]=true;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		xComienzo=e.getX();
		yComienzo=e.getY();
		seleccionado.setLocation(xComienzo, yComienzo);
			
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		int xNuevo=0,yNuevo=0;
		int xCapturado=e.getX();
		int yCapturado=e.getY();
		if(xCapturado<xComienzo) {
			xNuevo=xComienzo;
			xComienzo=xCapturado;
		}else {
			xNuevo=xCapturado;
			
		}
		if(yCapturado<yComienzo) {
			yNuevo=yComienzo;
			yComienzo=yCapturado;
		}else {
			yNuevo=yCapturado;
		}
		seleccionado.setBounds(xComienzo, yComienzo,xNuevo-xComienzo,yNuevo-yComienzo);
		fin[0]=true;
	}

}

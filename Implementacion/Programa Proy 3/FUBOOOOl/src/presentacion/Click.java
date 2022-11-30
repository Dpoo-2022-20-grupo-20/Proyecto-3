package presentacion;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Click implements MouseListener{
	
	private JLabel label; 
	private Frames frame ; 
	Click(JLabel lable , Frames frame)
	{
		this.label= lable;
		this.frame=frame;
		
	}
		
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource()==label) 
		{frame.prev();}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class Frames extends JFrame {
		protected JPanel top ; 
		protected ImageIcon img   = new 	ImageIcon("src/images/PanelSuperior.jpg");
		protected ImageIcon err   = new 	ImageIcon("src/images/xix.jpeg") ;  ; 
		protected ImageIcon exit  = new 	ImageIcon("src/images/nooo.png"); 
		protected ImageIcon succes= new	    ImageIcon("src/images/ummmmn.png"); 
		protected ImageIcon latout= new 	ImageIcon("src/images/Alineacion.jpg"); 
		                                                   
		Frames() {
			JLabel top= new JLabel();
			this.setSize(1420,1069);
			ImageIcon img= new ImageIcon("src/images/PanelSuperior.jpg");
			img.setImage(img.getImage().getScaledInstance(this.getWidth(), 150, DO_NOTHING_ON_CLOSE));
			top.setIcon(img);
			//top.setVerticalAlignment(JLabel.TOP);
			ImageIcon Logo = new ImageIcon("src/images/Logo-mini.png");
			
			this.setIconImage(Logo.getImage());
			this.setLayout(new BorderLayout());
			
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setResizable(true);
			this.getContentPane().setBackground(new Color(0,0,0));
			
			//this.setVisible(true);//this.add(top);
			
			JPanel panel1= new JPanel();
		
			
			JLabel label1 = new JLabel(img);
		
			panel1.setBackground(new Color(64, 251, 128));
			panel1.add(label1);
			panel1.setPreferredSize(new Dimension(100,155));
			this.add(panel1,BorderLayout.NORTH);
			
            
            this.err = new ImageIcon(this.err.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH));
			this.exit= new ImageIcon(this.exit.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH));	
			this.succes= new ImageIcon(this.succes.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH));
		}
		
		public void prev() {}

}

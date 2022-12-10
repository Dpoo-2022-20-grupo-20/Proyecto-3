package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Users_menu extends Frames implements ActionListener{

	
	private JButton equipo; 
	private JButton fun;
	private JButton datos; 
	private JButton pasadas; 
	private JButton cerrar;
	private String[] text = {"Mi equipo","Ver funFacts","Datos de la liga","Ver ligas Pasadas","Salir"};
	
	
	Click mouse;
	public Users_menu() {
			super();	
			this.setTitle("Users_Menu");
			
			this.inital();
	
	}
	
	public void inital() 
	{
			this.equipo = new JButton();
			this.fun    = new JButton();
			this.datos  = new JButton();
			this.pasadas= new JButton();
			this.cerrar = new JButton();
			JButton[] butons= {equipo,fun,datos,pasadas,cerrar};
			JLabel label = new JLabel();
			Click mouse = new Click(label, this);
			label.setText(">>Volver<<");
			label.setForeground(Color.WHITE);
			label.addMouseListener(mouse);
			label.setFont(new Font("Araboto Bold",Font.BOLD,20));
		    this.add(label,BorderLayout.SOUTH);
		    
			JPanel botones = new JPanel();
			botones.setLayout(new GridLayout(5,1));
		    for (int i= 0 ;i< butons.length;i++) 
			{
				JButton but = butons[i];
				but.setText(text[i]);
				but.setFont(new Font("Araboto Bold",Font.BOLD,30));
				but.addActionListener(this);
				int x = this.getWidth()/2 -150 ;
				int y = this.getHeight()/2 - 220;	
				
				but.setBounds(x, y+(i*130), 300, 1);
				but.setBackground(Color.GREEN);
				
				botones.add(but);
			}
		    this.add(botones,BorderLayout.WEST);
		    this.setVisible(true);
	}
	
	
	
	@Override
	public void prev() {
		Jprincipal.getControlador().close_user();
		this.dispose();
		new Jprincipal();
	}
	
	
	public void second() {
			
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== this.equipo) 
		{this.dispose();
		 new team_Sel();}
		else if(e.getSource()== this.datos)
		{
			this.dispose();
			new Graficas();
			
		}
		else if (e.getSource()== this.fun) {}
		else if (e.getSource()== this.pasadas) {}
		else if (e.getSource()== this.cerrar) {this.prev();}
		
	}	
}

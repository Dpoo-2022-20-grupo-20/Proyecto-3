 package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Admin_menu extends Frames implements ActionListener {
	
	JButton partido; 
	JButton fun;
	JButton cerrar;
	String[] text = {"Añadir un Partido","Añadir datos curiosos","Cerrar la liga actual","Salir"};
	
	
	Click mouse;
	public Admin_menu() {
			super();	
			this.setTitle("Menu de Administrador");
			
			this.inital();
	
	}
		
	public void inital() 
	{
		
			
			System.out.println("asdasdadadadda");
			this.partido = new JButton();
			this.fun    = new JButton();
			this.cerrar = new JButton();
			JButton[] butons= {partido,fun,cerrar};
			JLabel label = new JLabel();
			Click mouse = new Click(label, this);
			label.setText(">>Volver<<");
			label.setForeground(Color.WHITE);
			label.addMouseListener(mouse);
			label.setFont(new Font("Araboto Bold",Font.BOLD,20));
		    this.add(label,BorderLayout.SOUTH);
		    
			JPanel botones = new JPanel();
			
			botones.setLayout(new GridLayout(3,1));
			
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
		    this.add(botones,BorderLayout.EAST);
		    this.setVisible(true);
	}
	
	
	
	@Override
	public void prev() {
		this.dispose();
		new Jprincipal();
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==this.partido) {
			this.dispose();
			new AddPartido();
		}
	}

}

package presentacion;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import Usuarios.App;
import controller.Controller;


public class Jprincipal extends Frames implements ActionListener{
	

		public static Controller  controlador ;   
	

		private String[] text = {"Login as Admin","Login as User","Register as User","Exit"};
		private JButton Logadmin ;
		private JButton Loguser ;
		private JButton Reguser ;
		private JButton Exit ;
		private JPanel panel;
		private JTextField user ;
		private JTextField clave; 
		private JButton confirmar  ; 
		
		public Jprincipal() {
			super();
			// TODO Auto-generated constructor stub
			this.Logadmin = new JButton();
			this.Loguser  = new JButton();
			this.Reguser  = new JButton();
			this.Exit	  = new JButton();
	        JButton[] butons= {Logadmin,Loguser,Reguser,Exit};
	        JPanel pan= new JPanel();
	        
	        this.setTitle("Menú Principal");
	        
	        pan.setLayout(new GridLayout(4,1));
	        
	        for (int i= 0 ;i< butons.length;i++) 
	        {
	            JButton but = butons[i];
	            but.addActionListener(this);
	            but.setText(text[i]);
	            but.addActionListener(this);
	            but.setBackground(Color.GREEN);
	            but.setFont(new Font("Aroboto",Font.BOLD,30));
	            int x = this.getWidth()/2 -150 ;
	            int y = this.getHeight()/2 + 120;
	            but.setBounds(x, y-(i*130), 300, 100);
	            but.setFocusable(false);
	            pan.add(but);
	            
	        }
	        this.add(pan,BorderLayout.WEST);
	        this.setVisible(true);
		}

		public static void main(String[] args) 
		{
				
			Jprincipal All = new Jprincipal();
			All.start();
		}

		public void start() {
			
			try {
				controlador = new Controller();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
						
			if (e.getSource()== this.Logadmin ) {info(0);
			this.resize(1419,1068);}
			else if (e.getSource()== this.Loguser) {this.info(1);
			this.resize(1419,1068);}
			else if (e.getSource()==this.Reguser) {this.info(2);
			this.resize(1419,1068);}
			else if (e.getSource()== this.confirmar) {
				System.out.println("adasdnaspdçásd");
				int act = Integer.parseInt( confirmar.getActionCommand());
				String user= this.user.getText();
				String clave= this.clave.getText();
				if (user != null && clave !=null) {
				 if (act==0) {
					if(controlador.get_adming(user, clave)) {
						this.dispose();
						new Admin_menu();
					}else {JOptionPane.showMessageDialog(null, "No se encuentra el admin o la clave está erronea", "Error", JOptionPane.ERROR_MESSAGE,this.err);
					prev();}}
				
				 else if (act ==1) {
					if(controlador.get_user(user, clave)) {this.dispose();
														   new Users_menu();}
					else{JOptionPane.showMessageDialog(null, "No se encuentra el usuario o la clave está erronea", "Error", JOptionPane.ERROR_MESSAGE,this.err);
					prev();}}
				 else if (act == 2) {
					 if(controlador.add_user(user, clave)) {
						JOptionPane.showMessageDialog(null, "Se agregó un nuevo usuario! ", "Succes",JOptionPane.INFORMATION_MESSAGE,this.succes);
					 }else{JOptionPane.showMessageDialog(null, "Ya existe el usuario", "Error", JOptionPane.ERROR_MESSAGE,this.err);}
					 		prev();}
				 else {System.out.println("how?");}
				}
				else {JOptionPane.showMessageDialog(null, "Ingrese todos los datos ", "Error", JOptionPane.ERROR_MESSAGE,this.err);}
				
			}
			else if (e.getSource()== this.Exit) {
				int ans= JOptionPane.showConfirmDialog(null, "Seguro quiere salir?", "Salir", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE,this.exit);
				if (ans == 0 ) {
				controlador.save();	
				this.dispose();}}
			
		}
	

		public static Controller getControlador() {
			return controlador;
		}

		
		/// No se muetra bien, toca cambiar el tamaño de la pantalla 		
		public void info(int opt) 
		{
			this.panel  = new JPanel();
			JPanel pre	= new JPanel();
			this.user   = new JTextField();
			this.confirmar = new JButton(); 
			this.clave  = new JTextField();
			JLabel la = new JLabel();
			pre.setLayout(new BorderLayout());
			la.setBounds(getBounds());
			la.setBackground(Color.BLACK);
			
			la.setOpaque(true);
			pre.add(panel,BorderLayout.CENTER);
			pre.add(la,BorderLayout.NORTH);
			pre.add(la,BorderLayout.SOUTH);
			pre.add(la,BorderLayout.WEST);
			pre.add(la,BorderLayout.EAST);
			panel.setLayout(new GridLayout(6,1));
			int i = 0;
			String[] dat= {"un Usuario","un Clave"};
			
			JTextField[] butonss= {user,clave};
			for(JTextField textfield : butonss) 
			{
				JLabel texto = new JLabel();
				texto.setForeground(Color.WHITE);
				texto.setFont(new Font("Araboto Bold",Font.BOLD,20));
				texto.setAlignmentX(CENTER_ALIGNMENT);
				texto.setText("Ingrese " + dat[i]);
				texto.setAlignmentX(JLabel.CENTER_ALIGNMENT);
				i++;
				panel.add(texto);
				textfield.setPreferredSize(new Dimension(250,40));
				textfield.setBounds(panel.getWidth()/2 - 250/2,panel.getHeight() -40 , 250, 40);
				textfield.setForeground(new Color(0x00FF00));
				textfield.setCaretColor(new Color(0x003F00));
				textfield.setBorder(BorderFactory.createLoweredBevelBorder());
				textfield.setBackground(Color.GRAY);
				panel.add(textfield);
			}
			panel.setBackground(Color.BLACK);
			
			
			JLabel label = new JLabel();
			label.setText(">>Volver<<");
			label.setForeground(Color.WHITE);
			
			Click mouse = new Click(label, this);
			label.addMouseListener(mouse);
			label.setFont(new Font("Araboto Bold",Font.BOLD,20));
			pre.setVisible(true);
			
			confirmar.setBounds(0, 0, 50, 40);
			confirmar.addActionListener(this);
			confirmar.setActionCommand(String.valueOf(opt));
			confirmar.setFont(new Font("Araboto Bold",Font.BOLD,20));
			confirmar.setForeground(new Color(31, 255, 26 ));
			
			confirmar.setText("Confirmar");
			confirmar.setBackground(new Color(34, 69, 33 ));
			confirmar.setBorder(BorderFactory.createEmptyBorder());
			panel.add(confirmar);
			panel.add(label);
			this.add(pre,BorderLayout.CENTER);
			
			
		}

		@Override
		public void prev() {
			this.panel.removeAll();
			this.dispose();
			new Jprincipal();
		}	

}


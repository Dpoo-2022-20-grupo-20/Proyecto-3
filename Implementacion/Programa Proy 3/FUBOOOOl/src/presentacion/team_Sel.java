package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Liga.Liga;

public class team_Sel extends Frames implements ActionListener{

	
	private JButton team1;
	private JButton team2;
	private JLabel  atras;
	private JLabel  chose; 
	private Click   back; 
	private JPanel  panel; 
	
	public team_Sel(){
		super();
		this.initial();
	}
	
	private void initial() {
		this.atras = new JLabel(); 
		this.back = new Click(this.atras,this); 
		this.atras.setText(">>Volver<<");
		this.atras.addMouseListener(back);
		this.atras.setForeground(Color.WHITE);
		this.atras.setFont(new Font("Araboto Bold",Font.BOLD,20));
		
		this.create_buttons();
		
		
		this.add(atras,BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	private void create_buttons() {
		this.panel = new JPanel();
		this.panel.setLayout(new GridLayout(3,1));
		this.team1 = new JButton();
		this.team2 = new JButton();
		
		this.chose = new JLabel();
		this.chose.setFont(new Font("Araboto Bold",Font.BOLD,30));
		this.chose.setBackground(Color.BLACK);
		this.chose.setForeground(new Color(0x7CE515));
		this.chose.setBorder(BorderFactory.createEmptyBorder());
		this.chose.setOpaque(true);
		
		JButton[] bot= {this.team1,this.team2};
		
		List<String> teams = Jprincipal.getControlador().get_teams();
		for(String names: teams) {
		System.out.println(teams);}
		for(JButton boton:bot) {
			
			boton.setActionCommand("2");
			boton.setFocusable(false);
	    	boton.addActionListener(this);
			boton.setFont(new Font("Araboto Bold",Font.BOLD,30));
			boton.setBackground(Color.BLACK);
			boton.setForeground(new Color(0x7CE515));
			boton.setBorder(BorderFactory.createEmptyBorder());
			 
		}
		
		if (teams.isEmpty()) {
			this.chose.setText("¡No tienes equipos!");
			this.team2.setText("No disponible");
			this.team2.setEnabled(false);
			this.team1.setText("Nuevo Equipo");
			this.team1.setActionCommand("1");
		}
		else {
			this.chose.setText("¡Escoje un equipo!");
			this.team1.setText(teams.get(0));
			if(teams.size()<2) {
				this.team2.setActionCommand("1");
				this.team2.setText("Nuevo Equipo");
			}else {
				this.team2.setText(teams.get(1));
				this.team2.setActionCommand("2");
			}
			
			
		}
		
		this.chose.setAlignmentX(CENTER_ALIGNMENT);
		this.chose.setAlignmentY(CENTER_ALIGNMENT);
		this.chose.setHorizontalTextPosition(JLabel.RIGHT);
		//
	
		this.panel.add(this.chose);
		this.panel.add(this.team1);
		this.panel.add(this.team2);
		this.panel.setVisible(true);
		
		this.add(this.panel,BorderLayout.CENTER);
	}
	
	@Override 
	public void prev() {
		this.dispose();
		new Users_menu();
	}

	public void next() {
		this.dispose();
		new Menu_Equipo();
		
	}	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		
		if(e.getSource()== this.team1) {
			if (e.getActionCommand().equals("2")) {
				System.out.println("asadiuasgbd");
				Jprincipal.getControlador().set_dream(0);
			}
		}else if(e.getSource()== this.team2) {
			if (e.getActionCommand().equals("2")) {
				Jprincipal.getControlador().set_dream(1);
			}
		}
		
		
		this.next();
		
		
		// TODO Auto-generated method stub
		
	}

}

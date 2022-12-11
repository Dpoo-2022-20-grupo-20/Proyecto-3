package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Graficas extends Frames implements ActionListener{
	JButton graph1; 
	JButton graph2;
	JButton graph3;
	JButton graph4;
	JButton graph5;
	JButton salir; 
	String[] text = {"Equipos y Jugadores","Por team","Por players","Compra", "Venta"};
	
	
	
	Click mouse;
	public Graficas() {
		super();
		this.setTitle("Graficas de datos importantes");
		
		this.initial();
		
	}
	
	
	
	
	private void initial() {
		
		// TODO Auto-generated method stub
		this.graph1 = new JButton();
		this.graph2 = new JButton();
		this.graph3 = new JButton();
		this.graph4 = new JButton();
		this.graph5 = new JButton();
		this.salir = new JButton();
		JButton[] buttons= {graph1,graph2,graph3,graph4,graph5};
		JLabel label = new JLabel();
		Click mouse = new Click(label, this);
		label.setText(">>Volver<<");
		label.setForeground(Color.WHITE);
		label.addMouseListener(mouse);
		label.setFont(new Font("Araboto Bold",Font.BOLD,20));
	    this.add(label,BorderLayout.SOUTH);
	    
	    
		JPanel botones = new JPanel();
		
		botones.setLayout(new GridLayout(5,1));
		
	    for (int i= 0 ;i< buttons.length;i++) 
		{
			JButton but = buttons[i];
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
		new Users_menu();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==this.graph1) {
			try {
				Map<String, Integer> dat = Jprincipal.getControlador().team_players();
				String team= Jprincipal.getControlador().nombre_best();
				List<String>s=new ArrayList<String>();
				List<Integer>v=new ArrayList<Integer>();
				int ee= 0;
				for(String fore: dat.keySet() ) {
					if(ee<10) {
						System.out.println(fore);
					s.add(fore);}
					ee++;
				}
				
				for(int fore: dat.values() ) {
					if(ee<20) {
						System.out.println(fore);
					v.add(fore);}
					ee++;
					
				}
				
				BarGraph ar = new BarGraph(v,s,team,"Jugadores","Puntaje",2);
				JPanel ne = new JPanel();
				this.add(ne,BorderLayout.CENTER);
				this.add(ar,BorderLayout.CENTER);	
				this.setVisible(true);
			
			}catch(NullPointerException er){
				JOptionPane.showMessageDialog(null, "No se encutra una posición, toca esperar a que se carguen partidos", "Error", JOptionPane.ERROR_MESSAGE,this.err);
			}
			
		}
		else if (e.getSource()==this.graph2) {

			Map<String, Integer> dat = Jprincipal.getControlador().tea_info();
			
			List<String>s=new ArrayList<String>();
			List<Integer>v=new ArrayList<Integer>();
			int ee= 0;
			for(String fore: dat.keySet() ) {
				if(ee<10) {
					System.out.println(fore);
				s.add(fore);}
				ee++;
			}
			
			for(int fore: dat.values() ) {
				if(ee<20) {
					System.out.println(fore);
				v.add(fore);}
				ee++;
				
			}
			
			BarGraph ar = new BarGraph(v,s,"Equipos","Equipo","Puntaje",1);
			JPanel ne = new JPanel();
			this.add(ne,BorderLayout.CENTER);
			this.add(ar,BorderLayout.CENTER);	
			this.setVisible(true);
			
		}
		else if (e.getSource()==this.graph3) {
			Map<String, Integer> dat = Jprincipal.getControlador().play_info();
			
			List<String>s=new ArrayList<String>();
			List<Integer>v=new ArrayList<Integer>();
			int ee= 0;
			for(String fore: dat.keySet() ) {
				if(ee<10) {
					System.out.println(fore);
				s.add(fore);}
				
				ee++;
			}
			
			for(int fore: dat.values() ) {
				if(ee<20) {
					System.out.println(fore);
				v.add(fore);}
				ee++;
				
			}
			
			BarGraph ar = new BarGraph(v,s,"Jugadores","Jugador","Puntaje",2);
			JPanel ne = new JPanel();
			this.add(ne,BorderLayout.CENTER);
			this.add(ar,BorderLayout.CENTER);	
			this.setVisible(true);
			
		}
		else if (e.getSource()==this.graph4) {
			Map<String, Integer> dat = Jprincipal.getControlador().get_compra();
			
			List<String>s=new ArrayList<String>();
			List<Integer>v=new ArrayList<Integer>();
			int ee= 0;
			for(String fore: dat.keySet() ) {
				if(ee<10) {
					System.out.println(fore);
				s.add(fore);}
				ee++;
			}
			
			for(int fore: dat.values() ) {
				if(ee<20) {
					System.out.println(fore);
				v.add(fore);}
				ee++;
				
			}
			
			BarGraph ar = new BarGraph(v,s,"Compras","Posición","Cantidad",3);
			JPanel ne = new JPanel();
			this.add(ne,BorderLayout.CENTER);
			this.add(ar,BorderLayout.CENTER);	
			this.setVisible(true);
			
		}else if(e.getSource()==this.graph5) {
			Map<String, Integer> dat = Jprincipal.getControlador().get_ventas();
			
			List<String>s=new ArrayList<String>();
			List<Integer>v=new ArrayList<Integer>();
			int ee= 0;
			for(String fore: dat.keySet() ) {
				if(ee<10) {
					System.out.println(fore);
				s.add(fore);}
				ee++;
			}
			
			for(int fore: dat.values() ) {
				if(ee<20) {
					System.out.println(fore);
				v.add(fore);}
				ee++;
				
			}
			
			BarGraph ar = new BarGraph(v,s,"Ventas","Posicion","Cantidad",3);
			JPanel ne = new JPanel();
			this.add(ne,BorderLayout.CENTER);
			this.add(ar,BorderLayout.CENTER);	
			this.setVisible(true);
		}else {JOptionPane.showMessageDialog(null, "How! ", "How!",JOptionPane.INFORMATION_MESSAGE,this.succes);}
	}

}

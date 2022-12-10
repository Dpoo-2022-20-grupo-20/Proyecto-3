package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Alineacion extends Frames implements ActionListener {


	private Click mouse; 
	private draw_Team dibujo;
	private JButton capitan;
	private JButton change ;
	private JPanel pos;
	private String[] text = {" Cambiar "," Set Capi "};
	
	private JTextArea jugadores;
	private JScrollPane opciones;
	private JPanel selctions;
	
	private JButton get_cap;
	private JButton volver_cp;
	private JLabel info;
	private JTextField select;
	private List<String> titulares;
	private JButton Delantero;
	private JButton MedioCampsita;
	private JButton Arquero;
	private JButton Defensa;
	private JPanel sl;
	private JButton Cancelar;

	private JComboBox<String> combobox;
	private JPanel comb;
	private JButton nay;
	private JButton goo;

	
	
	
	public Alineacion() {
		super();
		this.initial();
		
	}
	
	private void initial() {
		this.dibujo = new draw_Team(this);
		this.dibujo.setVisible(true);
		Jprincipal.getControlador().set_observers(this.dibujo);
		this.add(this.dibujo,BorderLayout.CENTER);
		
		JLabel label = new JLabel();
		label.setBackground(Color.black);
		label.setOpaque(true);
		label.setText(">> Volver <<");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(JLabel.CENTER);
		
		mouse = new Click(label,this);
		label.addMouseListener(mouse);
		this.pos= new JPanel();
		this.pos.setLayout(new GridLayout(2,1));
		
		label.setFont(new Font("Araboto Bold",Font.BOLD,20));
		int i= 0 ;
		this.change = new JButton();
		this.capitan= new JButton();
		JButton [] butons = {this.change,this.capitan};
		for (JButton boton : butons) 
		{
	
			boton.setText(text[i]);
			boton.setFocusable(false);
	    	boton.addActionListener(this);
			boton.setFont(new Font("Araboto Bold",Font.BOLD,30));
			boton.setBackground(Color.BLACK);
			boton.setForeground(new Color(0x7CE515));
			boton.setBorder(BorderFactory.createEmptyBorder());
				
			boton.setFocusable(false);
			i++;
			this.pos.add(boton);
		}
		
		
		this.add(this.pos, BorderLayout.EAST);
		this.add(label,BorderLayout.SOUTH);
		this.setVisible(true);
		
	}
	
	
	public void get_capi() {
		
		this.selctions = new JPanel();
		this.selctions.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		this.jugadores   = new JTextArea();
	 	
		this.volver_cp = new JButton();
		this.get_cap  = new JButton();
		
		this.info		 = new JLabel();
	 	this.select 	 = new JTextField();
		
	 	this.info.setText("Los jugadores disponibles");
	 	this.info.setHorizontalAlignment(JLabel.CENTER);
	 	this.info.setVerticalAlignment(JLabel.CENTER);
	 	this.info.setBackground(Color.black);
	 	this.info.setFont(new Font("Araboto Bold",Font.BOLD,30));
	 	this.info.setForeground(new Color(36, 157, 61));
	 	this.info.setOpaque(true);
	 	
	 	gbc.gridx= 0;
	 	gbc.gridy= 0 ;
	 	gbc.gridwidth=2;
	 	gbc.gridheight=1;
	 	gbc.weightx = 1.0;
	 	gbc.weighty = 1.0;
	 	gbc.fill=GridBagConstraints.BOTH;
	 	this.selctions.add(this.info,gbc);
	 	this.titulares= Jprincipal.getControlador().nom_tit();
	 	String jugadores = "";
		int i = 0 ;
		for (String add : titulares) {
			jugadores = jugadores +i+") " + add +"\n"; 
			i++;		
		}
		
		this.jugadores.setText(jugadores);
		this.jugadores.setFont(new Font("Araboto Bold",Font.BOLD,30));
		this.jugadores.setForeground(new Color(36, 157, 61 ));
		this.jugadores.setBackground(Color.black);
		this.jugadores.setEditable(false);
	
		this.opciones = new JScrollPane(this.jugadores,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.opciones.setBackground(Color.black);
		
		gbc.gridx= 0;
	 	gbc.gridy= 1 ;
	 	gbc.gridwidth=2;
	 	gbc.gridheight=4;
	 	gbc.weightx = 1.0;
	 	gbc.weighty = 1.0;
	 	gbc.fill=GridBagConstraints.BOTH;
	 	
	 	this.selctions.add(this.opciones,gbc);
		
		
		this.select.setPreferredSize(new Dimension(250,40));
		this.select.setForeground(new Color(0x00FF00));
		this.select.setCaretColor(new Color(0x003F00));
		this.select.setBorder(BorderFactory.createLoweredBevelBorder());
		this.select.setBackground(Color.DARK_GRAY);
		this.select.setFont(new Font("Araboto Bold",Font.BOLD,30));
		
		gbc.gridx= 0;
	 	gbc.gridy= 5;
	 	gbc.gridwidth=2;
	 	gbc.gridheight=1;
	 	gbc.weightx = 1.0;
	 	gbc.weighty = 1.0;
	 	gbc.fill=GridBagConstraints.BOTH;
	 	this.selctions.add(this.select,gbc);
		
		String [] texta = {"Volver","Envíar selección"};
		JButton [] butons = {this.volver_cp,this.get_cap};	
		
		int e = 0; 
		for (JButton boton : butons) 
		{
			
			boton.setText(texta[e]);
			boton.setFocusable(false);
	    	boton.addActionListener(this);
			boton.setFont(new Font("Araboto Bold",Font.BOLD,30));
			boton.setBackground(Color.BLACK);
			boton.setForeground(new Color(0x7CE515));
			boton.setBorder(BorderFactory.createEmptyBorder());
				
			boton.setFocusable(false);
			gbc.gridx= e;
		 	gbc.gridy= 6 ;
		 	gbc.gridwidth=1;
		 	gbc.gridheight=1;
		 	gbc.weightx = 1.0;
		 	gbc.weighty = 1.0;
		 	gbc.fill=GridBagConstraints.BOTH;
		 	this.selctions.add(boton,gbc);
			e++;
		}	
		
		this.add(this.selctions,BorderLayout.CENTER);
	}
		
	public void change_pos() {
		this.sl = new JPanel();
		this.sl.setLayout(new GridLayout(6,1));
		String[] text= {"Delantero","Arquero","Defensor","Medio_Campista","Cancelar"};
		this.Delantero = new JButton(); 
		this.MedioCampsita = new JButton();
		this.Arquero = new JButton();
		this.Defensa = new JButton();
		this.Cancelar = new JButton();
		JLabel label = new JLabel();
		label.setText("Escoja una posición");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Araboto Bold",Font.BOLD,20));
		label.setBackground(Color.BLACK);
		label.setOpaque(true);
		label.setVerticalAlignment(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
	    this.sl.add(label);
		JButton[] butons = {this.Delantero,this.MedioCampsita,this.Arquero,this.Defensa,this.Cancelar};
		int i= 0; 
		for (JButton boton : butons) 
		{
			boton.setActionCommand(text[i]);
			boton.setText(text[i]);
			boton.setFocusable(false);
	    	boton.addActionListener(this);
			boton.setFont(new Font("Araboto Bold",Font.BOLD,30));
			boton.setBackground(Color.BLACK);
			boton.setForeground(new Color(0x7CE515));
			boton.setBorder(BorderFactory.createEmptyBorder());
				
			boton.setFocusable(false);
			i++;
			this.sl.add(boton);
		}
		this.sl.setBackground(Color.black);;
		this.sl.setVisible(true);
		this.add(this.sl,BorderLayout.WEST);
		
		this.setVisible(true);
		
		
	}
	
	
	 public Image get_Layout() {
		 return this.latout.getImage();
	 }
	 
	 @Override
	 public void prev() {
		 this.dispose();
		 new Menu_Equipo();
	 }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.change) {
			this.change_pos();
			
		}
		else if(e.getSource()==this.capitan) {
			this.dibujo.setVisible(false);
			this.get_capi();
		}else if(e.getSource() == this.get_cap) {
			if (this.titulares!= null) {
				if (!this.titulares.isEmpty()) {
					try {	int posi= Integer.parseInt(this.select.getText()) ;
							String capi=Jprincipal.getControlador().get_capi();
							String aer= this.titulares.get(posi);
						if(!capi.equals(aer)) 
						 {	
							Jprincipal.getControlador().set_capitan(aer);
							JOptionPane.showMessageDialog(null, "Volvió capitán al jugador "+aer, "Success ",JOptionPane.INFORMATION_MESSAGE,this.succes);
							this.dispose();
							new Alineacion();
						 } 
						else {JOptionPane.showMessageDialog(null,"Se que no debe aparecer el capitán, pero no lo escoja :)" , "Error ",JOptionPane.ERROR_MESSAGE,this.err);
}
					}
					catch(Exception erar) {
						JOptionPane.showMessageDialog(null, "Escoja una opción válida", "Error ",JOptionPane.ERROR_MESSAGE,this.err);
						erar.printStackTrace();
					}
					
				}
				else {JOptionPane.showMessageDialog(null, "No tiene titulares, el cap debe ser titular ", "Error ",JOptionPane.ERROR_MESSAGE,this.err);}
			}
			else{JOptionPane.showMessageDialog(null, "No tiene lista de titulares...? ", "What",JOptionPane.ERROR_MESSAGE,this.err);}
		}else if(e.getSource() == this.Delantero || e.getSource() == this.Defensa ||e.getSource() == this.Arquero || e.getSource() == this.MedioCampsita ){
			String pos=e.getActionCommand();
			String subs = Jprincipal.getControlador().sup_pos(pos);			
			if(subs!=null) {
				
				 this.select_change(pos,subs);
			}
			else {
				JOptionPane.showMessageDialog(null, "NO tiene suplentes para esta posición", "Error",JOptionPane.ERROR_MESSAGE,this.err);
			}
			
		}else if(e.getSource()==this.Cancelar){
			this.sl.removeAll();
			this.sl.setVisible(false);
			
		}else if(e.getSource()== this.volver_cp) {
			this.selctions.setVisible(false);
			this.selctions.removeAll();
			this.initial();
		}else if (e.getSource()== this.nay) {
			this.comb.removeAll();
			this.comb.setVisible(false);
			this.dispose();
			this.initial();
		}else if(e.getSource()==this.combobox || e.getSource()==this.goo) {
			String sel=(String) combobox.getSelectedItem();
			System.out.println(sel);
			
			if (sel != "None") {
				String[] opt= this.goo.getActionCommand().split(",");
				String nuevo= opt[0];
				String posi = opt[1];
				Jprincipal.getControlador().change_alnc(posi, sel, nuevo);
				JOptionPane.showMessageDialog(null, "Se cambió el jugador exitosamente", "Succes",JOptionPane.INFORMATION_MESSAGE,this.succes);
				this.dispose();
				new Menu_Equipo();
			}
		}
		else {JOptionPane.showMessageDialog(null, "How! ", "How! ",JOptionPane.INFORMATION_MESSAGE,this.succes);}
	}

	private void select_change(String pos,String subs) {
		 
		 List<String>tit = Jprincipal.getControlador().nom_alnc().get(pos);
		 String rem= "None";
		 System.out.println(tit.size());
		 System.out.println(tit);
		 for(int ar=1;ar<tit.size()+1;ar++) {
			 
			 rem=rem+","+tit.get(ar-1);
		 }
		 String[]add=rem.split(",");
		 this.comb = new JPanel();
		 this.comb.setBackground(Color.black);
		 this.comb.setLayout(new GridLayout(4,1));
		 this.combobox= new JComboBox<String>(add);
		 this.combobox.setSelectedIndex(0);
		 this.combobox.setBackground(Color.black);
		 
		 this.combobox.setFont(new Font("Araboto Bold",Font.BOLD,30));
		 this.combobox.setForeground(new Color(0x7CE515));
		 
		 JLabel selecti  = new JLabel();
		 selecti.setText("Escoja una posición");
		 selecti.setForeground(Color.WHITE);
		 selecti.setFont(new Font("Araboto Bold",Font.BOLD,20));
		 selecti.setBackground(Color.BLACK);
		 selecti.setOpaque(true);
		 selecti.setVerticalAlignment(JLabel.CENTER);
		 selecti.setHorizontalAlignment(JLabel.CENTER);
		 
		 this.nay= new JButton();
		 this.goo= new JButton();
		 this.comb.add(selecti);
		 this.comb.add(this.combobox);
		 this.nay.setText("Cancelar");
		 this.nay.setFocusable(false);
	     this.nay.addActionListener(this);
		 this.nay.setFont(new Font("Araboto Bold",Font.BOLD,30));
		 this.nay.setBackground(Color.BLACK);
		 this.nay.setForeground(new Color(0x7CE515));
		 this.nay.setBorder(BorderFactory.createEmptyBorder());
		 this.goo.setText("Confimar");
		 this.goo.setFocusable(false);
	     this.goo.addActionListener(this);
		 this.goo.setFont(new Font("Araboto Bold",Font.BOLD,30));
		 this.goo.setBackground(Color.BLACK);
		 this.goo.setForeground(new Color(0x7CE515));
		 this.goo.setBorder(BorderFactory.createEmptyBorder());
		 this.goo.setActionCommand(subs+","+pos);
		 this.comb.add(goo);
		 this.comb.add(nay);
		 this.sl.removeAll();
		 this.sl.setVisible(false);
		 this.add(comb,BorderLayout.WEST);
	}

	public class draw_Team extends JPanel implements Observer{
		
		Alineacion team; 
		String [] delanteros= {"1. Ninguno","2. Ninguno"};
		String [] defensas= {"1. Ninguno","2. Ninguno","3. Ninguno","4 Ninguno"};
		String [] arqueros = {"Ninguno"};
		String [] mid={"1. Ninguno","2. Ninguno","3. Ninguno","4. Ninguno"};
		String capitan = "Ninguno";
		String [] suplentes = {"1.    Ninguno","2.    Ninguno","3.    Ninguno","4.    Ninguno"};
		
		
	    draw_Team(Alineacion alineacion){
	    	this.team=alineacion;
	    	this.update_comp(Jprincipal.getControlador().nom_alnc(),
					Jprincipal.getControlador().nom_supl(),Jprincipal.getControlador().get_capi());
		}
		
	    private void update_comp(Map<String,List<String>>titular,List<String>suplentes,String capi) {
	    	this.capitan=capi;
	    	String[] text= {"Delantero","Arquero","Defensor","Medio_Campista"};
	    	String[][] act= {this.delanteros,this.arqueros,this.defensas,this.mid};
	    	
	    	
	    	for(int i=0 ; i< text.length; i++) {
	    		if (!titular.get(text[i]).isEmpty()) {
	    		    System.out.println(titular.get(text[i])+"ar");
	    			for(int o=0;o< titular.get(text[i]).size();o++) {
	    		    	String nombre= titular.get(text[i]).get(o);
	    		    	
	    		    	act[i][o] = nombre;	
	    			}
	    		}
	    		
	    		
	    	}
	    	
	    	if(!suplentes.isEmpty()) {
	    		for(int a=0; a<suplentes.size();a++) {
	    			this.suplentes[a]=suplentes.get(a);
	    		}
	    	}
	    	
	    }
	    
	    @Override
		public void update(Observable o, Object arg) {
			this.update_comp(Jprincipal.getControlador().nom_alnc(),
					Jprincipal.getControlador().nom_supl(),Jprincipal.getControlador().get_capi());
			
		}

		
		@Override 
		public void paint(Graphics g) 
		{
			Graphics2D g2d = (Graphics2D) g; 
			int x = this.getWidth();
			int y = this.getHeight();
			g2d.drawImage(this.team.get_Layout(),0, 0, x, y, team);
			g2d.setFont(new Font("Araboto Bold",Font.BOLD,30));
			g2d.setPaint(Color.YELLOW);
			int i= 0 ; 
			for(String Delantero : this.delanteros) {
				g2d.drawString(Delantero, 450+(190*i), 200);
				i++;
			}
			i=0;
			
			for(String midf : this.mid) {
				if (i ==3) {
				g2d.drawString(midf, 120+(290*i), 350);
				}
				else if (i ==0) {
					g2d.drawString(midf, 80+(290*i), 350);
				}else if (i==1) {
					g2d.drawString(midf, 80+(290*i), 360);
				}else {
					g2d.drawString(midf, 150+(290*i), 360);
				}
				i++;
			}
			i=0;
			for(String def : this.defensas) {
				g2d.drawString(def, 180+(250*i), 490);
				i++;
			}
			
			i=0;
			
			g2d.drawString(this.arqueros[0], 580, 620);
			
			g2d.drawString("Suplentes: ", 10, 560);
			g2d.drawString("Capitán: "+this.capitan, 50, 50);
			g2d.setFont(new Font("Araboto Bold",Font.BOLD,15));
			
			for(String suplente :this.suplentes ) {
				g2d.drawString(suplente, 10,580+(20*i));
				i++;
			}
			
			
			
		}
	}
}	

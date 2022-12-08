package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class Menu_Equipo extends Frames implements ActionListener {

	
	public  int state = 0;
	
	private JButton Dream_team ; 
	private JButton Comprar ;
	private JButton Vender ;
	private JButton Mi_alineacion ;
	
	private JButton Delantero ; 
	private JButton MedioCampsita ;
	private JButton Arquero ;
	private JButton Defensa ;
	
	private JPanel extra ;
	private JPanel poner;
	private JLabel pres  ;
	
	
	private JButton Volver ;
	
	private JLabel label; 
	
	private JLabel stats; 
	private JLabel Id; 
	
	private JPanel panel; 
	private JPanel pos ; 
	
	private JTextField select;
	private JScrollPane opciones;
	private JPanel selctions; 
	private JTextArea jugadores; 
	private JLabel info; 
	private JButton get_player;
	private JButton back_player;
	
	private String[] text= {"Crear equipo","Comprar Jugadores","Vender Jugadores","Ver mi alineación","Volver"};
	
	private Map<String, Integer> disp;
	
	private List<String> Nombres; 
	private String lugar ; 
	
	public Menu_Equipo() {
		super();	
		this.setTitle("Equipo");
		this.initial();
	}
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}





	public void initial() {
		
		
		
		this.label= new JLabel();
		this.label.setText(">>Volver<<");
		Click mouse = new Click(label, this);
		this.label.addMouseListener(mouse);
		this.label.setForeground(Color.WHITE);
		this.label.setFont(new Font("Araboto Bold",Font.BOLD,20));
	   
		this.panel = new JPanel();	
		this.Dream_team= new JButton();
		this.Comprar=new JButton();
		this.Vender=new JButton();
		this.Mi_alineacion=new JButton();
		this.Volver=new JButton();
		
		JPanel pan = new JPanel();
		
		pan.setLayout(new FlowLayout());
		
		
		this.Id = new JLabel();
		this.Id.setText((Jprincipal.controlador.no_team())?"No tíene equipo  ":"Su ID "+Jprincipal.controlador.get_id_Team()+"  ");
		this.Id.setForeground(Color.GREEN);
		this.Id.setFont(new Font("Araboto Bold",Font.BOLD,20));
	   
		
		this.stats= new JLabel();
		this.stats.setText((Jprincipal.controlador.no_team())?"  No tíene equipo":"  Su puntaje "+String.valueOf(Jprincipal.controlador.get_puntaje()));
		
		this.stats.setForeground(Color.GREEN);
		this.stats.setFont(new Font("Araboto Bold",Font.BOLD,20));
		
		pan.add(this.Id);
		
		pan.add(this.label);
		
		pan.add(this.stats);
		
		pan.setBackground(Color.BLACK);
		
		
		
		JButton[] Buttons= {this.Dream_team,this.Comprar,this.Vender,this.Mi_alineacion,this.Volver};
	    this.add(pan,BorderLayout.SOUTH);
	    int i = 0;
	    boolean go=false;
	    this.panel.setLayout(new GridLayout(5,1));
	    this.setBackground(Color.black);
	    for (JButton boton : Buttons) {
	    	if (i==0) {
	    		go = Jprincipal.controlador.no_team();
	    		
	    	}else {go= true;}
	    
	    	if (!go) {
	    		boton.setEnabled(false);
	    		boton.setDisabledIcon(this.succes);
		   	   	}
	    	else if (i!=0 && Jprincipal.controlador.no_team()) {
	    		boton.setEnabled(false);
	       	}else if (i!=0 && !Jprincipal.controlador.no_team()) {
	       		boton.setEnabled(true);
	       	} 	
	    	
	    		boton.setFocusable(false);
		    	boton.addActionListener(this);
		    	boton.setText(this.text[i]);
				boton.setFont(new Font("Araboto Bold",Font.BOLD,30));
				boton.setBackground(Color.GREEN);
				boton.setActionCommand("2");
				this.panel.add(boton);
	    	i++;		
	    }
	    	this.poner = new JPanel();
	    	if (Jprincipal.controlador.no_team()) {
	    		
	    		JLabel pro = new JLabel();
	    		pro.setText("No tiene equipo aún !");
	    		pro.setHorizontalTextPosition(JLabel.CENTER);
	    		pro.setVerticalTextPosition(JLabel.TOP);
	    		pro.setForeground(Color.GREEN);
	    		pro.setFont(new Font("Araboto Bold",Font.BOLD,20));
	    		pro.setBackground(Color.BLACK);
	    		
	    		Image img = this.succes.getImage();
	    		img.getScaledInstance(530, 530, Image.SCALE_SMOOTH);
	    		ImageIcon icon = new ImageIcon(img);
	    		pro.setOpaque(true);
	    		pro.setIcon(icon);
	    		this.poner.add(pro);	
	    		this.poner.setBackground(Color.BLACK);	
	    		this.add(poner,BorderLayout.EAST);
	    		   
	    	}else {
	    		this.show_stats();
	    	}
	    this.add(this.panel,BorderLayout.WEST);
	    this.add(pan,BorderLayout.SOUTH);
	    this.setVisible(true);
	}
	
	
	public void show_stats() {
		this.poner = new JPanel();
		JLabel pres  = new JLabel();
		String text = String.valueOf(Jprincipal.getControlador().get_presupuesto());
		
		this.poner.setLayout(new GridLayout(6,1));
		pres.setText("Su presupuesto es " + text);
		pres.setForeground(Color.WHITE);
		pres.setFont(new Font("Araboto Bold",Font.BOLD,20));
		pres.setBackground(Color.BLACK);
		pres.setOpaque(true);
		pres.setVerticalAlignment(JLabel.CENTER);
		pres.setHorizontalAlignment(JLabel.CENTER);
		this.poner.add(pres);
		
		JLabel data= new JLabel(); 
		data.setText("Disponibles para cada posición");
		data.setForeground(Color.WHITE);
		data.setFont(new Font("Araboto Bold",Font.BOLD,20));
		data.setBackground(Color.BLACK);
		data.setOpaque(true);
		data.setVerticalAlignment(JLabel.CENTER);
		data.setHorizontalAlignment(JLabel.CENTER);
		this.poner.add(data);
		
		this.disp = Jprincipal.getControlador().get_dips();
		for ( Entry<String, Integer> pos:disp.entrySet()) {
			JLabel texto = new JLabel();
			String posi=pos.getKey();
			String disp=String.valueOf(pos.getValue());
			texto.setText(posi+": " +disp );
			texto.setForeground(Color.WHITE);
			texto.setFont(new Font("Araboto Bold",Font.BOLD,20));
			texto.setBackground(Color.BLACK);
			texto.setOpaque(true);
			texto.setVerticalAlignment(JLabel.CENTER);
			texto.setHorizontalAlignment(JLabel.CENTER);
			this.poner.add(texto);
		}
		this.poner.setBackground(Color.BLACK);	
		this.add(poner,BorderLayout.EAST);
		this.setVisible(true);
	}
	
	
	public void show_pos(int a) {
			this.pos = new JPanel();
			this.pos.setLayout(new GridLayout(5,1));
			String[] text= {"Delantero","Arquero","Defensor","Medio_Campista"};
			this.Delantero = new JButton(); 
			this.MedioCampsita = new JButton();
			this.Arquero = new JButton();
			this.Defensa = new JButton();
			JLabel label = new JLabel();
			String add; 
			if (a==2) {add="Para compar";}
			else {add="Para Vender";}
			label.setText("Escoja una posición "+ add);
			label.setForeground(Color.WHITE);
			label.setFont(new Font("Araboto Bold",Font.BOLD,20));
			label.setBackground(Color.BLACK);
			label.setOpaque(true);
			label.setVerticalAlignment(JLabel.CENTER);
			label.setHorizontalAlignment(JLabel.CENTER);
		    this.pos.add(label);
			JButton[] butons = {this.Delantero,this.MedioCampsita,this.Arquero,this.Defensa};
			int i= 0; 
			for (JButton boton : butons) 
			{
				boton.setActionCommand(String.valueOf(a)+","+text[i]);
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
			this.pos.setBackground(Color.black);;
			this.add(this.pos,BorderLayout.CENTER);
			
			this.setVisible(true);
			
	}
	
	
	public void print_choises(String action) {
		
		this.Volver.setActionCommand("2");
		this.selctions = new JPanel();
		this.selctions.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		this.jugadores   = new JTextArea();
	 	
		this.back_player = new JButton();
		this.get_player  = new JButton();
		
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
	 	
	 	String jugadores = "";
		int i = 0 ;
		for (String add : this.Nombres) {
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
		this.select.setBounds(panel.getWidth()/2 - 250/2,panel.getHeight() -40 , 250, 40);
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
		JButton [] butons = {this.back_player,this.get_player};	
		
		int e = 0; 
		for (JButton boton : butons) 
		{
			boton.setActionCommand(action);
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
	
	
	@Override
	public void prev() {
		Jprincipal.getControlador().reomve_team();
		this.dispose();
		new team_Sel();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==this.Dream_team){
			String id= Jprincipal.getControlador().new_team();
			JOptionPane.showMessageDialog(null, "Se creó su nuevo Equipo con la Id "+id+"! ", "Succes",JOptionPane.INFORMATION_MESSAGE,this.succes);
			this.Dream_team.setEnabled(false);
			this.show_stats();
			this.Vender.setEnabled(true);
			this.Comprar.setEnabled(true);
			this.Mi_alineacion.setEnabled(true);
			this.Volver.setEnabled(true);
			this.Id.setText("Su ID "+id);
			this.stats.setText("Su puntaje 0");
			
		}else if(e.getSource()==this.Volver) {
			if(e.getActionCommand()!="2") {
			
				this.pos.removeAll();
				this.pos.setVisible(false);
				this.initial();
				
			}else { 
				
				this.prev();
				}
		}else if (e.getSource()==this.Vender) {
			
			this.Vender.setEnabled(false);
			this.Comprar.setEnabled(false);
			this.Mi_alineacion.setEnabled(false);
			this.Volver.setActionCommand("1");
			show_pos(1);
			
			Jprincipal.getControlador();
		}else if (e.getSource()==this.Mi_alineacion) {
			this.dispose();
			new Alineacion();
		}else if (e.getSource()==this.Comprar){
			this.Vender.setEnabled(false);
			this.Comprar.setEnabled(false);
			this.Mi_alineacion.setEnabled(false);
			this.Volver.setActionCommand("1");
			show_pos(2);
		}else if (e.getSource() == this.Delantero || e.getSource() == this.Defensa ||e.getSource() == this.Arquero || e.getSource() == this.MedioCampsita ) {
			String[] dtata= e.getActionCommand().split(",");
			
			this.lugar= dtata[1];
			if (dtata[0].equals("1")) {
			 if (! Jprincipal.getControlador().empty_pos(this.lugar)) {
				Nombres=Jprincipal.getControlador().get_team_player(this.lugar);
				this.pos.removeAll();
				this.pos.setVisible(false);
				this.print_choises("2");}
				else {JOptionPane.showMessageDialog(null, "No tiene Jugadores en esa posición! ", "Error",JOptionPane.ERROR_MESSAGE,
						this.err);
				}
			}else if (dtata[0].equals("2")) {
			   if (this.disp.get(this.lugar)>0) {
				Nombres=Jprincipal.getControlador().available_players(this.lugar);
				this.pos.removeAll();
				this.pos.setVisible(false);
				this.print_choises("1");}
			   else {JOptionPane.showMessageDialog(null, "No tiene Jugadores para agregar en esa posición! ", "Error",JOptionPane.ERROR_MESSAGE,
						this.err);}
			}else {
				JOptionPane.showMessageDialog(null, "Whooops ! ", "Whoooops! ",JOptionPane.INFORMATION_MESSAGE,this.succes);
				
			}
		}else if (e.getSource() == this.back_player) {
			this.selctions.removeAll();
			
			if(e.getActionCommand().equals( "1")) {
				this.show_pos(1);}
			else if (e.getActionCommand().equals("2")) {
				this.show_pos(2);}
			else {JOptionPane.showMessageDialog(null, "Whooops  ", "Whoooops ",JOptionPane.INFORMATION_MESSAGE,this.succes);}
			
			}
		else if (e.getSource()== this.get_player) {
			try {
				int get = Integer.parseInt(this.select.getText());
				
				String noms = this.Nombres.get(get);
				String[] nombres = noms.split(",");
				String nom = nombres[0];
				if (e.getActionCommand().equals("2")) {
					float ganancia =Jprincipal.getControlador().vender_jugador(lugar,nom);
					JOptionPane.showMessageDialog(null, "Vendió el jugador "+ nom +" por " +ganancia+" nos robamos el 3% ;)", "Success ",JOptionPane.INFORMATION_MESSAGE,this.succes);
					this.dispose();
					new Menu_Equipo();
				}
				else if (e.getActionCommand().equals("1")){
				 if (Jprincipal.getControlador().check_pres(nom, this.lugar)) {
					float[] ar= Jprincipal.getControlador().buy_jugador(this.lugar,nom);
					String pres= String.valueOf(ar[0]);
					String precio=String.valueOf(ar[1]);
					JOptionPane.showMessageDialog(null, "Compró el jugador "+ nom+" por "+precio+ "\nTiene presupuesto : "+pres, "Succcess ",JOptionPane.INFORMATION_MESSAGE,this.succes);
					this.dispose();
					new Menu_Equipo();
			    	}else {
				    	JOptionPane.showMessageDialog(null, "No tiene suficiente presupuesto ", "Error ",JOptionPane.ERROR_MESSAGE,this.err);
				 }
			}
			}
			catch(Exception erro){
				erro.printStackTrace();
				JOptionPane.showMessageDialog(null, "Ingrese una opción válida ", "Error",JOptionPane.ERROR_MESSAGE,
						this.err);
			}
			
		}	
	}
 
}

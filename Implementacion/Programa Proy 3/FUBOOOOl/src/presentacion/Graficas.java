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

public class Graficas extends Frames implements ActionListener{
	JButton graph1; 
	JButton graph2;
	JButton graph3;
	JButton graph4;
	JButton salir; 
	String[] text = {"Ver Grafica 1","Ver Grafica 2","Ver Grafica 3","Ver Grafica 4"};
	
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
		this.salir = new JButton();
		JButton[] buttons= {graph1,graph2,graph3,graph4};
		JLabel label = new JLabel();
		Click mouse = new Click(label, this);
		label.setText(">>Volver<<");
		label.setForeground(Color.WHITE);
		label.addMouseListener(mouse);
		label.setFont(new Font("Araboto Bold",Font.BOLD,20));
	    this.add(label,BorderLayout.SOUTH);
	    
	    
		JPanel botones = new JPanel();
		
		botones.setLayout(new GridLayout(4,1));
		
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
			//anadir grafico 1
			
		}
		else if (e.getSource()==this.graph2) {
			//anadir grafico 2
			
		}
		else if (e.getSource()==this.graph3) {
			//anadir grafico 3
			
		}
		else if (e.getSource()==this.graph4) {
			//anadir grafico 4
			
		}
	}

}

package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Controller;

public class AddPartido extends Frames implements ActionListener {
	JTextField pathText= new JTextField();
	JPanel panel= new JPanel();
	JButton btnSubmit= new JButton();
	public AddPartido() {
		super();
		this.setTitle("Anada un partido a la liga");
		this.initial();
		
	}

	private void initial() {
		// TODO Auto-generated method stub
		
		panel.setBackground(Color.BLACK);
		panel.setLayout(new GridLayout(4,2));
		JLabel ingrese= new JLabel("Ingrese el path del partido que desea ingresar(csv)");
		ingrese.setBounds(10,200,600,250);
		ingrese.setFont(new Font("Araboto Bold",Font.BOLD,40));
		ingrese.setForeground(Color.GREEN);
		panel.add(ingrese);
		
		
		pathText.setBounds(500,300,700,100);
		pathText.setBackground(Color.BLACK);
		pathText.setFont(new Font("Araboto Bold",Font.BOLD,40));
		pathText.setForeground(Color.GREEN);
		panel.add(pathText);
		
		
		
		btnSubmit.setBounds(500,650,200,100);
		btnSubmit.setText("Submit");
		btnSubmit.setBackground(Color.BLACK);
		btnSubmit.setFont(new Font("Araboto Bold",Font.BOLD,40));
		btnSubmit.setForeground(Color.GREEN);
		btnSubmit.setBorder(null);
		btnSubmit.addActionListener(this);
		panel.add(btnSubmit);
		
		JLabel label = new JLabel();
		Click mouse = new Click(label, this);
		label.setText(">>Volver<<");
		label.setForeground(Color.WHITE);
		label.addMouseListener(mouse);
		label.setFont(new Font("Araboto Bold",Font.BOLD,20));
	    panel.add(label);
		this.add(panel);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String path= this.pathText.getText();
		System.out.println("eonsfbviu");
		if (path != null) {
			try{
				Jprincipal.getControlador().cargarPartida(path);
				JOptionPane.showMessageDialog(null, "Se cargó el achivo ", "Succes", JOptionPane.INFORMATION_MESSAGE,this.succes);
				
				}
			catch(Exception err) {
				JOptionPane.showMessageDialog(null, "Hubo un error leyendo el archivo ", "Error", JOptionPane.ERROR_MESSAGE,this.err);
				err.printStackTrace();
			}
			}
			}
	@Override
	public void prev() {
		this.dispose();
		new Admin_menu();
	}

		 
	 }


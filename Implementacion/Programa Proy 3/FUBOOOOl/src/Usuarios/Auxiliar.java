package Usuarios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Auxiliar {
	

	public static void print() throws IOException 
	{
		BufferedReader br;
		try 
		{
			br = new BufferedReader(new FileReader("Data/proyects.txt"));
			String linea; 
			linea= br.readLine();
		
			while (linea != null) 
				{
					linea= linea.replace("\n","");
					System.out.println(linea);
					linea=br.readLine();
				}
		} 
		catch (FileNotFoundException e) 
		{
		    e.printStackTrace();
		}
		
		
	}
	
}

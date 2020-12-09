package com.clearminds.cca.bdd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class ConexionBDD {
	public static String directorio = "./conexion.properties";
	
	
	public static String leerPropiedad(String nombre){
		File f = new File(directorio);
		BufferedReader br =null;
		FileReader fr =null;
		
		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			
			String linea;
			while ((linea=br.readLine())!=null) {
				String[] propiedad = linea.split(":");
				if(propiedad[0].equals(nombre))
					return propiedad[1];
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("No se encontro el archivo "+ directorio);
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Problema al leer el archivo");
			e.printStackTrace();
		}finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}

package com.clearminds.cca.bdd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.clearminds.cca.excepciones.BDDException;

public class ConexionBDD {
	public static String directorio = "./conexion.properties";

	public static String leerPropiedad(String nombre) {
		File f = new File(directorio);
		BufferedReader br = null;
		FileReader fr = null;

		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String linea = "";
			String valor = "";

			while ((linea = br.readLine()) != null) {
				String[] propiedad = linea.split(":", 2);
				if (propiedad[0].equals(nombre))
					return propiedad[1];
			}

		} catch (FileNotFoundException e) {
			System.out.println("No se encontro el archivo " + directorio);
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Problema al leer el archivo");
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static Connection obtenerConexion() throws BDDException {
		String usuario = leerPropiedad("usuario");
		String password = leerPropiedad("password");
		String urlConexion = leerPropiedad("urlConexion");
		Connection connection = null;
		try {
			//System.out.print("Connecting to SQL Server ... ");
			connection = DriverManager.getConnection(urlConexion + ";user=" + usuario + ";password=" + password);
			//System.out.println("Done.");
			return connection;

		} catch (SQLException se) {
			throw new BDDException("No se pudo conectar a la base de datos.");
		} catch (Exception e) {
			System.out.println("Error, consulte al administador");
			e.printStackTrace();
		}

		return null;
	}

}

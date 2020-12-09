package com.clearminds.cca.bdd.test;

import java.sql.Connection;

import com.clearminds.cca.bdd.ConexionBDD;

public class TestConexion {

	public static void main(String[] args) {
		try {
			Connection conexion = ConexionBDD.obtenerConexion();
			if (conexion!=null) {
				System.out.println("Conexion exitosa");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}

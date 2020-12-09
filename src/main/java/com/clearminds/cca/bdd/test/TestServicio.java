package com.clearminds.cca.bdd.test;

import com.clearminds.cca.dtos.Estudiante;
import com.clearminds.cca.servicios.ServicioEstudiante;

public class TestServicio {

	public static void main(String[] args) {
		ServicioEstudiante serEstudiante = new ServicioEstudiante();
		try {
			serEstudiante.insertarEstudiante(new Estudiante("Marcos", "Milena"));
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
	}
}

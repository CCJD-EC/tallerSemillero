package com.clearminds.cca.bdd.test;

import java.util.Date;

import com.clearminds.cca.dtos.Estudiante;
import com.clearminds.cca.servicios.DateUtil;
import com.clearminds.cca.servicios.ServicioEstudiante;

public class TestServicio {

	public static void main(String[] args) {
		ServicioEstudiante serEstudiante = new ServicioEstudiante();
		String fecha = DateUtil.convertirFecha(new Date());
		try {
			serEstudiante.actualizarEstudiante(new Estudiante("Milo", "Martinez",2,20,fecha));
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
	}
}

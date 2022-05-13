package com.idat.examen1.servicio;

import java.util.List;

import com.idat.examen1.modelo.Profesor;

public interface ProfesorServicio {
	
	public void guardarProfesor(Profesor profesor);
	public void editaProfesor(Profesor profesor);
	public void eliminarProfesor(Integer id);
	public List<Profesor> listarProfesores();
	public Profesor obtenerProfesorId(Integer id);
	
}

package com.idat.examen1.servicio;

import java.util.List;

import com.idat.examen1.modelo.Curso;

public interface CursoServicio {

	public void guardarCurso(Curso curso);
	public void editaCurso(Curso curso);
	public void eliminarCurso(Integer id);
	public List<Curso> listarCursos();
	public Curso obtenerCursoId(Integer id);
	
}

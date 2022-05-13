package com.idat.examen1.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.examen1.modelo.Curso;
import com.idat.examen1.repositorio.CursoRepositorio;

@Service
public class CursoServicioImpl implements CursoServicio{
	
	@Autowired
	public CursoRepositorio repositorio;
	
	@Override
	public void guardarCurso(Curso curso) {
		repositorio.save(curso);
	}

	@Override
	public void editaCurso(Curso curso) {
		repositorio.saveAndFlush(curso);
	}

	@Override
	public void eliminarCurso(Integer id) {
		repositorio.deleteById(id);
	}

	@Override
	public List<Curso> listarCursos() {
		return repositorio.findAll();
	}

	@Override
	public Curso obtenerCursoId(Integer id) {
		return repositorio.findById(id).orElse(null);
	}

}

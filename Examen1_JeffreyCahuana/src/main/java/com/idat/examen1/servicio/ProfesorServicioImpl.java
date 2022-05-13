package com.idat.examen1.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.examen1.modelo.Profesor;
import com.idat.examen1.repositorio.ProfesorRepositorio;

@Service
public class ProfesorServicioImpl implements ProfesorServicio{

	@Autowired
	public ProfesorRepositorio repositorio;
	
	@Override
	public void guardarProfesor(Profesor profesor) {
		repositorio.save(profesor);
	}

	@Override
	public void editaProfesor(Profesor profesor) {
		repositorio.saveAndFlush(profesor);
	}

	@Override
	public void eliminarProfesor(Integer id) {
		repositorio.deleteById(id);
	}

	@Override
	public List<Profesor> listarProfesores() {
		return repositorio.findAll();
	}

	@Override
	public Profesor obtenerProfesorId(Integer id) {
		return repositorio.findById(id).orElse(null);
	}

}

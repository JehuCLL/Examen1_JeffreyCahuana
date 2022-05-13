package com.idat.examen1.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.examen1.modelo.Malla;
import com.idat.examen1.repositorio.MallaRepositorio;

@Service
public class MallaServicioImpl implements MallaServicio{
	
	@Autowired
	public MallaRepositorio repositorio;
	
	@Override
	public void guardarMalla(Malla malla) {
		repositorio.save(malla);
	}

	@Override
	public void editaMalla(Malla malla) {
		repositorio.saveAndFlush(malla);
	}

	@Override
	public void eliminarMalla(Integer id) {
		repositorio.deleteById(id);
	}

	@Override
	public List<Malla> listarMallas() {
		return repositorio.findAll();
	}

	@Override
	public Malla obtenerMallaId(Integer id) {
		return repositorio.findById(id).orElse(null);
	}

}

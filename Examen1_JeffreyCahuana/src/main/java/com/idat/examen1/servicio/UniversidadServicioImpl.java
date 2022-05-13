package com.idat.examen1.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.examen1.modelo.Universidad;
import com.idat.examen1.repositorio.UniversidadRepositorio;

@Service
public class UniversidadServicioImpl implements UniversidadServicio{
	
	@Autowired
	public UniversidadRepositorio repositorio;
	
	@Override
	public void guardarUniversidad(Universidad universidad) {
		repositorio.save(universidad);
	}

	@Override
	public void editaUniversidad(Universidad universidad) {
		repositorio.saveAndFlush(universidad);
	}

	@Override
	public void eliminarUniversidad(Integer id) {
		repositorio.deleteById(id);
	}

	@Override
	public List<Universidad> listarUniversidades() {
		return repositorio.findAll();
	}

	@Override
	public Universidad obtenerUniversidadId(Integer id) {
		return repositorio.findById(id).orElse(null);
	}

}

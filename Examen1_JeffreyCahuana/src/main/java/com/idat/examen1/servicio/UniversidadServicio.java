package com.idat.examen1.servicio;

import java.util.List;

import com.idat.examen1.modelo.Universidad;

public interface UniversidadServicio {
	
	public void guardarUniversidad(Universidad universidad);
	public void editaUniversidad(Universidad universidad);
	public void eliminarUniversidad(Integer id);
	public List<Universidad> listarUniversidades();
	public Universidad obtenerUniversidadId(Integer id);

}

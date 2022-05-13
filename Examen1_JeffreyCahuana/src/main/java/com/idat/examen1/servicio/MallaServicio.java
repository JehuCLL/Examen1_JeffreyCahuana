package com.idat.examen1.servicio;

import java.util.List;

import com.idat.examen1.modelo.Malla;

public interface MallaServicio {
	
	public void guardarMalla(Malla malla);
	public void editaMalla(Malla malla);
	public void eliminarMalla(Integer id);
	public List<Malla> listarMallas();
	public Malla obtenerMallaId(Integer id);
	
}

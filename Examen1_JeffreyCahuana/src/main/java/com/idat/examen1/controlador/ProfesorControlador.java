package com.idat.examen1.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.examen1.modelo.Profesor;
import com.idat.examen1.servicio.ProfesorServicio;

@RestController
@RequestMapping("/profesor/v1")
public class ProfesorControlador {

	@Autowired
	private ProfesorServicio servicio;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Profesor>> listarProfesores(){
		return new ResponseEntity<List<Profesor>>(servicio.listarProfesores(), HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Profesor profesor){
		servicio.guardarProfesor(profesor);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}")
	public ResponseEntity<Profesor> listarporId(@PathVariable Integer id){
		Profesor u = servicio.obtenerProfesorId(id);
		if(u != null) {
			return new ResponseEntity<Profesor>(u, HttpStatus.OK);
		}			
		return new ResponseEntity<Profesor>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/editar")
	public ResponseEntity<Void> editar(@RequestBody Profesor profesor){
		
		Profesor u = servicio.obtenerProfesorId(profesor.getIdProfesor());
		
		if(u != null) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		Profesor u = servicio.obtenerProfesorId(id);
		if(u != null) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}

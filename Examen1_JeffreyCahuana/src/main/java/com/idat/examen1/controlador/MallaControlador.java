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

import com.idat.examen1.modelo.Malla;
import com.idat.examen1.servicio.MallaServicio;

@RestController
@RequestMapping("/malla/v1")
public class MallaControlador {
	
	@Autowired
	private MallaServicio servicio;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Malla>> listarMallaes(){
		return new ResponseEntity<List<Malla>>(servicio.listarMallas(), HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Malla malla){
		servicio.guardarMalla(malla);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}")
	public ResponseEntity<Malla> listarporId(@PathVariable Integer id){
		Malla u = servicio.obtenerMallaId(id);
		if(u != null) {
			return new ResponseEntity<Malla>(u, HttpStatus.OK);
		}			
		return new ResponseEntity<Malla>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/editar")
	public ResponseEntity<Void> editar(@RequestBody Malla malla){
		
		Malla u = servicio.obtenerMallaId(malla.getIdMalla());
		
		if(u != null) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		Malla u = servicio.obtenerMallaId(id);
		if(u != null) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}

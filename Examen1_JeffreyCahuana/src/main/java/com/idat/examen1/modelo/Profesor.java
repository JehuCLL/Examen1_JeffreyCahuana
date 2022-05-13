package com.idat.examen1.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name = "Profesor")
@Entity
public class Profesor implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -656377770171849077L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProfesor;
	private String Profesor;
	
	@ManyToMany(mappedBy = "curso", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Curso> cursos = new ArrayList<Curso>();
	
	public Profesor() {
		super();
	}

	public Integer getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(Integer idProfesor) {
		this.idProfesor = idProfesor;
	}

	public String getProfesor() {
		return Profesor;
	}

	public void setProfesor(String profesor) {
		Profesor = profesor;
	}
	
}

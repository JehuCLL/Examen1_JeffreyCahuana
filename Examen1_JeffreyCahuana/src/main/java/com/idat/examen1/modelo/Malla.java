package com.idat.examen1.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "Malla")
@Entity
public class Malla implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9117085271382281192L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMalla;
	private String anio;
	
	@OneToOne
	@JoinColumn(name = "id_universidad", nullable = false, unique = true,
	foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_universidad) references Universidad(id_universidad)"))
	private Universidad universidad;
	
	@OneToMany(mappedBy = "malla")
	private List<Curso> curso = new ArrayList<Curso>();
	
	public Malla() {
		super();
	}

	public Integer getIdMalla() {
		return idMalla;
	}

	public void setIdMalla(Integer idMalla) {
		this.idMalla = idMalla;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}
	
}

package com.idat.examen1.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "Curso")
@Entity
public class Curso implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3512454607291776384L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCurso;
	private String curso;
	private String descripcion;
	
	@JoinColumn(name = "id_malla", nullable = false, unique = true, 
			foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_malla) references Malla (id_malla)"))
	@ManyToOne
	private Malla malla;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "curso_profesor",
			joinColumns = @JoinColumn(
					name = "id_profesor",
					nullable = false,
					unique = true,
					foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_profesor) references Profesor (id_profesor)")),
			
			inverseJoinColumns = @JoinColumn(
					name = "id_curso",
					nullable = false,
					unique = true,
					foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_curso) references Curso (id_curso)"))
			)
	private List<Profesor> profesores = new ArrayList<Profesor>();
	
	
	public Curso() {
		super();
	}

	public Integer getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}

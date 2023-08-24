package mx.gufe.escuela.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_profesores_materia")
public class ProfesorMateria implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id_t_profesores_materia")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="id_t_materias")
	private Materia materia;
	
	@ManyToOne
	@JoinColumn(name="id_t_profesor")
	private Profesor profesor;
	
	@Column(name="fecha_registro")
	private Date fechaRegistro;

	public ProfesorMateria() {
		super();
	}
	
	public ProfesorMateria(Materia materia, Profesor profesor, Date fechaRegistro) {
		super();
		this.materia = materia;
		this.profesor = profesor;
		this.fechaRegistro = fechaRegistro;
	}

	public ProfesorMateria(int id, Materia materia, Profesor profesor, Date fechaRegistro) {
		super();
		this.id = id;
		this.materia = materia;
		this.profesor = profesor;
		this.fechaRegistro = fechaRegistro;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

}

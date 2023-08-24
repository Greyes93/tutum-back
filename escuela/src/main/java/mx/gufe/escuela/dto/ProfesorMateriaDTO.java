package mx.gufe.escuela.dto;

import java.io.Serializable;

public class ProfesorMateriaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private Integer idProfesorMateria;
	private Integer idMateria;	
	private Integer idProfesor;
	
	public ProfesorMateriaDTO() {
		super();
	}
		
	public ProfesorMateriaDTO(Integer idProfesorMateria, Integer idMateria, Integer idProfesor) {
		super();
		this.idProfesorMateria = idProfesorMateria;
		this.idMateria = idMateria;
		this.idProfesor = idProfesor;
	}
	
	public ProfesorMateriaDTO(Integer idMateria, Integer idProfesor) {
		super();
		this.idMateria = idMateria;
		this.idProfesor = idProfesor;
	}
	
	public Integer getIdProfesorMateria() {
		return idProfesorMateria;
	}
	public void setIdProfesorMateria(Integer idProfesorMateria) {
		this.idProfesorMateria = idProfesorMateria;
	}
	public Integer getIdMateria() {
		return idMateria;
	}
	public void setIdMateria(Integer idMateria) {
		this.idMateria = idMateria;
	}
	public Integer getIdProfesor() {
		return idProfesor;
	}
	public void setIdProfesor(Integer idProfesor) {
		this.idProfesor = idProfesor;
	}

	
	

}

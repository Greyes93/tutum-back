package mx.gufe.escuela.service;

import java.util.List;

import mx.gufe.escuela.model.Alumno;
import mx.gufe.escuela.utils.EscuelaException;

public interface AlumnosService {
	List<Alumno> allAlumnos() throws EscuelaException;
	Alumno alumnos(Integer idAlumno) throws EscuelaException;
}

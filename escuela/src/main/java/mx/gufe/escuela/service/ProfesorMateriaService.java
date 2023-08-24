package mx.gufe.escuela.service;

import java.util.List;

import mx.gufe.escuela.dto.ProfesorMateriaDTO;
import mx.gufe.escuela.model.Materia;
import mx.gufe.escuela.utils.EscuelaException;
import mx.gufe.escuela.utils.OveralResponse;

public interface ProfesorMateriaService {
	
	List<Materia> allMaterias(Integer idProfesor) throws EscuelaException; 
	OveralResponse insert(ProfesorMateriaDTO profesorMateria) throws EscuelaException;
	OveralResponse delete(Integer idProfesor, Integer idProfesorMateria) throws EscuelaException;

}

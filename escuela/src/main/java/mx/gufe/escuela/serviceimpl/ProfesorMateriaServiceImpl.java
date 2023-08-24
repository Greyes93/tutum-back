package mx.gufe.escuela.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.gufe.escuela.dto.ProfesorMateriaDTO;
import mx.gufe.escuela.model.Materia;
import mx.gufe.escuela.model.Profesor;
import mx.gufe.escuela.model.ProfesorMateria;
import mx.gufe.escuela.repositories.ProfesorMateriaRepository;
import mx.gufe.escuela.service.ProfesorMateriaService;
import mx.gufe.escuela.utils.EscuelaException;
import mx.gufe.escuela.utils.OveralResponse;

@Service
public class ProfesorMateriaServiceImpl implements ProfesorMateriaService {
	
	final static Logger logger = Logger.getLogger(ProfesorMateriaServiceImpl.class);
	
	
	@Autowired
	private ProfesorMateriaRepository profesorRepository;

	@Override
	public List<Materia> allMaterias(Integer idProfesor) throws EscuelaException {
		List<Materia> lstMaterias = new ArrayList<>();
		try {
			profesorRepository.findAllByProfesor(idProfesor).forEach(profesor -> lstMaterias.add(profesor.getMateria()));
			return lstMaterias;
		}catch(Exception e) {
			logger.error("Error al consultar las materias del profesor" + e.getMessage());
			throw new EscuelaException("Error al consultar las materias del profesor" + e.getMessage());
		}
	}

	@Override
	public OveralResponse insert(ProfesorMateriaDTO profesorMateria) throws EscuelaException{
		
		if(profesorMateria.getIdProfesorMateria() != null)
			throw new EscuelaException("Ya existe esa materia para este profesor");
		
		Materia materia = new Materia();
		materia.setId(profesorMateria.getIdMateria());
		
		Profesor profesor = new Profesor();
		profesor.setId(profesorMateria.getIdProfesor());
		
		
		ProfesorMateria pMateria = new ProfesorMateria();
		pMateria.setMateria(materia);
		pMateria.setProfesor(profesor);
		pMateria.setFechaRegistro(new Date());
		
		try {
			profesorRepository.save(pMateria);
			return new OveralResponse("Ok", "Materia registrada");
		}catch(Exception ex) {
			logger.error("Error al guardar materia del profesor: " + ex.getMessage());
			throw new EscuelaException("Error al guardar materia del profesor: " + ex.getMessage());
		}
	}

	@Override
	public OveralResponse delete(Integer idProfesor, Integer idProfesorMateria)
			throws EscuelaException {
		
		if(idProfesorMateria == null || idProfesorMateria == 0)
			throw new EscuelaException("No se ha seleccionado la materia a eliminar");
		
		try {
			
			List<ProfesorMateria> profesorMaterias =  profesorRepository.findAllByProfesor(idProfesor);
			
			if(profesorMaterias.isEmpty())
				throw new EscuelaException("Este profesor no tiene materias asignadas");
		
			
			profesorRepository.deleteById(idProfesorMateria);
			return new OveralResponse("OK", "Materia eliminada correctamente");
		}catch(Exception ex) {
			logger.error("Error al eliminar materia del profesor" + ex.getMessage());
			throw new EscuelaException("Error al eliminar materia del profesor" + ex.getMessage());
		}
	}

}

package mx.gufe.escuela.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mx.gufe.escuela.dto.ProfesorMateriaDTO;
import mx.gufe.escuela.model.Materia;
import mx.gufe.escuela.service.ProfesorMateriaService;
import mx.gufe.escuela.utils.EscuelaException;
import mx.gufe.escuela.utils.OveralResponse;

@Controller
@RequestMapping("profesor")
@CrossOrigin(origins="*",methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
public class ProfesorController {
	
	@Autowired
	private ProfesorMateriaService profesorMateriaService;
	
	
	@GetMapping("{idProfesor}/materias")
	public ResponseEntity<List<Materia>> allMaterias(@PathVariable int idProfesor){
		List<Materia> materias = new ArrayList<>();
		try {
			materias = profesorMateriaService.allMaterias(idProfesor);
			return new ResponseEntity<>(materias, HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<>(materias, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("{idProfesor}/materias")
	public ResponseEntity<OveralResponse> insert(@PathVariable int idProfesor, @RequestBody ProfesorMateriaDTO profesorMateria){
		try {
			profesorMateria.setIdProfesor(idProfesor);
			OveralResponse response = profesorMateriaService.insert(profesorMateria);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}catch(EscuelaException e) {
			OveralResponse responseError = new OveralResponse("Error", e.getMessage());
			return new ResponseEntity<>(responseError, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("{idProfesor}/materias")
	public ResponseEntity<OveralResponse> delete(@PathVariable int idProfesor, @RequestParam("idProfesorMateria") int idProfesorMateria){
		try {
			OveralResponse response = profesorMateriaService.delete(idProfesor, idProfesorMateria);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}catch(EscuelaException e) {
			OveralResponse responseError = new OveralResponse("Error", e.getMessage());
			return new ResponseEntity<>(responseError, HttpStatus.BAD_REQUEST);
		}
	}
	

}

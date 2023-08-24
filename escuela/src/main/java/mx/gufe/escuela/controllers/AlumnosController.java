package mx.gufe.escuela.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mx.gufe.escuela.model.Alumno;
import mx.gufe.escuela.service.AlumnosService;
import mx.gufe.escuela.utils.EscuelaException;

@Controller
@RequestMapping("alumnos")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET})
public class AlumnosController {
	@Autowired
	private AlumnosService alumnosService;
	
	@GetMapping
	public ResponseEntity<List<Alumno>> alumnos () {
		List<Alumno> resp = new ArrayList<>(); 
		try {
			resp = alumnosService.allAlumnos();
			return new ResponseEntity<>(resp, HttpStatus.OK);
		}catch( EscuelaException ee ) {
			return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
		}
	}
}

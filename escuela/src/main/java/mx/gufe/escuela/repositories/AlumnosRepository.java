package mx.gufe.escuela.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.gufe.escuela.model.Alumno;

public interface AlumnosRepository extends JpaRepository<Alumno, Integer> {

}

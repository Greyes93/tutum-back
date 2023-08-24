package mx.gufe.escuela.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import mx.gufe.escuela.model.ProfesorMateria;

public interface ProfesorMateriaRepository extends JpaRepository<ProfesorMateria, Integer>, CrudRepository<ProfesorMateria, Integer>{

	
	@Query("select pm from ProfesorMateria pm where pm.profesor.id = :idProfesor")
	List<ProfesorMateria> findAllByProfesor(Integer idProfesor);
}

package com.example.SpringHello.repositories;

import com.example.SpringHello.models.Actividad;
import com.example.SpringHello.models.Alumno;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author anton
 */
public interface ActividadRepository extends JpaRepository<Actividad, Integer> {

    List<Actividad> findByAlumnoId(Integer id);
}

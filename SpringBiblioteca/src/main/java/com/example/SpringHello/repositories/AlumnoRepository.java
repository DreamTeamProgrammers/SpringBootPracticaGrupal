package com.example.SpringHello.repositories;

import com.example.SpringHello.models.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author anton
 */
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
}

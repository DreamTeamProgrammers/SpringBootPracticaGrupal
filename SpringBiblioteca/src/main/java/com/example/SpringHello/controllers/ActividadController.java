package com.example.SpringHello.controllers;

import ch.qos.logback.core.CoreConstants;
import com.example.SpringHello.models.Actividad;
import com.example.SpringHello.models.Alumno;
import com.example.SpringHello.repositories.ActividadRepository;
import com.example.SpringHello.repositories.AlumnoRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author anton
 */
@RestController
@RequestMapping("/actividad")
public class ActividadController {

    @Autowired
    ActividadRepository repo;
    @Autowired
    AlumnoRepository repoAlumno;
    
    /*Listar todas las actividades*/
    @GetMapping()
    public List<Actividad> list() {
        return repo.findAll();
    }

    /* Listar el detalle de una actividad en concreto */
    @GetMapping("/{id}")
    public Optional<Actividad> getActividadById(@PathVariable Integer id) {
        return repo.findById(id);
    }
    
    /* Listar las actividades de un alumno por su ID */
    @GetMapping("/alumno/{id}")
    public List<Actividad> getByAlumnoId(@PathVariable Integer id) {
        return repo.findByAlumnoId(id);
    }

    /* Actualiza una actividad existente */
    @PostMapping
    public ResponseEntity<Actividad> updateActividad(@RequestBody Actividad input) {
        repo.save(input);
        System.out.println(input.getNombre());
        return new ResponseEntity<>(input, HttpStatus.CREATED);
    }
    
    /* Creamos una actividad para un alumno pasandole su ID*/
    @PostMapping("/{alumnoId}/actividad")
    public ResponseEntity<Actividad> createActividad(@PathVariable Integer alumnoId, @RequestBody Actividad actividad) {
        Optional<Alumno> optionalAlumno = repoAlumno.findById(alumnoId);
        if (optionalAlumno.isPresent()) {
            Alumno alumno = optionalAlumno.get();
            actividad.setAlumno(alumno);
            Actividad savedActividad = repo.save(actividad);
            return new ResponseEntity<>(savedActividad, HttpStatus.CREATED);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Optional<Actividad> actividadBorrada = repo.findById(id);
        repo.deleteById(id);
        return new ResponseEntity<>(actividadBorrada, HttpStatus.OK);
    }
    
}

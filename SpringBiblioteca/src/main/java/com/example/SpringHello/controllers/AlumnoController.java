package com.example.SpringHello.controllers;

import com.example.SpringHello.models.Alumno;
import com.example.SpringHello.models.AlumnoDTO;
import com.example.SpringHello.repositories.AlumnoRepository;
import java.util.ArrayList;
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
@RequestMapping("/alumno")
public class AlumnoController {

    @Autowired
    AlumnoRepository repo;

    @GetMapping()
    public List<Alumno> list() {
        return repo.findAll();
    }

    /* Listas un alumno por su ID */
    @GetMapping("/{id}")
    public Optional<Alumno> getAlumnoById(@PathVariable Integer id) {
        return repo.findById(id);
    }

    /* Listar las estadisticas de un alumno por su ID. Creamos un alumnoDTO */
    @GetMapping("/estadisticas/{id}")
    public AlumnoDTO getEstadisticasByAlumnoId(@PathVariable Integer id) {
        Optional<Alumno> alumnoActual = repo.findById(id);
        AlumnoDTO alumnoDTO = createAlumnoDTO(alumnoActual);
        
        return alumnoDTO;
    }

    @PostMapping
    public ResponseEntity<Alumno> post(@RequestBody Alumno input) {
        repo.save(input);
        System.out.println(input.getNombre());
        return new ResponseEntity<>(input, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Optional<Alumno> alumnoBorrado = repo.findById(id);
        repo.deleteById(id);
        return new ResponseEntity<>(alumnoBorrado, HttpStatus.OK);
    }
    
    public AlumnoDTO createAlumnoDTO(Optional<Alumno> alumnoActual){
        AlumnoDTO alumnoDTO = new AlumnoDTO();
        alumnoDTO.setNombre(alumnoActual.get().getNombre());
        alumnoDTO.setApellidos(alumnoActual.get().getApellidos());
        alumnoDTO.setHoras_dual(alumnoActual.get().getHoras_dual());
        alumnoDTO.setHoras_fct(alumnoActual.get().getHoras_fct());
        Integer horasTotales = alumnoActual.get().getHoras_dual() + alumnoActual.get().getHoras_fct();
        alumnoDTO.setHoras_totales(horasTotales);
        alumnoDTO.setTutor(alumnoActual.get().getProfesor().getNombre() +" "+ alumnoActual.get().getProfesor().getApellidos());
        alumnoDTO.setEmpresa(alumnoActual.get().getEmpresa().getNombre());
        
        return alumnoDTO;
    }
            
        
}

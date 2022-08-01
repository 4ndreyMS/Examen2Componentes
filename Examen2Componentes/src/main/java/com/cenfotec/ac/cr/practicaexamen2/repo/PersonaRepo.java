package com.cenfotec.ac.cr.practicaexamen2.repo;

import com.cenfotec.ac.cr.practicaexamen2.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonaRepo extends JpaRepository<Persona, Long> {
    public List<Persona> findByNombreContainingIgnoreCaseOrApellido1ContainingIgnoreCase(String nombre, String apellido1);
}

package com.cenfotec.ac.cr.practicaexamen2.service;

import com.cenfotec.ac.cr.practicaexamen2.domain.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaService {
    void registrarPersona(Persona persona);
    List<Persona> listarPersonas();
    void updatePersona(Persona persona);
    Optional<Persona> get(long id);
    public void save(Persona persona);

    public List<Persona> findBy(Persona persona);
}

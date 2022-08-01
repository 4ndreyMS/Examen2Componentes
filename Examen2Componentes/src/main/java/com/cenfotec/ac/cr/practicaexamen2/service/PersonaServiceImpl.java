package com.cenfotec.ac.cr.practicaexamen2.service;

import com.cenfotec.ac.cr.practicaexamen2.domain.Persona;
import com.cenfotec.ac.cr.practicaexamen2.repo.PersonaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    PersonaRepo personaRepo;

    @Override
    public void registrarPersona(Persona persona){
        personaRepo.save(persona);
    }

    @Override
    public List<Persona> listarPersonas(){
        return personaRepo.findAll();
    }

    @Override
    public void updatePersona(Persona pPersona) {
        Optional<Persona> retPertsona = personaRepo.findById(pPersona.getId());
        Persona updPersona = new Persona();
        updPersona.setId(retPertsona.get().getId());
        updPersona.setNombre(pPersona.getNombre());
        updPersona.setNombre(pPersona.getApellido1());
        updPersona.setNombre(pPersona.getApellido2());
        personaRepo.save(updPersona);
    }

    @Override
    public Optional<Persona> get(long id) {
        return personaRepo.findById(id);
    }

    @Override
    public void save(Persona persona) {
        personaRepo.save(persona);
    }

    @Override
    public List<Persona> findBy(Persona persona) {
        String nom = persona.getNombre();
        String ape = persona.getApellido1();

        if (nom.equals("")){
            nom = "nulo";
        }
        if (ape.equals("")){
            ape = "nulo";
        }

        List<Persona> lista =this.personaRepo.findByNombreContainingIgnoreCaseOrApellido1ContainingIgnoreCase(nom, ape);

        return lista;
    }
}

package com.cenfotec.ac.cr.practicaexamen2.service;

import com.cenfotec.ac.cr.practicaexamen2.domain.Imc;
import com.cenfotec.ac.cr.practicaexamen2.domain.Persona;
import com.cenfotec.ac.cr.practicaexamen2.repo.ImcRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImcServiceImp implements ImcService  {
    @Autowired
    ImcRepo imcRepo;
    @Override
    public void registrarImc(Persona persona) {
        Imc imc = new Imc();
        imc.setImc(persona.getPeso(), persona.getAltura());
        imc.setPersona(persona);
        imcRepo.save(imc);
    }
    @Override
    public void save(Imc imc) {

    }
}

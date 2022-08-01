package com.cenfotec.ac.cr.practicaexamen2.service;

import com.cenfotec.ac.cr.practicaexamen2.domain.Imc;
import com.cenfotec.ac.cr.practicaexamen2.domain.Persona;

public interface ImcService {

    void registrarImc(Persona imc);
    public void save(Imc imc);
}

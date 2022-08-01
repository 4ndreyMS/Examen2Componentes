package com.cenfotec.ac.cr.practicaexamen2.controller;

import com.cenfotec.ac.cr.practicaexamen2.domain.Imc;
import com.cenfotec.ac.cr.practicaexamen2.domain.Persona;
import com.cenfotec.ac.cr.practicaexamen2.service.ImcService;
import com.cenfotec.ac.cr.practicaexamen2.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @Autowired
    ImcService imcService;

    @RequestMapping("/")
    private String homePage(Model model){
        return "index";
    }

    @RequestMapping("/registrar")
    private String getRegistrarPage(Model model){
        Persona persona = new Persona();
        model.addAttribute("persona", persona);
        return "registrar";
    }

    @RequestMapping(value = "/registrar", method = RequestMethod.POST)
    private String registrarPage(Model model, Persona persona, BindingResult result){
        personaService.registrarPersona(persona);
        imcService.registrarImc(persona);
        return "exito";
    }

    @RequestMapping(value = "/listar")
    private String getListPersonas(Model model) {
        model.addAttribute("lista", personaService.listarPersonas());
        return "listar";
    }

    @RequestMapping({"/detalle/{id}"})
    public String getDetallePersona(Model model, @PathVariable long id) {
        Optional<Persona> persona = this.personaService.get(id);
        Persona newPersona=  new Persona();
        if (persona.isPresent()) {
            newPersona = ((Persona)persona.get());
            newPersona.getLastImc();
            model.addAttribute("persona",newPersona);
            return "detalle";
        } else {
            return "notFound";
        }
    }

    @RequestMapping("/actualizar/{id}")
    private String getActualizarPage(Model model, @PathVariable long id){
        Optional<Persona> persona = this.personaService.get(id);
        Persona updPersona = new Persona();
        if (persona.isPresent()) {
            model.addAttribute("persona", ((Persona)persona.get()));
            model.addAttribute("updPersona", updPersona);
            return "actualizar";
        } else {
            return "notFound";
        }
    }

    @RequestMapping(value = "/actualizar/{id}", method = RequestMethod.POST)
    private String getActualizarPage(Model model, Persona persona, @PathVariable long id){
        Optional<Persona> retPersona = this.personaService.get(id);
        Persona newPersona = ((Persona)retPersona.get());
        persona.setNombre(newPersona.getNombre());
        persona.setApellido1(newPersona.getApellido1());
        persona.setApellido2(newPersona.getApellido2());
        persona.setRama(newPersona.getRama());
        persona.setPosicion(newPersona.getPosicion());
        persona.setAltura(newPersona.getAltura());
        persona.setFechaNacimiento(newPersona.getFechaNacimiento());
        //hacer validacion del imc
        if ( Double.compare(persona.getPeso(),newPersona.getPeso()) != 0){
            //agregar el imc
            imcService.registrarImc(persona);
        }
        this.personaService.save(persona);

        return "exito";
    }

    @RequestMapping("/historico-imc/{id}")
    private String getHistorialImc(Model model, @PathVariable long id){
        Optional<Persona> persona = this.personaService.get(id);
        Persona updPersona = new Persona();
        if (persona.isPresent()) {
            model.addAttribute("lista", ((Persona)persona.get()).getImc());
            model.addAttribute("persona", ((Persona)persona.get()));
            return "historialImc";
        } else {
            return "notFound";
        }
    }


    @RequestMapping(value = "/buscar")
    private String buscarPersonas(Model model) {
        model.addAttribute("persona", new Persona());
        return "buscar";
    }

    @RequestMapping(value = "/buscar", method = RequestMethod.POST)
    private String buscarPage(Model model, Persona persona, BindingResult result){
        model.addAttribute("lista", personaService.findBy(persona));
        return "listar";
    }

}

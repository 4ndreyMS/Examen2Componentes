package com.cenfotec.ac.cr.practicaexamen2.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
public class Imc {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private long id;
    private String fechaCalculoImc;
    private double valor;
    private double ultimoValor;
    @ManyToOne
    @JoinColumn(
            nullable = false
    )
    private Persona persona;


    public Imc(Persona imc) {
    }
    public Imc() {
    }

    public double getUltimoValor() {
        return ultimoValor;
    }

    public void setUltimoValor(double ultimoValor) {
        this.ultimoValor = ultimoValor;
    }

    public void setImc(double peso, double altura) {
        this.valor = peso / (altura*altura);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd");
        LocalDate localDate = LocalDate.now();
        setFechaCalculoImc(dtf.format(localDate));
        setUltimoValor(this.valor);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFechaCalculoImc() {
        return fechaCalculoImc;
    }

    public void setFechaCalculoImc(String fechaCalculoImc) {
        this.fechaCalculoImc = fechaCalculoImc;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}

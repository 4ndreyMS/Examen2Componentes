package com.cenfotec.ac.cr.practicaexamen2.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.function.DoubleConsumer;

@Entity
public class Persona {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private long id;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "persona"
    )
    private Set<Imc> imc;
    private double ultimoValor;
    private String fechaUltimoValor;

    public String getFechaUltimoValor() {
        return fechaUltimoValor;
    }

    public void setFechaUltimoValor(String fechaUltimoValor) {
        this.fechaUltimoValor = fechaUltimoValor;
    }

    private String nombre;
    private String apellido1;
    private String apellido2;
    private String posicion;
    private String fechaNacimiento;
    private Double altura;
    private Double peso;
    private String rama;

    private String direccion;
    private String email;
    private String telefono;
    private String provincia;
    private String canton;
    private String distrito;
    public Persona() {
    }
    public Set<Imc> getImc() {
        return imc;
    }
    public void setImc(Set<Imc> imc) {
        this.imc = imc;
    }

    public void getLastImc(){
        double value = 0.0;
        String fecha = "";
        for (Imc val: imc) {
            value = val.getValor();
            fecha = val.getFechaCalculoImc();
            break;
        }
        setFechaUltimoValor(fecha);
        setUltimoValor(value);
    }

    public double getUltimoValor() {
        return ultimoValor;
    }

    public void setUltimoValor(double ultimoValor) {
        this.ultimoValor = ultimoValor;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getRama() {
        return rama;
    }

    public void setRama(String rama) {
        this.rama = rama;
    }


}

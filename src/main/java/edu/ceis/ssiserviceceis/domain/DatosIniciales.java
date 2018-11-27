package edu.ceis.ssiserviceceis.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class DatosIniciales extends ModelBase{
    @Column
    private int capacidad;
    @Column
    private int pisos;
    @Column
    private int tiempo;
    @Column
    private int emergencia;
    @Column
    private int paciente;
    @Column
    private int personal;
    @Column
    private int servicio;
    @Column
    private int visita;

    public DatosIniciales(int capacidad, int pisos, int tiempo, int emergencia,
                          int paciente, int personal, int servicio, int visita) {
        this.capacidad = capacidad;
        this.pisos = pisos;
        this.tiempo = tiempo;
        this.emergencia = emergencia;
        this.paciente = paciente;
        this.personal = personal;
        this.servicio = servicio;
        this.visita = visita;
    }
    public DatosIniciales(){};

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getPisos() {
        return pisos;
    }

    public void setPisos(int pisos) {
        this.pisos = pisos;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public int getEmergencia() {
        return emergencia;
    }

    public void setEmergencia(int emergencia) {
        this.emergencia = emergencia;
    }

    public int getPaciente() {
        return paciente;
    }

    public void setPaciente(int paciente) {
        this.paciente = paciente;
    }

    public int getPersonal() {
        return personal;
    }

    public void setPersonal(int personal) {
        this.personal = personal;
    }

    public int getServicio() {
        return servicio;
    }

    public void setServicio(int servicio) {
        this.servicio = servicio;
    }

    public int getVisita() {
        return visita;
    }

    public void setVisita(int visita) {
        this.visita = visita;
    }
}


package edu.ceis.ssiserviceceis.Dao;

import edu.ceis.ssiserviceceis.domain.DatosIniciales;
import edu.ceis.ssiserviceceis.domain.ModelBase;

public class DatosInicialesDto extends DtoBase {
    private int capacidad;
    private int pisos;
    private int tiempo;
    private int emergencia;
    private int paciente;
    private int personal;
    private int servicio;
    private int visita;

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

    public DatosInicialesDto(DatosIniciales datosIniciales){
        setId(datosIniciales.getId());
        this.capacidad = datosIniciales.getCapacidad();
        this.pisos = datosIniciales.getPisos();
        this.tiempo = datosIniciales.getTiempo();
        this.emergencia = datosIniciales.getEmergencia();
        this.paciente = datosIniciales.getPaciente();
        this.personal = datosIniciales.getPersonal();
        this.servicio = datosIniciales.getServicio();
        this.visita = datosIniciales.getVisita();
    }

    public DatosInicialesDto(){}

    public DatosIniciales toDatosInciales(){
        DatosIniciales datosIniciales = new DatosIniciales();
        datosIniciales.setCapacidad(getCapacidad());
        datosIniciales.setPisos(getPisos());
        datosIniciales.setTiempo(getTiempo());
        datosIniciales.setEmergencia(getEmergencia());
        datosIniciales.setPaciente(getPaciente());
        datosIniciales.setPersonal(getPersonal());
        datosIniciales.setServicio(getServicio());
        datosIniciales.setVisita(getVisita());
        return datosIniciales;
    }

    @Override
    public DtoBase toDto(ModelBase element) {
        DatosInicialesDto datosInicialesDto = new DatosInicialesDto();
        datosInicialesDto.setId(element.getId());
        DatosIniciales datosIniciales = (DatosIniciales) element;
        datosInicialesDto.setCapacidad(datosIniciales.getCapacidad());
        datosInicialesDto.setPisos(datosIniciales.getPisos());
        datosInicialesDto.setTiempo(datosIniciales.getTiempo());
        datosInicialesDto.setEmergencia(datosIniciales.getEmergencia());
        datosInicialesDto.setPaciente(datosIniciales.getPaciente());
        datosInicialesDto.setPersonal(datosIniciales.getPersonal());
        datosInicialesDto.setServicio(datosIniciales.getServicio());
        datosInicialesDto.setVisita(datosIniciales.getVisita());
        return datosInicialesDto;
    }
}

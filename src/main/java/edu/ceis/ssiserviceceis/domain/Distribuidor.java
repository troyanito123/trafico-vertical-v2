package edu.ceis.ssiserviceceis.domain;

import java.util.ArrayList;

public class Distribuidor {
    private ArrayList<Llamada> emergencia;
    private ArrayList<Llamada> emergenciaListo;
    private ArrayList<Llamada> paciente;
    private ArrayList<Llamada> pacienteListo;
    private ArrayList<Llamada> personal;
    private ArrayList<Llamada> personalListo;
    private ArrayList<Llamada> servicio;
    private ArrayList<Llamada> servicioListo;
    private ArrayList<Llamada> visita;
    private ArrayList<Llamada> visitaListo;
    private Generador generador;

    public Distribuidor(){
        this.emergencia = new ArrayList<>();
        this.emergenciaListo = new ArrayList<>();
        this.paciente = new ArrayList<>();
        this.pacienteListo = new ArrayList<>();
        this.personal = new ArrayList<>();
        this.personalListo = new ArrayList<>();
        this.servicio = new ArrayList<>();
        this.servicioListo = new ArrayList<>();
        this.visita = new ArrayList<>();
        this.visitaListo = new ArrayList<>();
        this.generador = new Generador();
    }

    public void generarLlamadas(int capacidad, int pisos, int tiempo){
        generador.generarVariables(capacidad, tiempo);
        generarEmergencia(generador.getEmergencia(), pisos);
        generarPaciente(generador.getPaciente(), pisos);
        generarPersonal(generador.getPersonal(), pisos);
        generarServicio(generador.getServicio(), pisos);
        generarVisita(generador.getVisita(), pisos);
    }

    public void distribuirLlamadas(int capacidad, int pisos, int tiempo, int emergencia, int paciente,
                                   int personal, int servicio, int visita) {
        generarLlamadas(capacidad, pisos, tiempo);
        if(paciente < 1){
            emergenciaListo = mixEP();
            pacienteListo = new ArrayList<>();
        }else{
            emergenciaListo = this.emergencia;
            pacienteListo = this.paciente;
        }
        if(personal >= 1){
            personalListo = this.personal;
        }
        else{
            personalListo = new ArrayList<>();
        }
        if(servicio >= 1){
            servicioListo = this.servicio;
        }
        else{
            servicioListo = new ArrayList<>();
        }
        if(visita >= 1){
            visitaListo = this.visita;
        }
        else{
            visitaListo = new ArrayList<>();
        }
    }

    private ArrayList<Llamada> mixEP() {
        ArrayList<Llamada> res = new ArrayList<>();
        int lim1 = emergencia.size();
        int lim2 = paciente.size();
        int lim = lim1 + lim2;
        for (int i=0; i < lim; i++){
            if(i < lim1)
                res.add(emergencia.get(i));
            if (i < lim2)
                res.add(paciente.get(i));
        }
        return res;
    }

    public void generarVisita(ArrayList<Integer> visita, int pisos) {
        int t = visita.size();
        int pisoA = 0;
        int pisoD = 0;
        int tl = 0;
        int te = 0;
        for (int i = 0; i < t; i++){
            if(visita.get(i) == 1){
                pisoA = (int)(Math.random()*pisos);
                pisoD = (int)(Math.random()*pisos);
                while (pisoA == pisoD){
                    pisoD = (int)(Math.random()*pisos);
                }
                tl = i;
                te = (int)(Math.random()*4) + 1;
                this.visita.add(new Llamada(pisoA, pisoD, tl, te));
            }
        }
    }

    private void generarServicio(ArrayList<Integer> servicio, int pisos) {
        int t = servicio.size();
        int pisoA = 0;
        int pisoD = 0;
        int tl = 0;
        int te = 0;
        for (int i = 0; i < t; i++){
            if(servicio.get(i) == 1){
                pisoA = (int)(Math.random()*pisos);
                pisoD = (int)(Math.random()*pisos);
                while (pisoA == pisoD){
                    pisoD = (int)(Math.random()*pisos);
                }
                tl = i;
                te = (int)(Math.random()*4) + 1;
                this.servicio.add(new Llamada(pisoA, pisoD, tl, te));
            }
        }
    }

    private void generarPersonal(ArrayList<Integer> personal, int pisos) {
        int t = personal.size();
        int pisoA = 0;
        int pisoD = 0;
        int tl = 0;
        int te = 0;
        for (int i = 0; i < t; i++){
            if(personal.get(i) == 1){
                pisoA = (int)(Math.random()*pisos);
                pisoD = (int)(Math.random()*pisos);
                while (pisoA == pisoD){
                    pisoD = (int)(Math.random()*pisos);
                }
                tl = i;
                te = (int)(Math.random()*4) + 1;
                this.personal.add(new Llamada(pisoA, pisoD, tl, te));
            }
        }
    }

    private void generarPaciente(ArrayList<Integer> paciente, int pisos) {
        int t = paciente.size();
        int pisoA = 0;
        int pisoD = 0;
        int tl = 0;
        int te = 0;
        for (int i = 0; i < t; i++){
            if(paciente.get(i) == 1){
                pisoA = (int)(Math.random()*pisos);
                pisoD = (int)(Math.random()*pisos);
                while (pisoA == pisoD){
                    pisoD = (int)(Math.random()*pisos);
                }
                tl = i;
                te = (int)(Math.random()*4) + 1;
                this.paciente.add(new Llamada(pisoA, pisoD, tl, te));
            }
        }
    }

    private void generarEmergencia(ArrayList<Integer> emergencia, int pisos) {
        int t = emergencia.size();
        int pisoA = 0;
        int pisoD = 0;
        int tl = 0;
        int te = 0;
        for (int i = 0; i < t; i++){
            if(emergencia.get(i) == 1){
                pisoA = (int)(Math.random()*pisos);
                pisoD = (int)(Math.random()*pisos);
                while (pisoA == pisoD){
                    pisoD = (int)(Math.random()*pisos);
                }
                tl = i;
                te = (int)(Math.random()*4) + 1;
                this.emergencia.add(new Llamada(pisoA, pisoD, tl, te));
            }
        }
    }


    public ArrayList<Llamada> getEmergenciaListo() {
        return emergenciaListo;
    }

    public ArrayList<Llamada> getPacienteListo() {
        return pacienteListo;
    }

    public ArrayList<Llamada> getPersonalListo() {
        return personalListo;
    }

    public ArrayList<Llamada> getServicioListo() {
        return servicioListo;
    }

    public ArrayList<Llamada> getVisitaListo() {
        return visitaListo;
    }

    public ArrayList<Llamada> getVisita() {
        return visita;
    }

    public Generador getGenerador() {
        return generador;
    }
}


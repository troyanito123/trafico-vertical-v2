package edu.ceis.ssiserviceceis.domain;

import java.util.ArrayList;

public class Generador {

    private ArrayList<Integer> emergencia;
    private ArrayList<Integer> paciente;
    private ArrayList<Integer> personal;
    private ArrayList<Integer> servicio;
    private ArrayList<Integer> visita;

    public Generador(){
        this.emergencia = new ArrayList<>();
        this.paciente = new ArrayList<>();
        this.personal = new ArrayList<>();
        this.servicio = new ArrayList<>();
        this.visita = new ArrayList<>();
    }

    public void generarVariables(int capacidad, int tiempo){
        generarEmergencia(capacidad, tiempo);
        generarPaciente(capacidad, tiempo);
        generarPersonal(capacidad, tiempo);
        generarServicio(capacidad, tiempo);
        generarVisita(capacidad, tiempo);
    }

    public void generarVisita(int capacidad, int tiempo) {
        int tiempoMin = tiempo*1440;
        double ran = 0;
        int limite = 1440;
        int cont1 = 0;
        int cont2 = 0;
        double var1 = 0.30;
        double var2 = 0.30;
        for (int i=0; i <= tiempoMin; i++ ){
            if (i == limite) {
                limite = limite + 1440;
                var1 = 0.30;
                var2 = 0.30;
                cont1 = 0;
                cont2 = 0;
            }
            if (cont1 >= capacidad)
                var1 = 1;
            if (cont2 >= capacidad)
                var2 = 1;
            if (i >= limite-780 && i<=limite-660){
                ran = Math.random();
                if(ran <= var1)
                    visita.add(0);
                else {
                    visita.add(1);
                    cont1 ++;
                }
            }else{
                if (i >= limite-480 && i<=limite-360){
                    ran = Math.random();
                    if(ran <= var2)
                        visita.add(0);
                    else {
                        visita.add(1);
                        cont2 ++;
                    }
                }else{
                    ran = Math.random();
                    if(ran <= 0.995)
                        visita.add(0);
                    else
                        visita.add(1);
                }
            }
        }
    }

    public void generarServicio(int capacidad, int tiempo) {
        int tiempoMin = tiempo*1440;
        //capacidad = capacidad*3;
        double ran = 0;
        int limite = 1440;
        int cont1 = 0;
        int cont2 = 0;
        int cont3 = 0;
        double varM = 0.85;
        double varT = 0.85;
        double varN = 0.85;
        for (int i=0; i <= tiempoMin; i++ ){
            if (i == limite) {
                limite = limite + 1440;
                varM = 0.85;
                varT = 0.85;
                varN = 0.85;
                cont1 = 0;
                cont2 = 0;
                cont3 = 0;
            }
            if (cont1 >= (capacidad/10)*0.90)
                varM = 1;
            if (cont2 >= (capacidad/10)*0.90)
                varT = 1;
            if (cont3 >= (capacidad/10)*0.90)
                varN = 1;
            if (i >= limite-1080 && i<=limite-1020){
                ran = Math.random();
                if(ran <= varM)
                    servicio.add(0);
                else {
                    servicio.add(1);
                    cont1 ++;
                }
            }else{
                if (i >= limite-720 && i<=limite-660){
                    ran = Math.random();
                    if(ran <= varT)
                        servicio.add(0);
                    else {
                        servicio.add(1);
                        cont2 ++;
                    }
                }else
                if (i >= limite-420 && i<=limite-360){
                    ran = Math.random();
                    if(ran <= varN)
                        servicio.add(0);
                    else {
                        servicio.add(1);
                        cont3 ++;
                    }
                }else{
                    ran = Math.random();
                    if(ran <= 0.99)
                        servicio.add(0);
                    else
                        servicio.add(1);
                }
            }
        }
    }

    public void generarPersonal(int capacidad, int tiempo) {
        int tiempoMin = tiempo*1440;
        capacidad = capacidad*2;
        double ran = 0;
        int limite = 1440;
        int cont1 = 0;
        int cont2 = 0;
        int cont3 = 0;
        double varM = 0.30;
        double varT = 0.30;
        double varN = 0.80;
        for (int i=0; i <= tiempoMin; i++ ){
            if (i == limite) {
                limite = limite + 1440;
                varM = 0.30;
                varT = 0.30;
                varN = 0.80;
                cont1 = 0;
                cont2 = 0;
                cont3 = 0;
            }
            if (cont1 >= capacidad*0.35)
                varM = 1;
            if (cont2 >= capacidad*0.35)
                varT = 1;
            if (cont3 >= capacidad*0.15)
                varN = 1;
            if (i >= limite-1110 && i<=limite-1050){
                ran = Math.random();
                if(ran <= varM)
                    personal.add(0);
                else {
                    personal.add(1);
                    cont1 ++;
                }
            }else{
                if (i >= limite-630 && i<=limite-570){
                    ran = Math.random();
                    if(ran <= varT)
                        personal.add(0);
                    else {
                        personal.add(1);
                        cont2 ++;
                    }
                }else
                if (i >= limite-150 && i<=limite-90){
                    ran = Math.random();
                    if(ran <= varN)
                        personal.add(0);
                    else {
                        personal.add(1);
                        cont3 ++;
                    }
                }else{
                    ran = Math.random();
                    if(ran <= 0.90)
                        personal.add(0);
                    else
                        personal.add(1);
                }
            }
        }
    }

    public void generarPaciente(int capacidad, int tiempo) {
        int tiempoMin = tiempo*1440;
        double ran = 0;
        int limite = 1440;
        int cont1 = 0;
        int cont2 = 0;
        double var1 = 0.50;
        double var2 = 0.50;
        for (int i=0; i <= tiempoMin; i++ ){
            if (i == limite) {
                limite = limite + 1440;
                var1 = 0.50;
                var2 = 0.50;
                cont1 = 0;
                cont2 = 0;
            }
            if (cont1 >= capacidad*0.65)
                var1 = 1;
            if (cont2 >= capacidad*0.65)
                var2 = 1;
            if (i >= limite-840 && i<=limite-720){
                ran = Math.random();
                if(ran <= var1)
                    paciente.add(0);
                else {
                    paciente.add(1);
                    cont1 ++;
                }
            }else{
                if (i >= limite-600 && i<=limite-480){
                    ran = Math.random();
                    if(ran <= var2)
                        paciente.add(0);
                    else {
                        paciente.add(1);
                        cont2 ++;
                    }
                }else{
                    ran = Math.random();
                    if(ran <= 0.95)
                        paciente.add(0);
                    else
                        paciente.add(1);
                }
            }
        }
    }

    public void generarEmergencia(int capacidad, int tiempo) {
        int tiempoMin = tiempo*1440;
        double ran = 0;
        for (int i=0; i <= tiempoMin; i++ ){
            ran = Math.random();
            if(ran <= 0.98)
                emergencia.add(0);
            else
                emergencia.add(1);
        }
    }

    public ArrayList<Integer> getEmergencia() {
        return emergencia;
    }

    public void setEmergencia(ArrayList<Integer> emergencia) {
        this.emergencia = emergencia;
    }

    public ArrayList<Integer> getPaciente() {
        return paciente;
    }

    public void setPaciente(ArrayList<Integer> paciente) {
        this.paciente = paciente;
    }

    public ArrayList<Integer> getPersonal() {
        return personal;
    }

    public void setPersonal(ArrayList<Integer> personal) {
        this.personal = personal;
    }

    public ArrayList<Integer> getServicio() {
        return servicio;
    }

    public void setServicio(ArrayList<Integer> servicio) {
        this.servicio = servicio;
    }

    public ArrayList<Integer> getVisita() {
        return visita;
    }

    public void setVisita(ArrayList<Integer> visita) {
        this.visita = visita;
    }
}


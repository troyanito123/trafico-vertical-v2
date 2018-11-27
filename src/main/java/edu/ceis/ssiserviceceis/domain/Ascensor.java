package edu.ceis.ssiserviceceis.domain;

import java.util.ArrayList;

public class Ascensor extends ModelBase{
    private String tipo;
    private int capacidad;
    private ArrayList<Llamada> llamadas;

    public Ascensor(){
        this.tipo = "";
        this.capacidad = 8;
        this.llamadas = new ArrayList<>();
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Llamada> getLlamadas() {
        return llamadas;
    }

    public void setLlamadas(ArrayList<Llamada> llamadas) {
        this.llamadas = llamadas;
    }
}

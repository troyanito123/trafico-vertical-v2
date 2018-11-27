package edu.ceis.ssiserviceceis.domain;

public class Llamada extends ModelBase{
    private int pisoActual;
    private int pisoDeseado;
    private int tiempoLLegada;
    private int tiempoEspera;

    public Llamada() {
        this.pisoActual = 0;
        this.pisoDeseado = 0;
        this.tiempoLLegada = 0;
        this.tiempoEspera = 0;
    }

    public Llamada(int pisoActual, int pisoDeseado, int tiempoLLegada, int tiempoEspera) {
        this.pisoActual = pisoActual;
        this.pisoDeseado = pisoDeseado;
        this.tiempoLLegada = tiempoLLegada;
        this.tiempoEspera = tiempoEspera;
    }

    public int getPisoActual() {
        return pisoActual;
    }

    public void setPisoActual(int pisoActual) {
        this.pisoActual = pisoActual;
    }

    public int getPisoDeseado() {
        return pisoDeseado;
    }

    public void setPisoDeseado(int pisoDeseado) {
        this.pisoDeseado = pisoDeseado;
    }

    public int getTiempoLLegada() {
        return tiempoLLegada;
    }

    public void setTiempoLLegada(int tiempoLLegada) {
        this.tiempoLLegada = tiempoLLegada;
    }

    public int getTiempoEspera() {
        return tiempoEspera;
    }

    public void setTiempoEspera(int tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }

    @Override
    public String toString() {
        return "Llamada{" +
                "pisoActual=" + pisoActual +
                ", pisoDeseado=" + pisoDeseado +
                ", tiempoLLegada=" + tiempoLLegada +
                ", tiempoEspera=" + tiempoEspera +
                '}';
    }
}

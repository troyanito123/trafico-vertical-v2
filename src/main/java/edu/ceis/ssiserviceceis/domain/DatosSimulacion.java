package edu.ceis.ssiserviceceis.domain;

import javax.jws.WebParam;
import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class DatosSimulacion extends ModelBase {
    @Column
    private int llamadasEmergencia;
    @Column
    private int llamadasPaciente;
    @Column
    private int llamadasPersonal;
    @Column
    private int llamadasServicio;
    @Column
    private int llamadasVisita;
    @Transient
    private ArrayList<Integer> graficoE;
    @Transient
    private ArrayList<Integer> graficoPa;
    @Transient
    private ArrayList<Integer> graficoPe;
    @Transient
    private ArrayList<Integer> graficoSe;
    @Transient
    private ArrayList<Integer> graficoVi;
    @Column
    private int tiempoUsoE;
    @Column
    private int tiempoUsoPa;
    @Column
    private int tiempoUsoPe;
    @Column
    private int tiempoUsoSe;
    @Column
    private int tiempoUsoVi;

    public DatosSimulacion() {
        this.llamadasEmergencia = 0;
        this.llamadasPaciente = 0;
        this.llamadasPersonal = 0;
        this.llamadasServicio = 0;
        this.llamadasVisita = 0;
        graficoE = new ArrayList<>();
        graficoPa = new ArrayList<>();
        graficoPe = new ArrayList<>();
        graficoSe = new ArrayList<>();
        graficoVi = new ArrayList<>();
        tiempoUsoE = 0;
        tiempoUsoPa = 0;
        tiempoUsoPe = 0;
        tiempoUsoSe = 0;
        tiempoUsoVi = 0;
    }

    public int getLlamadasEmergencia() {
        return llamadasEmergencia;
    }

    public void setLlamadasEmergencia(int llamadasEmergencia) {
        this.llamadasEmergencia = llamadasEmergencia;
    }

    public int getLlamadasPaciente() {
        return llamadasPaciente;
    }

    public void setLlamadasPaciente(int llamadasPaciente) {
        this.llamadasPaciente = llamadasPaciente;
    }

    public int getLlamadasPersonal() {
        return llamadasPersonal;
    }

    public void setLlamadasPersonal(int llamadasPersonal) {
        this.llamadasPersonal = llamadasPersonal;
    }

    public int getLlamadasServicio() {
        return llamadasServicio;
    }

    public void setLlamadasServicio(int llamadasServicio) {
        this.llamadasServicio = llamadasServicio;
    }

    public int getLlamadasVisita() {
        return llamadasVisita;
    }

    public void setLlamadasVisita(int llamadasVisita) {
        this.llamadasVisita = llamadasVisita;
    }

    public ArrayList<Integer> getGraficoE() {
        return graficoE;
    }

    public void setGraficoE(ArrayList<Integer> graficoE) {
        this.graficoE = graficoE;
    }

    public ArrayList<Integer> getGraficoPa() {
        return graficoPa;
    }

    public void setGraficoPa(ArrayList<Integer> graficoPa) {
        this.graficoPa = graficoPa;
    }

    public ArrayList<Integer> getGraficoPe() {
        return graficoPe;
    }

    public void setGraficoPe(ArrayList<Integer> graficoPe) {
        this.graficoPe = graficoPe;
    }

    public ArrayList<Integer> getGraficoSe() {
        return graficoSe;
    }

    public void setGraficoSe(ArrayList<Integer> graficoSe) {
        this.graficoSe = graficoSe;
    }

    public ArrayList<Integer> getGraficoVi() {
        return graficoVi;
    }

    public void setGraficoVi(ArrayList<Integer> graficoVi) {
        this.graficoVi = graficoVi;
    }

    public int getTiempoUsoE() {
        return tiempoUsoE;
    }

    public void setTiempoUsoE(int tiempoUsoE) {
        this.tiempoUsoE = tiempoUsoE;
    }

    public int getTiempoUsoPa() {
        return tiempoUsoPa;
    }

    public void setTiempoUsoPa(int tiempoUsoPa) {
        this.tiempoUsoPa = tiempoUsoPa;
    }

    public int getTiempoUsoPe() {
        return tiempoUsoPe;
    }

    public void setTiempoUsoPe(int tiempoUsoPe) {
        this.tiempoUsoPe = tiempoUsoPe;
    }

    public int getTiempoUsoSe() {
        return tiempoUsoSe;
    }

    public void setTiempoUsoSe(int tiempoUsoSe) {
        this.tiempoUsoSe = tiempoUsoSe;
    }

    public int getTiempoUsoVi() {
        return tiempoUsoVi;
    }

    public void setTiempoUsoVi(int tiempoUsoVi) {
        this.tiempoUsoVi = tiempoUsoVi;
    }


}

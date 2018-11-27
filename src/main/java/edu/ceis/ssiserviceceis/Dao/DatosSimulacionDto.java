package edu.ceis.ssiserviceceis.Dao;

import edu.ceis.ssiserviceceis.domain.DatosSimulacion;
import edu.ceis.ssiserviceceis.domain.ModelBase;

import java.util.ArrayList;

public class DatosSimulacionDto extends DtoBase {
    private int llamadasEmergencia;
    private int llamadasPaciente;
    private int llamadasPersonal;
    private int llamadasServicio;
    private int llamadasVisita;
    private int tiempoUsoE;
    private int tiempoUsoPa;
    private int tiempoUsoPe;
    private int tiempoUsoSe;
    private int tiempoUsoVi;
    /*private ArrayList<Integer> graficoE;
    private ArrayList<Integer> graficoPa;
    private ArrayList<Integer> graficoPe;
    private ArrayList<Integer> graficoSe;
    private ArrayList<Integer> graficoVi;*/

    /*public ArrayList<Integer> getGraficoE() {
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
    }*/

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

    public DatosSimulacionDto (DatosSimulacion datosSimulacion){
        setId(datosSimulacion.getId());
        this.llamadasEmergencia = datosSimulacion.getLlamadasEmergencia();
        this.llamadasPaciente = datosSimulacion.getLlamadasPaciente();
        this.llamadasPersonal = datosSimulacion.getLlamadasPersonal();
        this.llamadasServicio = datosSimulacion.getLlamadasServicio();
        this.llamadasVisita = datosSimulacion.getLlamadasVisita();

        this.tiempoUsoE = datosSimulacion.getTiempoUsoE();
        this.tiempoUsoPa = datosSimulacion.getTiempoUsoPa();
        this.tiempoUsoPe = datosSimulacion.getTiempoUsoPe();
        this.tiempoUsoSe = datosSimulacion.getTiempoUsoSe();
        this.tiempoUsoVi = datosSimulacion.getTiempoUsoVi();

        /*this.graficoE = datosSimulacion.getGraficoE();
        this.graficoPa = datosSimulacion.getGraficoPa();
        this.graficoPe = datosSimulacion.getGraficoPe();
        this.graficoSe = datosSimulacion.getGraficoSe();
        this.graficoVi = datosSimulacion.getGraficoVi();*/

    }

    public DatosSimulacionDto(){}

    public DatosSimulacion toDatosSimulacion(){
        DatosSimulacion datosSimulacion = new DatosSimulacion();
        datosSimulacion.setLlamadasEmergencia(getLlamadasEmergencia());
        datosSimulacion.setLlamadasPaciente(getLlamadasPaciente());
        datosSimulacion.setLlamadasPersonal(getLlamadasPersonal());
        datosSimulacion.setLlamadasServicio(getLlamadasServicio());
        datosSimulacion.setLlamadasVisita(getLlamadasVisita());

        datosSimulacion.setTiempoUsoE(getTiempoUsoE());
        datosSimulacion.setTiempoUsoPa(getTiempoUsoPa());
        datosSimulacion.setTiempoUsoPe(getTiempoUsoPe());
        datosSimulacion.setTiempoUsoSe(getTiempoUsoSe());
        datosSimulacion.setTiempoUsoVi(getTiempoUsoVi());

        /*datosSimulacion.setGraficoE(getGraficoE());
        datosSimulacion.setGraficoPa(getGraficoPa());
        datosSimulacion.setGraficoPe(getGraficoPe());
        datosSimulacion.setGraficoSe(getGraficoSe());
        datosSimulacion.setGraficoVi(getGraficoVi());*/
        return datosSimulacion;
    }

    @Override
    public DtoBase toDto(ModelBase element) {
        DatosSimulacionDto datosSimulacionDto = new DatosSimulacionDto();
        datosSimulacionDto.setId(element.getId());
        DatosSimulacion datosSimulacion = (DatosSimulacion)element;
        datosSimulacionDto.setLlamadasEmergencia(datosSimulacion.getLlamadasEmergencia());
        datosSimulacionDto.setLlamadasPaciente(datosSimulacion.getLlamadasPaciente());
        datosSimulacionDto.setLlamadasPersonal(datosSimulacion.getLlamadasPersonal());
        datosSimulacionDto.setLlamadasServicio(datosSimulacion.getLlamadasServicio());
        datosSimulacionDto.setLlamadasVisita(datosSimulacion.getLlamadasVisita());

        datosSimulacionDto.setTiempoUsoE(datosSimulacion.getTiempoUsoE());
        datosSimulacionDto.setTiempoUsoPa(datosSimulacion.getTiempoUsoPa());
        datosSimulacionDto.setTiempoUsoPe(datosSimulacion.getTiempoUsoPe());
        datosSimulacionDto.setTiempoUsoSe(datosSimulacion.getTiempoUsoSe());
        datosSimulacionDto.setTiempoUsoVi(datosSimulacion.getTiempoUsoVi());

        /*datosSimulacionDto.setGraficoE(datosSimulacion.getGraficoE());
        datosSimulacionDto.setGraficoPa(datosSimulacion.getGraficoPa());
        datosSimulacionDto.setGraficoPe(datosSimulacion.getGraficoPe());
        datosSimulacionDto.setGraficoSe(datosSimulacion.getGraficoSe());
        datosSimulacionDto.setGraficoVi(datosSimulacion.getGraficoVi());*/
        return datosSimulacionDto;
    }
}

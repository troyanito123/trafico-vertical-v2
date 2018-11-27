package edu.ceis.ssiserviceceis.domain;

import org.junit.Test;

public class generadorTest {
    @Test
    public void generadorEmergenciaTest(){
        Generador generador = new Generador();
        generador.generarEmergencia(100,10);
        System.out.println(generador.getEmergencia());
        System.out.println(generador.getEmergencia().size());
    }
    @Test
    public void generadorPacienteTest(){
        Generador generador = new Generador();
        generador.generarPaciente(100,10);
        System.out.println(generador.getPaciente());
        System.out.println(generador.getPaciente().size());
    }
    @Test
    public void generadorPersonalTest(){
        Generador generador = new Generador();
        generador.generarPersonal(100,10);
        System.out.println(generador.getPersonal());
        System.out.println(generador.getPersonal().size());
    }
    @Test
    public void generadorServicioTest(){
        Generador generador = new Generador();
        generador.generarServicio(100,10);
        System.out.println(generador.getServicio());
        System.out.println(generador.getServicio().size());
    }
    @Test
    public void generadorVistaTest(){
        Generador generador = new Generador();
        generador.generarVisita(100,10);
        System.out.println(generador.getVisita());
        System.out.println(generador.getVisita().size());
    }
}

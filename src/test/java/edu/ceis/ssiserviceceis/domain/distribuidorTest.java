package edu.ceis.ssiserviceceis.domain;

import org.junit.Test;

import java.util.ArrayList;

public class distribuidorTest {
    @Test
    public void distribuirLlamadasTest(){
        Generador generador = new Generador();
        Distribuidor distribuidor = new Distribuidor();
        distribuidor.distribuirLlamadas(100,5,10,1,1,1,1,1);
        generador = distribuidor.getGenerador();
        System.out.println("TAMAÑO DE LAS LISTAS DE LLAMADAS");
        System.out.println(distribuidor.getEmergenciaListo().size());
        System.out.println(distribuidor.getPacienteListo().size());
        System.out.println(distribuidor.getPersonalListo().size());
        System.out.println(distribuidor.getServicioListo().size());
        System.out.println(distribuidor.getVisitaListo().size());
        System.out.println("CANTIDAD DE UNOS EN LAS LISTAS DE POSIBLES LLAMADAS");
        ArrayList<Integer> emergencia = generador.getEmergencia();
        int maxE = emergencia.size();
        int cantE = 0;
        for (int i = 0; i < maxE; i++){
            if(emergencia.get(i) == 1)
                cantE = cantE + 1;
        }
        System.out.println(cantE);

        ArrayList<Integer> paciente = generador.getPaciente();
        int maxPA = paciente.size();
        int cantPA = 0;
        for (int i = 0; i < maxPA; i++){
            if(paciente.get(i) == 1)
                cantPA = cantPA + 1;
        }
        System.out.println(cantPA);

        ArrayList<Integer> personal = generador.getPersonal();
        int maxPE = personal.size();
        int cantPE = 0;
        for (int i = 0; i < maxPE; i++){
            if(personal.get(i) == 1)
                cantPE = cantPE + 1;
        }
        System.out.println(cantPE);

        ArrayList<Integer> servicio = generador.getServicio();
        int maxSE = servicio.size();
        int cantSE = 0;
        for (int i = 0; i < maxSE; i++){
            if(servicio.get(i) == 1)
                cantSE = cantSE + 1;
        }
        System.out.println(cantSE);

        ArrayList<Integer> visita = generador.getVisita();
        int maxVI = visita.size();
        int cantVI = 0;
        for (int i = 0; i < maxVI; i++){
            if(visita.get(i) == 1)
                cantVI = cantVI + 1;
        }
        System.out.println(cantVI);
    }
}

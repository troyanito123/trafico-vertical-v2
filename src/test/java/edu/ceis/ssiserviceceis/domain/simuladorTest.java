package edu.ceis.ssiserviceceis.domain;

import org.junit.Test;

import java.util.ArrayList;

    public class simuladorTest {
        @Test
        public void ascensoresTest(){
            DatosIniciales datosIniciales = new DatosIniciales(100, 10, 2,1,1,1,1,1);
            Simulador simulador = new Simulador(datosIniciales);
            simulador.prepararAscensores();
            simulador.generarResultadosAscensores();

            ArrayList<Integer> horaAtencionE = simulador.getHoraAtencionE();
            ArrayList<Integer> tiempoAtencionE = simulador.getTiempoAtencionE();
            ArrayList<Integer> tiempoEsperaE = simulador.getTiempoEsperaE();
            System.out.println("--------------------------------------------------------");
            System.out.println("ASCENSOR EMERGENCIA");
            System.out.println("Hora de atencion(min):\n" + horaAtencionE);
            System.out.println("Tiempo de atencion(seg):\n" + tiempoAtencionE);

            ArrayList<Integer> horaAtencionPa = simulador.getHoraAtencionPa();
            ArrayList<Integer> tiempoAtencionPa = simulador.getTiempoAtencionPa();
            ArrayList<Integer> tiempoEsperaPa = simulador.getTiempoEsperaPa();
            System.out.println("ASCENSOR PACIENTE");
            System.out.println("Hora de atencion(min):\n" + horaAtencionPa);
            System.out.println("Tiempo de atencion(seg):\n" + tiempoAtencionPa);

            ArrayList<Integer> horaAtencionPe = simulador.getHoraAtencionPe();
            ArrayList<Integer> tiempoAtencionPe = simulador.getTiempoAtencionPe();
            ArrayList<Integer> tiempoEsperaPe = simulador.getTiempoEsperaPe();
            System.out.println("ASCENSOR PERSONAL");
            System.out.println("Hora de atencion(min):\n" + horaAtencionPe);
            System.out.println("Tiempo de atencion(seg):\n" + tiempoAtencionPe);

            ArrayList<Integer> horaAtencionSe = simulador.getHoraAtencionSe();
            ArrayList<Integer> tiempoAtencionSe = simulador.getTiempoAtencionSe();
            ArrayList<Integer> tiempoEsperaSe = simulador.getTiempoEsperaSe();
            System.out.println("ASCENSOR SERVICIO");
            System.out.println("Hora de atencion(min):\n" + horaAtencionSe);
            System.out.println("Tiempo de atencion(seg):\n" + tiempoAtencionSe);

            ArrayList<Integer> horaAtencionVi = simulador.getHoraAtencionVi();
            ArrayList<Integer> tiempoAtencionVi = simulador.getTiempoAtencionVi();
            ArrayList<Integer> tiempoEsperaVi = simulador.getTiempoEsperaVi();
            System.out.println("ASCENSOR VISITA");
            System.out.println("Hora de atencion(min):\n" + horaAtencionVi);
            System.out.println("Tiempo de atencion(seg):\n" + tiempoAtencionVi);
        }
        @Test
        public void graficoTest(){
            DatosIniciales datosIniciales = new DatosIniciales(100, 10, 2,1,1,1,1,1);
            Simulador simulador = new Simulador(datosIniciales);
            simulador.generarResultados();
            System.out.println("GRAFICO ASCENSOR EMERGENCIA");
            System.out.println(simulador.getGraficoE());
            System.out.println("TIEMPO DE USO EN MIN: "+ simulador.getTiempoUsoE());

            System.out.println("GRAFICO ASCENSOR PACIENTE");
            System.out.println(simulador.getGraficoPa());
            System.out.println("TIEMPO DE USO EN MIN: "+ simulador.getTiempoUsoPa());

            System.out.println("GRAFICO ASCENSOR PERSONAL");
            System.out.println(simulador.getGraficoPe());
            System.out.println("TIEMPO DE USO EN MIN: "+ simulador.getTiempoUsoPe());

            System.out.println("GRAFICO ASCENSOR SERVICIO");
            System.out.println(simulador.getGraficoSe());
            System.out.println("TIEMPO DE USO EN MIN: "+ simulador.getTiempoUsoSe());

            System.out.println("GRAFICO ASCENSOR VISITA");
            System.out.println(simulador.getGraficoVi());
            System.out.println("TIEMPO DE USO EN MIN: "+ simulador.getTiempoUsoVi());
        }
    }

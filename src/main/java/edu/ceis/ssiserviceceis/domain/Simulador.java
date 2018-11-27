package edu.ceis.ssiserviceceis.domain;

import java.util.ArrayList;

public class Simulador {
    private Ascensor emergencia;
    private Ascensor paciente;
    private Ascensor personal;
    private Ascensor servicio;
    private Ascensor visita;
    private DatosIniciales datosIniciales;
    private Distribuidor distribuidor;
    private DatosSimulacion datosSimulacion;
    private Graficos graficos1;
    private Graficos graficos2;
    private Graficos graficos3;
    private Graficos graficos4;
    private Graficos graficos5;

    private ArrayList<Integer> horaAtencionE;
    private ArrayList<Integer> tiempoAtencionE;
    private ArrayList<Integer> tiempoEsperaE;
    private ArrayList<Integer> graficoE;
    private int tiempoUsoE;

    private ArrayList<Integer> horaAtencionPa;
    private ArrayList<Integer> tiempoAtencionPa;
    private ArrayList<Integer> tiempoEsperaPa;
    private ArrayList<Integer> graficoPa;
    private int tiempoUsoPa;

    private ArrayList<Integer> horaAtencionPe;
    private ArrayList<Integer> tiempoAtencionPe;
    private ArrayList<Integer> tiempoEsperaPe;
    private ArrayList<Integer> graficoPe;
    private int tiempoUsoPe;

    private ArrayList<Integer> horaAtencionSe;
    private ArrayList<Integer> tiempoAtencionSe;
    private ArrayList<Integer> tiempoEsperaSe;
    private ArrayList<Integer> graficoSe;
    private int tiempoUsoSe;

    private ArrayList<Integer> horaAtencionVi;
    private ArrayList<Integer> tiempoAtencionVi;
    private ArrayList<Integer> tiempoEsperaVi;
    private ArrayList<Integer> graficoVi;
    private int tiempoUsoVi;

    public Simulador(DatosIniciales datosIniciales) {
        this.emergencia = new Ascensor();
        this.paciente = new Ascensor();
        this.personal = new Ascensor();
        this.servicio = new Ascensor();
        this.visita = new Ascensor();
        this.datosIniciales = datosIniciales;
        this.distribuidor = new Distribuidor();
        this.datosSimulacion = new DatosSimulacion();
        this.graficos1 = new Graficos();
        this.graficos2 = new Graficos();
        this.graficos3 = new Graficos();
        this.graficos4 = new Graficos();
        this.graficos5 = new Graficos();

        horaAtencionE = new ArrayList<>();
        tiempoAtencionE = new ArrayList<>();
        tiempoEsperaE = new ArrayList<>();
        graficoE = new ArrayList<>();
        for (int i = 0; i < 24; i++)
            graficoE.add(0);
        tiempoUsoE = 0;


        horaAtencionPa = new ArrayList<>();
        tiempoAtencionPa = new ArrayList<>();
        tiempoEsperaPa = new ArrayList<>();
        graficoPa = new ArrayList<>();
        for (int i = 0; i < 24; i++)
            graficoPa.add(0);
        tiempoUsoPa = 0;

        horaAtencionPe = new ArrayList<>();
        tiempoAtencionPe = new ArrayList<>();
        tiempoEsperaPe = new ArrayList<>();
        graficoPe = new ArrayList<>();
        for (int i = 0; i < 24; i++)
            graficoPe.add(0);
        tiempoUsoPe = 0;

        horaAtencionSe = new ArrayList<>();
        tiempoAtencionSe = new ArrayList<>();
        tiempoEsperaSe = new ArrayList<>();
        graficoSe = new ArrayList<>();
        for (int i = 0; i < 24; i++)
            graficoSe.add(0);
        tiempoUsoSe = 0;

        horaAtencionVi = new ArrayList<>();
        tiempoAtencionVi = new ArrayList<>();
        tiempoEsperaVi = new ArrayList<>();
        graficoVi = new ArrayList<>();
        for (int i = 0; i < 24; i++)
            graficoVi.add(0);
        tiempoUsoVi = 0;
    }

    public void prepararAscensores(){
        distribuidor.distribuirLlamadas(datosIniciales.getCapacidad(), datosIniciales.getPisos(),
                datosIniciales.getTiempo(), datosIniciales.getEmergencia(), datosIniciales.getPaciente(),
                datosIniciales.getPersonal(), datosIniciales.getServicio(), datosIniciales.getVisita());
        emergencia.setLlamadas(distribuidor.getEmergenciaListo());
        paciente.setLlamadas(distribuidor.getPacienteListo());
        personal.setLlamadas(distribuidor.getPersonalListo());
        servicio.setLlamadas(distribuidor.getServicioListo());
        visita.setLlamadas(distribuidor.getVisitaListo());
    }

    public void generarResultados(){
        prepararAscensores();
        generarResultadosAscensores();
        generarGraficos();
        generarTiempoUsoPromedio();
        datosSimulacion.setLlamadasEmergencia(distribuidor.getEmergenciaListo().size());
        datosSimulacion.setLlamadasPaciente(distribuidor.getPacienteListo().size());
        datosSimulacion.setLlamadasPersonal(distribuidor.getPersonalListo().size());
        datosSimulacion.setLlamadasServicio(distribuidor.getServicioListo().size());
        datosSimulacion.setLlamadasVisita(distribuidor.getVisitaListo().size());
        datosSimulacion.setGraficoE(getGraficoE());
        datosSimulacion.setGraficoPa(getGraficoPa());
        datosSimulacion.setGraficoPe(getGraficoPe());
        datosSimulacion.setGraficoSe(getGraficoSe());
        datosSimulacion.setGraficoVi(getGraficoVi());
        datosSimulacion.setTiempoUsoE(getTiempoUsoE());
        datosSimulacion.setTiempoUsoPa(getTiempoUsoPa());
        datosSimulacion.setTiempoUsoPe(getTiempoUsoPe());
        datosSimulacion.setTiempoUsoSe(getTiempoUsoSe());
        datosSimulacion.setTiempoUsoVi(getTiempoUsoVi());

        datosGraficoE(graficos1);
        datosGraficoPa(graficos2);
        datosGraficoPe(graficos3);
        datosGraficoSe(graficos4);
        datosGraficoVi(graficos5);

    }

    public void generarResultadoAscensorE(){
        ArrayList<Llamada> llamadasEmergencia = emergencia.getLlamadas();
        int max = llamadasEmergencia.size();
        int tea = 0;
        for (int i = 0; i < max; i++){
            Llamada actual = llamadasEmergencia.get(i);
            int tla = actual.getTiempoLLegada();
            int tva = tla + tea;
            horaAtencionE.add(tva);
            int dondeEstas = actual.getPisoActual();
            int dondeVas = actual.getPisoDeseado();
            int dif = 0;
            if(dondeEstas < dondeVas)
                dif = dondeVas - dondeEstas;
            else
                dif = dondeEstas - dondeVas;
            int taa = 15 + (int)Math.ceil(dondeEstas*4/1.5) + (int)Math.ceil(dif*4/1.5);
            tiempoAtencionE.add(taa);
            if(taa > 60){
                int tls = llamadasEmergencia.get(i+1).getTiempoLLegada();
                int tas = tva + (int)Math.ceil(taa/60);
                if(tls < tas){
                    int tass = (tva*60) + taa;
                    int tlss = tls*60;
                    tiempoEsperaE.add(tass - tlss);
                    tea = tea + (tass - tlss);
                }
            }

        }
    }

    public void generarResultadoAscensorPa(){
        ArrayList<Llamada> llamadasPaciente = paciente.getLlamadas();
        int max = llamadasPaciente.size();
        int tea = 0;
        for (int i = 0; i < max; i++){
            Llamada actual = llamadasPaciente.get(i);
            int tla = actual.getTiempoLLegada();
            int tva = tla + tea;
            horaAtencionPa.add(tva);
            int dondeEstas = actual.getPisoActual();
            int dondeVas = actual.getPisoDeseado();
            int dif = 0;
            if(dondeEstas < dondeVas)
                dif = dondeVas - dondeEstas;
            else
                dif = dondeEstas - dondeVas;
            int taa = 15 + (int)Math.ceil(dondeEstas*4/1.5) + (int)Math.ceil(dif*4/1.5);
            tiempoAtencionPa.add(taa);
            if(taa > 60){
                if(i != max-1){
                    int tls = llamadasPaciente.get(i+1).getTiempoLLegada();
                    int tas = tva + (int)Math.ceil(taa/60);
                    if(tls < tas){
                        int tass = (tva*60) + taa;
                        int tlss = tls*60;
                        tiempoEsperaPa.add(tass - tlss);
                        tea = tea + (tass - tlss);
                    }
                }else {tiempoEsperaPa.add(0);}
            }
        }
    }

    public void generarResultadoAscensorPe(){
        ArrayList<Llamada> llamadasPersonal = personal.getLlamadas();
        int max = llamadasPersonal.size();
        int tea = 0;
        for (int i = 0; i < max; i++){
            Llamada actual = llamadasPersonal.get(i);
            int tla = actual.getTiempoLLegada();
            int tva = tla + tea;
            horaAtencionPe.add(tva);
            int dondeEstas = actual.getPisoActual();
            int dondeVas = actual.getPisoDeseado();
            int dif = 0;
            if(dondeEstas < dondeVas)
                dif = dondeVas - dondeEstas;
            else
                dif = dondeEstas - dondeVas;
            int taa = 15 + (int)Math.ceil(dondeEstas*4/1.5) + (int)Math.ceil(dif*4/1.5);
            tiempoAtencionPe.add(taa);
            if(taa > 60){
                if(i != max-1){
                    int tls = llamadasPersonal.get(i+1).getTiempoLLegada();
                    int tas = tva + (int)Math.ceil(taa/60);
                    if(tls < tas){
                        int tass = (tva*60) + taa;
                        int tlss = tls*60;
                        tiempoEsperaPe.add(tass - tlss);
                        tea = tea + (tass - tlss);
                    }
                }else {tiempoEsperaPe.add(0);}
            }
        }
    }

    public void generarResultadoAscensorSe(){
        ArrayList<Llamada> llamadasServicio = servicio.getLlamadas();
        int max = llamadasServicio.size();
        int tea = 0;
        for (int i = 0; i < max; i++){
            Llamada actual = llamadasServicio.get(i);
            int tla = actual.getTiempoLLegada();
            int tva = tla + tea;
            horaAtencionSe.add(tva);
            int dondeEstas = actual.getPisoActual();
            int dondeVas = actual.getPisoDeseado();
            int dif = 0;
            if(dondeEstas < dondeVas)
                dif = dondeVas - dondeEstas;
            else
                dif = dondeEstas - dondeVas;
            int taa = 15 + (int)Math.ceil(dondeEstas*4/1.5) + (int)Math.ceil(dif*4/1.5);
            tiempoAtencionSe.add(taa);
            if(taa > 60){
                if(i != max-1){
                    int tls = llamadasServicio.get(i+1).getTiempoLLegada();
                    int tas = tva + (int)Math.ceil(taa/60);
                    if(tls < tas){
                        int tass = (tva*60) + taa;
                        int tlss = tls*60;
                        tiempoEsperaSe.add(tass - tlss);
                        tea = tea + (tass - tlss);
                    }
                }else {tiempoEsperaSe.add(0);}
            }
        }
    }

    public void generarResultadoAscensorVi(){
        ArrayList<Llamada> llamadasVisita = visita.getLlamadas();
        int max = llamadasVisita.size();
        int tea = 0;
        for (int i = 0; i < max; i++){
            Llamada actual = llamadasVisita.get(i);
            int tla = actual.getTiempoLLegada();
            int tva = tla + tea;
            horaAtencionVi.add(tva);
            int dondeEstas = actual.getPisoActual();
            int dondeVas = actual.getPisoDeseado();
            int dif = 0;
            if(dondeEstas < dondeVas)
                dif = dondeVas - dondeEstas;
            else
                dif = dondeEstas - dondeVas;
            int taa = 15 + (int)Math.ceil(dondeEstas*4/1.5) + (int)Math.ceil(dif*4/1.5);
            tiempoAtencionVi.add(taa);
            if(taa > 60){
                if(i != max-1){
                    int tls = llamadasVisita.get(i+1).getTiempoLLegada();
                    int tas = tva + (int)Math.ceil(taa/60);
                    if(tls < tas){
                        int tass = (tva*60) + taa;
                        int tlss = tls*60;
                        tiempoEsperaVi.add(tass - tlss);
                        tea = tea + (tass - tlss);
                    }
                }else {tiempoEsperaVi.add(0);}
            }
        }
    }

    public void generarResultadosAscensores(){
        generarResultadoAscensorE();
        generarResultadoAscensorPa();
        generarResultadoAscensorPe();
        generarResultadoAscensorSe();
        generarResultadoAscensorVi();
    }

    public void generarGraficoE(){
        int max = horaAtencionE.size();
        int limDia = 1440;
        int limHora = 60;
        int cont = 0;
        int posGra = 0;
        while(cont < max){
            int horaActual = horaAtencionE.get(cont);
            if(horaActual < limDia){
                if(horaActual < limHora){
                    int x = graficoE.get(posGra);
                    int y = x + 1;
                    graficoE.set(posGra, y);
                }else{
                    limHora = limHora + 60;
                    posGra ++;
                    cont --;
                }
            }else{
                limHora = limDia + 60;
                limDia = limDia + 1440;
                cont = cont - 1;
                posGra = 0;
            }
            cont++;
        }
    }

    public void generarGraficoPa(){
        int max = horaAtencionPa.size();
        int limDia = 1440;
        int limHora = 60;
        int cont = 0;
        int posGra = 0;
        while(cont < max){
            int horaActual = horaAtencionPa.get(cont);
            if(horaActual < limDia){
                if(horaActual < limHora){
                    int x = graficoPa.get(posGra);
                    int y = x + 1;
                    graficoPa.set(posGra, y);
                }else{
                    limHora = limHora + 60;
                    posGra ++;
                    cont --;
                }
            }else{
                limHora = limDia + 60;
                limDia = limDia + 1440;
                cont = cont - 1;
                posGra = 0;
            }
            cont++;
        }
    }

    public void generarGraficoPe(){
        int max = horaAtencionPe.size();
        int limDia = 1440;
        int limHora = 60;
        int cont = 0;
        int posGra = 0;
        while(cont < max){
            int horaActual = horaAtencionPe.get(cont);
            if(horaActual < limDia){
                if(horaActual < limHora){
                    int x = graficoPe.get(posGra);
                    int y = x + 1;
                    graficoPe.set(posGra, y);
                }else{
                    limHora = limHora + 60;
                    posGra ++;
                    cont --;
                }
            }else{
                limHora = limDia + 60;
                limDia = limDia + 1440;
                cont = cont - 1;
                posGra = 0;
            }
            cont++;
        }
    }

    public void generarGraficoSe(){
        int max = horaAtencionSe.size();
        int limDia = 1440;
        int limHora = 60;
        int cont = 0;
        int posGra = 0;
        while(cont < max){
            int horaActual = horaAtencionSe.get(cont);
            if(horaActual < limDia){
                if(horaActual < limHora){
                    int x = graficoSe.get(posGra);
                    int y = x + 1;
                    graficoSe.set(posGra, y);
                }else{
                    limHora = limHora + 60;
                    posGra ++;
                    cont --;
                }
            }else{
                limHora = limDia + 60;
                limDia = limDia + 1440;
                cont = cont - 1;
                posGra = 0;
            }
            cont++;
        }
    }

    public void generarGraficoVi(){
        int max = horaAtencionVi.size();
        int limDia = 1440;
        int limHora = 60;
        int cont = 0;
        int posGra = 0;
        while(cont < max){
            int horaActual = horaAtencionVi.get(cont);
            if(horaActual < limDia){
                if(horaActual < limHora){
                    int x = graficoVi.get(posGra);
                    int y = x + 1;
                    graficoVi.set(posGra, y);
                }else{
                    limHora = limHora + 60;
                    posGra ++;
                    cont --;
                }
            }else{
                limHora = limDia + 60;
                limDia = limDia + 1440;
                cont = cont - 1;
                posGra = 0;
            }
            cont++;
        }
    }

    public void generarGraficos(){
        generarGraficoE();
        generarGraficoPa();
        generarGraficoPe();
        generarGraficoSe();
        generarGraficoVi();
    }

    public void generarTiempoUsoPromedioE(){
        int max = tiempoAtencionE.size();
        int sumaTotal = 0;
        for (int i = 0; i < max; i++){
            sumaTotal = sumaTotal + tiempoAtencionE.get(i);
        }
        tiempoUsoE = (int)Math.ceil((sumaTotal/datosIniciales.getTiempo())/60);
    }

    public void generarTiempoUsoPromedioPa(){
        int max = tiempoAtencionPa.size();
        int sumaTotal = 0;
        for (int i = 0; i < max; i++){
            sumaTotal = sumaTotal + tiempoAtencionPa.get(i);
        }
        tiempoUsoPa = (int)Math.ceil((sumaTotal/datosIniciales.getTiempo())/60);
    }

    public void generarTiempoUsoPromedioPe(){
        int max = tiempoAtencionPe.size();
        int sumaTotal = 0;
        for (int i = 0; i < max; i++){
            sumaTotal = sumaTotal + tiempoAtencionPe.get(i);
        }
        tiempoUsoPe = (int)Math.ceil((sumaTotal/datosIniciales.getTiempo())/60);
    }

    public void generarTiempoUsoPromedioSe(){
        int max = tiempoAtencionSe.size();
        int sumaTotal = 0;
        for (int i = 0; i < max; i++){
            sumaTotal = sumaTotal + tiempoAtencionSe.get(i);
        }
        tiempoUsoSe = (int)Math.ceil((sumaTotal/datosIniciales.getTiempo())/60);
    }

    public void generarTiempoUsoPromedioVi(){
        int max = tiempoAtencionVi.size();
        int sumaTotal = 0;
        for (int i = 0; i < max; i++){
            sumaTotal = sumaTotal + tiempoAtencionVi.get(i);
        }
        tiempoUsoVi = (int)Math.ceil((sumaTotal/datosIniciales.getTiempo())/60);
    }

    public void generarTiempoUsoPromedio(){
        generarTiempoUsoPromedioE();
        generarTiempoUsoPromedioPa();
        generarTiempoUsoPromedioPe();
        generarTiempoUsoPromedioSe();
        generarTiempoUsoPromedioVi();
    }

    public void datosGraficoE(Graficos grafico){
        grafico.setHora1(graficoE.get(0));
        grafico.setHora2(graficoE.get(1));
        grafico.setHora3(graficoE.get(2));
        grafico.setHora4(graficoE.get(3));
        grafico.setHora5(graficoE.get(4));
        grafico.setHora6(graficoE.get(5));
        grafico.setHora7(graficoE.get(6));
        grafico.setHora8(graficoE.get(7));
        grafico.setHora9(graficoE.get(8));
        grafico.setHora10(graficoE.get(9));
        grafico.setHora11(graficoE.get(10));
        grafico.setHora12(graficoE.get(11));
        grafico.setHora13(graficoE.get(12));
        grafico.setHora14(graficoE.get(13));
        grafico.setHora15(graficoE.get(14));
        grafico.setHora16(graficoE.get(15));
        grafico.setHora17(graficoE.get(16));
        grafico.setHora18(graficoE.get(17));
        grafico.setHora19(graficoE.get(18));
        grafico.setHora20(graficoE.get(19));
        grafico.setHora21(graficoE.get(20));
        grafico.setHora22(graficoE.get(21));
        grafico.setHora23(graficoE.get(22));
        grafico.setHora24(graficoE.get(23));
    }
    public void datosGraficoPa(Graficos grafico){
        grafico.setHora1(graficoPa.get(0));
        grafico.setHora2(graficoPa.get(1));
        grafico.setHora3(graficoPa.get(2));
        grafico.setHora4(graficoPa.get(3));
        grafico.setHora5(graficoPa.get(4));
        grafico.setHora6(graficoPa.get(5));
        grafico.setHora7(graficoPa.get(6));
        grafico.setHora8(graficoPa.get(7));
        grafico.setHora9(graficoPa.get(8));
        grafico.setHora10(graficoPa.get(9));
        grafico.setHora11(graficoPa.get(10));
        grafico.setHora12(graficoPa.get(11));
        grafico.setHora13(graficoPa.get(12));
        grafico.setHora14(graficoPa.get(13));
        grafico.setHora15(graficoPa.get(14));
        grafico.setHora16(graficoPa.get(15));
        grafico.setHora17(graficoPa.get(16));
        grafico.setHora18(graficoPa.get(17));
        grafico.setHora19(graficoPa.get(18));
        grafico.setHora20(graficoPa.get(19));
        grafico.setHora21(graficoPa.get(20));
        grafico.setHora22(graficoPa.get(21));
        grafico.setHora23(graficoPa.get(22));
        grafico.setHora24(graficoPa.get(23));
    }
    public void datosGraficoPe(Graficos grafico){
        grafico.setHora1(graficoPe.get(0));
        grafico.setHora2(graficoPe.get(1));
        grafico.setHora3(graficoPe.get(2));
        grafico.setHora4(graficoPe.get(3));
        grafico.setHora5(graficoPe.get(4));
        grafico.setHora6(graficoPe.get(5));
        grafico.setHora7(graficoPe.get(6));
        grafico.setHora8(graficoPe.get(7));
        grafico.setHora9(graficoPe.get(8));
        grafico.setHora10(graficoPe.get(9));
        grafico.setHora11(graficoPe.get(10));
        grafico.setHora12(graficoPe.get(11));
        grafico.setHora13(graficoPe.get(12));
        grafico.setHora14(graficoPe.get(13));
        grafico.setHora15(graficoPe.get(14));
        grafico.setHora16(graficoPe.get(15));
        grafico.setHora17(graficoPe.get(16));
        grafico.setHora18(graficoPe.get(17));
        grafico.setHora19(graficoPe.get(18));
        grafico.setHora20(graficoPe.get(19));
        grafico.setHora21(graficoPe.get(20));
        grafico.setHora22(graficoPe.get(21));
        grafico.setHora23(graficoPe.get(22));
        grafico.setHora24(graficoPe.get(23));
    }
    public void datosGraficoSe(Graficos grafico){
        grafico.setHora1(graficoSe.get(0));
        grafico.setHora2(graficoSe.get(1));
        grafico.setHora3(graficoSe.get(2));
        grafico.setHora4(graficoSe.get(3));
        grafico.setHora5(graficoSe.get(4));
        grafico.setHora6(graficoSe.get(5));
        grafico.setHora7(graficoSe.get(6));
        grafico.setHora8(graficoSe.get(7));
        grafico.setHora9(graficoSe.get(8));
        grafico.setHora10(graficoSe.get(9));
        grafico.setHora11(graficoSe.get(10));
        grafico.setHora12(graficoSe.get(11));
        grafico.setHora13(graficoSe.get(12));
        grafico.setHora14(graficoSe.get(13));
        grafico.setHora15(graficoSe.get(14));
        grafico.setHora16(graficoSe.get(15));
        grafico.setHora17(graficoSe.get(16));
        grafico.setHora18(graficoSe.get(17));
        grafico.setHora19(graficoSe.get(18));
        grafico.setHora20(graficoSe.get(19));
        grafico.setHora21(graficoSe.get(20));
        grafico.setHora22(graficoSe.get(21));
        grafico.setHora23(graficoSe.get(22));
        grafico.setHora24(graficoSe.get(23));
    }
    public void datosGraficoVi(Graficos grafico){
        grafico.setHora1(graficoVi.get(0));
        grafico.setHora2(graficoVi.get(1));
        grafico.setHora3(graficoVi.get(2));
        grafico.setHora4(graficoVi.get(3));
        grafico.setHora5(graficoVi.get(4));
        grafico.setHora6(graficoVi.get(5));
        grafico.setHora7(graficoVi.get(6));
        grafico.setHora8(graficoVi.get(7));
        grafico.setHora9(graficoVi.get(8));
        grafico.setHora10(graficoVi.get(9));
        grafico.setHora11(graficoVi.get(10));
        grafico.setHora12(graficoVi.get(11));
        grafico.setHora13(graficoVi.get(12));
        grafico.setHora14(graficoVi.get(13));
        grafico.setHora15(graficoVi.get(14));
        grafico.setHora16(graficoVi.get(15));
        grafico.setHora17(graficoVi.get(16));
        grafico.setHora18(graficoVi.get(17));
        grafico.setHora19(graficoVi.get(18));
        grafico.setHora20(graficoVi.get(19));
        grafico.setHora21(graficoVi.get(20));
        grafico.setHora22(graficoVi.get(21));
        grafico.setHora23(graficoVi.get(22));
        grafico.setHora24(graficoVi.get(23));
    }

    public DatosSimulacion getDatosSimulacion() {
        return datosSimulacion;
    }

    public void setDatosSimulacion(DatosSimulacion datosSimulacion) {
        this.datosSimulacion = datosSimulacion;
    }

    public Ascensor getEmergencia() {
        return emergencia;
    }

    public Ascensor getPaciente() {
        return paciente;
    }

    public Ascensor getPersonal() {
        return personal;
    }

    public Ascensor getServicio() {
        return servicio;
    }

    public Ascensor getVisita() {
        return visita;
    }

    public ArrayList<Integer> getHoraAtencionE() {
        return horaAtencionE;
    }

    public ArrayList<Integer> getTiempoAtencionE() {
        return tiempoAtencionE;
    }

    public ArrayList<Integer> getTiempoEsperaE() {
        return tiempoEsperaE;
    }

    public ArrayList<Integer> getHoraAtencionPa() {
        return horaAtencionPa;
    }

    public ArrayList<Integer> getTiempoAtencionPa() {
        return tiempoAtencionPa;
    }

    public ArrayList<Integer> getTiempoEsperaPa() {
        return tiempoEsperaPa;
    }

    public ArrayList<Integer> getHoraAtencionPe() {
        return horaAtencionPe;
    }

    public ArrayList<Integer> getTiempoAtencionPe() {
        return tiempoAtencionPe;
    }

    public ArrayList<Integer> getTiempoEsperaPe() {
        return tiempoEsperaPe;
    }

    public ArrayList<Integer> getHoraAtencionSe() {
        return horaAtencionSe;
    }

    public ArrayList<Integer> getTiempoAtencionSe() {
        return tiempoAtencionSe;
    }

    public ArrayList<Integer> getTiempoEsperaSe() {
        return tiempoEsperaSe;
    }

    public ArrayList<Integer> getHoraAtencionVi() {
        return horaAtencionVi;
    }

    public ArrayList<Integer> getTiempoAtencionVi() {
        return tiempoAtencionVi;
    }

    public ArrayList<Integer> getTiempoEsperaVi() {
        return tiempoEsperaVi;
    }

    public ArrayList<Integer> getGraficoE() {
        return graficoE;
    }

    public ArrayList<Integer> getGraficoPa() {
        return graficoPa;
    }

    public ArrayList<Integer> getGraficoPe() {
        return graficoPe;
    }

    public ArrayList<Integer> getGraficoSe() {
        return graficoSe;
    }

    public ArrayList<Integer> getGraficoVi() {
        return graficoVi;
    }

    public int getTiempoUsoE() {
        return tiempoUsoE;
    }

    public int getTiempoUsoPa() {
        return tiempoUsoPa;
    }

    public int getTiempoUsoPe() {
        return tiempoUsoPe;
    }

    public int getTiempoUsoSe() {
        return tiempoUsoSe;
    }

    public int getTiempoUsoVi() {
        return tiempoUsoVi;
    }

    public Graficos getGraficos1() {
        return graficos1;
    }

    public Graficos getGraficos2() {
        return graficos2;
    }

    public Graficos getGraficos3() {
        return graficos3;
    }

    public Graficos getGraficos4() {
        return graficos4;
    }

    public Graficos getGraficos5() {
        return graficos5;
    }
}

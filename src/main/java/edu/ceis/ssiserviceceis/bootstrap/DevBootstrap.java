package edu.ceis.ssiserviceceis.bootstrap;

import edu.ceis.ssiserviceceis.domain.*;
import edu.ceis.ssiserviceceis.repositories.DatosInicialesRepository;
import edu.ceis.ssiserviceceis.repositories.DatosSimulacionRepository;
import edu.ceis.ssiserviceceis.repositories.GraficosRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private DatosInicialesRepository datosInicialesRepository;
    private DatosSimulacionRepository datosSimulacionRepository;
    private GraficosRepository graficosRepository;

    public DevBootstrap(DatosInicialesRepository datosInicialesRepository,
                        DatosSimulacionRepository datosSimulacionRepository,
                        GraficosRepository graficosRepository) {
        this.datosInicialesRepository = datosInicialesRepository;
        this.datosSimulacionRepository = datosSimulacionRepository;
        this.graficosRepository = graficosRepository;

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        nitData();
    }

    private void nitData() {
        /*DatosIniciales datosIniciales = new DatosIniciales(100, 5,1,1,1,1,1,1);
        datosInicialesRepository.save(datosIniciales);

        Simulador simulador = new Simulador(datosIniciales);
        simulador.generarResultados();

        DatosSimulacion datosSimulacion = new DatosSimulacion();
        datosSimulacion = simulador.getDatosSimulacion();

        datosSimulacionRepository.save(datosSimulacion);

        Graficos graficos1 = new Graficos();
        graficos1 = simulador.getGraficos1();
        graficosRepository.save(graficos1);

        Graficos graficos2 = new Graficos();
        graficos2 = simulador.getGraficos2();
        graficosRepository.save(graficos2);

        Graficos graficos3 = new Graficos();
        graficos3 = simulador.getGraficos3();
        graficosRepository.save(graficos3);

        Graficos graficos4 = new Graficos();
        graficos4 = simulador.getGraficos4();
        graficosRepository.save(graficos4);

        Graficos graficos5 = new Graficos();
        graficos5 = simulador.getGraficos5();
        graficosRepository.save(graficos5);
*/
        /*DatosIniciales d2 = new DatosIniciales(50, 4,1,1,1,1,0,1);
        datosInicialesRepository.save(d2);

        Simulador simulador1 = new Simulador(d2);
        simulador1.generarResultados();

        DatosSimulacion datosSimulacion1 = new DatosSimulacion();
        datosSimulacion1 = simulador1.getDatosSimulacion();

        datosSimulacionRepository.save(datosSimulacion1);*/

    }
}

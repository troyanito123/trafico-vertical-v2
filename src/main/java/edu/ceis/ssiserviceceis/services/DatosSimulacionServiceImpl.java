package edu.ceis.ssiserviceceis.services;

import edu.ceis.ssiserviceceis.domain.DatosIniciales;
import edu.ceis.ssiserviceceis.domain.DatosSimulacion;
import edu.ceis.ssiserviceceis.domain.Graficos;
import edu.ceis.ssiserviceceis.domain.Simulador;
import edu.ceis.ssiserviceceis.repositories.DatosSimulacionRepository;
import edu.ceis.ssiserviceceis.repositories.GraficosRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DatosSimulacionServiceImpl implements DatosSimulacionService{
    private DatosSimulacionRepository datosSimulacionRepository;
    private GraficosRepository graficosRepository;

    public DatosSimulacionServiceImpl(DatosSimulacionRepository datosSimulacionRepository, GraficosRepository graficosRepository) {
        this.datosSimulacionRepository = datosSimulacionRepository;
        this.graficosRepository = graficosRepository;
    }

    @Override
    public List<DatosSimulacion> getDatosSimulacion() {
        List<DatosSimulacion> datosSimulacion = new ArrayList<>();
        datosSimulacionRepository.findAll().iterator().forEachRemaining(datosSimulacion::add);
        return datosSimulacion;
    }

    @Override
    public DatosSimulacion getUltimo() {
        return null;
    }

    @Override
    public DatosSimulacion simular(DatosIniciales datosIniciales) {
        Simulador simulador = new Simulador(datosIniciales);
        simulador.generarResultados();

        DatosSimulacion datosSimulacion = new DatosSimulacion();
        datosSimulacion = simulador.getDatosSimulacion();


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

        return datosSimulacionRepository.save(datosSimulacion);

    }

}

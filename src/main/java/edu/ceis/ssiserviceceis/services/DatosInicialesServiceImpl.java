package edu.ceis.ssiserviceceis.services;

import edu.ceis.ssiserviceceis.domain.DatosIniciales;
import edu.ceis.ssiserviceceis.domain.DatosSimulacion;
import edu.ceis.ssiserviceceis.domain.Simulador;
import edu.ceis.ssiserviceceis.repositories.DatosInicialesRepository;
import edu.ceis.ssiserviceceis.repositories.DatosSimulacionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DatosInicialesServiceImpl implements  DatosInicialesService{

    private DatosInicialesRepository datosInicialesRepository;
    private DatosSimulacionRepository datosSimulacionRepository;

    public DatosInicialesServiceImpl(DatosInicialesRepository datosInicialesRepository) {
        this.datosInicialesRepository = datosInicialesRepository;
        this.datosSimulacionRepository = datosSimulacionRepository;

    }


    @Override
    public List<DatosIniciales> getDatosIniciales() {
        List<DatosIniciales> datosIniciales = new ArrayList<>();
        datosInicialesRepository.findAll().iterator().forEachRemaining(datosIniciales::add);
        return datosIniciales;
    }

    @Override
    public void simular(DatosIniciales datosIniciales) {
        Simulador simulador1 = new Simulador(datosIniciales);
        DatosSimulacion datosSimulacion = new DatosSimulacion();
        simulador1.generarResultados();
        datosSimulacion = simulador1.getDatosSimulacion();
        saveSimu(datosSimulacion);
    }

    public DatosSimulacion saveSimu(DatosSimulacion datosSimulacion){
        return datosSimulacionRepository.save(datosSimulacion);
    }

    @Override
    public DatosIniciales save(DatosIniciales datosIniciales) {
        return datosInicialesRepository.save(datosIniciales);
    }
}

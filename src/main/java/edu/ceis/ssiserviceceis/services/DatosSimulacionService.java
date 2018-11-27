package edu.ceis.ssiserviceceis.services;

import edu.ceis.ssiserviceceis.domain.DatosIniciales;
import edu.ceis.ssiserviceceis.domain.DatosSimulacion;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DatosSimulacionService {
    List<DatosSimulacion> getDatosSimulacion();
    DatosSimulacion getUltimo();

    DatosSimulacion simular(DatosIniciales datosIniciales);
}
package edu.ceis.ssiserviceceis.services;

import edu.ceis.ssiserviceceis.domain.DatosIniciales;

import java.util.List;

public interface DatosInicialesService {
    List<DatosIniciales> getDatosIniciales();
    void simular(DatosIniciales datosIniciales);

    DatosIniciales save(DatosIniciales datosIniciales);

}

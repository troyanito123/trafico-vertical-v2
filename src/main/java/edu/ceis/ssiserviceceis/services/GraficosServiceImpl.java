package edu.ceis.ssiserviceceis.services;

import edu.ceis.ssiserviceceis.domain.Graficos;
import edu.ceis.ssiserviceceis.repositories.GraficosRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class GraficosServiceImpl implements GraficosService {
    private GraficosRepository graficosRepository;

    public GraficosServiceImpl(GraficosRepository graficosRepository) {
        this.graficosRepository = graficosRepository;
    }

    @Override
    public List<Graficos> getGraficos() {
        List<Graficos> graficos = new ArrayList<>();
        graficosRepository.findAll().iterator().forEachRemaining(graficos::add);
        return graficos;
    }
}

package edu.ceis.ssiserviceceis.Controllers;

import edu.ceis.ssiserviceceis.domain.Graficos;
import edu.ceis.ssiserviceceis.services.GraficosService;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/graficos")
@Produces("application/json")
@Controller
public class GraficosController extends GenericController {
    private GraficosService graficosService;

    public GraficosController(GraficosService graficosService) {
        this.graficosService = graficosService;
    }

    @GET
    public Response getDatosSimulacion() {
        List<Graficos> graficos = new ArrayList<>();
        graficosService.getGraficos().forEach(grafico -> graficos.add(grafico));
        return Response.ok(graficos).build();
    }
}

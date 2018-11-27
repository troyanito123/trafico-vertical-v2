package edu.ceis.ssiserviceceis.Controllers;

import edu.ceis.ssiserviceceis.Dao.DatosInicialesDto;
import edu.ceis.ssiserviceceis.Dao.DatosSimulacionDto;
import edu.ceis.ssiserviceceis.domain.DatosIniciales;
import edu.ceis.ssiserviceceis.domain.DatosSimulacion;
import edu.ceis.ssiserviceceis.services.DatosSimulacionService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/datossimulacion")
@Produces("application/json")
@Controller
public class DatosSimulacionController  {

    private DatosSimulacionService datosSimulacionService;

    public DatosSimulacionController(DatosSimulacionService datosSimulacionService) {
        this.datosSimulacionService = datosSimulacionService;
    }

    @GET
    public Response getDatosSimulacion() {
        List<DatosSimulacionDto> datosSimulacionDtos = new ArrayList<>();
        datosSimulacionService.getDatosSimulacion().forEach(datosSimulacionDto -> datosSimulacionDtos.add(new DatosSimulacionDto(datosSimulacionDto)));
        return Response.ok(datosSimulacionDtos).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public DatosSimulacionDto addDatosIniciales(DatosInicialesDto datosInicialesDto) {
        DatosSimulacion datosSimulacion = datosSimulacionService.simular(datosInicialesDto.toDatosInciales());
        return new DatosSimulacionDto(datosSimulacion);
    }

}

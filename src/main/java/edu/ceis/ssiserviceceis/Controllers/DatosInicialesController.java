package edu.ceis.ssiserviceceis.Controllers;
import edu.ceis.ssiserviceceis.Dao.DatosInicialesDto;
import edu.ceis.ssiserviceceis.domain.DatosIniciales;
import edu.ceis.ssiserviceceis.services.DatosInicialesService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
@Path("/datosiniciales")
@Produces("application/json")
@Controller
public class DatosInicialesController extends GenericController{

    private DatosInicialesService datosInicialesService;

    public DatosInicialesController(DatosInicialesService datosInicialesService) {
        this.datosInicialesService = datosInicialesService;
    }

    @GET
    public Response getDatosInciales() {
        List<DatosInicialesDto> datosInicialesDtos = new ArrayList<>();
        datosInicialesService.getDatosIniciales().forEach(datosInicialesDto -> datosInicialesDtos.add(new DatosInicialesDto(datosInicialesDto)));
        return Response.ok(datosInicialesDtos).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public DatosInicialesDto addDatosIniciales(DatosInicialesDto datosInicialesDto) {
        DatosIniciales datosIniciales = datosInicialesService.save(datosInicialesDto.toDatosInciales());
        return new DatosInicialesDto(datosIniciales);
    }


}


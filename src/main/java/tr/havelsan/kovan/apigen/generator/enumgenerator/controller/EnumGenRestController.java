package tr.havelsan.kovan.apigen.generator.enumgenerator.controller;

import tr.havelsan.kovan.apigen.common.constraint.ApiGenConstraint;
import tr.havelsan.kovan.apigen.generator.enumgenerator.model.EnumModel;
import tr.havelsan.kovan.apigen.generator.enumgenerator.service.EnumGenService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path(ApiGenConstraint.PATH_ENUM_GEN)
public class EnumGenRestController {

    public static final String GENERATE = "/generate";


    @Inject
    EnumGenService enumGenService;

    @GET
    @Path(ApiGenConstraint.API_SAY_MY_NAME)
    @Produces(MediaType.TEXT_PLAIN)
    public String sayMyName() {
        return "Walter White";
    }


    @POST
    @Path(GENERATE)
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean generate(EnumModel enumModel) {
        System.out.println("Enum generating is started for " + enumModel.getName());
        boolean result = true;
        try {
            enumGenService.generateEnum(enumModel);
        } catch (IOException e) {
            e.printStackTrace();
            result = false;
        } finally {
            System.out.println("Enum generating is end for : " + result);
        }
        return result;
    }


}

package tr.havelsan.kovan.apigen.generator.enumgenerator.controller;

import tr.havelsan.kovan.apigen.common.constant.ApiConstant;
import tr.havelsan.kovan.apigen.generator.enumgenerator.model.EnumGeneratorModel;
import tr.havelsan.kovan.apigen.generator.enumgenerator.service.EnumGeneratorService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path(ApiConstant.ENUM_GENERATOR_PATH)
public class EnumGeneratorRestController {

    @Inject
    EnumGeneratorService enumGeneratorService;

    @GET
    @Path(ApiConstant.SAY_MY_NAME_PATH)
    @Produces(MediaType.TEXT_PLAIN)
    public String sayMyName() {
        return "Walter White";
    }


    @POST
    @Path(ApiConstant.GENERATE_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Boolean generate(EnumGeneratorModel enumGeneratorModel) throws IOException {
        return enumGeneratorService.generateEnum(enumGeneratorModel);
    }


}

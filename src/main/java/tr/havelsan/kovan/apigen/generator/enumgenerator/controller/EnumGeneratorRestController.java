package tr.havelsan.kovan.apigen.generator.enumgenerator.controller;

import tr.havelsan.kovan.apigen.common.constant.ApiConstant;
import tr.havelsan.kovan.apigen.common.model.ApiGenResponse;
import tr.havelsan.kovan.apigen.generator.enumgenerator.model.EnumGeneratorModel;
import tr.havelsan.kovan.apigen.generator.enumgenerator.service.EnumGeneratorService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path(ApiConstant.APIGEN_ENUM)
public class EnumGeneratorRestController {

    @Inject
    EnumGeneratorService enumGeneratorService;

    @GET
    @Path(ApiConstant.SAY_MY_NAME)
    @Produces(MediaType.TEXT_PLAIN)
    public String sayMyName() {
        return "Walter White";
    }


    @POST
    @Path(ApiConstant.GENERATE)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ApiGenResponse<Boolean> generate(EnumGeneratorModel enumGeneratorModel) throws IOException {
        return new ApiGenResponse<>(enumGeneratorService.generateEnum(enumGeneratorModel));
    }


}

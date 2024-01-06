package tr.subasi.apigen.generator.controller;

import tr.subasi.apigen.common.constant.ApiConstant;
import tr.subasi.apigen.common.model.ApiGenResponse;
import tr.subasi.apigen.generator.model.ApiGeneratorModel;
import tr.subasi.apigen.generator.service.ApiGeneratorService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.io.IOException;

@Path(ApiConstant.APIGEN_API)
public class ApiGeneratorRestController {

    @Inject
    ApiGeneratorService apiGeneratorService;

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
    public ApiGenResponse<Boolean> generate(ApiGeneratorModel apiGeneratorModel) throws IOException {
        return new ApiGenResponse<>(apiGeneratorService.generate(apiGeneratorModel));
    }

}
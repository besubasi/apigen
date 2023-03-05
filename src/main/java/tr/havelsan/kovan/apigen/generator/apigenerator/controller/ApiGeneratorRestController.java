package tr.havelsan.kovan.apigen.generator.apigenerator.controller;

import tr.havelsan.kovan.apigen.common.constant.ApiConstant;
import tr.havelsan.kovan.apigen.common.model.ApiGenResponse;
import tr.havelsan.kovan.apigen.generator.apigenerator.model.ApiGeneratorModel;
import tr.havelsan.kovan.apigen.generator.apigenerator.model.CloneBasicConverterModel;
import tr.havelsan.kovan.apigen.generator.apigenerator.service.ApiGeneratorService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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


    @POST
    @Path(ApiConstant.CLONE_BASIC_CONVERTER)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ApiGenResponse<String> cloneBasicConverter(CloneBasicConverterModel cloneBasicConverter) throws IOException {
        apiGeneratorService.cloneBasicConverter(cloneBasicConverter);
        return new ApiGenResponse<>("Ok meeeeeeeeen");
    }


}
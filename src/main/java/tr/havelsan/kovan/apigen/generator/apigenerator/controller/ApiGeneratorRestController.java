package tr.havelsan.kovan.apigen.generator.apigenerator.controller;

import tr.havelsan.kovan.apigen.common.constant.ApiConstant;
import tr.havelsan.kovan.apigen.generator.apigenerator.model.ApiGeneratorModel;
import tr.havelsan.kovan.apigen.generator.apigenerator.model.FrontEndCopyModel;
import tr.havelsan.kovan.apigen.generator.apigenerator.service.ApiGeneratorService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path(ApiConstant.API_GENERATOR_PATH)
public class ApiGeneratorRestController {


    @Inject
    ApiGeneratorService apiGeneratorService;

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
    public Boolean generate(ApiGeneratorModel apiGeneratorModel) throws IOException {
        return apiGeneratorService.generate(apiGeneratorModel);
    }


    @POST
    @Path(ApiConstant.COPY_FRONT_END_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Boolean copyFrontEndApi(FrontEndCopyModel frontEndCopyModel) throws IOException {
        return apiGeneratorService.copyFrontEnd(frontEndCopyModel);
    }


    @POST
    @Path(ApiConstant.CLONE_BASIC_CONVERTER_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String cloneBasicConverter(FrontEndCopyModel frontEndCopyModel) throws IOException {
        apiGeneratorService.cloneBasicConverter(frontEndCopyModel);
        return "Ok meeeeeeeeen";
    }


}
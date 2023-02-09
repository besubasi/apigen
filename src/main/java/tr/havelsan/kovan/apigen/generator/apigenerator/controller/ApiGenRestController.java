package tr.havelsan.kovan.apigen.generator.apigenerator.controller;

import tr.havelsan.kovan.apigen.common.constraint.ApiGenConstraint;
import tr.havelsan.kovan.apigen.generator.apigenerator.model.ApiModel;
import tr.havelsan.kovan.apigen.generator.apigenerator.model.FrontEndCopyModel;
import tr.havelsan.kovan.apigen.generator.apigenerator.service.ApiGenService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path(ApiGenConstraint.PATH_API_GEN)
public class ApiGenRestController {

    public static final String GENERATE = "/generate";

    @Inject
    ApiGenService apiGenService;

    @GET
    @Path(ApiGenConstraint.API_SAY_MY_NAME)
    @Produces(MediaType.TEXT_PLAIN)
    public String sayMyName() {
        return "Walter White";
    }


    @POST
    @Path(GENERATE)
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean generateApi(ApiModel apiModel) {
        System.out.println("\"" + apiModel.getApiName() + "\" api generating");
        boolean result = true;
        try {
            apiGenService.generate(apiModel);
        } catch (IOException e) {
            e.printStackTrace();
            result = false;
        } finally {
            System.out.println("End generate api result : " + result);
        }
        return result;
    }

    @POST
    @Path(ApiGenConstraint.API_COPY_BACK_END)
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean copyBackEndApi(ApiModel apiModel) {
        System.out.println("BackEnd \"" + apiModel.getApiName() + "\" api being copied");
        return Boolean.TRUE;
    }


    @POST
    @Path(ApiGenConstraint.API_COPY_FRONT_END)
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean copyFrontEndApi(FrontEndCopyModel frontEndCopyModel) {
        System.out.println("FrontEnd \"" + frontEndCopyModel.getSourcePath() + "\" api being copied");
        boolean result = true;
        try {
            apiGenService.copyFrontEnd(frontEndCopyModel);
        } catch (IOException e) {
            e.printStackTrace();
            result = false;
        } finally {
            System.out.println("FrontEnd copy generate api result : " + result);
        }
        return result;
    }


    @POST
    @Path(ApiGenConstraint.API_CLONE_BASIC_CONVERTER)
    @Produces(MediaType.APPLICATION_JSON)
    public String cloneBasicConverter(FrontEndCopyModel frontEndCopyModel) throws IOException {
        apiGenService.cloneBasicConverter(frontEndCopyModel);
        return "Ok meeeeeeeeen";
    }


}
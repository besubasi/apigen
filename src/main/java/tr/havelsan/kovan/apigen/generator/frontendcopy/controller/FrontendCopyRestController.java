package tr.havelsan.kovan.apigen.generator.frontendcopy.controller;

import tr.havelsan.kovan.apigen.common.constant.ApiConstant;
import tr.havelsan.kovan.apigen.common.model.ApiGenResponse;
import tr.havelsan.kovan.apigen.generator.frontendcopy.service.FrontendCopyService;
import tr.havelsan.kovan.apigen.generator.frontendcopy.model.FrontendCopyModel;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path(ApiConstant.APIGEN_FRONT_END)
public class FrontendCopyRestController {

    @Inject
    FrontendCopyService frontEndCopyService;

    @GET
    @Path(ApiConstant.SAY_MY_NAME)
    @Produces(MediaType.TEXT_PLAIN)
    public String sayMyName() {
        return "Walter White";
    }

    @POST
    @Path(ApiConstant.COPY)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ApiGenResponse<Boolean> copy(FrontendCopyModel frontendCopyModel) throws IOException {
        return new ApiGenResponse<>(frontEndCopyService.copy(frontendCopyModel));
    }

}

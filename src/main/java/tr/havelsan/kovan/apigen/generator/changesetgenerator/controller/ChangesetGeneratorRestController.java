package tr.havelsan.kovan.apigen.generator.changesetgenerator.controller;

import tr.havelsan.kovan.apigen.common.constant.ApiConstant;
import tr.havelsan.kovan.apigen.generator.changesetgenerator.model.MenuChangesetModel;
import tr.havelsan.kovan.apigen.generator.changesetgenerator.model.OauthChangesetModel;
import tr.havelsan.kovan.apigen.generator.changesetgenerator.service.ChangesetGeneratorService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path(ApiConstant.APIGEN_CHANGESET)
public class ChangesetGeneratorRestController {


    @Inject
    ChangesetGeneratorService changeSetGeneratorService;

    @GET
    @Path(ApiConstant.SAY_MY_NAME)
    @Produces(MediaType.TEXT_PLAIN)
    public String sayMyName() {
        return "Walter White";
    }

    @POST
    @Path(ApiConstant.GENERATE_OAUTH)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String generateOauthChangeset(OauthChangesetModel oauthChangesetModel) throws IOException {
        return changeSetGeneratorService.generateOauthChangeset(oauthChangesetModel);
    }

    @POST
    @Path(ApiConstant.GENERATE_MENU)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String generateMenuChangeset(MenuChangesetModel menuChangesetModel) throws IOException {
        return changeSetGeneratorService.generateMenuChangeset(menuChangesetModel);
    }

}

package tr.subasi.apigen.menu.controller;

import tr.subasi.apigen.common.constant.ApiConstant;
import tr.subasi.apigen.menu.service.ApiGenMenuItemService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.io.IOException;
import java.net.URISyntaxException;


@Path(ApiConstant.MENU_ITEMS)
public class ApiGenMenuItemRestController {

    @Inject
    ApiGenMenuItemService apiGenMenuItemService;

    @GET
    @Path(ApiConstant.SAY_MY_NAME)
    @Produces(MediaType.TEXT_PLAIN)
    public String sayMyName() {
        return "Walter White";
    }

    @GET
    @Path(ApiConstant.DATA_LIST)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Object getMenuItemList() throws IOException, URISyntaxException {
        return apiGenMenuItemService.readFromJsonFile();
    }

}

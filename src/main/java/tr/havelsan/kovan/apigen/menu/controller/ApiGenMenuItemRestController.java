package tr.havelsan.kovan.apigen.menu.controller;

import tr.havelsan.kovan.apigen.common.constant.ApiConstant;
import tr.havelsan.kovan.apigen.menu.service.ApiGenMenuItemService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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

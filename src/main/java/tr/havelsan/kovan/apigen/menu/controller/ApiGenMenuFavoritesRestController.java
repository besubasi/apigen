package tr.havelsan.kovan.apigen.menu.controller;

import tr.havelsan.kovan.apigen.common.constant.ApiConstant;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collections;

@Path(ApiConstant.MENU_FAVORITES)
public class ApiGenMenuFavoritesRestController {

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
    public Object getMenuItemList() {
        return Collections.emptyList();
    }

}

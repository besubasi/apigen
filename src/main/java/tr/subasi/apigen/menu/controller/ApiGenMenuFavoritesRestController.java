package tr.subasi.apigen.menu.controller;

import tr.subasi.apigen.common.constant.ApiConstant;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
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

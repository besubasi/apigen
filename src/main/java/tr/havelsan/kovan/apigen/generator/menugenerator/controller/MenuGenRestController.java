package tr.havelsan.kovan.apigen.generator.menugenerator.controller;

import tr.havelsan.kovan.apigen.common.constraint.ApiGenConstraint;
import tr.havelsan.kovan.apigen.generator.menugenerator.model.MenuChangeSetModel;
import tr.havelsan.kovan.apigen.generator.menugenerator.model.MenuSqlScriptModel;
import tr.havelsan.kovan.apigen.generator.menugenerator.service.MenuGenService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path(ApiGenConstraint.PATH_MENU_GEN)
public class MenuGenRestController {


    public static final String API_SQL_SCRIPT = "/sql-script";
    public static final String API_CHANGE_SET = "/change-set";

    @Inject
    MenuGenService menuGenService;

    @GET
    @Path(ApiGenConstraint.API_SAY_MY_NAME)
    @Produces(MediaType.TEXT_PLAIN)
    public String sayMyName() {
        return "Walter White";
    }


    @POST
    @Path(API_SQL_SCRIPT)
    @Produces(MediaType.APPLICATION_JSON)
    public String generateSqlScript(MenuSqlScriptModel menuSqlScriptModel) {
        System.out.println("Menu script generating is started for " + menuSqlScriptModel.getMenuLabel());
        String result = null;
        try {
            return menuGenService.generateSqlScript(menuSqlScriptModel);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Menu script generating is end for : " + result);
        }
        return result;
    }


    @POST
    @Path(API_CHANGE_SET)
    @Produces(MediaType.APPLICATION_JSON)
    public String generateChangeSet(MenuChangeSetModel menuChangeSetModel) {
        System.out.println("Menu change set generating is started for " + menuChangeSetModel.getMenuLabel());
        String result = null;
        try {
            return menuGenService.generateChangeSet(menuChangeSetModel);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Menu change set generating is end for : " + result);
        }
        return result;
    }

}

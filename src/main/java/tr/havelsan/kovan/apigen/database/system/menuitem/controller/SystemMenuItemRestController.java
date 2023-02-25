package tr.havelsan.kovan.apigen.database.system.menuitem.controller;

import org.jboss.resteasy.reactive.RestPath;
import tr.havelsan.kovan.apigen.database.system.menuitem.entity.SystemMenuItem;
import tr.havelsan.kovan.apigen.database.system.menuitem.service.SystemMenuItemService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/database/system/sys-menu-item")
public class SystemMenuItemRestController {

    @Inject
    SystemMenuItemService systemMenuItemService;

    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<SystemMenuItem> findAll() {
        return systemMenuItemService.findAll();
    }

    @GET
    @Path("/findByParentId/{parentId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<SystemMenuItem> findByParentId(@RestPath Long parentId) {
        return systemMenuItemService.findByParentId(parentId);
    }


}
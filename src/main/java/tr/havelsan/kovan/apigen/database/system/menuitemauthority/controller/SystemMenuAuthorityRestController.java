package tr.havelsan.kovan.apigen.database.system.menuitemauthority.controller;

import org.jboss.resteasy.reactive.RestPath;
import tr.havelsan.kovan.apigen.database.system.menuitemauthority.entity.SystemMenuAuthority;
import tr.havelsan.kovan.apigen.database.system.menuitemauthority.service.SystemMenuAuthorityService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/database/system/sys-menu-item-authority")
public class SystemMenuAuthorityRestController {

    @Inject
    SystemMenuAuthorityService systemMenuAuthorityService;

    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<SystemMenuAuthority> findAll() {
        return systemMenuAuthorityService.findAll();
    }

    @GET
    @Path("/findByMenuItemId/{menuItemId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<SystemMenuAuthority> findByMenuItemId(@RestPath Long menuItemId) {
        return systemMenuAuthorityService.findByMenuItemId(menuItemId);
    }

    @GET
    @Path("/findByAuthorityCode/{authorityCode}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<SystemMenuAuthority> findByAuthorityCode(@RestPath String authorityCode) {
        return systemMenuAuthorityService.findByAuthorityCode(authorityCode);
    }

}

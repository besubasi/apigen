package tr.havelsan.kovan.apigen.database.system.menuitemauthority.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import tr.havelsan.kovan.apigen.database.system.menuitemauthority.entity.SystemMenuAuthority;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class SystemMenuAuthorityRepository implements PanacheRepository<SystemMenuAuthority> {

    public List<SystemMenuAuthority> findByMenuItemId(Long menuItemId) {
        return list("menu_item_id", menuItemId);
    }

    public List<SystemMenuAuthority> findByAuthorityCode(String authorityCode) {
        return list("authority_code", authorityCode);
    }

}

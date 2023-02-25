package tr.havelsan.kovan.apigen.database.system.menuitem.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import tr.havelsan.kovan.apigen.database.system.menuitem.entity.SystemMenuItem;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class SystemMenuItemRepository implements PanacheRepository<SystemMenuItem> {

    public List<SystemMenuItem> findByParentId(Long parentId){
        return list("parent_id", parentId);
    }

}

package tr.havelsan.kovan.apigen.database.system.menuitem.service;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import tr.havelsan.kovan.apigen.database.system.menuitem.entity.SystemMenuItem;
import tr.havelsan.kovan.apigen.database.system.menuitem.repository.SystemMenuItemRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class SystemMenuItemServiceImpl implements SystemMenuItemService {

    @Inject
    SystemMenuItemRepository systemMenuItemRepository;


    public List<SystemMenuItem> findAll() {
        PanacheQuery<SystemMenuItem> all = systemMenuItemRepository.findAll();
        return all.stream().collect(Collectors.toList());
    }

    public List<SystemMenuItem> findByParentId(Long parentId) {
        return systemMenuItemRepository.findByParentId(parentId);
    }

}

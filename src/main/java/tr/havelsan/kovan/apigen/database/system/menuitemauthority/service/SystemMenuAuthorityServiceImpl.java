package tr.havelsan.kovan.apigen.database.system.menuitemauthority.service;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import tr.havelsan.kovan.apigen.database.system.menuitemauthority.entity.SystemMenuAuthority;
import tr.havelsan.kovan.apigen.database.system.menuitemauthority.repository.SystemMenuAuthorityRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class SystemMenuAuthorityServiceImpl implements SystemMenuAuthorityService {

    @Inject
    SystemMenuAuthorityRepository systemMenuAuthorityRepository;

    public List<SystemMenuAuthority> findAll() {
        PanacheQuery<SystemMenuAuthority> all = systemMenuAuthorityRepository.findAll();
        return all.stream().collect(Collectors.toList());
    }

    public List<SystemMenuAuthority> findByMenuItemId(Long menuItemId) {
        return systemMenuAuthorityRepository.findByMenuItemId(menuItemId);
    }

    public List<SystemMenuAuthority> findByAuthorityCode(String authorityCode) {
        return systemMenuAuthorityRepository.findByAuthorityCode(authorityCode);
    }

}
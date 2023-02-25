package tr.havelsan.kovan.apigen.database.system.menuitemauthority.service;

import tr.havelsan.kovan.apigen.database.system.menuitemauthority.entity.SystemMenuAuthority;

import java.util.List;


public interface SystemMenuAuthorityService {

    List<SystemMenuAuthority> findAll();

    List<SystemMenuAuthority> findByMenuItemId(Long menuItemId);

    List<SystemMenuAuthority> findByAuthorityCode(String authorityCode);

}


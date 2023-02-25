package tr.havelsan.kovan.apigen.database.system.menuitem.service;

import tr.havelsan.kovan.apigen.database.system.menuitem.entity.SystemMenuItem;

import java.util.List;

public interface SystemMenuItemService {

    List<SystemMenuItem> findAll();

    List<SystemMenuItem> findByParentId(Long parentId);

}

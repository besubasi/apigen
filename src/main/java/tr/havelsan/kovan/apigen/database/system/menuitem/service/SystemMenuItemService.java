package tr.havelsan.kovan.apigen.database.system.menuitem.service;

import tr.havelsan.kovan.apigen.database.system.menuitem.entity.SystemMenuItem;
import tr.havelsan.kovan.apigen.menu.model.TreeNode;

import java.util.List;

public interface SystemMenuItemService {

    List<SystemMenuItem> findAll();

    List<SystemMenuItem> findByParentId(Long parentId);

    List<SystemMenuItem> getParentIdIsNull();

    List<SystemMenuItem> getLogisticParentMenu();

    List<TreeNode<SystemMenuItem>> getLogisticParentNode();

}

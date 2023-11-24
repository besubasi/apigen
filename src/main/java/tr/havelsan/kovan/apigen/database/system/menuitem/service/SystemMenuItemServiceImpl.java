package tr.havelsan.kovan.apigen.database.system.menuitem.service;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import tr.havelsan.kovan.apigen.database.system.menuitem.entity.SystemMenuItem;
import tr.havelsan.kovan.apigen.database.system.menuitem.repository.SystemMenuItemRepository;
import tr.havelsan.kovan.apigen.menu.model.TreeNode;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
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

    @Override
    public List<SystemMenuItem> getParentIdIsNull() {
        return systemMenuItemRepository.getParentIdIsNull();
    }

    @Override
    public List<SystemMenuItem> getLogisticParentMenu() {
        return systemMenuItemRepository.getLogisticParentMenu();
    }

    @Override
    public List<TreeNode<SystemMenuItem>> getLogisticParentNode() {
        List<SystemMenuItem> menuItemList = systemMenuItemRepository.getLogisticParentMenu();
        if (menuItemList == null || menuItemList.isEmpty())
            return Collections.emptyList();

        SystemMenuItem parentMenuItem = menuItemList.stream().filter(x -> x.getParentId() == null).findFirst().orElse(null);
        List<SystemMenuItem> childMenuItemList = menuItemList.stream().filter(x -> Objects.equals(x.getParentId(), parentMenuItem.getId())).collect(Collectors.toList());
        return convertToTreeNode(childMenuItemList, parentMenuItem);
    }

    private List<TreeNode<SystemMenuItem>> convertToTreeNode(List<SystemMenuItem> menuItemList, SystemMenuItem parentMenuItem) {
        List<TreeNode<SystemMenuItem>> treeNodeList = new ArrayList<>();
        menuItemList.forEach(menuItem -> {
            TreeNode<SystemMenuItem> treeNode = new TreeNode<>();
            treeNode.setKey(menuItem.getUuid());
            treeNode.setLabel(menuItem.getLabel());
            treeNode.setData(menuItem);

            List<SystemMenuItem> childMenuItemList = menuItemList.stream().filter(x -> Objects.equals(x.getParentId(), parentMenuItem.getId())).collect(Collectors.toList());
            if (!childMenuItemList.isEmpty())
                treeNode.setChildren(this.convertToTreeNode(childMenuItemList, menuItem));

            treeNodeList.add(treeNode);
        });
        return treeNodeList;
    }


}

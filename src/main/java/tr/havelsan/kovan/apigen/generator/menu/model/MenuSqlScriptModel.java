package tr.havelsan.kovan.apigen.generator.menu.model;

public class MenuSqlScriptModel {
    // Menu
    String menuUuid;
    String menuLabel;
    Integer menuOrder;
    String menuPath;
    String menuParentUuid;

    // Authority
    String authorityCode;
    String authorityUuid;
    String authorityLabel;

    // Authority
    String roleUuid;

    public String getMenuUuid() {
        return menuUuid;
    }

    public void setMenuUuid(String menuUuid) {
        this.menuUuid = menuUuid;
    }

    public String getMenuLabel() {
        return menuLabel;
    }

    public void setMenuLabel(String menuLabel) {
        this.menuLabel = menuLabel;
    }

    public Integer getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(Integer menuOrder) {
        this.menuOrder = menuOrder;
    }

    public String getMenuPath() {
        return menuPath;
    }

    public void setMenuPath(String menuPath) {
        this.menuPath = menuPath;
    }

    public String getMenuParentUuid() {
        return menuParentUuid;
    }

    public void setMenuParentUuid(String menuParentUuid) {
        this.menuParentUuid = menuParentUuid;
    }

    public String getAuthorityCode() {
        return authorityCode;
    }

    public void setAuthorityCode(String authorityCode) {
        this.authorityCode = authorityCode;
    }

    public String getAuthorityUuid() {
        return authorityUuid;
    }

    public void setAuthorityUuid(String authorityUuid) {
        this.authorityUuid = authorityUuid;
    }

    public String getAuthorityLabel() {
        return authorityLabel;
    }

    public void setAuthorityLabel(String authorityLabel) {
        this.authorityLabel = authorityLabel;
    }

    public String getRoleUuid() {
        return roleUuid;
    }

    public void setRoleUuid(String roleUuid) {
        this.roleUuid = roleUuid;
    }
}

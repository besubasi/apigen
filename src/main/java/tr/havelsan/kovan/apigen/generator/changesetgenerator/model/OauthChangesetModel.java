package tr.havelsan.kovan.apigen.generator.changesetgenerator.model;

import java.util.List;

public class OauthChangesetModel {

    String code;
    String label;
    List<String> roleCodeList;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<String> getRoleCodeList() {
        return roleCodeList;
    }

    public void setRoleCodeList(List<String> roleCodeList) {
        this.roleCodeList = roleCodeList;
    }
}

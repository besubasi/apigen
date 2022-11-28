package tr.havelsan.kovan.apigen.model;

import java.util.List;

public class EnumModel {

    private String name;
    private List<EnumKeyModel> keyList;

    private String commonPackage;
    private String sharedName;
    private String sharedPackage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EnumKeyModel> getKeyList() {
        return keyList;
    }

    public void setKeyList(List<EnumKeyModel> keyList) {
        this.keyList = keyList;
    }

    public String getCommonPackage() {
        return commonPackage;
    }

    public void setCommonPackage(String commonPackage) {
        this.commonPackage = commonPackage;
    }

    public String getSharedName() {
        return sharedName;
    }

    public void setSharedName(String sharedName) {
        this.sharedName = sharedName;
    }

    public String getSharedPackage() {
        return sharedPackage;
    }

    public void setSharedPackage(String sharedPackage) {
        this.sharedPackage = sharedPackage;
    }
}

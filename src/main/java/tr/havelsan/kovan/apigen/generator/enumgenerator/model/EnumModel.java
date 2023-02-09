package tr.havelsan.kovan.apigen.generator.enumgenerator.model;

import tr.havelsan.kovan.apigen.common.enums.EnumMicroservice;

import java.util.List;

public class EnumModel {

    private String name;
    private List<EnumKeyModel> keyList;

    private EnumMicroservice microservice;
    private String commonPackage;
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

    public EnumMicroservice getMicroservice() {
        return microservice;
    }

    public void setMicroservice(EnumMicroservice microservice) {
        this.microservice = microservice;
    }

    public String getSharedPackage() {
        return sharedPackage;
    }

    public void setSharedPackage(String sharedPackage) {
        this.sharedPackage = sharedPackage;
    }
}

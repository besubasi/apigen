package tr.havelsan.kovan.apigen.common.model;

import tr.havelsan.kovan.apigen.common.enums.EnumMicroservice;
import tr.havelsan.kovan.apigen.common.util.PathUtil;

public class ConfModel {

    private String microServiceName;// yml daki deger icin
    private String commonPackage;
    private String servicePackage;
    private String groovyPackage;

    public ConfModel(EnumMicroservice microservice) {
        this.microServiceName =  PathUtil.getMicroserviceName(microservice);
        this.commonPackage = PathUtil.getCommonPackage(microservice);
        this.servicePackage = PathUtil.getServicePackage(microservice);
        this.groovyPackage = PathUtil.getGroovyPackage(microservice);
    }

    public String getMicroServiceName() {
        return microServiceName;
    }

    public void setMicroServiceName(String microServiceName) {
        this.microServiceName = microServiceName;
    }

    public String getCommonPackage() {
        return commonPackage;
    }

    public void setCommonPackage(String commonPackage) {
        this.commonPackage = commonPackage;
    }

    public String getServicePackage() {
        return servicePackage;
    }

    public void setServicePackage(String servicePackage) {
        this.servicePackage = servicePackage;
    }

    public String getGroovyPackage() {
        return groovyPackage;
    }

    public void setGroovyPackage(String groovyPackage) {
        this.groovyPackage = groovyPackage;
    }
}

package tr.havelsan.kovan.apigen.common.model;

import tr.havelsan.kovan.apigen.common.enums.EnumMicroservice;
import tr.havelsan.kovan.apigen.common.enums.EnumModule;
import tr.havelsan.kovan.apigen.common.util.PathUtil;

public class ConfModel {

    private String microServiceName;
    private String commonPackage;
    private String servicePackage;
    private String groovyPackage;

    private String moduleName;
    private String configurationConstant;
    private String groovyPathConstant;

    public ConfModel(EnumMicroservice microservice, EnumModule module) {
        this.microServiceName =  PathUtil.getMicroserviceName(microservice);
        this.commonPackage = PathUtil.getCommonPackage(microservice);
        this.servicePackage = PathUtil.getServicePackage(microservice);
        this.groovyPackage = PathUtil.getGroovyPackage(microservice);

        this.moduleName = PathUtil.getModuleName(module);
        this.configurationConstant = PathUtil.getConfigurationConstant(microservice);
        this.groovyPathConstant = PathUtil.getGroovyPathConstant(module);
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

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getConfigurationConstant() {
        return configurationConstant;
    }

    public void setConfigurationConstant(String configurationConstant) {
        this.configurationConstant = configurationConstant;
    }

    public String getGroovyPathConstant() {
        return groovyPathConstant;
    }

    public void setGroovyPathConstant(String groovyPathConstant) {
        this.groovyPathConstant = groovyPathConstant;
    }
}

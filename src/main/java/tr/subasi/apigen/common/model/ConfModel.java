package tr.subasi.apigen.common.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import tr.subasi.apigen.common.enums.EnumMicroservice;
import tr.subasi.apigen.common.enums.EnumModule;
import tr.subasi.apigen.common.util.PathUtil;

@Data
@NoArgsConstructor
public class ConfModel {

    private String microServiceName, commonPackage, servicePackage, groovyPackage;
    private String moduleName, configurationConstant, groovyPathConstant;

    public ConfModel(EnumMicroservice microservice, EnumModule module) {
        this.microServiceName = PathUtil.getMicroserviceName(microservice);
        this.commonPackage = PathUtil.getClientPackage(microservice);
        this.servicePackage = PathUtil.getServicePackage(microservice);
        this.groovyPackage = PathUtil.getGroovyPackage(microservice);

        this.moduleName = PathUtil.getModuleName(module);
        this.configurationConstant = PathUtil.getConfigurationConstant(microservice);
        this.groovyPathConstant = "";
    }
}

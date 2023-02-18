package tr.havelsan.kovan.apigen.common.util;

import tr.havelsan.kovan.apigen.common.constraint.PathConstraint;
import tr.havelsan.kovan.apigen.common.enums.EnumMicroservice;
import tr.havelsan.kovan.apigen.common.enums.EnumModule;
import tr.havelsan.kovan.apigen.generator.apigenerator.model.ApiModel;

import java.io.File;

public class PathUtil {

    static String repositoryPath;

    public static void setRepositoryPath(String repositoryPath) {
        PathUtil.repositoryPath = repositoryPath;
    }

    public static String getFrontendPath(EnumMicroservice microservice) {
        if (EnumMicroservice.LOGISTIC_GENERAL == microservice)
            return repositoryPath + PathConstraint.LOGISTIC_GENERAL_FRONTEND_PATH;
        else if (EnumMicroservice.MATERIAL_MANAGEMENT == microservice)
            return repositoryPath + PathConstraint.MATERIAL_MANAGEMENT_FRONTEND_PATH;
        else if (EnumMicroservice.MAINTENANCE_MANAGEMENT == microservice)
            return repositoryPath + PathConstraint.MAINTENANCE_MANAGEMENT_FRONTEND_PATH;

        return "";
    }

    public static String getFrontendSharedPath(EnumMicroservice microservice) {
        if (EnumMicroservice.LOGISTIC_GENERAL == microservice)
            return repositoryPath + PathConstraint.LOGISTIC_GENERAL_FRONTEND_SHARED_PATH;
        else if (EnumMicroservice.MATERIAL_MANAGEMENT == microservice)
            return repositoryPath + PathConstraint.MATERIAL_MANAGEMENT_FRONTEND_SHARED_PATH;
        else if (EnumMicroservice.MAINTENANCE_MANAGEMENT == microservice)
            return repositoryPath + PathConstraint.MAINTENANCE_MANAGEMENT_FRONTEND_SHARED_PATH;

        return "";
    }

    public static String getFrontendSharedSrcLibPath(EnumMicroservice microservice) {
        return getFrontendSharedPath(microservice) + PathConstraint.SRC_LIB;
    }


    public static String geti18nTrPath(EnumMicroservice microservice) {
        return getFrontendSharedPath(microservice) + PathConstraint.i18n_TR_PATH;
    }


    public static String geti18nEnPath(EnumMicroservice microservice) {
        return getFrontendSharedPath(microservice) + PathConstraint.i18n_EN_PATH;
    }


    public static String getPublicApiTsPath(EnumMicroservice microservice) {
        return getFrontendSharedPath(microservice) + PathConstraint.PUBLIC_API_TS;
    }

    public static String getYmlPath(EnumMicroservice microservice) {
        if (EnumMicroservice.LOGISTIC_GENERAL == microservice)
            return repositoryPath + PathConstraint.LOGISTIC_GENERAL_YML_PATH;
        else if (EnumMicroservice.MATERIAL_MANAGEMENT == microservice)
            return repositoryPath + PathConstraint.MATERIAL_MANAGEMENT_YML_PATH;
        else if (EnumMicroservice.MAINTENANCE_MANAGEMENT == microservice)
            return repositoryPath + PathConstraint.MAINTENANCE_MANAGEMENT_YML_PATH;

        return "";
    }

    public static String getCommonPath(EnumMicroservice microservice) {
        if (EnumMicroservice.LOGISTIC_GENERAL == microservice)
            return repositoryPath + PathConstraint.LOGISTIC_GENERAL_COMMON_PATH;
        else if (EnumMicroservice.MATERIAL_MANAGEMENT == microservice)
            return repositoryPath + PathConstraint.MATERIAL_MANAGEMENT_COMMON_PATH;
        else if (EnumMicroservice.MAINTENANCE_MANAGEMENT == microservice)
            return repositoryPath + PathConstraint.MAINTENANCE_MANAGEMENT_COMMON_PATH;

        return "";
    }

    public static String getServicePath(EnumMicroservice microservice) {
        if (EnumMicroservice.LOGISTIC_GENERAL == microservice)
            return repositoryPath + PathConstraint.LOGISTIC_GENERAL_SERVICE_PATH;
        else if (EnumMicroservice.MATERIAL_MANAGEMENT == microservice)
            return repositoryPath + PathConstraint.MATERIAL_MANAGEMENT_SERVICE_PATH;
        else if (EnumMicroservice.MAINTENANCE_MANAGEMENT == microservice)
            return repositoryPath + PathConstraint.MAINTENANCE_MANAGEMENT_SERVICE_PATH;

        return "";
    }

    public static String getGroovyPath(EnumMicroservice microservice) {
        if (EnumMicroservice.LOGISTIC_GENERAL == microservice)
            return repositoryPath + PathConstraint.LOGISTIC_GENERAL_GROOVY_PATH;
        else if (EnumMicroservice.MATERIAL_MANAGEMENT == microservice)
            return repositoryPath + PathConstraint.MATERIAL_MANAGEMENT_GROOVY_PATH;
        else if (EnumMicroservice.MAINTENANCE_MANAGEMENT == microservice)
            return repositoryPath + PathConstraint.MAINTENANCE_MANAGEMENT_GROOVY_PATH;

        return "";
    }

    public static String getMicroserviceName(EnumMicroservice microservice) {
        if (EnumMicroservice.LOGISTIC_GENERAL == microservice)
            return PathConstraint.LOGISTIC_GENERAL_MICROSERVICE_NAME;
        else if (EnumMicroservice.MATERIAL_MANAGEMENT == microservice)
            return PathConstraint.MATERIAL_MANAGEMENT_MICROSERVICE_NAME;
        else if (EnumMicroservice.MAINTENANCE_MANAGEMENT == microservice)
            return PathConstraint.MAINTENANCE_MANAGEMENT_MICROSERVICE_NAME;

        return "";
    }


    public static String getCommonPackagePath(ApiModel apiModel, String subPackage) {
        return getCommonPath(apiModel.getMicroservice()) + File.separator +
                convertPackageToPath(getCommonPackage(apiModel.getMicroservice())
                        + File.separator + getModuleName(apiModel.getModule())
                        + File.separator + apiModel.getApiPackage()
                        + File.separator + subPackage);
    }

    public static String getServicePackagePath(ApiModel apiModel, String subPackage) {
        return getServicePath(apiModel.getMicroservice()) + File.separator +
                convertPackageToPath(getServicePackage(apiModel.getMicroservice())
                        + File.separator + getModuleName(apiModel.getModule())
                        + File.separator + apiModel.getApiPackage()
                        + File.separator + subPackage);
    }

    public static String getGroovyPackagePath(ApiModel apiModel) {
        return getGroovyPath(apiModel.getMicroservice()) + File.separator +
                convertPackageToPath(getGroovyPackage(apiModel.getMicroservice())
                        + File.separator + getModuleName(apiModel.getModule())
                        + File.separator + apiModel.getApiPackage());
    }

    public static String getCommonPackage(EnumMicroservice microservice) {
        if (EnumMicroservice.LOGISTIC_GENERAL == microservice)
            return PathConstraint.LOGISTIC_GENERAL_COMMON_PACKAGE;
        else if (EnumMicroservice.MATERIAL_MANAGEMENT == microservice)
            return PathConstraint.MATERIAL_MANAGEMENT_COMMON_PACKAGE;
        else if (EnumMicroservice.MAINTENANCE_MANAGEMENT == microservice)
            return PathConstraint.MAINTENANCE_MANAGEMENT_COMMON_PACKAGE;

        return "";
    }

    public static String getServicePackage(EnumMicroservice microservice) {
        if (EnumMicroservice.LOGISTIC_GENERAL == microservice)
            return PathConstraint.LOGISTIC_GENERAL_SERVICE_PACKAGE;
        else if (EnumMicroservice.MATERIAL_MANAGEMENT == microservice)
            return PathConstraint.MATERIAL_MANAGEMENT_SERVICE_PACKAGE;
        else if (EnumMicroservice.MAINTENANCE_MANAGEMENT == microservice)
            return PathConstraint.MAINTENANCE_MANAGEMENT_SERVICE_PACKAGE;

        return "";
    }

    public static String getGroovyPackage(EnumMicroservice microservice) {
        if (EnumMicroservice.LOGISTIC_GENERAL == microservice)
            return PathConstraint.LOGISTIC_GENERAL_GROOVY_PACKAGE;
        else if (EnumMicroservice.MATERIAL_MANAGEMENT == microservice)
            return PathConstraint.MATERIAL_MANAGEMENT_GROOVY_PACKAGE;
        else if (EnumMicroservice.MAINTENANCE_MANAGEMENT == microservice)
            return PathConstraint.MAINTENANCE_MANAGEMENT_GROOVY_PACKAGE;

        return "";
    }

    public static String getModuleName(EnumModule module) {
        if (EnumModule.CONDITION == module)
            return PathConstraint.LOGISTIC_GENERAL_MODULE_CONDITION;
        else if (EnumModule.GENERAL == module)
            return PathConstraint.LOGISTIC_GENERAL_MODULE_GENERAL;
        else if (EnumModule.GENERAL_ADDRESS == module)
            return PathConstraint.LOGISTIC_GENERAL_MODULE_GENERAL_ADDRESS;
        else if (EnumModule.INTEGRATIONS == module)
            return PathConstraint.LOGISTIC_GENERAL_MODULE_INTEGRATIONS;
        else if (EnumModule.ORGANIZATION == module)
            return PathConstraint.LOGISTIC_GENERAL_MODULE_ORGANIZATION;
        else if (EnumModule.PARAMETERS == module)
            return PathConstraint.LOGISTIC_GENERAL_MODULE_PARAMETERS;
        else if (EnumModule.MATERIAL_IDENTIFICATION == module)
            return PathConstraint.MATERIAL_MANAGEMENT_MODULE_MATERIAL_IDENTIFICATION;
        else if (EnumModule.PURCHASING == module)
            return PathConstraint.MATERIAL_MANAGEMENT_MODULE_PURCHASING;
        else if (EnumModule.STOCK == module)
            return PathConstraint.MATERIAL_MANAGEMENT_MODULE_STOCK;
        else if (EnumModule.WAREHOUSE == module)
            return PathConstraint.MATERIAL_MANAGEMENT_MODULE_WAREHOUSE;
        else if (EnumModule.CONFIGURATION_MANAGEMENT == module)
            return PathConstraint.MAINTENANCE_MANAGEMENT_MODULE_CONFIGURATION_MANAGEMENT;
        else if (EnumModule.ENGINEERING == module)
            return PathConstraint.MAINTENANCE_MANAGEMENT_MODULE_ENGINEERING;
        else if (EnumModule.MAINTENANCE_ASSETS_MANAGEMENT == module)
            return PathConstraint.MAINTENANCE_MANAGEMENT_MODULE_MAINTENANCE_ASSETS_MANAGEMENT;
        else if (EnumModule.MAINTENANCE_REPAIR_APPLICATION == module)
            return PathConstraint.MAINTENANCE_MANAGEMENT_MODULE_MAINTENANCE_REPAIR_APPLICATION;
        else if (EnumModule.PREVENTIVE_MAINTENANCE == module)
            return PathConstraint.MAINTENANCE_MANAGEMENT_MODULE_PREVENTIVE_MAINTENANCE;

        return "";
    }

    public static String getGroovyPathConstant(EnumModule module) {
        if (EnumModule.CONDITION == module)
            return PathConstraint.CONTROL_CLASS_LOGISTIC_GENERAL_PATH;
        else if (EnumModule.GENERAL == module)
            return null;
        else if (EnumModule.GENERAL_ADDRESS == module)
            return null;
        else if (EnumModule.INTEGRATIONS == module)
            return null;
        else if (EnumModule.ORGANIZATION == module)
            return PathConstraint.CONTROL_CLASS_ORGANIZATION_PATH;
        else if (EnumModule.PARAMETERS == module)
            return null;
        else if (EnumModule.MATERIAL_IDENTIFICATION == module)
            return PathConstraint.CONTROL_CLASS_MATERIAL_IDENTIFICATION_PATH;
        else if (EnumModule.PURCHASING == module)
            return PathConstraint.CONTROL_CLASS_PURCHASING_PATH;
        else if (EnumModule.STOCK == module)
            return PathConstraint.CONTROL_CLASS_STOCK_PATH;
        else if (EnumModule.WAREHOUSE == module)
            return null;
        else if (EnumModule.CONFIGURATION_MANAGEMENT == module)
            return PathConstraint.CONTROL_CLASS_CONFIGURATION_MANAGEMENT_PATH;
        else if (EnumModule.ENGINEERING == module)
            return PathConstraint.CONTROL_CLASS_MAINTENANCE_ENGINEERING_PATH;
        else if (EnumModule.MAINTENANCE_ASSETS_MANAGEMENT == module)
            return PathConstraint.CONTROL_CLASS_MAINTENANCE_ASSETS_MANAGEMENT_PATH;
        else if (EnumModule.MAINTENANCE_REPAIR_APPLICATION == module)
            return PathConstraint.CONTROL_CLASS_MAINTENANCE_REPAIR_APPLICATION_PATH;
        else if (EnumModule.PREVENTIVE_MAINTENANCE == module)
            return PathConstraint.CONTROL_CLASS_PREVENTIVE_MAINTENANCE_PATH;

        return "";
    }

    public static String getConfigurationConstant(EnumMicroservice microservice) {
        if (EnumMicroservice.LOGISTIC_GENERAL == microservice)
            return PathConstraint.LOGISTIC_GENERAL_CONFIGURATION_CONSTANT;
        else if (EnumMicroservice.MATERIAL_MANAGEMENT == microservice)
            return PathConstraint.MATERIAL_MANAGEMENT_CONFIGURATION_CONSTANTS;
        else if (EnumMicroservice.MAINTENANCE_MANAGEMENT == microservice)
            return PathConstraint.MAINTENANCE_MANAGEMENT_CONFIGURATION_CONSTANTS;

        return "";
    }

    public static String convertPackageToPath(String packageName) {
        return packageName.replaceAll("\\.", "\\" + File.separator);
    }

}

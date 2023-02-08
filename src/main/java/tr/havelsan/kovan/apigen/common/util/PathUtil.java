package tr.havelsan.kovan.apigen.common.util;

import tr.havelsan.kovan.apigen.common.constraint.PathConstraint;
import tr.havelsan.kovan.apigen.common.enums.EnumMicroservice;
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


    public static String getCommonPackagePath(ApiModel apiModel) {
        return getCommonPath(apiModel.getMicroservice()) +File.separator+
                convertPackageToPath(getCommonPackage(apiModel.getMicroservice())
                        + File.separator + apiModel.getModulePackage()
                        + File.separator + apiModel.getApiPackage());
    }

    public static String getServicePackagePath(ApiModel apiModel) {
        return getServicePath(apiModel.getMicroservice()) +File.separator+
                convertPackageToPath(getServicePackage(apiModel.getMicroservice())
                        + File.separator + apiModel.getModulePackage()
                        + File.separator + apiModel.getApiPackage());
    }

    public static String getGroovyPackagePath(ApiModel apiModel) {
        return getGroovyPath(apiModel.getMicroservice()) +File.separator +
                convertPackageToPath(getGroovyPackage(apiModel.getMicroservice())
                        + File.separator + apiModel.getModulePackage()
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

    public static String convertPackageToPath(String packageName){
        return packageName.replaceAll("\\.", "\\" + File.separator);
    }

}

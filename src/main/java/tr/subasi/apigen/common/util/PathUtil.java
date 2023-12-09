package tr.subasi.apigen.common.util;

import tr.subasi.apigen.common.constant.PathConstant;
import tr.subasi.apigen.common.enums.EnumMicroservice;
import tr.subasi.apigen.common.enums.EnumModule;

import java.io.File;

public class PathUtil {

    static String repositoryPath;

    public static void setRepositoryPath(String repositoryPath) {
        PathUtil.repositoryPath = repositoryPath;
    }

    public static String getMicroserviceName(EnumMicroservice microservice) {
        if (EnumMicroservice.GUIDE_ACCOUNT == microservice)
            return PathConstant.ACCOUNT;
        else if (EnumMicroservice.GUIDE_APP == microservice)
            return PathConstant.APP;

        return "";
    }

/*
    public static String getGroovyPackagePath(EnumMicroservice microservice) {
        return getGroovyPath(microservice) + File.separator + convertPackageToPath(getGroovyPackage(microservice));
    }
*/

    public static String getGroovyPath(EnumMicroservice microservice) {
        if (EnumMicroservice.GUIDE_ACCOUNT == microservice)
            return repositoryPath + File.separator + PathConstant.ACCOUNT_GROOVY_PATH;
        else if (EnumMicroservice.GUIDE_APP == microservice)
            return repositoryPath + File.separator + PathConstant.APP_GROOVY_PATH;

        return "";
    }

    public static String getGroovyPackage(EnumMicroservice microservice) {
        if (EnumMicroservice.GUIDE_ACCOUNT == microservice)
            return PathConstant.ACCOUNT_GROOVY_PACKAGE;
        else if (EnumMicroservice.GUIDE_APP == microservice)
            return PathConstant.APP_GROOVY_PACKAGE;

        return "";
    }

    public static String getConfigurationConstant(EnumMicroservice microservice) {
        if (EnumMicroservice.GUIDE_ACCOUNT == microservice)
            return PathConstant.ACCOUNT_CONFIGURATION_CONSTANT;
        else if (EnumMicroservice.GUIDE_APP == microservice)
            return PathConstant.APP_CONFIGURATION_CONSTANT;

        return "";
    }



    public static String getClientPath(EnumMicroservice microservice) {
        if (EnumMicroservice.GUIDE_APP == microservice)
            return repositoryPath + PathConstant.APP_CLIENT_PATH;
        else if (EnumMicroservice.GUIDE_ACCOUNT == microservice)
            return repositoryPath + PathConstant.ACCOUNT_CLIENT_PATH;

        return "";
    }

    public static String getServicePath(EnumMicroservice microservice) {
        if (EnumMicroservice.GUIDE_APP == microservice)
            return repositoryPath + PathConstant.APP_SERVICE_PATH;
        else if (EnumMicroservice.GUIDE_ACCOUNT == microservice)
            return repositoryPath + PathConstant.ACCOUNT_SERVICE_PATH;

        return "";
    }

    public static String getClientPackagePath(EnumMicroservice microservice) {
        return getClientPath(microservice) + File.separator + convertPackageToPath(getClientPackage(microservice));
    }

    public static String getServicePackagePath(EnumMicroservice microservice) {
        return getServicePath(microservice) + File.separator + convertPackageToPath(getServicePackage(microservice));
    }

    public static String getClientPackage(EnumMicroservice microservice) {
        if (EnumMicroservice.GUIDE_APP == microservice)
            return PathConstant.APP_CLIENT_PACKAGE;
        else if (EnumMicroservice.GUIDE_ACCOUNT == microservice)
            return PathConstant.ACCOUNT_CLIENT_PACKAGE;

        return "";
    }

    public static String getServicePackage(EnumMicroservice microservice) {
        if (EnumMicroservice.GUIDE_APP == microservice)
            return PathConstant.APP_SERVICE_PACKAGE;
        else if (EnumMicroservice.GUIDE_ACCOUNT == microservice)
            return PathConstant.ACCOUNT_SERVICE_PACKAGE;

        return "";
    }

    public static String getModuleName(EnumModule module) {
        if (EnumModule.CLIENT == module)
            return PathConstant.ACCOUNT;
        else if (EnumModule.SERVICE == module)
            return PathConstant.APP;

        return "";
    }


    public static String convertPackageToPath(String packageName) {
        return packageName.replaceAll("\\.", "\\" + File.separator);
    }

}

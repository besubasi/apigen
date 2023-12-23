package tr.subasi.apigen.common.util;

import freemarker.template.Template;

import java.io.File;

import static tr.subasi.apigen.generator.constant.ApiGeneratorConstant.FILE_JAVA;

public class PathUtil {

    static String repositoryPath;
    static String servicePackage;

    public static void setRepositoryPath(String repositoryPath) {
        PathUtil.repositoryPath = repositoryPath;
    }

    public static void setServicePackage(String servicePackage) {
        PathUtil.servicePackage = servicePackage;
    }

    public static String getApiMainPath(String apiPackage) {
        return getProjectMainPath() + File.separator + convertPackageToPath(apiPackage);
    }

    public static String getApiPath(Template template, String apiPackage) {
        return getApiMainPath(apiPackage) + File.separator + FileUtil.getSubPackage(template) + File.separator + FileUtil.getFileEndFix(template) + FILE_JAVA;
    }


    public static String getProjectMainPath() {
        return repositoryPath + File.separator + convertPackageToPath(servicePackage);
    }

    public static String convertPackageToPath(String packageName) {
        return packageName.replaceAll("\\.", "\\" + File.separator);
    }

}

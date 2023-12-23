package tr.subasi.apigen.common.util;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import tr.subasi.apigen.config.freemarker.Templates;
import tr.subasi.apigen.generator.model.ApiGeneratorModel;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import static tr.subasi.apigen.generator.constant.ApiGeneratorConstant.*;

public class FileUtil {
    private static final Map<Template, String> mapFileEndFix = Map.of(
            Templates.CONSTANT, END_FIX_CONSTANT
            , Templates.ENTITY, END_FIX_ENTITY
            , Templates.MODEL, END_FIX_MODEL
            , Templates.SEARCH_MODEL, END_FIX_SEARCH_MODEL
            , Templates.REPOSITORY, END_FIX_REPOSITORY
            , Templates.MAPPER, END_FIX_MAPPER
            , Templates.SERVICE, END_FIX_SERVICE
            , Templates.SERVICE_IMPL, END_FIX_SERVICE_IMPL
            , Templates.REST_CONTROLLER, END_FIX_REST_CONTROLLER
    );

    private static final Map<Template, String> mapPackage = Map.of(
            Templates.CONSTANT, PACKAGE_CONSTANT
            , Templates.ENTITY, PACKAGE_ENTITY
            , Templates.MODEL, PACKAGE_MODEL
            , Templates.SEARCH_MODEL, PACKAGE_MODEL
            , Templates.REPOSITORY, PACKAGE_REPOSITORY
            , Templates.MAPPER, PACKAGE_MAPPER
            , Templates.SERVICE, PACKAGE_SERVICE
            , Templates.SERVICE_IMPL, PACKAGE_SERVICE
            , Templates.REST_CONTROLLER, PACKAGE_CONTROLLER
    );

    private static final String FILE_JAVA = ".java";

    private static final String SRC_MAIN_JAVA = "\\src\\main\\java\\";
    static String repositoryPath;
    static String servicePackage;

    public static void setRepositoryPath(String repositoryPath) {
        FileUtil.repositoryPath = repositoryPath;
    }

    public static void setServicePackage(String servicePackage) {
        FileUtil.servicePackage = servicePackage;
    }

    public static Path getFilePath(Template template, ApiGeneratorModel apiGeneratorModel) {
        return Paths.get(getDirectoryPath(template, apiGeneratorModel) + File.separator + apiGeneratorModel.getApiName() + FileUtil.getFileEndFix(template) + FILE_JAVA);
    }

    public static String getDirectoryPath(Template template, ApiGeneratorModel apiGeneratorModel) {
        return getProjectMainPath() + File.separator + convertPackageToPath(apiGeneratorModel.getApiPackage()) + File.separator + FileUtil.getSubPackage(template);
    }

    public static String getProjectMainPath() {
        return repositoryPath + File.separator + SRC_MAIN_JAVA + File.separator + convertPackageToPath(servicePackage);
    }

    public static String convertPackageToPath(String packageName) {
        return packageName.replaceAll("\\.", "\\" + File.separator);
    }

    public static String getFileEndFix(Template template) {
        return mapFileEndFix.get(template);
    }

    public static String getSubPackage(Template template) {
        return mapPackage.get(template);
    }

    public static void createDirectory(Path path) throws IOException {
        if (Files.notExists(path))
            Files.createDirectories(path);
    }

    public static void writeFile(Path path, String content) throws IOException {
        createDirectory(path.getParent());

        if (Files.notExists(path))
            Files.createFile(path);

        Files.writeString(path, content);
    }

    public static void generateFile(Template template, ApiGeneratorModel apiGeneratorModel, Map<String, Object> map) throws IOException {
        FileUtil.writeFile(getFilePath(template, apiGeneratorModel), getContent(template, map));
    }

    public static String getContent(Template template, Map<String, Object> parameterMap) {
        final StringWriter stringWriter = new StringWriter();
        try {
            template.process(parameterMap, stringWriter);
        } catch (TemplateException | IOException e) {
            stringWriter.getBuffer().setLength(0);
        }
        return stringWriter.toString();
    }

}

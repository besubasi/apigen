package tr.subasi.apigen.generator.service;

import freemarker.template.Template;
import tr.subasi.apigen.common.util.FileUtil;
import tr.subasi.apigen.common.util.PathUtil;
import tr.subasi.apigen.config.freemarker.Templates;
import tr.subasi.apigen.generator.model.ApiGeneratorModel;

import jakarta.inject.Singleton;
import tr.subasi.apigen.common.util.TemplateUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import static tr.subasi.apigen.generator.constant.ApiGeneratorConstant.*;

@Singleton
public class ApiGeneratorServiceImpl extends AbstractApiGeneratorService {

    @Override
    void createConstant() throws IOException {
        this.createServiceFile(Templates.CONSTANT, PACKAGE_CONSTANT, END_FIX_CONSTANT);
    }

    @Override
    void createEntity() throws IOException {
        this.createServiceFile(Templates.ENTITY, PACKAGE_ENTITY, END_FIX_ENTITY);
    }

    @Override
    void createModel() throws IOException {
        this.createCommonFile(Templates.MODEL, PACKAGE_MODEL, END_FIX_MODEL);
    }

    @Override
    void createSearchModel() throws IOException {
        this.createCommonFile(Templates.SEARCH_MODEL, PACKAGE_MODEL, END_FIX_SEARCH_MODEL);
    }

    @Override
    void createMapper() throws IOException {
        this.createServiceFile(Templates.MAPPER, PACKAGE_MAPPER, END_FIX_MAPPER);
    }

    @Override
    void createRepository() throws IOException {
        this.createServiceFile(Templates.REPOSITORY, PACKAGE_REPOSITORY, END_FIX_REPOSITORY);
    }

    @Override
    void createService() throws IOException {
        this.createServiceFile(Templates.SERVICE, PACKAGE_SERVICE, END_FIX_SERVICE);
    }

    @Override
    void createServiceImpl() throws IOException {
        this.createServiceFile(Templates.SERVICE_IMPL, PACKAGE_SERVICE, END_FIX_SERVICE_IMPL);
    }

    @Override
    void createRestController() throws IOException {
        this.createServiceFile(Templates.REST_CONTROLLER, PACKAGE_CONTROLLER, END_FIX_REST_CONTROLLER);
    }

    private void createCommonFile(Template template, String subPackage, String fileNameEndFix) throws IOException {
        String directoryPath = getClientPackagePath(apiGeneratorModel, subPackage);
        FileUtil.createDirectory(Paths.get(directoryPath));
        String filePath = directoryPath + File.separator + apiGeneratorModel.getApiName() + fileNameEndFix + FILE_JAVA;
        FileUtil.writeFile(Paths.get(filePath), TemplateUtil.getContent(template, map));
    }

    private void createServiceFile(Template template, String subPackage, String fileNameEndFix) throws IOException {
        String directoryPath = getServicePackagePath(apiGeneratorModel, subPackage);
        FileUtil.createDirectory(Paths.get(directoryPath));
        String filePath = directoryPath + File.separator + apiGeneratorModel.getApiName() + fileNameEndFix + FILE_JAVA;
        FileUtil.writeFile(Paths.get(filePath), TemplateUtil.getContent(template, map));
    }

    public static String getClientPackagePath(ApiGeneratorModel apiGeneratorModel, String subPackage) {
        return PathUtil.getClientPackagePath(apiGeneratorModel.getMicroservice()) + File.separator +
                PathUtil.convertPackageToPath(File.separator + PathUtil.getModuleName(apiGeneratorModel.getModule())
                        + File.separator + apiGeneratorModel.getApiPackage()
                        + File.separator + subPackage);
    }

    public static String getServicePackagePath(ApiGeneratorModel apiGeneratorModel, String subPackage) {
        return PathUtil.getServicePackagePath(apiGeneratorModel.getMicroservice()) + File.separator +
                PathUtil.convertPackageToPath(File.separator + PathUtil.getModuleName(apiGeneratorModel.getModule())
                        + File.separator + apiGeneratorModel.getApiPackage()
                        + File.separator + subPackage);
    }
}

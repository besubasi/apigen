package tr.havelsan.kovan.apigen.generator.apigenerator.service;

import freemarker.template.Template;
import tr.havelsan.kovan.apigen.config.freemarker.Templates;
import tr.havelsan.kovan.apigen.generator.apigenerator.model.FrontEndCopyModel;
import tr.havelsan.kovan.apigen.common.util.ApiGenUtil;

import javax.inject.Singleton;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static tr.havelsan.kovan.apigen.common.constraint.ApiGenConstraint.*;
import static tr.havelsan.kovan.apigen.common.constraint.TemplateConstraint.*;
import static tr.havelsan.kovan.apigen.common.util.ApiGenUtil.createDirectory;
import static tr.havelsan.kovan.apigen.common.util.ApiGenUtil.writeFile;
import static tr.havelsan.kovan.apigen.common.util.PathUtil.*;
import static tr.havelsan.kovan.apigen.common.util.TemplateUtil.getContent;

@Singleton
public class ApiGenServiceImpl extends AbstractApiGenService {

    @Override
    void createConstraint() {
        this.createServiceFile(Templates.CONSTRAINT, PACKAGE_ENTITY, END_FIX_CONSTRAINT);
    }

    @Override
    void createEntity() {
        this.createServiceFile(Templates.ENTITY, PACKAGE_ENTITY, END_FIX_ENTITY);
    }

    @Override
    void createEntityQuery() {
        this.createServiceFile(Templates.ENTITY_QUERY, PACKAGE_ENTITY_QUERY, END_FIX_ENTITY_QUERY);
    }

    @Override
    void createDefEntity() {
        this.createServiceFile(Templates.DEF_ENTITY, PACKAGE_ENTITY, END_FIX_DEF_ENTITY);
    }

    @Override
    void createDefEntityQuery() {
        this.createServiceFile(Templates.DEF_ENTITY_QUERY, PACKAGE_ENTITY_QUERY, END_FIX_DEF_ENTITY_QUERY);
    }

    @Override
    void createModel() {
        this.createCommonFile(Templates.MODEL, PACKAGE_MODEL, END_FIX_MODEL);
    }

    @Override
    void createQueryModel() {
        this.createCommonFile(Templates.QUERY_MODEL, PACKAGE_MODEL, END_FIX_QUERY_MODEL);
    }

    @Override
    void createQueryGenerator() {
        this.createServiceFile(Templates.QUERY_GENERATOR, PACKAGE_GENERATOR, END_FIX_QUERY_GENERATOR);
    }

    @Override
    void createConverter() {
        this.createServiceFile(Templates.CONVERTER, PACKAGE_CONVERTER, END_FIX_CONVERTER);
    }

    @Override
    void createConverterImpl() {
        this.createServiceFile(Templates.CONVERTER_IMPL, PACKAGE_CONVERTER, END_FIX_CONVERTER_IMPL);
    }

    @Override
    void createBasicConverter() {
        this.createServiceFile(Templates.BASIC_CONVERTER, PACKAGE_CONVERTER, END_FIX_BASIC_CONVERTER);
    }

    @Override
    void createBasicConverterImpl() {
        this.createServiceFile(Templates.BASIC_CONVERTER_IMPL, PACKAGE_CONVERTER, END_FIX_BASIC_CONVERTER_IMPL);
    }

    @Override
    void createRepository() {
        this.createServiceFile(Templates.REPOSITORY, PACKAGE_REPOSITORY, END_FIX_REPOSITORY);
    }

    @Override
    void createRules() {
        this.createGroovyFile(Templates.RULES);
    }

    @Override
    void createRuleService() {
        this.createServiceFile(Templates.RULE_SERVICE, PACKAGE_SERVICE, END_FIX_RULE_SERVICE);
    }

    @Override
    void createService() {
        this.createServiceFile(Templates.SERVICE, PACKAGE_SERVICE, END_FIX_SERVICE);
    }

    @Override
    void createServiceImpl() {
        this.createServiceFile(Templates.SERVICE_IMPL, PACKAGE_SERVICE, END_FIX_SERVICE_IMPL);
    }

    @Override
    void createPrivateRestService() {
        this.createCommonFile(Templates.PRIVATE_REST_SERVICE, PACKAGE_SERVICE, END_FIX_PRIVATE_REST_SERVICE);
    }

    @Override
    void createPublicRestService() {
        this.createCommonFile(Templates.PUBLIC_REST_SERVICE, PACKAGE_SERVICE, END_FIX_PUBLIC_REST_SERVICE);
    }

    @Override
    void createRestController() {
        this.createServiceFile(Templates.REST_CONTROLLER, PACKAGE_CONTROLLER, END_FIX_REST_CONTROLLER);
    }


    private void createCommonFile(Template template, String subPackage, String fileNameEndFix) {
        String directoryPath = getCommonPackagePath(apiModel, subPackage);
        createDirectory(Paths.get(directoryPath));
        String filePath = directoryPath + File.separator + apiModel.getApiName() + fileNameEndFix + FILE_JAVA;
        writeFile(Paths.get(filePath), getContent(template, getTemplateParameters(getCommonPackage(apiModel.getMicroservice()))));
    }

    private void createServiceFile(Template template, String subPackage, String fileNameEndFix) {
        String directoryPath = getServicePackagePath(apiModel, subPackage);
        createDirectory(Paths.get(directoryPath));
        String filePath = directoryPath + File.separator + apiModel.getApiName() + fileNameEndFix + FILE_JAVA;
        writeFile(Paths.get(filePath), getContent(template, getTemplateParameters(getServicePackage(apiModel.getMicroservice()))));
    }

    private void createGroovyFile(Template template) {
        String directoryPath = getGroovyPackagePath(apiModel);
        createDirectory(Paths.get(directoryPath));
        String filePath = directoryPath + File.separator + apiModel.getApiName() + END_FIX_RULES + FILE_GROOVY;
        writeFile(Paths.get(filePath), getContent(template, getTemplateParameters(getGroovyPackage(apiModel.getMicroservice()))));
    }

    private Map<String, Object> getTemplateParameters(String packageName) {
        return Map.of(
                MODEL, apiModel,
                CONF, confModel,
                PACKAGE_NAME, packageName);
    }

    @Override
    public void copyFrontEnd(FrontEndCopyModel frontEndCopyModel) throws IOException {
        List<Path> sourcePathList;
        try (Stream<Path> walk = Files.walk(Paths.get(frontEndCopyModel.getSourcePath()))) {
            sourcePathList = walk.collect(Collectors.toList());
        }
        for (Path sourcePath : sourcePathList)
            ApiGenUtil.createTarget(sourcePath, frontEndCopyModel);

    }

    @Override
    public void cloneBasicConverter(FrontEndCopyModel frontEndCopyModel) throws IOException {
        List<Path> pathList;
        try (Stream<Path> walk = Files.walk(Paths.get(frontEndCopyModel.getSourcePath()))
                .filter(path -> path.toString().endsWith("Converter.java") || path.toString().endsWith("ConverterImpl.java"))) {
            pathList = walk.collect(Collectors.toList());
        }

        for (Path path : pathList) {
            Path basicPath = Paths.get(path.toString().replace("Converter", "BasicConverter"));
            ApiGenUtil.writeFile(basicPath, ApiGenUtil.getTargetContent(path, frontEndCopyModel));
        }
    }
}

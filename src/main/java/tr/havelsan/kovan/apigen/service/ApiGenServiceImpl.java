package tr.havelsan.kovan.apigen.service;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import tr.havelsan.kovan.apigen.config.freemarker.Templates;
import tr.havelsan.kovan.apigen.model.FrontEndCopyModel;
import tr.havelsan.kovan.apigen.util.ApiGenUtil;

import javax.inject.Singleton;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static tr.havelsan.kovan.apigen.constraint.ApiGenConstraint.*;
import static tr.havelsan.kovan.apigen.constraint.TemplateConstraint.*;

@Singleton
public class ApiGenServiceImpl extends AbstractApiGenService {

    @ConfigProperty(name = ENV_COMMON_PATH)
    String commonPath;

    @ConfigProperty(name = ENV_SERVICE_PATH)
    String servicePath;

    @ConfigProperty(name = ENV_GROOVY_PATH)
    String groovyPath;

    final StringWriter stringWriter = new StringWriter();

    @Override
    void createConstraint() {
        this.createCommonFile(Templates.CONSTRAINT, PACKAGE_CONSTRAINT, END_FIX_CONSTRAINT);
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
        this.createServiceFile(Templates.BASIC_CONVERTER, PACKAGE_CONVERTER, END_FIX_CONVERTER);
    }

    @Override
    void createBasicConverterImpl() {
        this.createServiceFile(Templates.BASIC_CONVERTER_IMPL, PACKAGE_CONVERTER, END_FIX_CONVERTER_IMPL);
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
        this.createServiceFile(Templates.RULE_SERVICE, PACKAGE_RULE, END_FIX_RULE_SERVICE);
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
        this.writeFile(template, commonPath, subPackage, fileNameEndFix, FILE_JAVA);
    }

    private void createServiceFile(Template template, String subPackage, String fileNameEndFix) {
        this.writeFile(template, servicePath, subPackage, fileNameEndFix, FILE_JAVA);
    }

    private void createGroovyFile(Template template) {
        this.writeFile(template, groovyPath, PACKAGE_RULE, END_FIX_RULES, FILE_GROOVY);
    }

    private void writeFile(Template template, String basePath, String subPackage, String fileNameEndFix, String fileType) {
        var packageName = (groovyPath.equals(basePath) ? apiModel.getGroovyPackage() : commonPath.equals(basePath) ? apiModel.getCommonPackage() : apiModel.getServicePackage())
                + "." + apiModel.getApiPackage() + "." + subPackage;

        String packagePath = packageName.replaceAll("\\.", "\\" + File.separator);
        var filePath = Paths.get(basePath + File.separator + packagePath + File.separator + apiModel.getApiName() + fileNameEndFix + fileType);
        ApiGenUtil.createDirectory(Paths.get(basePath + File.separator + packagePath));
        ApiGenUtil.writeFile(filePath, this.getContentFromTemplate(template, this.prepareTemplateParameters(packagePath, packageName, fileNameEndFix)));

/*
        try {
            Files.createDirectories(Paths.get( basePath + File.separator + packagePath));
            Files.createFile(filePath);
        } catch (IOException e) {
            if (!(e instanceof FileAlreadyExistsException))
                e.printStackTrace();
        }

        Map<String, Object> templateParameters = this.prepareTemplateParameters(packagePath, packageName, fileNameEndFix);
        try {
            Files.write(filePath, this.getContentFromTemplate(template, templateParameters));
        } catch (IOException e) {
            e.printStackTrace();
        }
*/
    }

    private Map<String, Object> prepareTemplateParameters(String packagePath, String packageName, String fileNameEndFix) {
        return Map.of(
                API_MODEL, apiModel,
                COMMON_PATH, commonPath,
                SERVICE_PATH, servicePath,
                GROOVY_PATH, groovyPath,
                PACKAGE_PATH, packagePath,
                PACKAGE_NAME, packageName,
                FILE_NAME_END_FIX, fileNameEndFix);
    }

    private byte[] getContentFromTemplate(Template template, Map<String, Object> parameterMap) {
        stringWriter.getBuffer().setLength(0);
        try {
            template.process(parameterMap, stringWriter);
        } catch (TemplateException | IOException e) {
            stringWriter.getBuffer().setLength(0);
            var defaultTemplate = FILE_GROOVY.equals(parameterMap.get(FILE_TYPE)) ? Templates.DEFAULT_GROOVY : Templates.DEFAULT_JAVA;
            try {
                defaultTemplate.process(parameterMap, stringWriter);
            } catch (TemplateException | IOException e2) {
                e.printStackTrace();
                System.out.println(" ******************************* ");
                e2.printStackTrace();
            }
        }
        return stringWriter.toString().getBytes(StandardCharsets.UTF_8);
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

        for (Path path : pathList){
            Path basicPath = Paths.get(path.toString().replace("Converter", "BasicConverter"));
            ApiGenUtil.writeFile(basicPath, ApiGenUtil.getTargetContent(path, frontEndCopyModel));
        }
    }
}

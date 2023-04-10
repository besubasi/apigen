package tr.havelsan.kovan.apigen.generator.apigenerator.service;

import freemarker.template.Template;
import tr.havelsan.kovan.apigen.common.util.FileUtil;
import tr.havelsan.kovan.apigen.common.util.PathUtil;
import tr.havelsan.kovan.apigen.common.util.TemplateUtil;
import tr.havelsan.kovan.apigen.config.freemarker.Templates;
import tr.havelsan.kovan.apigen.generator.apigenerator.model.ApiGeneratorModel;
import tr.havelsan.kovan.apigen.generator.apigenerator.model.CloneBasicConverterModel;

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

import static tr.havelsan.kovan.apigen.common.constant.TemplateConstant.CONF;
import static tr.havelsan.kovan.apigen.common.constant.TemplateConstant.MODEL;
import static tr.havelsan.kovan.apigen.common.util.PathUtil.*;
import static tr.havelsan.kovan.apigen.common.util.TemplateUtil.getContent;
import static tr.havelsan.kovan.apigen.generator.apigenerator.constant.ApiGeneratorConstant.*;

@Singleton
public class ApiGeneratorServiceImpl extends AbstractApiGeneratorService {

    @Override
    void createConstraint() throws IOException {
        this.createServiceFile(Templates.CONSTANT, PACKAGE_ENTITY, END_FIX_CONSTANT);
    }

    @Override
    void createEntity() throws IOException {
        this.createServiceFile(Templates.ENTITY, PACKAGE_ENTITY, END_FIX_ENTITY);
    }

    @Override
    void createEntityQuery() throws IOException {
        this.createServiceFile(Templates.ENTITY_QUERY, PACKAGE_ENTITY_QUERY, END_FIX_ENTITY_QUERY);
    }

    @Override
    void createDefEntity() throws IOException {
        this.createServiceFile(Templates.DEF_ENTITY, PACKAGE_ENTITY, END_FIX_DEF_ENTITY);
    }

    @Override
    void createDefEntityQuery() throws IOException {
        this.createServiceFile(Templates.DEF_ENTITY_QUERY, PACKAGE_ENTITY_QUERY, END_FIX_DEF_ENTITY_QUERY);
    }

    @Override
    void createModel() throws IOException {
        this.createCommonFile(Templates.MODEL, PACKAGE_MODEL, END_FIX_MODEL);
    }

    @Override
    void createQueryModel() throws IOException {
        this.createCommonFile(Templates.QUERY_MODEL, PACKAGE_MODEL, END_FIX_QUERY_MODEL);
    }

    @Override
    void createQueryGenerator() throws IOException {
        this.createServiceFile(Templates.QUERY_GENERATOR, PACKAGE_GENERATOR, END_FIX_QUERY_GENERATOR);
    }

    @Override
    void createConverter() throws IOException {
        this.createServiceFile(Templates.CONVERTER, PACKAGE_CONVERTER, END_FIX_CONVERTER);
    }

    @Override
    void createConverterImpl() throws IOException {
        this.createServiceFile(Templates.CONVERTER_IMPL, PACKAGE_CONVERTER, END_FIX_CONVERTER_IMPL);
    }

    @Override
    void createBasicConverter() throws IOException {
        //this.createServiceFile(Templates.BASIC_CONVERTER, PACKAGE_CONVERTER, END_FIX_BASIC_CONVERTER);
    }

    @Override
    void createBasicConverterImpl() throws IOException {
        //this.createServiceFile(Templates.BASIC_CONVERTER_IMPL, PACKAGE_CONVERTER, END_FIX_BASIC_CONVERTER_IMPL);
    }

    @Override
    void createRepository() throws IOException {
        this.createServiceFile(Templates.REPOSITORY, PACKAGE_REPOSITORY, END_FIX_REPOSITORY);
    }

    @Override
    void createRules() throws IOException {
        this.createGroovyFile(Templates.RULES);
    }

    @Override
    void createRuleService() throws IOException {
        this.createServiceFile(Templates.RULE_SERVICE, PACKAGE_SERVICE, END_FIX_RULE_SERVICE);
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
    void createPrivateRestService() throws IOException {
        this.createCommonFile(Templates.PRIVATE_REST_SERVICE, PACKAGE_SERVICE, END_FIX_PRIVATE_REST_SERVICE);
    }

    @Override
    void createPublicRestService() throws IOException {
        this.createCommonFile(Templates.PUBLIC_REST_SERVICE, PACKAGE_SERVICE, END_FIX_PUBLIC_REST_SERVICE);
    }

    @Override
    void createRestController() throws IOException {
        this.createServiceFile(Templates.REST_CONTROLLER, PACKAGE_CONTROLLER, END_FIX_REST_CONTROLLER);
    }

    @Override
    void updateYml() throws IOException {
        String apiYml = TemplateUtil.getContent(Templates.YML_UPDATE, Map.of(MODEL, apiGeneratorModel, CONF, confModel));
        Path ymlPath = Paths.get(getYmlPath(apiGeneratorModel.getMicroservice()));
        String ymlContent = Files.readString(ymlPath);
        ymlContent = ymlContent.replace("          " + confModel.getModuleName() + ":", apiYml);
        FileUtil.writeFile(ymlPath, ymlContent);
    }

    private void createCommonFile(Template template, String subPackage, String fileNameEndFix) throws IOException {
        String directoryPath = getCommonPackagePath(apiGeneratorModel, subPackage);
        FileUtil.createDirectory(Paths.get(directoryPath));
        String filePath = directoryPath + File.separator + apiGeneratorModel.getApiName() + fileNameEndFix + FILE_JAVA;
        FileUtil.writeFile(Paths.get(filePath), getContent(template, map));
    }

    private void createServiceFile(Template template, String subPackage, String fileNameEndFix) throws IOException {
        String directoryPath = getServicePackagePath(apiGeneratorModel, subPackage);
        FileUtil.createDirectory(Paths.get(directoryPath));
        String filePath = directoryPath + File.separator + apiGeneratorModel.getApiName() + fileNameEndFix + FILE_JAVA;
        FileUtil.writeFile(Paths.get(filePath), getContent(template, map));
    }

    private void createGroovyFile(Template template) throws IOException {
        String directoryPath = getGroovyPackagePath(apiGeneratorModel);
        FileUtil.createDirectory(Paths.get(directoryPath));
        String filePath = directoryPath + File.separator + apiGeneratorModel.getApiName() + END_FIX_RULES + FILE_GROOVY;
        FileUtil.writeFile(Paths.get(filePath), getContent(template, map));
    }

    @Override
    public void cloneBasicConverter(CloneBasicConverterModel cloneBasicConverter) throws IOException {
        List<Path> pathList;
        try (Stream<Path> walk = Files.walk(Paths.get(cloneBasicConverter.getSourcePath()))
                .filter(path -> path.toString().endsWith("Converter.java") || path.toString().endsWith("ConverterImpl.java"))) {
            pathList = walk.collect(Collectors.toList());
        }

        for (Path path : pathList) {
            Path basicPath = Paths.get(path.toString().replace("Converter", "BasicConverter"));
            FileUtil.writeFile(basicPath, getTargetContent(path, cloneBasicConverter));
        }
    }

    public static String getCommonPackagePath(ApiGeneratorModel apiGeneratorModel, String subPackage) {
        return PathUtil.getCommonPackagePath(apiGeneratorModel.getMicroservice()) + File.separator +
                convertPackageToPath(File.separator + getModuleName(apiGeneratorModel.getModule())
                        + File.separator + apiGeneratorModel.getApiPackage()
                        + File.separator + subPackage);
    }

    public static String getServicePackagePath(ApiGeneratorModel apiGeneratorModel, String subPackage) {
        return PathUtil.getServicePackagePath(apiGeneratorModel.getMicroservice()) + File.separator +
                convertPackageToPath(File.separator + getModuleName(apiGeneratorModel.getModule())
                        + File.separator + apiGeneratorModel.getApiPackage()
                        + File.separator + subPackage);
    }

    public static String getGroovyPackagePath(ApiGeneratorModel apiGeneratorModel) {
        return PathUtil.getGroovyPackagePath(apiGeneratorModel.getMicroservice()) + File.separator +
                convertPackageToPath(getModuleName(apiGeneratorModel.getModule()));
    }

    public static String getTargetContent(Path path, CloneBasicConverterModel cloneBasicConverter) throws IOException {
        var content = Files.readString(path);
        for (Map.Entry<String, String> entry : cloneBasicConverter.getKeyMap().entrySet())
            content = content.replaceAll(entry.getKey(), entry.getValue());

        return content;
    }

}

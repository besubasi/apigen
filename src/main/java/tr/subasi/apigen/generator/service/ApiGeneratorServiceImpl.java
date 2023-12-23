package tr.subasi.apigen.generator.service;

import freemarker.template.Template;
import jakarta.inject.Singleton;
import tr.subasi.apigen.common.util.FileUtil;
import tr.subasi.apigen.common.util.PathUtil;
import tr.subasi.apigen.common.util.TemplateUtil;
import tr.subasi.apigen.config.freemarker.Templates;

import java.io.IOException;
import java.nio.file.Paths;

@Singleton
public class ApiGeneratorServiceImpl extends AbstractApiGeneratorService {

    @Override
    void createConstant() throws IOException {
        if (apiGeneratorModel.isCreateConstant())
            this.createServiceFile(Templates.CONSTANT);
    }

    @Override
    void createEntity() throws IOException {
        if (apiGeneratorModel.isCreateEntity())
            this.createServiceFile(Templates.ENTITY);
    }

    @Override
    void createModel() throws IOException {
        if (apiGeneratorModel.isCreateModel())
            this.createServiceFile(Templates.MODEL);
    }

    @Override
    void createSearchModel() throws IOException {
        if (apiGeneratorModel.isCreateSearchModel())
            this.createServiceFile(Templates.SEARCH_MODEL);
    }

    @Override
    void createMapper() throws IOException {
        if (apiGeneratorModel.isCreateMapper())
            this.createServiceFile(Templates.MAPPER);
    }

    @Override
    void createRepository() throws IOException {
        if (apiGeneratorModel.isCreateRepository())
            this.createServiceFile(Templates.REPOSITORY);
    }

    @Override
    void createService() throws IOException {
        if (apiGeneratorModel.isCreateService())
            this.createServiceFile(Templates.SERVICE);
    }

    @Override
    void createServiceImpl() throws IOException {
        if (apiGeneratorModel.isCreateServiceImpl())
            this.createServiceFile(Templates.SERVICE_IMPL);
    }

    @Override
    void createRestController() throws IOException {
        if (apiGeneratorModel.isCreateRestController())
            this.createServiceFile(Templates.REST_CONTROLLER);
    }

    private void createServiceFile(Template template) throws IOException {
        FileUtil.createDirectory(Paths.get(PathUtil.getApiMainPath(apiGeneratorModel.getApiPackage())));
        FileUtil.writeFile(Paths.get(PathUtil.getApiPath(template, apiGeneratorModel.getApiPackage())), TemplateUtil.getContent(template, map));
    }

}

package tr.subasi.apigen.generator.service;

import jakarta.inject.Singleton;
import tr.subasi.apigen.common.util.FileUtil;
import tr.subasi.apigen.config.freemarker.Templates;

import java.io.IOException;

@Singleton
public class ApiGeneratorServiceImpl extends AbstractApiGeneratorService {

    @Override
    void createConstant() throws IOException {
        if (apiGeneratorModel.isCreateConstant())
            FileUtil.generateFile(Templates.CONSTANT, apiGeneratorModel, map);
    }

    @Override
    void createEntity() throws IOException {
        if (apiGeneratorModel.isCreateEntity())
            FileUtil.generateFile(Templates.ENTITY, apiGeneratorModel, map);
    }

    @Override
    void createModel() throws IOException {
        if (apiGeneratorModel.isCreateModel())
            FileUtil.generateFile(Templates.MODEL, apiGeneratorModel, map);
    }

    @Override
    void createSearchModel() throws IOException {
        if (apiGeneratorModel.isCreateSearchModel())
            FileUtil.generateFile(Templates.SEARCH_MODEL, apiGeneratorModel, map);
    }

    @Override
    void createMapper() throws IOException {
        if (apiGeneratorModel.isCreateMapper())
            FileUtil.generateFile(Templates.MAPPER, apiGeneratorModel, map);
    }

    @Override
    void createRepository() throws IOException {
        if (apiGeneratorModel.isCreateRepository())
            FileUtil.generateFile(Templates.REPOSITORY, apiGeneratorModel, map);
    }

    @Override
    void createService() throws IOException {
        if (apiGeneratorModel.isCreateService())
            FileUtil.generateFile(Templates.SERVICE, apiGeneratorModel, map);
    }

    @Override
    void createServiceImpl() throws IOException {
        if (apiGeneratorModel.isCreateServiceImpl())
            FileUtil.generateFile(Templates.SERVICE_IMPL, apiGeneratorModel, map);
    }

    @Override
    void createRestController() throws IOException {
        if (apiGeneratorModel.isCreateRestController())
            FileUtil.generateFile(Templates.REST_CONTROLLER, apiGeneratorModel, map);
    }

}

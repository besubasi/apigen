package tr.subasi.apigen.generator.service;

import tr.subasi.apigen.common.model.ConfModel;
import tr.subasi.apigen.generator.model.ApiGeneratorModel;
import tr.subasi.apigen.common.constant.TemplateConstant;

import java.io.IOException;
import java.util.Map;

public abstract class AbstractApiGeneratorService implements ApiGeneratorService {

    protected ApiGeneratorModel apiGeneratorModel;
    protected ConfModel confModel;
    protected Map<String, Object> map;

    @Override
    public Boolean generate(ApiGeneratorModel apiGeneratorModel) throws IOException {
        this.apiGeneratorModel = apiGeneratorModel;
        this.confModel = new ConfModel(apiGeneratorModel.getMicroservice(), apiGeneratorModel.getModule());

        this.map = Map.of(TemplateConstant.MODEL, apiGeneratorModel, TemplateConstant.CONF, confModel);

        if (apiGeneratorModel.isCreateConstant()) this.createConstant();
        if (apiGeneratorModel.isCreateEntity()) this.createEntity();
        if (apiGeneratorModel.isCreateModel()) this.createModel();
        if (apiGeneratorModel.isCreateQueryModel()) this.createSearchModel();

        if (apiGeneratorModel.isCreateMapper()) this.createMapper();

        if (apiGeneratorModel.isCreateRepository()) this.createRepository();

        if (apiGeneratorModel.isCreateService()) this.createService();
        if (apiGeneratorModel.isCreateServiceImpl()) this.createServiceImpl();

        if (apiGeneratorModel.isCreateRestController()) this.createRestController();

        return Boolean.TRUE;
    }

    abstract void createConstant() throws IOException;

    abstract void createEntity() throws IOException;

    abstract void createModel() throws IOException;

    abstract void createSearchModel() throws IOException;

    abstract void createMapper() throws IOException;

    abstract void createRepository() throws IOException;

    abstract void createService() throws IOException;

    abstract void createServiceImpl() throws IOException;

    abstract void createRestController() throws IOException;

}

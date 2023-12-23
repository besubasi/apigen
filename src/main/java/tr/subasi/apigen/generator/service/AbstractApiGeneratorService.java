package tr.subasi.apigen.generator.service;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import tr.subasi.apigen.common.constant.TemplateConstant;
import tr.subasi.apigen.common.model.ConfModel;
import tr.subasi.apigen.generator.model.ApiGeneratorModel;

import java.io.IOException;
import java.util.Map;

import static tr.subasi.apigen.generator.constant.ApiGeneratorConstant.ENV_SERVICE_PACKAGE;

public abstract class AbstractApiGeneratorService implements ApiGeneratorService {

    @ConfigProperty(name = ENV_SERVICE_PACKAGE)
    String servicePackage;

    protected ApiGeneratorModel apiGeneratorModel;
    protected ConfModel confModel;
    protected Map<String, Object> map;

    @Override
    public Boolean generate(ApiGeneratorModel apiGeneratorModel) throws IOException {
        this.apiGeneratorModel = apiGeneratorModel;
        this.confModel = new ConfModel(servicePackage);

        this.map = Map.of(TemplateConstant.MODEL, apiGeneratorModel, TemplateConstant.CONF, confModel);

        this.createConstant();
        this.createEntity();
        this.createModel();
        this.createSearchModel();
        this.createMapper();
        this.createRepository();
        this.createService();
        this.createServiceImpl();
        this.createRestController();

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

package tr.havelsan.kovan.apigen.generator.apigenerator.service;

import tr.havelsan.kovan.apigen.common.model.ConfModel;
import tr.havelsan.kovan.apigen.generator.apigenerator.model.ApiGeneratorModel;

import java.io.IOException;
import java.util.Map;

import static tr.havelsan.kovan.apigen.common.constant.TemplateConstant.*;

public abstract class AbstractApiGeneratorService implements ApiGeneratorService {

    protected ApiGeneratorModel apiGeneratorModel;
    protected ConfModel confModel;
    protected Map<String, Object> map;

    @Override
    public Boolean generate(ApiGeneratorModel apiGeneratorModel) throws IOException {
        this.apiGeneratorModel = apiGeneratorModel;
        this.apiGeneratorModel.setApiPackage(apiGeneratorModel.getApiName().toLowerCase());
        this.confModel = new ConfModel(apiGeneratorModel.getMicroservice(), apiGeneratorModel.getModule());

        this.map = Map.of(MODEL, apiGeneratorModel, CONF, confModel);

        this.createConstraint();
        this.createEntity();
        this.createEntityQuery();

        if (Boolean.TRUE.equals(this.apiGeneratorModel.isHasDefEntity())) {
            this.createDefEntity();
            this.createDefEntityQuery();
        }

        this.createModel();
        this.createQueryModel();
        this.createQueryGenerator();

        this.createConverter();
        this.createConverterImpl();
        this.createBasicConverter();
        this.createBasicConverterImpl();

        this.createRepository();

        if (Boolean.TRUE.equals(this.apiGeneratorModel.isHasBusinessRule())) {
            this.createRules();
            this.createRuleService();
        }

        this.createService();
        this.createServiceImpl();

        this.createPrivateRestService();
        this.createPublicRestService();
        this.createRestController();

        this.updateYml();

        return Boolean.TRUE;
    }

    abstract void createConstraint() throws IOException;

    abstract void createEntity() throws IOException;

    abstract void createEntityQuery() throws IOException;

    abstract void createDefEntity() throws IOException;

    abstract void createDefEntityQuery() throws IOException;

    abstract void createModel() throws IOException;

    abstract void createQueryModel() throws IOException;

    abstract void createQueryGenerator() throws IOException;

    abstract void createConverter() throws IOException;

    abstract void createConverterImpl() throws IOException;

    abstract void createBasicConverter() throws IOException;

    abstract void createBasicConverterImpl() throws IOException;

    abstract void createRepository() throws IOException;

    abstract void createRules() throws IOException;

    abstract void createRuleService() throws IOException;

    abstract void createService() throws IOException;

    abstract void createServiceImpl() throws IOException;

    abstract void createPrivateRestService() throws IOException;

    abstract void createPublicRestService() throws IOException;

    abstract void createRestController() throws IOException;

    abstract void updateYml() throws IOException;


}

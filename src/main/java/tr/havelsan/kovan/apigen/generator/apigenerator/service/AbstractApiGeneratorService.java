package tr.havelsan.kovan.apigen.generator.apigenerator.service;

import tr.havelsan.kovan.apigen.common.model.ConfModel;
import tr.havelsan.kovan.apigen.generator.apigenerator.model.ApiGeneratorModel;

import java.io.IOException;
import java.util.Map;

import static tr.havelsan.kovan.apigen.common.constant.TemplateConstant.CONF;
import static tr.havelsan.kovan.apigen.common.constant.TemplateConstant.MODEL;

public abstract class AbstractApiGeneratorService implements ApiGeneratorService {

    protected ApiGeneratorModel apiGeneratorModel;
    protected ConfModel confModel;
    protected Map<String, Object> map;

    @Override
    public Boolean generate(ApiGeneratorModel apiGeneratorModel) throws IOException {
        this.apiGeneratorModel = apiGeneratorModel;
        this.confModel = new ConfModel(apiGeneratorModel.getMicroservice(), apiGeneratorModel.getModule());

        this.map = Map.of(MODEL, apiGeneratorModel, CONF, confModel);

        if (apiGeneratorModel.isCreateConstant())
            this.createConstant();
        if (apiGeneratorModel.isCreateEntity())
            this.createEntity();
        if (apiGeneratorModel.isCreateEntityQuery())
            this.createEntityQuery();

        if (Boolean.TRUE.equals(this.apiGeneratorModel.isHasDefEntity())) {
            if (apiGeneratorModel.isCreateDefEntity())
                this.createDefEntity();
            if (apiGeneratorModel.isCreateDefEntityQuery())
                this.createDefEntityQuery();
        }

        if (apiGeneratorModel.isCreateModel())
            this.createModel();
        if (apiGeneratorModel.isCreateQueryModel())
            this.createQueryModel();
        if (apiGeneratorModel.isCreateQueryGenerator())
            this.createQueryGenerator();

        if (apiGeneratorModel.isCreateConverter())
            this.createConverter();
        if (apiGeneratorModel.isCreateConverterImpl())
            this.createConverterImpl();
        if (apiGeneratorModel.isCreateBasicConverter())
            this.createBasicConverter();
        if (apiGeneratorModel.isCreateBasicConverterImpl())
            this.createBasicConverterImpl();

        if (apiGeneratorModel.isCreateRepository())
            this.createRepository();

        if (Boolean.TRUE.equals(this.apiGeneratorModel.isHasBusinessRule())) {
            if (apiGeneratorModel.isCreateRules())
                this.createRules();
            if (apiGeneratorModel.isCreateRuleService())
                this.createRuleService();
        }

        if (apiGeneratorModel.isCreateService())
            this.createService();
        if (apiGeneratorModel.isCreateServiceImpl())
            this.createServiceImpl();

        if (apiGeneratorModel.isCreatePrivateRestService())
            this.createPrivateRestService();
        if (apiGeneratorModel.isCreatePublicRestService())
            this.createPublicRestService();
        if (apiGeneratorModel.isCreateRestController())
            this.createRestController();

        if (apiGeneratorModel.isUpdateYml())
            this.updateYml();

        return Boolean.TRUE;
    }

    abstract void createConstant() throws IOException;

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

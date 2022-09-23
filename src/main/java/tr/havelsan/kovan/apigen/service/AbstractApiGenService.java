package tr.havelsan.kovan.apigen.service;

import tr.havelsan.kovan.apigen.model.ApiModel;

import java.io.IOException;

public abstract class AbstractApiGenService implements ApiGenService {

    protected ApiModel apiModel;

    @Override
    public void generate(ApiModel apiModel) throws IOException {
        this.apiModel = apiModel;

        this.createConstraint();
        this.createEntity();
        this.createEntityQuery();

        if (Boolean.TRUE.equals(this.apiModel.isHasDefEntity())) {
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

        if (Boolean.TRUE.equals(this.apiModel.isHasBusinessRule())) {
            this.createRules();
            this.createRuleService();
        }

        this.createService();
        this.createServiceImpl();

        this.createPrivateRestService();
        this.createPublicRestService();
        this.createRestController();
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


}

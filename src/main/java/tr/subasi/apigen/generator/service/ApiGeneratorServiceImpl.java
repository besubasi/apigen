package tr.subasi.apigen.generator.service;

import jakarta.inject.Singleton;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import tr.subasi.apigen.common.constant.TemplateConstant;
import tr.subasi.apigen.common.model.ConfModel;
import tr.subasi.apigen.common.util.FileUtil;
import tr.subasi.apigen.config.freemarker.Templates;
import tr.subasi.apigen.generator.model.ApiGeneratorModel;

import java.io.IOException;
import java.util.Map;

import static tr.subasi.apigen.common.constant.ApiConstant.*;
import static tr.subasi.apigen.generator.constant.ApiGeneratorConstant.ENV_SERVICE_PACKAGE;

@Singleton
public class ApiGeneratorServiceImpl implements ApiGeneratorService {

    @ConfigProperty(name = ENV_SERVICE_PACKAGE)
    String servicePackage;

    protected ApiGeneratorModel model;
    protected ConfModel confModel;
    protected Map<String, Object> map;

    @Override
    public Boolean generate(ApiGeneratorModel apiGeneratorModel) throws IOException {
        this.model = apiGeneratorModel;
        this.confModel = this.prepareConfModel();
        this.map = Map.of(TemplateConstant.MODEL, apiGeneratorModel, TemplateConstant.CONF, confModel);

        this.createConstant();
        this.createEntity();
        this.createModel();
        this.createSearchModel();
        this.createConverter();
        this.createRepository();
        this.createRepositoryImpl();
        this.createService();
        this.createServiceImpl();
        this.createRestService();
        this.createRestController();

        return Boolean.TRUE;
    }


    private void createConstant() throws IOException {
        if (model.isCreateConstant())
            FileUtil.generateFile(Templates.CONSTANT, model, map);
    }

    private void createEntity() throws IOException {
        if (model.isCreateEntity())
            FileUtil.generateFile(Templates.ENTITY, model, map);
    }

    private void createModel() throws IOException {
        if (model.isCreateModel())
            FileUtil.generateFile(Templates.MODEL, model, map);
    }

    private void createSearchModel() throws IOException {
        if (model.isCreateSearchModel())
            FileUtil.generateFile(Templates.SEARCH_MODEL, model, map);
    }

    private void createConverter() throws IOException {
        if (model.isCreateConverter())
            FileUtil.generateFile(Templates.CONVERTER, model, map);
    }

    private void createRepository() throws IOException {
        if (model.isCreateRepository())
            FileUtil.generateFile(Templates.REPOSITORY, model, map);
    }

    private void createRepositoryImpl() throws IOException {
        if (model.isCreateRepositoryImpl())
            FileUtil.generateFile(Templates.REPOSITORY_IMPL, model, map);
    }

    private void createService() throws IOException {
        if (model.isCreateService())
            FileUtil.generateFile(Templates.SERVICE, model, map);
    }

    private void createServiceImpl() throws IOException {
        if (model.isCreateServiceImpl())
            FileUtil.generateFile(Templates.SERVICE_IMPL, model, map);
    }

    private void createRestService() throws IOException {
        if (model.isCreateRestService())
            FileUtil.generateFile(Templates.REST_SERVICE, model, map);
    }

    private void createRestController() throws IOException {
        if (model.isCreateRestController())
            FileUtil.generateFile(Templates.REST_CONTROLLER, model, map);
    }

    private ConfModel prepareConfModel() {
        ConfModel confModel = new ConfModel(servicePackage);
        confModel.setImportNotBlank(this.hasPropertyTypeNotNullString());
        confModel.setImportBigDecimal(this.hasPropertyType(PROPERTY_TYPE_BIG_DECIMAL));
        confModel.setImportLocalDate(this.hasPropertyType(PROPERTY_TYPE_LOCAL_DATE));
        confModel.setImportLocalDateTime(this.hasPropertyType(PROPERTY_TYPE_LOCAL_DATE_TIME));

        confModel.setImportBigDecimalSearchModel(this.hasSearchPropertyType(PROPERTY_TYPE_BIG_DECIMAL));
        confModel.setImportLocalDateSearchModel(this.hasSearchPropertyType(PROPERTY_TYPE_LOCAL_DATE));
        confModel.setImportLocalDateTimeSearchModel(this.hasSearchPropertyType(PROPERTY_TYPE_LOCAL_DATE_TIME));

        return confModel;
    }

    private boolean hasPropertyTypeNotNullString() {
        return this.model.getPropertyList().stream().anyMatch(x -> x.getType().equals(PROPERTY_TYPE_STRING) && x.isNotNull());
    }

    private boolean hasPropertyType(String propertyType) {
        return this.model.getPropertyList().stream().anyMatch(x -> x.getType().equals(propertyType));
    }

    private boolean hasSearchPropertyType(String propertyType) {
        return this.model.getPropertyList().stream().anyMatch(x -> x.isUseSearchParameter() && x.getType().equals(propertyType));
    }

}

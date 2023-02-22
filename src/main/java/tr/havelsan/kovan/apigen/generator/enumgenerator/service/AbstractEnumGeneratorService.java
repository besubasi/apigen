package tr.havelsan.kovan.apigen.generator.enumgenerator.service;

import io.quarkus.runtime.util.StringUtil;
import tr.havelsan.kovan.apigen.common.model.ConfModel;
import tr.havelsan.kovan.apigen.generator.enumgenerator.model.EnumGeneratorModel;

import java.io.IOException;
import java.util.Map;

import static tr.havelsan.kovan.apigen.common.constant.TemplateConstant.*;

public abstract class AbstractEnumGeneratorService implements EnumGeneratorService {

    protected EnumGeneratorModel enumGeneratorModel;
    protected ConfModel confModel;
    protected Map<String, Object> map;

    @Override
    public Boolean generateEnum(EnumGeneratorModel enumGeneratorModel) throws IOException {
        this.enumGeneratorModel = enumGeneratorModel;
        this.confModel = new ConfModel(enumGeneratorModel.getMicroservice());

        this.map = Map.of(MODEL, enumGeneratorModel, CONF, confModel);

        if (!StringUtil.isNullOrEmpty(enumGeneratorModel.getCommonSubPackage())) {
            this.createBackendEnum();
            this.createBackendEnumConverter();
        }
        if (!StringUtil.isNullOrEmpty(enumGeneratorModel.getSharedPackage())) {
            this.createFrontendEnum();
            this.createFrontendEnumJsonTr();
            this.createFrontendEnumJsonEn();
            this.updateFrontendPublicApiTs();
        }
        return Boolean.TRUE;
    }

    abstract void createBackendEnum() throws IOException;

    abstract void createBackendEnumConverter() throws IOException;

    abstract void createFrontendEnum() throws IOException;

    abstract void createFrontendEnumJsonTr() throws IOException;

    abstract void createFrontendEnumJsonEn() throws IOException;

    abstract void updateFrontendPublicApiTs() throws IOException;


}

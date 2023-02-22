package tr.havelsan.kovan.apigen.generator.enumgenerator.service;

import io.quarkus.runtime.util.StringUtil;
import tr.havelsan.kovan.apigen.generator.enumgenerator.model.EnumGeneratorModel;

import java.io.IOException;
import java.util.Map;

import static tr.havelsan.kovan.apigen.common.constant.TemplateConstant.MODEL;
import static tr.havelsan.kovan.apigen.common.constant.TemplateConstant.PACKAGE_NAME;

public abstract class AbstractEnumGeneratorService implements EnumGeneratorService {

    protected EnumGeneratorModel enumGeneratorModel;
    protected Map<String, Object> map;

    @Override
    public Boolean generateEnum(EnumGeneratorModel enumGeneratorModel) throws IOException {
        this.enumGeneratorModel = enumGeneratorModel;
        this.map = Map.of(MODEL, enumGeneratorModel, PACKAGE_NAME, enumGeneratorModel.getCommonPackage());

        if (!StringUtil.isNullOrEmpty(enumGeneratorModel.getCommonPackage())) {
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

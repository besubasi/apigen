package tr.havelsan.kovan.apigen.generator.enumgenerator.service;

import io.quarkus.runtime.util.StringUtil;
import tr.havelsan.kovan.apigen.generator.enumgenerator.model.EnumModel;

import java.io.IOException;
import java.util.Map;

import static tr.havelsan.kovan.apigen.common.constraint.TemplateConstraint.MODEL;
import static tr.havelsan.kovan.apigen.common.constraint.TemplateConstraint.PACKAGE_NAME;

public abstract class AbstractEnumGenService implements EnumGenService {

    protected EnumModel enumModel;
    protected Map<String, Object> map;

    @Override
    public void generateEnum(EnumModel enumModel) throws IOException {
        this.enumModel = enumModel;
        this.map = Map.of(MODEL, enumModel, PACKAGE_NAME, enumModel.getCommonPackage());

        if(!StringUtil.isNullOrEmpty(enumModel.getCommonPackage())){
            this.createBackendEnum();
            this.createBackendEnumConverter();
        }
        if(!StringUtil.isNullOrEmpty(enumModel.getSharedPackage())){
            this.createFrontendEnum();
            this.createFrontendEnumJsonTr();
            this.createFrontendEnumJsonEn();
            this.updateFrontendPublicApiTs();
        }
    }

    abstract void createBackendEnum() throws IOException;

    abstract void createBackendEnumConverter() throws IOException;

    abstract void createFrontendEnum() throws IOException;

    abstract void createFrontendEnumJsonTr() throws IOException;
    abstract void createFrontendEnumJsonEn() throws IOException;

    abstract void updateFrontendPublicApiTs() throws IOException;


}

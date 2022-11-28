package tr.havelsan.kovan.apigen.service;

import tr.havelsan.kovan.apigen.model.EnumModel;

import java.io.IOException;

public abstract class AbstractEnumGenService implements EnumGenService {

    protected EnumModel enumModel;

    @Override
    public void generateEnum(EnumModel enumModel) throws IOException {
        this.enumModel = enumModel;

        this.createBackendEnum();
        this.createBackendEnumConverter();
        this.createFrontendEnum();
        this.createFrontendEnumJsonTr();
        this.createFrontendEnumJsonEn();
        this.updateFrontendPublicApiTs();
    }


    abstract void createBackendEnum() throws IOException;

    abstract void createBackendEnumConverter() throws IOException;

    abstract void createFrontendEnum() throws IOException;

    abstract void createFrontendEnumJsonTr() throws IOException;
    abstract void createFrontendEnumJsonEn() throws IOException;

    abstract void updateFrontendPublicApiTs() throws IOException;


}

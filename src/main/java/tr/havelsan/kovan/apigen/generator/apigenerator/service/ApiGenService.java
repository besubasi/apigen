package tr.havelsan.kovan.apigen.generator.apigenerator.service;

import tr.havelsan.kovan.apigen.generator.apigenerator.model.ApiModel;
import tr.havelsan.kovan.apigen.generator.apigenerator.model.FrontEndCopyModel;

import java.io.IOException;


public interface ApiGenService {

    void generate(ApiModel apiModel) throws IOException;

    void copyFrontEnd(FrontEndCopyModel frontEndCopyModel) throws IOException;

    void cloneBasicConverter(FrontEndCopyModel frontEndCopyModel) throws IOException;

}

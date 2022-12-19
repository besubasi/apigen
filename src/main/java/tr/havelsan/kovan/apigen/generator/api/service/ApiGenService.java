package tr.havelsan.kovan.apigen.generator.api.service;

import tr.havelsan.kovan.apigen.generator.api.model.ApiModel;
import tr.havelsan.kovan.apigen.generator.api.model.FrontEndCopyModel;

import java.io.IOException;


public interface ApiGenService {

    void generate(ApiModel apiModel) throws IOException;

    void copyFrontEnd(FrontEndCopyModel frontEndCopyModel) throws IOException;

    void cloneBasicConverter(FrontEndCopyModel frontEndCopyModel) throws IOException;

}

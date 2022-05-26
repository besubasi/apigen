package tr.havelsan.kovan.apigen.service;

import tr.havelsan.kovan.apigen.model.ApiModel;
import tr.havelsan.kovan.apigen.model.FrontEndCopyModel;

import java.io.IOException;


public interface ApiGenService {

    void generate(ApiModel apiModel) throws IOException;


    void copyFrontEnd(FrontEndCopyModel frontEndCopyModel) throws IOException;

}

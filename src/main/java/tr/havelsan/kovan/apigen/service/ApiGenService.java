package tr.havelsan.kovan.apigen.service;

import tr.havelsan.kovan.apigen.model.ApiModel;
import tr.havelsan.kovan.apigen.model.FrontEndCopyModel;
import tr.havelsan.kovan.apigen.model.MenuScriptModel;

import java.io.IOException;


public interface ApiGenService {

    void generate(ApiModel apiModel) throws IOException;


    String generateMenuScript(MenuScriptModel menuScriptModel) throws IOException;


    void copyFrontEnd(FrontEndCopyModel frontEndCopyModel) throws IOException;

    void cloneBasicConverter(FrontEndCopyModel frontEndCopyModel) throws IOException;

}

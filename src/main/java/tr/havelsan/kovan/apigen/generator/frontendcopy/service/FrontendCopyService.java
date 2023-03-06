package tr.havelsan.kovan.apigen.generator.frontendcopy.service;

import tr.havelsan.kovan.apigen.generator.frontendcopy.model.FrontendCopyModel;

import java.io.IOException;

public interface FrontendCopyService {


    Boolean copy(FrontendCopyModel frontendCopyModel) throws IOException;

}

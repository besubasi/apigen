package tr.havelsan.kovan.apigen.generator.frontendcopy.service;

import tr.havelsan.kovan.apigen.generator.frontendcopy.model.FrontEndCopyModel;

import java.io.IOException;

public interface FrontEndCopyService {


    Boolean copy(FrontEndCopyModel frontEndCopyModel) throws IOException;

}

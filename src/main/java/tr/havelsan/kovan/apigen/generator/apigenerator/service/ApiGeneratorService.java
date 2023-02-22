package tr.havelsan.kovan.apigen.generator.apigenerator.service;

import tr.havelsan.kovan.apigen.generator.apigenerator.model.ApiGeneratorModel;
import tr.havelsan.kovan.apigen.generator.apigenerator.model.FrontEndCopyModel;

import java.io.IOException;


public interface ApiGeneratorService {

    Boolean generate(ApiGeneratorModel apiGeneratorModel) throws IOException;

    Boolean copyFrontEnd(FrontEndCopyModel frontEndCopyModel) throws IOException;

    Boolean cloneBasicConverter(FrontEndCopyModel frontEndCopyModel) throws IOException;

}

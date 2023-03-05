package tr.havelsan.kovan.apigen.generator.apigenerator.service;

import tr.havelsan.kovan.apigen.generator.apigenerator.model.ApiGeneratorModel;
import tr.havelsan.kovan.apigen.generator.apigenerator.model.CloneBasicConverterModel;

import java.io.IOException;


public interface ApiGeneratorService {

    Boolean generate(ApiGeneratorModel apiGeneratorModel) throws IOException;

    void cloneBasicConverter(CloneBasicConverterModel cloneBasicConverter) throws IOException;

}

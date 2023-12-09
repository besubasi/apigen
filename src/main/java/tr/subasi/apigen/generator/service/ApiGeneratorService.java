package tr.subasi.apigen.generator.service;

import tr.subasi.apigen.generator.model.ApiGeneratorModel;

import java.io.IOException;


public interface ApiGeneratorService {

    Boolean generate(ApiGeneratorModel apiGeneratorModel) throws IOException;

}

package tr.havelsan.kovan.apigen.generator.enumgenerator.service;

import tr.havelsan.kovan.apigen.generator.enumgenerator.model.EnumGeneratorModel;

import java.io.IOException;

public interface EnumGeneratorService {


    Boolean generateEnum(EnumGeneratorModel enumGeneratorModel) throws IOException;

}

package tr.havelsan.kovan.apigen.generator.enumgenerator.service;

import tr.havelsan.kovan.apigen.generator.enumgenerator.model.EnumModel;

import java.io.IOException;

public interface EnumGenService {


    void generateEnum(EnumModel enumModel) throws IOException;

}

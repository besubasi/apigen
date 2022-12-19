package tr.havelsan.kovan.apigen.generator.enumgen.service;

import tr.havelsan.kovan.apigen.generator.enumgen.model.EnumModel;

import java.io.IOException;

public interface EnumGenService {


    void generateEnum(EnumModel enumModel) throws IOException;

}

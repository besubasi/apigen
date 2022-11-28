package tr.havelsan.kovan.apigen.service;

import tr.havelsan.kovan.apigen.model.EnumModel;

import java.io.IOException;

public interface EnumGenService {


    void generateEnum(EnumModel enumModel) throws IOException;

}

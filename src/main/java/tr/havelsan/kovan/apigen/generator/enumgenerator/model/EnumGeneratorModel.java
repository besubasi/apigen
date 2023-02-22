package tr.havelsan.kovan.apigen.generator.enumgenerator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tr.havelsan.kovan.apigen.common.enums.EnumMicroservice;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnumGeneratorModel {

    private EnumMicroservice microservice;
    private String name, commonSubPackage, sharedPackage;
    private List<EnumKeyModel> keyList;
}

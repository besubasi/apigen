package tr.havelsan.kovan.apigen.generator.apigenerator.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import tr.havelsan.kovan.apigen.common.enums.EnumMicroservice;
import tr.havelsan.kovan.apigen.common.enums.EnumModule;

import java.util.List;

@Data
@NoArgsConstructor
public class ApiGeneratorModel {

    private EnumMicroservice microservice;
    private EnumModule module;
    private String apiPackage, apiName, tableName, extendedName;
    private boolean hasDefEntity, hasBusinessRule, isView;

    private List<PropertyModel> propertyList;
    private List<JoinPropertyModel> joinPropertyList;

}

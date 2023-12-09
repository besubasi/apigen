package tr.subasi.apigen.generator.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import tr.subasi.apigen.common.enums.EnumMicroservice;
import tr.subasi.apigen.common.enums.EnumModule;

import java.util.List;

@Data
@NoArgsConstructor
public class ApiGeneratorModel {

    private EnumMicroservice microservice;
    private EnumModule module;
    private String apiPackage, apiName, tableName, extendedName;

    private boolean createConstant = true;
    private boolean createEntity = true;
    private boolean createModel = true;
    private boolean createQueryModel = true;
    private boolean createMapper = true;
    private boolean createMapperImpl = true;
    private boolean createRepository = true;
    private boolean createService = true;
    private boolean createServiceImpl = true;
    private boolean createRestController = true;

    private List<PropertyModel> propertyList;
}

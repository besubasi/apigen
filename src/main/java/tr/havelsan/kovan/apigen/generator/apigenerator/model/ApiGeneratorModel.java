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

    private boolean createConstant = true;
    private boolean createEntity = true;
    private boolean createEntityQuery = true;
    private boolean createDefEntity = true;
    private boolean createDefEntityQuery = true;
    private boolean createModel = true;
    private boolean createQueryModel = true;
    private boolean createQueryGenerator = true;
    private boolean createConverter = true;
    private boolean createConverterImpl = true;
    private boolean createBasicConverter = true;
    private boolean createBasicConverterImpl = true;
    private boolean createRepository = true;
    private boolean createRules = true;
    private boolean createRuleService = true;
    private boolean createService = true;
    private boolean createServiceImpl = true;
    private boolean createPrivateRestService = true;
    private boolean createPublicRestService = true;
    private boolean createRestController = true;
    private boolean updateYml = true;

    private List<PropertyModel> propertyList;
}

package tr.subasi.apigen.generator.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ApiGeneratorModel {

    private String apiPackage;
    private String apiName;
    private String tableName;

    private boolean createConstant = true;
    private boolean createEntity = true;
    private boolean createModel = true;
    private boolean createSearchModel = true;
    private boolean createConverter = true;
    private boolean createRepository = true;
    private boolean createService = true;
    private boolean createServiceImpl = true;
    private boolean createRestService = true;
    private boolean createRestController = true;

    private List<PropertyModel> propertyList;
}

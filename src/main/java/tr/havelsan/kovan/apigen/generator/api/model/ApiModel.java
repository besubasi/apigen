package tr.havelsan.kovan.apigen.generator.api.model;

import tr.havelsan.kovan.apigen.enums.EnumMicroservice;

import java.util.List;

public class ApiModel {

    private EnumMicroservice microservice;
//    private String microServiceName;// yml da
//    private String servicePackage;
//    private String commonPackage;
//    private String groovyPackage;
    private String apiPackage;

    private String apiName;
    private String schemaName;
    private String tableName;
    private String extendedName;

    private boolean hasDefEntity;
    private boolean hasBusinessRule;
    private boolean isView;

    private List<PropertyModel> propertyList;
    private List<JoinPropertyModel> joinPropertyList;

    public EnumMicroservice getMicroservice() {
        return microservice;
    }

    public void setMicroservice(EnumMicroservice microservice) {
        this.microservice = microservice;
    }

    public String getApiPackage() {
        return apiPackage;
    }

    public void setApiPackage(String apiPackage) {
        this.apiPackage = apiPackage;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getExtendedName() {
        return extendedName;
    }

    public void setExtendedName(String extendedName) {
        this.extendedName = extendedName;
    }

    public boolean isHasDefEntity() {
        return hasDefEntity;
    }

    public void setHasDefEntity(boolean hasDefEntity) {
        this.hasDefEntity = hasDefEntity;
    }

    public boolean isHasBusinessRule() {
        return hasBusinessRule;
    }

    public void setHasBusinessRule(boolean hasBusinessRule) {
        this.hasBusinessRule = hasBusinessRule;
    }

    public boolean isView() {
        return isView;
    }

    public void setView(boolean view) {
        isView = view;
    }

    public List<PropertyModel> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<PropertyModel> propertyList) {
        this.propertyList = propertyList;
    }

    public List<JoinPropertyModel> getJoinPropertyList() {
        return joinPropertyList;
    }

    public void setJoinPropertyList(List<JoinPropertyModel> joinPropertyList) {
        this.joinPropertyList = joinPropertyList;
    }
}

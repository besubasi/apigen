package ${conf.servicePackage}.${conf.moduleName}.${model.apiPackage}.constant;

import ${conf.servicePackage}.common.constant.CommonConstant;

public interface ${model.apiName}Constant extends CommonConstant {

String REQUEST_MAPPING = "/guide/${model.apiName}";
String TABLE_NAME = "${model.tableName}";
String TABLE_SEQ_NAME = TABLE_NAME + SEQUENCE_SUFFIX;

<#list model.propertyList as property>
	String COLUMN_${property.dbName?upper_case} = "${property.dbName?upper_case}";
</#list>
}
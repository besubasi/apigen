package ${conf.servicePackage}.${model.apiPackage}.constant;

import ${conf.servicePackage}.common.constant.CommonConstant;

public interface ${model.apiName}Constant extends CommonConstant {

	String REQUEST_MAPPING = "/${model.apiName?lower_case}";

	String TABLE_NAME = "${model.tableName}";

<#list model.propertyList as property>
	String COLUMN_${property.dbName?upper_case} = "${property.dbName?upper_case}";
</#list>
}
package ${conf.servicePackage}.${conf.moduleName}.${model.apiPackage}.entity;

import static tr.com.havelsan.kovan.logistic.core.constant.GeneralConstants.*;

public interface ${model.apiName}Constant {

	String TABLE_NAME = "${model.tableName}";
	<#if model.hasDefEntity>
	String DEFINITION_TABLE_NAME = TABLE_NAME + DEFINITION_SUFFIX;
	</#if>
	String TABLE_SEQ_NAME = TABLE_NAME + SEQUENCE_SUFFIX;

	<#list model.propertyList as property>
	String COLUMN_${property.dbName?upper_case} = "${property.dbName?upper_case}";
	</#list>

	String MAPPED_BY = "${model.apiName?uncap_first}";

	<#assign FK_DEFINITION_KEY = 'FK_${model.tableName}_L_TO_${model.tableName}'>

	<#if model.hasDefEntity>
	String ${FK_DEFINITION_KEY} = "${FK_DEFINITION_KEY}";
	</#if>

}
package ${packageName};

import static tr.com.havelsan.kovan.logistic.core.constant.GeneralConstants.*;

public final class ${model.apiName}Constraint {

	private ${model.apiName}Constraint() {

	}

	public static final String TABLE_NAME = "${model.tableName}";
	<#if model.hasDefEntity>
	public static final String DEFINITION_TABLE_NAME = TABLE_NAME + DEFINITION_SUFFIX;
	</#if>
	public static final String TABLE_SEQ_NAME = TABLE_NAME + SEQUENCE_SUFFIX;

	<#list model.propertyList as property>
	public static final String COLUMN_${property.dbName?upper_case} = "${property.dbName?upper_case}";
	</#list>

	public static final String MAPPED_BY = "${model.apiName?uncap_first}";

	<#assign FK_DEFINITION_KEY = 'FK_${model.tableName}_L_TO_${model.tableName}'>

	<#if model.hasDefEntity>
	public static final String ${FK_DEFINITION_KEY} = "${FK_DEFINITION_KEY}";
	</#if>

}

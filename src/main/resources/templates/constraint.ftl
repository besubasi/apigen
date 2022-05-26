package ${packageName};

import static ${apiModel.commonPackage}.constant.CommonConstants.*;

public final class ${apiModel.apiName}Constraint {

	private ${apiModel.apiName}Constraint() {

	}

	public static final String TABLE_NAME = "${apiModel.tableName}";
	<#if apiModel.hasDefEntity>
	public static final String DEFINITION_TABLE_NAME = TABLE_NAME + DEFINITION_SUFFIX;
	</#if>
	public static final String TABLE_SEQ_NAME = TABLE_NAME + SEQUENCE_SUFFIX;

	<#list apiModel.propertyList as property>
	public static final String COLUMN_${property.dbName?upper_case} = "${property.dbName?upper_case}";
	</#list>

	public static final String MAPPED_BY = "${apiModel.apiName?uncap_first}";

	<#if apiModel.hasDefEntity>
	public static final String FK_${apiModel.apiName?upper_case} = FOREIGN_KEY_PREFIX + TABLE_NAME;
	</#if>


}

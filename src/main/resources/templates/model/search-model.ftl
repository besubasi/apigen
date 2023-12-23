package ${conf.servicePackage}.${model.apiPackage}.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ${conf.servicePackage}.common.model.BaseSearchModel;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ${model.apiName}SearchModel extends BaseSearchModel {

<#list model.propertyList as property>
    <#if property.useSearchParameter>
    private ${property.type} ${property.name};
    </#if>
</#list>

}
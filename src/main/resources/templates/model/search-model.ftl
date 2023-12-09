package tr.com.subasi.guideassistant.app.${model.apiPackage}.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import tr.com.subasi.guideassistant.common.model.BaseSearchModel;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ${model.apiName}SearchModel extends BaseSearchModel {


<#list model.propertyList as property>
    <#if property.useQueryParameter>
        private ${property.type} ${property.name};
    </#if>
</#list>

}
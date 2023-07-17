package ${conf.commonPackage}.${conf.moduleName}.${model.apiPackage}.model;

import java.math.BigDecimal;
import java.time.LocalDate;

<#if model.extendedName == 'KovanActivable'>
import tr.com.havelsan.kovan.logistic.core.activibility.dto.KovanActivableQueryModel;

public class ${model.apiName}QueryModel extends KovanActivableQueryModel {
<#else >
import tr.com.havelsan.javarch.dto.model.query.HvlQueryModel;

public class ${model.apiName}QueryModel extends HvlQueryModel {
</#if>

<#if model.hasDefEntity>
    private String definition;
</#if>
<#list model.propertyList as property>
    <#if property.useQueryParameter>
    private ${property.type} ${property.name};
    </#if>
</#list>

    /**** Getter & Setter ****/

<#if model.hasDefEntity>
    public String getDefinition() {
    return definition;
    }

    public void setDefinition(String definition) {
    this.definition = definition;
    }
</#if>
<#list model.propertyList as property>
    <#if property.useQueryParameter>
    public ${property.type} get${property.name?cap_first}() {
        return ${property.name};
    }

    public void set${property.name?cap_first}(${property.type} ${property.name}) {
        this.${property.name} = ${property.name};
    }

    </#if>
</#list>
}

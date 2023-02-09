package ${conf.commonPackage}.${conf.moduleName}.${model.apiPackage};

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
<#if model.hasDefEntity>
import java.util.HashMap;
import java.util.Map;
import javax.validation.constraints.Size;
</#if>

import java.time.OffsetDateTime;

<#if model.extendedName == 'KovanActivable'>
import tr.com.havelsan.kovan.logistic.core.activibility.dto.KovanActivableModel;
<#else >
import tr.com.havelsan.javarch.dto.model.HvlModel;
</#if>
<#if model.hasDefEntity>
import tr.com.havelsan.kovan.logistic.core.dto.DefinitionModel;
</#if>

<#if model.hasDefEntity>
import static tr.com.havelsan.kovan.logistic.core.constant.GeneralConstants.*;
</#if>

<#if model.extendedName == 'KovanActivable'>
public class ${model.apiName}Model extends KovanActivableModel {
<#else >
public class ${model.apiName}Model extends HvlModel {
</#if>

<#list model.propertyList as property>
    <#if property.notNull>
    @NotNull
    </#if>
    private ${property.type} ${property.name};
</#list>

<#assign TAG_STRING_DEF_MODEL = '<String, DefinitionModel>'>
<#if model.hasDefEntity>
    @Size(max = DEFINITION_MAX_SIZE)
    private String definition;
    private Map${TAG_STRING_DEF_MODEL} definitionMap = new HashMap<>();
</#if>

    /*** Getter & Setter ***/
<#list model.propertyList as property>

    public ${property.type} get${property.name?cap_first}() {
        return ${property.name};
    }

    public void set${property.name?cap_first}(${property.type} ${property.name}) {
        this.${property.name} = ${property.name};
    }
</#list>

<#if model.hasDefEntity>
    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }


    public Map${TAG_STRING_DEF_MODEL} getDefinitionMap() {
        return definitionMap;
    }

    public void setDefinitionMap(Map${TAG_STRING_DEF_MODEL} definitionMap) {
        this.definitionMap = definitionMap;
    }
</#if>

}

package ${packageName};

import javax.validation.constraints.NotNull;
<#if apiModel.hasDefEntity>
import java.util.HashMap;
import java.util.Map;
import javax.validation.constraints.Size;
</#if>

import java.time.OffsetDateTime;

<#if apiModel.extendedName == 'KovanActivable'>
import tr.com.havelsan.kovan.logistic.core.activibility.dto.KovanActivableModel;
<#else >
import tr.com.havelsan.javarch.dto.model.HvlModel;
</#if>
<#if apiModel.hasDefEntity>
import tr.com.havelsan.kovan.logistic.core.dto.DefinitionModel;
</#if>


<#if apiModel.hasDefEntity>
import static ${apiModel.commonPackage}.constant.CommonConstants.*;
</#if>

public class ${apiModel.apiName}Model extends ${apiModel.extendedName}Model {

<#list apiModel.propertyList as property>
    <#if property.notNull>
    @NotNull
    </#if>
    private ${property.type} ${property.name};
</#list>

<#assign TAG_STRING_DEF_MODEL = '<String, DefinitionModel>'>
<#if apiModel.hasDefEntity>
    @Size(max = DEFINITION_MAX_SIZE)
    private String definition;
    private Map${TAG_STRING_DEF_MODEL} definitionMap = new HashMap<>();
</#if>

    /** Getter & Setter **/
<#list apiModel.propertyList as property>

    public ${property.type} get${property.name?cap_first}() {
        return ${property.name};
    }

    public void set${property.name?cap_first}(${property.type} ${property.name}) {
        this.${property.name} = ${property.name};
    }
</#list>

<#if apiModel.hasDefEntity>
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

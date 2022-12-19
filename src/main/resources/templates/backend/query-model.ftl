package ${packageName};

import java.time.OffsetDateTime;

<#if model.extendedName == 'KovanActivable'>
import tr.com.havelsan.kovan.logistic.core.activibility.dto.KovanActivableQueryModel;
<#else >
import tr.com.havelsan.javarch.dto.model.query.HvlQueryModel;
</#if>

public class ${model.apiName}QueryModel extends ${model.extendedName}QueryModel {

<#list model.propertyList as property>
    private ${property.type} ${property.name};
</#list>
<#if model.hasDefEntity>
    private String definition;
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
</#if>

}

package ${packageName};

import java.time.OffsetDateTime;

<#if apiModel.extendedName == 'KovanActivable'>
import tr.com.havelsan.kovan.logistic.core.activibility.dto.KovanActivableQueryModel;
<#else >
import tr.com.havelsan.javarch.dto.model.query.HvlQueryModel;
</#if>

public class ${apiModel.apiName}QueryModel extends ${apiModel.extendedName}QueryModel {

<#list apiModel.propertyList as property>
    private ${property.type} ${property.name};
</#list>
<#if apiModel.hasDefEntity>
    private String definition;
</#if>

    /*** Getter & Setter ***/
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
</#if>

}

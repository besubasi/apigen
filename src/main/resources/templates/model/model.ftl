package tr.com.subasi.guideassistant.app.${model.apiPackage}.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import tr.com.subasi.guideassistant.common.model.BaseModel;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ${model.apiName}Model extends BaseModel {

<#list model.propertyList as property>
    <#if property.notNull>
        <#if property.type == "String">
            @NotBlank
        <#else>
            @NotNull
        </#if>
    </#if>
    private ${property.type} ${property.name};
</#list>

}
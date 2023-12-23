package ${conf.servicePackage}.${model.apiPackage}.model;

<#if conf.importNotBlank>
import jakarta.validation.constraints.NotBlank;
</#if>
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ${conf.servicePackage}.common.model.BaseModel;

<#if conf.importBigDecimal>
import java.math.BigDecimal;
</#if>
<#if conf.importLocalDate>
import java.time.LocalDate;
</#if>
<#if conf.importLocalDateTime>
import java.time.LocalDateTime;
</#if>

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
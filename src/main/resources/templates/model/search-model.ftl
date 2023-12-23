package ${conf.servicePackage}.${model.apiPackage}.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ${conf.servicePackage}.common.model.BaseSearchModel;

<#if conf.importBigDecimalSearchModel>
import java.math.BigDecimal;
</#if>
<#if conf.importLocalDateSearchModel>
import java.time.LocalDate;
</#if>
<#if conf.importLocalDateTimeSearchModel>
import java.time.LocalDateTime;
</#if>

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
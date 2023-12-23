package ${conf.servicePackage}.${model.apiPackage}.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ${conf.servicePackage}.common.entity.BaseEntity;

import static ${conf.servicePackage}.${model.apiPackage}.constant.${model.apiName}Constant.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(schema = SCHEMA_GUIDE, name = TABLE_NAME)
public class ${model.apiName}Entity extends BaseEntity {

<#list model.propertyList as property>
    <#if property.notNull>
        <#if property.type == "String">
    @NotBlank
        <#else>
    @NotNull
        </#if>
    </#if>
    @Column(name = COLUMN_${property.dbName})
    <#if property.type?starts_with("Enum")  >
    @Convert(converter = ${property.type}Converter.class)
    </#if>
    private ${property.type} ${property.name};

</#list>
}
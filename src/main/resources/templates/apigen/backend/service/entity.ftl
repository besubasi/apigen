package ${conf.servicePackage}.${conf.moduleName}.${model.apiPackage}.entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;
<#if model.hasDefEntity>
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
</#if>
<#if model.extendedName == 'KovanActivable'>
import tr.com.havelsan.javarch.hibernate.annotations.HvlEntitySequence;
import tr.com.havelsan.kovan.logistic.core.activibility.entity.KovanActivableEntity;
<#else >
import tr.com.havelsan.javarch.domain.model.entity.${model.extendedName}Entity;
import tr.com.havelsan.javarch.hibernate.annotations.HvlEntitySequence;
</#if>

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

<#if model.hasDefEntity>
import static tr.com.havelsan.kovan.logistic.core.constant.GeneralConstants.LANGUAGE_LOCALIZED;
</#if>
import static ${conf.servicePackage}.${conf.moduleName}.${model.apiPackage}.constant.${model.apiName}Constant.*;
<#if conf.microServiceName == "production" || conf.microServiceName == "quality" || conf.microServiceName == "sales" || conf.microServiceName == "progress">
import static ${conf.servicePackage}.constant.CommonConstant.SCHEMA_NAME;
<#else >
import static ${conf.servicePackage}.constants.CommonConstants.SCHEMA_NAME;
</#if>

@Entity
@Table(schema = SCHEMA_NAME, name = TABLE_NAME)
@HvlEntitySequence(name = TABLE_SEQ_NAME)
public class ${model.apiName}Entity extends ${model.extendedName}Entity {

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
<#assign TAG_STRING_DEF_ENTITY = '<String, ${model.apiName}DefEntity>'>
<#if model.hasDefEntity>
    @NotEmpty
    @Valid
    @OneToMany(mappedBy = MAPPED_BY, orphanRemoval = true, cascade = CascadeType.ALL)
    @MapKey(name = LANGUAGE_LOCALIZED)
    @Fetch(FetchMode.SUBSELECT)
    @Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
    private Map${TAG_STRING_DEF_ENTITY} definitionMap = new HashMap<>();

</#if>
    /**** Getter & Setter ****/
<#list model.propertyList as property>

    public ${property.type} get${property.name?cap_first}() {
        return ${property.name};
    }

    public void set${property.name?cap_first}(${property.type} ${property.name}) {
        this.${property.name} = ${property.name};
    }
</#list>

<#if model.hasDefEntity>
    public Map${TAG_STRING_DEF_ENTITY} getDefinitionMap() {
        return definitionMap;
    }

    public void setDefinitionMap(Map${TAG_STRING_DEF_ENTITY} definitionMap) {
        this.definitionMap = definitionMap;
    }
</#if>

}

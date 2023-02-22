package ${conf.servicePackage}.${conf.moduleName}.${model.apiPackage}.entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;
<#if model.hasDefEntity>
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
</#if>

<#if model.extendedName == 'KovanActivable'>
import tr.com.havelsan.kovan.logistic.core.activibility.entity.KovanActivableEntity;
<#else >
import tr.com.havelsan.javarch.domain.model.entity.${model.extendedName}Entity;
</#if>


import tr.com.havelsan.javarch.hibernate.annotations.HvlEntitySequence;


import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;

<#if model.hasDefEntity>
import static tr.com.havelsan.kovan.logistic.core.constant.GeneralConstants.LANGUAGE_LOCALIZED;
</#if>
import static ${conf.servicePackage}.${conf.moduleName}.${model.apiPackage}.entity.${model.apiName}Constant.*;
import static ${conf.servicePackage}.constants.CommonConstants.SCHEMA_NAME;

@Entity
@Table(schema = SCHEMA_NAME, name = TABLE_NAME)
@HvlEntitySequence(name = TABLE_SEQ_NAME)
public class ${model.apiName}Entity extends ${model.extendedName}Entity {

<#list model.propertyList as property>
    <#if property.notNull>
    @NotNull
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
    public Map${TAG_STRING_DEF_ENTITY} getDefinitionMap() {
        return definitionMap;
    }

    public void setDefinitionMap(Map${TAG_STRING_DEF_ENTITY} definitionMap) {
        this.definitionMap = definitionMap;
    }
</#if>

}

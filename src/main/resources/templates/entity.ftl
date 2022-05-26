package ${packageName};

import org.hibernate.annotations.CacheConcurrencyStrategy;
<#if apiModel.hasDefEntity>
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
</#if>

<#if apiModel.extendedName == 'KovanActivable'>
import tr.com.havelsan.kovan.logistic.core.activibility.entity.KovanActivableEntity;
<#else >
import tr.com.havelsan.javarch.domain.model.entity.HvlEntity;
</#if>


import tr.com.havelsan.javarch.hibernate.annotations.HvlEntitySequence;


import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;

import static ${apiModel.commonPackage}.constant.CommonConstants.*;
import static ${apiModel.commonPackage}.${apiModel.apiPackage}.constraint.${apiModel.apiName}Constraint.*;

@Entity
@Table(schema = SCHEMA_NAME, name = TABLE_NAME)
@HvlEntitySequence(name = TABLE_SEQ_NAME)
public class ${apiModel.apiName}Entity extends ${apiModel.extendedName}Entity {

<#list apiModel.propertyList as property>
    <#if property.notNull>
    @NotNull
    </#if>
    @Column(name = COLUMN_${property.dbName})
    private ${property.type} ${property.name};

</#list>

<#assign TAG_STRING_DEF_ENTITY = '<String, ${apiModel.apiName}DefEntity>'>
<#if apiModel.hasDefEntity>
    @NotEmpty
    @Valid
    @OneToMany(mappedBy = MAPPED_BY, orphanRemoval = true, cascade = CascadeType.ALL)
    @MapKey(name = LANGUAGE_LOCALIZED)
    @Fetch(FetchMode.SUBSELECT)
    @Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
    private Map${TAG_STRING_DEF_ENTITY} definitionMap = new HashMap<>();
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
    public Map${TAG_STRING_DEF_ENTITY} getDefinitionMap() {
        return definitionMap;
    }

    public void setDefinitionMap(Map${TAG_STRING_DEF_ENTITY} definitionMap) {
        this.definitionMap = definitionMap;
    }
</#if>

}

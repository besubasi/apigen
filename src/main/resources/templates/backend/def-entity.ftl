package ${packageName};

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Cache;

import tr.com.havelsan.javarch.domain.model.entity.HvlLocalizedEntity;

import static org.hibernate.annotations.CacheConcurrencyStrategy.TRANSACTIONAL;
import static ${model.commonPackage}.${model.apiPackage}.constraint.${model.apiName}Constraint.*;
import static ${model.servicePackage}.constants.CommonConstants.*;
import static tr.com.havelsan.kovan.logistic.core.constant.GeneralConstants.DEFINITION_MAX_SIZE;

<#assign FK_DEFINITION_KEY = 'FK_${model.tableName}_L_TO_${model.tableName}'>
@Entity
@Table(schema = SCHEMA_NAME, name = DEFINITION_TABLE_NAME)
@Cache(usage = TRANSACTIONAL)
public class ${model.apiName}DefEntity extends HvlLocalizedEntity {

    @NotBlank
    @Size(max = DEFINITION_MAX_SIZE)
    @Column(name = COLUMN_DEFINITION, nullable = false)
    private String definition;

    @NotNull
    @MapsId(ID)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = COLUMN_ID, foreignKey = @ForeignKey(name = ${FK_DEFINITION_KEY}))
    private ${model.apiName}Entity ${model.apiName?uncap_first};

    /*** Getter & Setter ***/

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public ${model.apiName}Entity get${model.apiName}() {
        return ${model.apiName?uncap_first};
    }

    public void set${model.apiName}(${model.apiName}Entity ${model.apiName?uncap_first}) {
        this.${model.apiName?uncap_first} = ${model.apiName?uncap_first};
    }
}

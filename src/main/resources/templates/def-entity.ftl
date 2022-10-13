package ${packageName};

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Cache;

import tr.com.havelsan.javarch.domain.model.entity.HvlLocalizedEntity;

import static org.hibernate.annotations.CacheConcurrencyStrategy.TRANSACTIONAL;
import static ${apiModel.commonPackage}.${apiModel.apiPackage}.constraint.${apiModel.apiName}Constraint.*;
import static ${apiModel.servicePackage}.constants.CommonConstants.*;
import static tr.com.havelsan.kovan.logistic.core.constant.GeneralConstants.DEFINITION_MAX_SIZE;

<#assign FK_DEFINITION_KEY = 'FK_${apiModel.tableName}_DEF_TO_${apiModel.tableName}'>

@Entity
@Table(schema = SCHEMA_NAME, name = DEFINITION_TABLE_NAME)
@Cache(usage = TRANSACTIONAL)
public class ${apiModel.apiName}DefEntity extends HvlLocalizedEntity {

    @NotBlank
    @Size(max = DEFINITION_MAX_SIZE)
    @Column(name = COLUMN_DEFINITION, nullable = false)
    private String definition;

    @NotNull
    @MapsId(ID)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = COLUMN_ID, foreignKey = @ForeignKey(name = ${FK_DEFINITION_KEY}))
    private ${apiModel.apiName}Entity ${apiModel.apiName?uncap_first};

    /*** Getter & Setter ***/

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public ${apiModel.apiName}Entity get${apiModel.apiName}() {
        return ${apiModel.apiName?uncap_first};
    }

    public void set${apiModel.apiName}(${apiModel.apiName}Entity ${apiModel.apiName?uncap_first}) {
        this.${apiModel.apiName?uncap_first} = ${apiModel.apiName?uncap_first};
    }
}

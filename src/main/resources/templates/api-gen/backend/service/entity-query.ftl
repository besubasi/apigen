package ${conf.servicePackage}.${conf.moduleName}.${model.apiPackage}.entity.query;

import static com.querydsl.core.types.PathMetadataFactory.*;
import ${conf.servicePackage}.${conf.moduleName}.${model.apiPackage}.entity.${model.apiName}Entity;
<#if model.hasDefEntity>
import ${conf.servicePackage}.${conf.moduleName}.${model.apiPackage}.entity.${model.apiName}DefEntity;
</#if>

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

<#assign TAG_ENTITY = "<${model.apiName}Entity>">

/**
* ${model.apiName}EntityQuery is a Querydsl query type for ${model.apiName}Entity
*/
@Generated("com.querydsl.codegen.EntitySerializer")
public class ${model.apiName}EntityQuery extends EntityPathBase${TAG_ENTITY} {

    private static final long serialVersionUID = -1453L;

    public static final ${model.apiName}EntityQuery ${model.apiName?uncap_first}Entity = new ${model.apiName}EntityQuery("${model.apiName?uncap_first}Entity");

    <#if model.extendedName == 'KovanActivable'>
    public final tr.com.havelsan.kovan.logistic.core.activibility.entity.query.KovanActivableEntityQuery _super = new tr.com.havelsan.kovan.logistic.core.activibility.entity.query.KovanActivableEntityQuery(this);

    //inherited
    public final BooleanPath active = _super.active;
    <#elseif model.extendedName?starts_with("Hvl")>
    public final tr.com.havelsan.javarch.domain.model.entity.query.${model.extendedName}EntityQuery _super = new tr.com.havelsan.javarch.domain.model.entity.query.${model.extendedName}EntityQuery(this);
    </#if>

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath< java.time.OffsetDateTime> dateCreated = _super.dateCreated;

    //inherited
    public final DateTimePath< java.time.OffsetDateTime> dateUpdated = _super.dateUpdated;

    <#if model.hasDefEntity>
    public final MapPath< String, ${model.apiName}DefEntity, ${model.apiName}DefEntityQuery> definitionMap = this.< String, ${model.apiName}DefEntity, ${model.apiName}DefEntityQuery>createMap("definitionMap", String.class, ${model.apiName}DefEntity.class, ${model.apiName}DefEntityQuery.class);
    </#if>

    //inherited
    public final NumberPath< Long> id = _super.id;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    //inherited
    public final StringPath uuid = _super.uuid;

    //inherited
    public final NumberPath< Integer> version = _super.version;

    public ${model.apiName}EntityQuery(String variable) {
        super(${model.apiName}Entity.class, forVariable(variable));
    }

    public ${model.apiName}EntityQuery(Path< ? extends ${model.apiName}Entity> path) {
        super(path.getType(), path.getMetadata());
    }

    public ${model.apiName}EntityQuery(PathMetadata metadata) {
        super(${model.apiName}Entity.class, metadata);
    }

}
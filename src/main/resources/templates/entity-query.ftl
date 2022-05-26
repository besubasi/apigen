package ${apiModel.servicePackage}.${apiModel.apiPackage}.entity.query;

import static com.querydsl.core.types.PathMetadataFactory.*;
import ${apiModel.servicePackage}.${apiModel.apiPackage}.entity.${apiModel.apiName}Entity;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

<#assign TAG_ENTITY = "<${apiModel.apiName}Entity>">


/**
* ${apiModel.apiName}EntityQuery is a Querydsl query type for ${apiModel.apiName}Entity
*/
@Generated("com.querydsl.codegen.EntitySerializer")
public class ${apiModel.apiName}EntityQuery extends EntityPathBase${TAG_ENTITY} {

    private static final long serialVersionUID = -1453L;

    public static final ${apiModel.apiName}EntityQuery ${apiModel.apiName?uncap_first}Entity = new ${apiModel.apiName}EntityQuery("${apiModel.apiName?uncap_first}Entity");

    <#if apiModel.extendedName == 'KovanActivable'>
    public final tr.com.havelsan.kovan.logistic.core.activibility.entity.query.KovanActivableEntityQuery _super = new tr.com.havelsan.kovan.logistic.core.activibility.entity.query.KovanActivableEntityQuery(this);

    //inherited
    public final BooleanPath active = _super.active;
    <#elseif apiModel.extendedName?starts_with("Hvl")>
    public final tr.com.havelsan.javarch.domain.model.entity.query.${apiModel.extendedName}EntityQuery _super = new tr.com.havelsan.javarch.domain.model.entity.query.${apiModel.extendedName}EntityQuery(this);
    </#if>

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath< java.time.OffsetDateTime> dateCreated = _super.dateCreated;

    //inherited
    public final DateTimePath< java.time.OffsetDateTime> dateUpdated = _super.dateUpdated;

    <#if apiModel.hasDefEntity>
    public final MapPath< String, ${apiModel.servicePackage}.${apiModel.apiPackage}.entity.${apiModel.apiName}DefEntity, ${apiModel.apiName}DefEntityQuery> definitionMap = this.< String, ${apiModel.servicePackage}.${apiModel.apiPackage}.entity.${apiModel.apiName}DefEntity, ${apiModel.apiName}DefEntityQuery>createMap("definitionMap", String.class, ${apiModel.servicePackage}.${apiModel.apiPackage}.entity.${apiModel.apiName}DefEntity.class, ${apiModel.apiName}DefEntityQuery.class);
    </#if>

    //inherited
    public final NumberPath< Long> id = _super.id;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    //inherited
    public final StringPath uuid = _super.uuid;

    //inherited
    public final NumberPath< Integer> version = _super.version;

    public ${apiModel.apiName}EntityQuery(String variable) {
        super(${apiModel.apiName}Entity.class, forVariable(variable));
    }

    public ${apiModel.apiName}EntityQuery(Path< ? extends ${apiModel.apiName}Entity> path) {
        super(path.getType(), path.getMetadata());
    }

    public ${apiModel.apiName}EntityQuery(PathMetadata metadata) {
        super(${apiModel.apiName}Entity.class, metadata);
    }

}
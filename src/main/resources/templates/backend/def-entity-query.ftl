package ${packageName};

import static com.querydsl.core.types.PathMetadataFactory.*;
import ${model.servicePackage}.${model.apiPackage}.entity.${model.apiName}DefEntity;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

<#assign TAG_ENTITY = "<${model.apiName}DefEntity>">

/**
* ${model.apiName}EntityQuery is a Querydsl query type for ${model.apiName}DefEntity
*/
@Generated("com.querydsl.codegen.EntitySerializer")
public class ${model.apiName}DefEntityQuery extends EntityPathBase${TAG_ENTITY} {

    private static final long serialVersionUID = 14532022L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final ${model.apiName}DefEntityQuery ${model.apiName?uncap_first}DefEntityQuery = new ${model.apiName}DefEntityQuery("${model.apiName?uncap_first}DefEntity");

    public final tr.com.havelsan.javarch.domain.model.entity.query.HvlLocalizedEntityQuery _super;

    public final StringPath definition = createString("definition");

    // inherited
    public final tr.com.havelsan.javarch.domain.model.entity.query.HvlLocalizedIdQuery localizedId;

    public final ${model.apiName}EntityQuery ${model.apiName?uncap_first};

    public ${model.apiName}DefEntityQuery(String variable) {
        this(${model.apiName}DefEntity.class, forVariable(variable), INITS);
    }

    public ${model.apiName}DefEntityQuery(Path< ? extends ${model.apiName}DefEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public ${model.apiName}DefEntityQuery(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public ${model.apiName}DefEntityQuery(PathMetadata metadata, PathInits inits) {
        this(${model.apiName}DefEntity.class, metadata, inits);
    }

    public ${model.apiName}DefEntityQuery(Class< ? extends ${model.apiName}DefEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new tr.com.havelsan.javarch.domain.model.entity.query.HvlLocalizedEntityQuery(type, metadata, inits);
        this.localizedId = _super.localizedId;
        this.${model.apiName?uncap_first} = inits.isInitialized("${model.apiName?uncap_first}") ? new ${model.apiName}EntityQuery(forProperty("${model.apiName?uncap_first} ")) : null;
    }

}


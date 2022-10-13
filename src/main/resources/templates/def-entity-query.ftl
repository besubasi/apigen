package ${packageName};

import static com.querydsl.core.types.PathMetadataFactory.*;
import ${apiModel.servicePackage}.${apiModel.apiPackage}.entity.${apiModel.apiName}DefEntity;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

<#assign TAG_ENTITY = "<${apiModel.apiName}DefEntity>">

/**
* ${apiModel.apiName}EntityQuery is a Querydsl query type for ${apiModel.apiName}DefEntity
*/
@Generated("com.querydsl.codegen.EntitySerializer")
public class ${apiModel.apiName}DefEntityQuery extends EntityPathBase${TAG_ENTITY} {

    private static final long serialVersionUID = 14532022L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final ${apiModel.apiName}DefEntityQuery ${apiModel.apiName?uncap_first}DefEntityQuery = new ${apiModel.apiName}DefEntityQuery("${apiModel.apiName?uncap_first}DefEntity");

    public final tr.com.havelsan.javarch.domain.model.entity.query.HvlLocalizedEntityQuery _super;

    public final StringPath definition = createString("definition");

    // inherited
    public final tr.com.havelsan.javarch.domain.model.entity.query.HvlLocalizedIdQuery localizedId;

    public final ${apiModel.apiName}EntityQuery ${apiModel.apiName?uncap_first};

    public ${apiModel.apiName}DefEntityQuery(String variable) {
        this(${apiModel.apiName}DefEntity.class, forVariable(variable), INITS);
    }

    public ${apiModel.apiName}DefEntityQuery(Path< ? extends ${apiModel.apiName}DefEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public ${apiModel.apiName}DefEntityQuery(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public ${apiModel.apiName}DefEntityQuery(PathMetadata metadata, PathInits inits) {
        this(${apiModel.apiName}DefEntity.class, metadata, inits);
    }

    public ${apiModel.apiName}DefEntityQuery(Class< ? extends ${apiModel.apiName}DefEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new tr.com.havelsan.javarch.domain.model.entity.query.HvlLocalizedEntityQuery(type, metadata, inits);
        this.localizedId = _super.localizedId;
        this.${apiModel.apiName?uncap_first} = inits.isInitialized("${apiModel.apiName?uncap_first}") ? new ${apiModel.apiName}EntityQuery(forProperty("${apiModel.apiName?uncap_first} ")) : null;
    }

}


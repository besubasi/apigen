package ${conf.servicePackage}.${model.modulePackage}.${model.apiPackage};

<#if model.hasDefEntity>
import org.apache.commons.collections4.MapUtils;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import tr.com.havelsan.javarch.data.model.mapper.HvlGenericMapStructMapper;
import tr.com.havelsan.javarch.domain.model.entity.HvlLocalizedId;
import tr.com.havelsan.javarch.session.context.HvlSessionContextHolder;
import ${conf.commonPackage}.${model.modulePackage}.${model.apiPackage}.${model.apiName}Model;

import java.util.Map;
<#else >
import org.mapstruct.Mapper;
import tr.com.havelsan.javarch.data.model.mapper.HvlGenericMapStructMapper;
import ${conf.commonPackage}.${model.apiPackage}.model.${model.apiName}Model;
import ${conf.servicePackage}.${model.apiPackage}.entity.${model.apiName}Entity;
</#if>

<#assign TAG_MODEL_ENTITY = "<${model.apiName}Model, ${model.apiName}Entity>">
@Mapper
public interface ${model.apiName}Converter extends HvlGenericMapStructMapper${TAG_MODEL_ENTITY} {

<#if model.hasDefEntity>
    @AfterMapping
    default void convertDefinitionMapObject(${model.apiName}Model model, @MappingTarget ${model.apiName}Entity entity) {
        for (Map.Entry< String, ${model.apiName}DefEntity> entry : MapUtils.emptyIfNull(entity.getDefinitionMap()).entrySet()) {
            ${model.apiName}DefEntity defEntity = entry.getValue();
            defEntity.set${model.apiName}(entity);
            defEntity.setLocalizedId(new HvlLocalizedId(model.getId(), entry.getKey()));
        }
    }

    @AfterMapping
    default void convertToModelAfterMapping(@MappingTarget ${model.apiName}Model model, ${model.apiName}Entity entity) {
        String activeLang = HvlSessionContextHolder.currentSession().getLocale().getLanguage();
        if(entity.getDefinitionMap()!=null && entity.getDefinitionMap().get(activeLang) != null && entity.getDefinitionMap().get(activeLang).getDefinition() != null){
            model.setDefinition(entity.getDefinitionMap().get(activeLang).getDefinition());
        }
    }
</#if>

}


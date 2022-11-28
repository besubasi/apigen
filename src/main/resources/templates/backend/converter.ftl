package ${packageName};

<#if apiModel.hasDefEntity>
import org.apache.commons.collections4.MapUtils;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import tr.com.havelsan.javarch.data.model.mapper.HvlGenericMapStructMapper;
import tr.com.havelsan.javarch.domain.model.entity.HvlLocalizedId;
import tr.com.havelsan.javarch.session.context.HvlSessionContextHolder;
import ${apiModel.commonPackage}.${apiModel.apiPackage}.model.${apiModel.apiName}Model;
import ${apiModel.servicePackage}.${apiModel.apiPackage}.entity.${apiModel.apiName}DefEntity;
import ${apiModel.servicePackage}.${apiModel.apiPackage}.entity.${apiModel.apiName}Entity;

import java.util.Map;
<#else >
import org.mapstruct.Mapper;
import tr.com.havelsan.javarch.data.model.mapper.HvlGenericMapStructMapper;
import ${apiModel.commonPackage}.${apiModel.apiPackage}.model.${apiModel.apiName}Model;
import ${apiModel.servicePackage}.${apiModel.apiPackage}.entity.${apiModel.apiName}Entity;
</#if>

<#assign TAG_MODEL_ENTITY = "<${apiModel.apiName}Model, ${apiModel.apiName}Entity>">
@Mapper
public interface ${apiModel.apiName}Converter extends HvlGenericMapStructMapper${TAG_MODEL_ENTITY} {

<#if apiModel.hasDefEntity>
    @AfterMapping
    default void convertDefinitionMapObject(${apiModel.apiName}Model model, @MappingTarget ${apiModel.apiName}Entity entity) {
        for (Map.Entry< String, ${apiModel.apiName}DefEntity> entry : MapUtils.emptyIfNull(entity.getDefinitionMap()).entrySet()) {
            ${apiModel.apiName}DefEntity defEntity = entry.getValue();
            defEntity.set${apiModel.apiName}(entity);
            defEntity.setLocalizedId(new HvlLocalizedId(model.getId(), entry.getKey()));
        }
    }

    @AfterMapping
    default void convertToModelAfterMapping(@MappingTarget ${apiModel.apiName}Model model, ${apiModel.apiName}Entity entity) {
        String activeLang = HvlSessionContextHolder.currentSession().getLocale().getLanguage();
        if(entity.getDefinitionMap()!=null && entity.getDefinitionMap().get(activeLang) != null && entity.getDefinitionMap().get(activeLang).getDefinition() != null){
            model.setDefinition(entity.getDefinitionMap().get(activeLang).getDefinition());
        }
    }
</#if>

}


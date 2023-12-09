package tr.com.subasi.guideassistant.app.${model.apiPackage}.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import tr.com.subasi.guideassistant.app.${model.apiPackage}.entity.${model.apiName}Entity;
import tr.com.subasi.guideassistant.app.${model.apiPackage}.model.${model.apiName}Model;
import tr.com.subasi.guideassistant.common.mapper.BaseMapper;


<#assign TAG_MODEL_ENTITY = "<${model.apiName}Model, ${model.apiName}Entity>">
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ${model.apiName}Mapper extends BaseMapper${TAG_MODEL_ENTITY} {

}
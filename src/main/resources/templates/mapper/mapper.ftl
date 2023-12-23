package ${conf.servicePackage}.${model.apiPackage}.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ${conf.servicePackage}.${model.apiPackage}.entity.${model.apiName}Entity;
import ${conf.servicePackage}.${model.apiPackage}.model.${model.apiName}Model;
import ${conf.servicePackage}.common.mapper.BaseMapper;

<#assign TAG_MODEL_AND_ENTITY = "<${model.apiName}Model, ${model.apiName}Entity>">
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ${model.apiName}Mapper extends BaseMapper${TAG_MODEL_AND_ENTITY} {

}
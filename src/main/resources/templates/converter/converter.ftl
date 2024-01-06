package ${conf.servicePackage}.${model.apiPackage}.converter;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ${conf.servicePackage}.${model.apiPackage}.entity.${model.apiName}Entity;
import ${conf.servicePackage}.${model.apiPackage}.model.${model.apiName}Model;
import ${conf.servicePackage}.common.converter.BaseConverter;

<#assign TAG_MODEL_AND_ENTITY = "<${model.apiName}Model, ${model.apiName}Entity>">
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ${model.apiName}Converter extends BaseConverter${TAG_MODEL_AND_ENTITY} {

}
package ${conf.servicePackage}.${model.apiPackage}.service;

import org.springframework.stereotype.Service;
import ${conf.servicePackage}.${model.apiPackage}.converter.${model.apiName}Converter;
import ${conf.servicePackage}.${model.apiPackage}.entity.${model.apiName}Entity;
import ${conf.servicePackage}.${model.apiPackage}.model.${model.apiName}Model;
import ${conf.servicePackage}.${model.apiPackage}.model.${model.apiName}SearchModel;
import ${conf.servicePackage}.${model.apiPackage}.repository.${model.apiName}Repository;
import ${conf.servicePackage}.common.service.BaseServiceImpl;

<#assign TAG_MODEL_SEARCH_MODEL_AND_ENTITY = '<${model.apiName}Model, ${model.apiName}SearchModel, ${model.apiName}Entity, ${model.apiName}Repository, ${model.apiName}Converter>'>
@Service
public class ${model.apiName}ServiceImpl extends BaseServiceImpl${TAG_MODEL_SEARCH_MODEL_AND_ENTITY} implements ${model.apiName}Service {

    public ${model.apiName}ServiceImpl(${model.apiName}Repository repository, ${model.apiName}Converter converter) {
        super(repository, converter);
    }
}
package ${conf.servicePackage}.${model.apiPackage}.service;

import org.springframework.stereotype.Service;
import ${conf.servicePackage}.${model.apiPackage}.entity.${model.apiName}Entity;
import ${conf.servicePackage}.${model.apiPackage}.mapper.${model.apiName}Mapper;
import ${conf.servicePackage}.${model.apiPackage}.model.${model.apiName}Model;
import ${conf.servicePackage}.${model.apiPackage}.model.${model.apiName}SearchModel;
import ${conf.servicePackage}.${model.apiPackage}.repository.${model.apiName}Repository;
import ${conf.servicePackage}.common.service.GenericServiceImpl;

<#assign TAG_MODEL_SEARCH_MODEL_AND_ENTITY = '<${model.apiName}Model, ${model.apiName}SearchModel, ${model.apiName}Entity>'>
@Service
public class ${model.apiName}ServiceImpl extends GenericServiceImpl${TAG_MODEL_SEARCH_MODEL_AND_ENTITY} implements ${model.apiName}Service {

    public ${model.apiName}ServiceImpl(${model.apiName}Repository repository, ${model.apiName}Mapper mapper) {
        super(repository, mapper);
    }
}
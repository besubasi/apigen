package ${conf.servicePackage}.${model.apiPackage}.service;

import ${conf.servicePackage}.${model.apiPackage}.model.${model.apiName}Model;
import ${conf.servicePackage}.${model.apiPackage}.model.${model.apiName}SearchModel;
import ${conf.servicePackage}.common.service.BaseService;

<#assign TAG_MODEL_AND_SEARCH_MODEL = '<${model.apiName}Model, ${model.apiName}SearchModel>'>
public interface ${model.apiName}Service extends BaseService${TAG_MODEL_AND_SEARCH_MODEL} {

}
package ${conf.servicePackage}.${model.apiPackage}.controller;

import org.springframework.validation.annotation.Validated;
import ${conf.servicePackage}.${model.apiPackage}.model.${model.apiName}Model;
import ${conf.servicePackage}.${model.apiPackage}.model.${model.apiName}SearchModel;
import ${conf.servicePackage}.common.controller.BaseRestService;

<#assign TAG_BASE_REST_SERVICE = '<${model.apiName}Model, ${model.apiName}SearchModel>'>
@Validated
public interface ${model.apiName}RestService extends BaseRestService${TAG_BASE_REST_SERVICE} {
}

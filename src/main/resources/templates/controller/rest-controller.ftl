package ${conf.servicePackage}.${model.apiPackage}.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ${conf.servicePackage}.${model.apiPackage}.model.${model.apiName}Model;
import ${conf.servicePackage}.${model.apiPackage}.model.${model.apiName}SearchModel;
import ${conf.servicePackage}.${model.apiPackage}.service.${model.apiName}Service;
import ${conf.servicePackage}.common.controller.BaseRestController;

import static ${conf.servicePackage}.${model.apiPackage}.constant.${model.apiName}Constant.REQUEST_MAPPING;

<#assign TAG_BASE_REST_CONTROLLER = '<${model.apiName}Service, ${model.apiName}Model, ${model.apiName}SearchModel>'>
@RestController
@RequestMapping(REQUEST_MAPPING)
public class ${model.apiName}RestController extends BaseRestController${TAG_BASE_REST_CONTROLLER} implements ${model.apiName}RestService{

    public ${model.apiName}RestController(${model.apiName}Service service) {
        super(service);
    }
}
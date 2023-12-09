package tr.com.subasi.guideassistant.app.${model.apiPackage}.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.subasi.guideassistant.app.${model.apiPackage}.model.${model.apiName}Model;
import tr.com.subasi.guideassistant.app.${model.apiPackage}.model.${model.apiName}SearchModel;
import tr.com.subasi.guideassistant.app.${model.apiPackage}.service.${model.apiName}Service;
import tr.com.subasi.guideassistant.common.controller.GenericRestController;

import static tr.com.subasi.guideassistant.app.${model.apiPackage}.constant.${model.apiName}Constant.REQUEST_MAPPING;

<#assign TAG_MODEL_AND_SEARCH_MODEL = '<${model.apiName}Model, ${model.apiName}SearchModel>'>

@RestController
@RequestMapping(REQUEST_MAPPING)
public class ${model.apiName}RestController extends GenericRestController${TAG_MODEL_AND_SEARCH_MODEL} {

    public CityRestController(${model.apiName}Service service) {
        super(service);
    }
}
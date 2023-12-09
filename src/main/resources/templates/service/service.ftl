package tr.com.subasi.guideassistant.app.${model.apiPackage}.service;

import tr.com.subasi.guideassistant.app.${model.apiPackage}.model.${model.apiName}Model;
import tr.com.subasi.guideassistant.app.${model.apiPackage}.model.${model.apiName}SearchModel;
import tr.com.subasi.guideassistant.common.service.GenericService;

<#assign TAG_MODEL_AND_SEARCH_MODEL = '<${model.apiName}Model, ${model.apiName}SearchModel>'>
public interface CityService extends GenericService${TAG_MODEL_AND_SEARCH_MODEL} {

}
package tr.com.subasi.guideassistant.app.${model.apiPackage}.service;

import org.springframework.stereotype.Service;
import tr.com.subasi.guideassistant.app.${model.apiPackage}.entity.CityEntity;
import tr.com.subasi.guideassistant.app.${model.apiPackage}.mapper.CityMapper;
import tr.com.subasi.guideassistant.app.${model.apiPackage}.model.CityModel;
import tr.com.subasi.guideassistant.app.${model.apiPackage}.model.CitySearchModel;
import tr.com.subasi.guideassistant.app.${model.apiPackage}.repository.CityRepository;
import tr.com.subasi.guideassistant.common.service.GenericServiceImpl;

<#assign TAG_MODEL_SEARCH_MODEL_AND_ENTITY = '<${model.apiName}Model, ${model.apiName}SearchModel, ${model.apiName}Entity>'>
@Service
public class CityServiceImpl extends GenericServiceImpl${TAG_MODEL_SEARCH_MODEL_AND_ENTITY} implements tr.com.subasi.guideassistant.app.${model.apiPackage}.service.${model.apiName}Service {
public ${model.apiPackage}ServiceImpl(${model.apiPackage}Repository repository, ${model.apiPackage}Mapper mapper) {
    super(repository, mapper);
    }
}
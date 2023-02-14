package ${conf.commonPackage}.${conf.moduleName}.${model.apiPackage}.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tr.com.havelsan.javarch.cloud.service.annotation.HvlPrivateFeignRestService;
import tr.com.havelsan.javarch.service.data.HvlResponse;
import ${conf.commonPackage}.${conf.moduleName}.${model.apiPackage}.model.${model.apiName}Model;

import javax.validation.Valid;
<#assign FEIGN_CLIENT_PATH = '{application.module.logistic.${conf.microServiceName}.services.${conf.moduleName}.${model.apiName?uncap_first}.path}'>
<#assign FEIGN_CLIENT_URL = '{application.module.logistic.${conf.microServiceName}.services.${conf.moduleName}.${model.apiName?uncap_first}.url}'>

@HvlPrivateFeignRestService
@FeignClient(name = "${model.apiName}PrivateRestService",
        path = "$${FEIGN_CLIENT_PATH}",
        url = "$${FEIGN_CLIENT_URL}")
public interface ${model.apiName}PrivateRestService {
<#assign TAG_LONG = '<Long>'>
<#assign TAG_MODEL = '<${model.apiName}Model>'>

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    HvlResponse${TAG_LONG} create(@Valid @RequestBody ${model.apiName}Model ${model.apiName?uncap_first}Model);

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    HvlResponse${TAG_MODEL} update(@Valid @RequestBody ${model.apiName}Model ${model.apiName?uncap_first}Model) throws IllegalAccessException;

    @DeleteMapping(path = "/{id}")
    void delete(@PathVariable("id") Long id);
}
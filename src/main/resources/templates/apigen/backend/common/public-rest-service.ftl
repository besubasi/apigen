package ${conf.commonPackage}.${conf.moduleName}.${model.apiPackage}.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import tr.com.havelsan.javarch.cloud.service.annotation.HvlPublicFeignRestService;
import tr.com.havelsan.javarch.data.commons.pageable.HvlPage;
import tr.com.havelsan.javarch.service.data.HvlResponse;
import ${conf.commonPackage}.${conf.moduleName}.${model.apiPackage}.model.${model.apiName}Model;
import ${conf.commonPackage}.${conf.moduleName}.${model.apiPackage}.model.${model.apiName}QueryModel;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.*;
<#assign FEIGN_CLIENT_PATH = '{application.module.logistic.${conf.microServiceName}.services.${conf.moduleName}.${model.apiName?uncap_first}.path}'>
<#assign FEIGN_CLIENT_URL = '{application.module.logistic.${conf.microServiceName}.services.url}'>

@HvlPublicFeignRestService
@FeignClient(name = "${model.apiName}PublicRestService",
            path = "$${FEIGN_CLIENT_PATH}",
            url = "$${FEIGN_CLIENT_URL}")
public interface ${model.apiName}PublicRestService {
<#assign TAG_BOOLEAN = '<Boolean>'>
<#assign TAG_MODEL = '<${model.apiName}Model>'>
<#assign TAG_LIST_MODEL = '<List<${model.apiName}Model>>'>
<#assign TAG_PAGE_MODEL = '<HvlPage<${model.apiName}Model>>'>

    @PostMapping(path = "/query", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    HvlResponse${TAG_LIST_MODEL} queryList(@Valid @RequestBody ${model.apiName}QueryModel queryModel);

    @PostMapping(path = "/page", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    HvlResponse${TAG_PAGE_MODEL} queryPage(@Valid @RequestBody ${model.apiName}QueryModel ${model.apiName?uncap_first}QueryModel);

    @PostMapping(path = "/exists", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    HvlResponse${TAG_BOOLEAN} exists(@Valid @RequestBody ${model.apiName}QueryModel ${model.apiName?uncap_first}QueryModel);

    @GetMapping(path = "/exists/{id}", produces = APPLICATION_JSON_VALUE)
    HvlResponse${TAG_BOOLEAN} existsById(@PathVariable("id") Long id);

    @GetMapping(path = "/exists/uuid/{uuid}", produces = APPLICATION_JSON_VALUE)
    HvlResponse${TAG_BOOLEAN} existsByUuid(@PathVariable("uuid") String uuid);

    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    HvlResponse${TAG_MODEL} getById(@PathVariable("id") Long id);

    @GetMapping(path = "/uuid/{uuid}", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    HvlResponse${TAG_MODEL} getByUuid(@PathVariable("uuid") String uuid);

}

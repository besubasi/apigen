package ${packageName};

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tr.com.havelsan.javarch.cloud.service.annotation.HvlPrivateFeignRestService;
import tr.com.havelsan.javarch.service.data.HvlResponse;
import ${apiModel.commonPackage}.${apiModel.apiPackage}.model.${apiModel.apiName}Model;

import javax.validation.Valid;

@HvlPrivateFeignRestService
@FeignClient(name = "${apiModel.apiName}PrivateRestService",
        path = " *** Please update this and yml file meeeeeeeen *** ",
        url = " *** Please update this and yml file meeeeeeeen *** ")
public interface ${apiModel.apiName}PrivateRestService {

<#assign TAG_LONG = '<Long>'>
<#assign TAG_MODEL = '<${apiModel.apiName}Model>'>

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    HvlResponse${TAG_LONG} create(@Valid @RequestBody ${apiModel.apiName}Model ${apiModel.apiName?uncap_first}Model);

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    HvlResponse${TAG_MODEL} update(@Valid @RequestBody ${apiModel.apiName}Model ${apiModel.apiName?uncap_first}Model) throws IllegalAccessException;

    @DeleteMapping(path = "/{id}")
    void delete(@PathVariable("id") Long id);
}
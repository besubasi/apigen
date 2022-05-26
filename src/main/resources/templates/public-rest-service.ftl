package ${packageName};

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import tr.com.havelsan.javarch.cloud.service.annotation.HvlPublicFeignRestService;
import tr.com.havelsan.javarch.data.commons.pageable.HvlPage;
import tr.com.havelsan.javarch.service.data.HvlResponse;
import ${apiModel.commonPackage}.${apiModel.apiPackage}.model.${apiModel.apiName}Model;
import ${apiModel.commonPackage}.${apiModel.apiPackage}.model.${apiModel.apiName}QueryModel;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.*;

@HvlPublicFeignRestService
@FeignClient(name = "${apiModel.apiName}PublicRestService",
        path = " *** Please update this and yml file meeeeeeeen *** ",
        url = " *** Please update this and yml file meeeeeeeen *** ")
public interface ${apiModel.apiName}PublicRestService {

<#assign TAG_BOOLEAN = '<Boolean>'>
<#assign TAG_MODEL = '<${apiModel.apiName}Model>'>
<#assign TAG_LIST_MODEL = '<List<${apiModel.apiName}Model>>'>
<#assign TAG_PAGE_MODEL = '<HvlPage<${apiModel.apiName}Model>>'>

    @PostMapping(path = "/query", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    HvlResponse${TAG_LIST_MODEL} queryList(@Valid @RequestBody ${apiModel.apiName}QueryModel queryModel);

    @PostMapping(path = "/page", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    HvlResponse${TAG_PAGE_MODEL} queryPage(@Valid @RequestBody ${apiModel.apiName}QueryModel ${apiModel.apiName?uncap_first}QueryModel);

    @PostMapping(path = "/exists", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    HvlResponse${TAG_BOOLEAN} exists(@Valid @RequestBody ${apiModel.apiName}QueryModel ${apiModel.apiName?uncap_first}QueryModel);

    @GetMapping(path = "/exists/{id}", produces = APPLICATION_JSON_VALUE)
    HvlResponse${TAG_BOOLEAN} existsById(@PathVariable("id") Long id);

    @GetMapping(path = "/exists/uuid/{uuid}", produces = APPLICATION_JSON_VALUE)
    HvlResponse${TAG_BOOLEAN} existsByUuid(@PathVariable("uuid") String uuid);

    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    HvlResponse${TAG_MODEL} getById(@PathVariable("id") Long id);

    @GetMapping(path = "/uuid/{uuid}", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    HvlResponse${TAG_MODEL} getByUuid(@PathVariable("uuid") String uuid);

}

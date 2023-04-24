package ${conf.servicePackage}.${conf.moduleName}.${model.apiPackage}.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tr.com.havelsan.javarch.actuator.annotation.HvlActuatorService;
import tr.com.havelsan.javarch.data.commons.pageable.HvlPage;
import tr.com.havelsan.javarch.service.data.HvlResponse;
import ${conf.commonPackage}.${conf.moduleName}.${model.apiPackage}.model.${model.apiName}Model;
import ${conf.commonPackage}.${conf.moduleName}.${model.apiPackage}.model.${model.apiName}QueryModel;
import ${conf.commonPackage}.${conf.moduleName}.${model.apiPackage}.service.${model.apiName}PrivateRestService;
import ${conf.commonPackage}.${conf.moduleName}.${model.apiPackage}.service.${model.apiName}PublicRestService;
import ${conf.servicePackage}.${conf.moduleName}.${model.apiPackage}.service.${model.apiName}Service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

import static tr.com.havelsan.kovan.logistic.${conf.microServiceName}.service.constant.${conf.microServiceName?cap_first}AuthorityConstant.HAS_${model.tableName}_AUTH;

<#assign CONTROLLER_PATH = '{application.module.logistic.${conf.microServiceName}.services.${conf.moduleName}.${model.apiName?uncap_first}.controllerPath}'>

@RestController
@PreAuthorize(HAS_${model.tableName}_AUTH)
@HvlActuatorService(name = "${model.apiName}Service", groupName = "${conf.microServiceName}")
@RequestMapping("$${CONTROLLER_PATH}")
public class ${model.apiName}RestController implements ${model.apiName}PublicRestService, ${model.apiName}PrivateRestService {

    private final ${model.apiName}Service service;

    @Autowired
    public ${model.apiName}RestController(${model.apiName}Service service) {
        this.service = service;
    }
    <#assign TAG_LONG = '<Long>'>
    <#assign TAG_BOOLEAN = '<Boolean>'>
    <#assign TAG_MODEL = '<${model.apiName}Model>'>
    <#assign TAG_LIST_MODEL = '<List<${model.apiName}Model>>'>
    <#assign TAG_PAGE_MODEL = '<HvlPage<${model.apiName}Model>>'>

    @Override
    public HvlResponse${TAG_LONG} create(@NotNull ${model.apiName}Model model) {
        return new HvlResponse<>(service.create(model));
    }

    @Override
    public HvlResponse${TAG_MODEL} update(@NotNull ${model.apiName}Model model) {
        return new HvlResponse<>(service.update(model));
    }

    @Override
    public void delete(@NotNull Long id) {
        service.delete(id);
    }

    @Override
    public HvlResponse${TAG_LIST_MODEL} queryList(@NotNull ${model.apiName}QueryModel queryModel) {
        return new HvlResponse<>(service.queryList(queryModel));
    }

    @Override
    public HvlResponse${TAG_PAGE_MODEL} queryPage(@NotNull ${model.apiName}QueryModel queryModel) {
        return new HvlResponse<>(service.queryPage(queryModel));
    }

    @Override
    public HvlResponse${TAG_BOOLEAN} exists(@NotNull ${model.apiName}QueryModel queryModel) {
        return new HvlResponse<>(service.exists(queryModel));
    }

    @Override
    public HvlResponse${TAG_BOOLEAN} existsById(@NotNull Long id) {
        return new HvlResponse<>(service.existsById(id));
    }

    @Override
    public HvlResponse${TAG_BOOLEAN} existsByUuid(@NotBlank String uuid) {
        return new HvlResponse<>(service.existsByUuid(uuid));
    }

    @Override
    public HvlResponse${TAG_MODEL} getById(@NotNull Long id) {
        return new HvlResponse<>(service.getById(id));
    }

    @Override
    public HvlResponse${TAG_MODEL} getByUuid(@NotBlank String uuid) {
        return new HvlResponse<>(service.getByUuid(uuid));
    }

}

package ${packageName};

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tr.com.havelsan.javarch.actuator.annotation.HvlActuatorService;
import tr.com.havelsan.javarch.data.commons.pageable.HvlPage;
import tr.com.havelsan.javarch.service.data.HvlResponse;
import tr.com.havelsan.kovan.logistic.core.constant.LogisticLocalizedViewer;
import ${apiModel.commonPackage}.${apiModel.apiPackage}.model.${apiModel.apiName}Model;
import ${apiModel.commonPackage}.${apiModel.apiPackage}.model.${apiModel.apiName}QueryModel;
import ${apiModel.commonPackage}.${apiModel.apiPackage}.service.${apiModel.apiName}PrivateRestService;
import ${apiModel.commonPackage}.${apiModel.apiPackage}.service.${apiModel.apiName}PublicRestService;
import ${apiModel.servicePackage}.${apiModel.apiPackage}.service.${apiModel.apiName}Service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@HvlActuatorService(name = "${apiModel.apiName}Service", groupName = "${apiModel.microServiceName}")
@RequestMapping(" *** Please update this and yml file meeeeeeeen *** ")
public class ${apiModel.apiName}RestController implements ${apiModel.apiName}PublicRestService, ${apiModel.apiName}PrivateRestService {

    private final ${apiModel.apiName}Service service;

    @Autowired
    public ${apiModel.apiName}RestController(${apiModel.apiName}Service service) {
        this.service = service;
    }
    <#assign TAG_LONG = '<Long>'>
    <#assign TAG_BOOLEAN = '<Boolean>'>
    <#assign TAG_MODEL = '<${apiModel.apiName}Model>'>
    <#assign TAG_LIST_MODEL = '<List<${apiModel.apiName}Model>>'>
    <#assign TAG_PAGE_MODEL = '<HvlPage<${apiModel.apiName}Model>>'>

    @Override
    @JsonView(value = {LogisticLocalizedViewer.WithLocaleMap.class})
    public HvlResponse${TAG_LONG} create(@NotNull ${apiModel.apiName}Model model) {
        return new HvlResponse<>(service.create(model));
    }

    @Override
    @JsonView(value = {LogisticLocalizedViewer.WithLocaleMap.class})
    public HvlResponse${TAG_MODEL} update(@NotNull ${apiModel.apiName}Model model) {
        return new HvlResponse<>(service.update(model));
    }

    @Override
    public void delete(@NotNull Long id) {
        service.delete(id);
    }

    @Override
    @JsonView(value = {LogisticLocalizedViewer.WithLocaleFields.class})
    public HvlResponse${TAG_LIST_MODEL} queryList(@NotNull ${apiModel.apiName}QueryModel queryModel) {
        return new HvlResponse<>(service.queryList(queryModel));
    }

    @Override
    @JsonView(value = {LogisticLocalizedViewer.WithLocaleFields.class})
    public HvlResponse${TAG_PAGE_MODEL} queryPage(@NotNull ${apiModel.apiName}QueryModel queryModel) {
        return new HvlResponse<>(service.queryPage(queryModel));
    }

    @Override
    @JsonView(value = {LogisticLocalizedViewer.WithLocaleFields.class})
    public HvlResponse${TAG_BOOLEAN} exists(@NotNull ${apiModel.apiName}QueryModel queryModel) {
        return new HvlResponse<>(service.exists(queryModel));
    }

    @Override
    @JsonView(value = {LogisticLocalizedViewer.WithLocaleFields.class})
    public HvlResponse${TAG_BOOLEAN} existsById(@NotNull Long id) {
        return new HvlResponse<>(service.existsById(id));
    }

    @Override
    @JsonView(value = {LogisticLocalizedViewer.WithLocaleFields.class})
    public HvlResponse${TAG_BOOLEAN} existsByUuid(@NotBlank String uuid) {
        return new HvlResponse<>(service.existsByUuid(uuid));
    }

    @Override
    @JsonView(value = {LogisticLocalizedViewer.WithLocaleFields.class})
    public HvlResponse${TAG_MODEL} getById(@NotNull Long id) {
        return new HvlResponse<>(service.getById(id));
    }

    @Override
    @JsonView(value = {LogisticLocalizedViewer.WithLocaleFields.class})
    public HvlResponse${TAG_MODEL} getByUuid(@NotBlank String uuid) {
        return new HvlResponse<>(service.getByUuid(uuid));
    }

}

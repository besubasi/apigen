package ${conf.servicePackage}.${conf.moduleName}.${model.apiPackage}.service;

import org.springframework.validation.annotation.Validated;
import tr.com.havelsan.javarch.data.commons.pageable.HvlPage;
import ${conf.commonPackage}.${conf.moduleName}.${model.apiPackage}.model.${model.apiName}Model;
import ${conf.commonPackage}.${conf.moduleName}.${model.apiPackage}.model.${model.apiName}QueryModel;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
public interface ${model.apiName}Service {

    <#assign TAG_MODEL = '<${model.apiName}Model>'>
    ${model.apiName}Model create(@Valid @NotNull ${model.apiName}Model model);

    ${model.apiName}Model update(@Valid @NotNull ${model.apiName}Model model);

    void delete(@NotNull Long id);

    List${TAG_MODEL} queryList(@NotNull ${model.apiName}QueryModel queryModel);

    HvlPage${TAG_MODEL} queryPage(@NotNull ${model.apiName}QueryModel queryModel);

    boolean exists(@NotNull ${model.apiName}QueryModel queryModel);

    boolean existsById(@NotNull Long id);

    boolean existsByUuid(@NotBlank String uuid);

    ${model.apiName}Model getById(@NotNull Long id);

    ${model.apiName}Model getByUuid(@NotBlank String uuid);

}

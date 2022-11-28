package ${packageName};

import org.springframework.validation.annotation.Validated;
import tr.com.havelsan.javarch.data.commons.pageable.HvlPage;
import ${apiModel.commonPackage}.${apiModel.apiPackage}.model.${apiModel.apiName}Model;
import ${apiModel.commonPackage}.${apiModel.apiPackage}.model.${apiModel.apiName}QueryModel;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
public interface ${apiModel.apiName}Service {

    <#assign TAG_MODEL = '<${apiModel.apiName}Model>'>
    Long create(@Valid @NotNull ${apiModel.apiName}Model model);

    ${apiModel.apiName}Model update(@Valid @NotNull ${apiModel.apiName}Model model);

    void delete(@NotNull Long id);

    List${TAG_MODEL} queryList(@NotNull ${apiModel.apiName}QueryModel queryModel);

    HvlPage${TAG_MODEL} queryPage(@NotNull ${apiModel.apiName}QueryModel queryModel);

    boolean exists(@NotNull ${apiModel.apiName}QueryModel queryModel);

    boolean existsById(@NotNull Long id);

    boolean existsByUuid(@NotBlank String uuid);

    ${apiModel.apiName}Model getById(@NotNull Long id);

    ${apiModel.apiName}Model getByUuid(@NotBlank String uuid);

}

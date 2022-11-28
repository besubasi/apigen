package ${packageName};

import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.havelsan.javarch.data.commons.pageable.HvlPage;
import tr.com.havelsan.javarch.data.jpa.annotation.HvlTransactionalRollbackForCheckedException;
import tr.com.havelsan.kovan.logistic.core.exception.LogisticNotFoundException;
import tr.com.havelsan.kovan.logistic.core.rule.BusinessRuleService;
import tr.com.havelsan.kovan.logistic.core.util.SortUtil;
import ${apiModel.commonPackage}.${apiModel.apiPackage}.model.${apiModel.apiName}Model;
import ${apiModel.commonPackage}.${apiModel.apiPackage}.model.${apiModel.apiName}QueryModel;
import ${apiModel.servicePackage}.${apiModel.apiPackage}.converter.${apiModel.apiName}Converter;
import ${apiModel.servicePackage}.${apiModel.apiPackage}.entity.${apiModel.apiName}Entity;
import ${apiModel.servicePackage}.${apiModel.apiPackage}.entity.query.${apiModel.apiName}EntityQuery;
import ${apiModel.servicePackage}.${apiModel.apiPackage}.generator.${apiModel.apiName}QueryGenerator;
import ${apiModel.servicePackage}.${apiModel.apiPackage}.repository.${apiModel.apiName}Repository;
<#if apiModel.hasBusinessRule>
import ${apiModel.servicePackage}.${apiModel.apiPackage}.rule.${apiModel.apiName}RuleService;
</#if>

import java.util.List;

<#if apiModel.hasBusinessRule>
import static tr.com.havelsan.kovan.logistic.core.constant.GeneralConstants.*;
</#if>


@Service
@HvlTransactionalRollbackForCheckedException
public class ${apiModel.apiName}ServiceImpl implements ${apiModel.apiName}Service {

    private final ${apiModel.apiName}Repository repository;
    private final ${apiModel.apiName}Converter converter;
    private final ${apiModel.apiName}QueryGenerator queryGenerator;
    <#if apiModel.hasBusinessRule>
    private final BusinessRuleService businessRuleService;
    </#if>
    @Autowired
    public ${apiModel.apiName}ServiceImpl(${apiModel.apiName}Repository repository
                                        , ${apiModel.apiName}Converter converter
                                        , ${apiModel.apiName}QueryGenerator queryGenerator
                                    <#if apiModel.hasBusinessRule>
                                        , ${apiModel.apiName}RuleService ${apiModel.apiName?uncap_first}RuleService
                                    </#if>
    ) {
        this.repository = repository;
        this.converter = converter;
        this.queryGenerator = queryGenerator;
        <#if apiModel.hasBusinessRule>
        this.businessRuleService = ${apiModel.apiName?uncap_first}RuleService;
        </#if>
    }

<#assign TAG_MODEL = '<${apiModel.apiName}Model>'>
    public Long create(${apiModel.apiName}Model model) {
        <#if apiModel.hasBusinessRule>
        this.businessRuleService.executeBusinessRule(model, BEFORE_CREATE);
        </#if>
        return repository.save(converter.convertToEntity(model)).getId();
    }

    public ${apiModel.apiName}Model update(${apiModel.apiName}Model model) {
        if (!repository.existsById(model.getId()))
            throw new LogisticNotFoundException(${apiModel.apiName}Entity.class.getSimpleName());

        <#if apiModel.hasBusinessRule>
        this.businessRuleService.executeBusinessRule(model, BEFORE_UPDATE);
        </#if>
        return converter.convertToModel(repository.update(converter.convertToEntity(model)));
    }

    public void delete(Long id) {
        if (!repository.existsById(id))
            throw new LogisticNotFoundException(${apiModel.apiName}Entity.class.getSimpleName());

        <#if apiModel.hasBusinessRule>
        this.businessRuleService.executeBusinessRule(id, BEFORE_DELETE);
        </#if>
        repository.deleteById(id);
    }

    public List${TAG_MODEL} queryList(${apiModel.apiName}QueryModel queryModel) {
        SortUtil.checkUnsorted(queryModel, SortUtil.ASC_CODE);
        Predicate predicate = queryGenerator.generate(queryModel, ${apiModel.apiName}EntityQuery.${apiModel.apiName?uncap_first}Entity);
        return this.converter.convertToModelList(repository.findAll(predicate, queryModel.getPageable().getSort()));
    }

    public HvlPage${TAG_MODEL} queryPage(${apiModel.apiName}QueryModel queryModel) {
        SortUtil.checkUnsorted(queryModel, SortUtil.ASC_CODE);
        Predicate predicate = this.queryGenerator.generate(queryModel, ${apiModel.apiName}EntityQuery.${apiModel.apiName?uncap_first}Entity);
        return converter.convertToHvlPageModel(this.repository.findAll(predicate, queryModel.getPageable()));
    }

    public boolean exists(${apiModel.apiName}QueryModel queryModel) {
        Predicate predicate = queryGenerator.generate(queryModel, ${apiModel.apiName}EntityQuery.${apiModel.apiName?uncap_first}Entity);
        return repository.exists(predicate);
    }

    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    public boolean existsByUuid(String uuid) {
        return repository.existsByUuid(uuid);
    }

    public ${apiModel.apiName}Model getById(Long id) {
        return converter.convertToModel(repository.getById(id));
    }

    public ${apiModel.apiName}Model getByUuid(String uuid) {
        return converter.convertToModel(repository.getByUuid(uuid));
    }
}
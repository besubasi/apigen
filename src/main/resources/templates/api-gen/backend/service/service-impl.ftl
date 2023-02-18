package ${conf.servicePackage}.${conf.moduleName}.${model.apiPackage}.service;

import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.havelsan.javarch.data.commons.pageable.HvlPage;
import tr.com.havelsan.javarch.data.jpa.annotation.HvlTransactionalRollbackForCheckedException;
import tr.com.havelsan.kovan.logistic.core.exception.LogisticNotFoundException;
import tr.com.havelsan.kovan.logistic.core.rule.BusinessRuleService;
import tr.com.havelsan.kovan.logistic.core.util.SortUtil;
import ${conf.commonPackage}.${conf.moduleName}.${model.apiPackage}.model.${model.apiName}Model;
import ${conf.commonPackage}.${conf.moduleName}.${model.apiPackage}.model.${model.apiName}QueryModel;
import ${conf.servicePackage}.${conf.moduleName}.${model.apiPackage}.converter.${model.apiName}Converter;
import ${conf.servicePackage}.${conf.moduleName}.${model.apiPackage}.entity.${model.apiName}Entity;
import ${conf.servicePackage}.${conf.moduleName}.${model.apiPackage}.entity.query.${model.apiName}EntityQuery;
import ${conf.servicePackage}.${conf.moduleName}.${model.apiPackage}.generator.${model.apiName}QueryGenerator;
import ${conf.servicePackage}.${conf.moduleName}.${model.apiPackage}.repository.${model.apiName}Repository;

import java.util.List;

<#if model.hasBusinessRule>
import static tr.com.havelsan.kovan.logistic.core.constant.GeneralConstants.*;
</#if>


@Service
@HvlTransactionalRollbackForCheckedException
public class ${model.apiName}ServiceImpl implements ${model.apiName}Service {

    private final ${model.apiName}Repository repository;
    private final ${model.apiName}Converter converter;
    private final ${model.apiName}QueryGenerator queryGenerator;
    <#if model.hasBusinessRule>
    private final BusinessRuleService businessRuleService;
    </#if>
    @Autowired
    public ${model.apiName}ServiceImpl(${model.apiName}Repository repository
                                        , ${model.apiName}Converter converter
                                        , ${model.apiName}QueryGenerator queryGenerator
                                    <#if model.hasBusinessRule>
                                        , ${model.apiName}RuleService ${model.apiName?uncap_first}RuleService
                                    </#if>
    ) {
        this.repository = repository;
        this.converter = converter;
        this.queryGenerator = queryGenerator;
        <#if model.hasBusinessRule>
        this.businessRuleService = ${model.apiName?uncap_first}RuleService;
        </#if>
    }

<#assign TAG_MODEL = '<${model.apiName}Model>'>
    public Long create(${model.apiName}Model model) {
        <#if model.hasBusinessRule>
        this.businessRuleService.executeBusinessRule(model, BEFORE_CREATE);
        </#if>
        return repository.save(converter.convertToEntity(model)).getId();
    }

    public ${model.apiName}Model update(${model.apiName}Model model) {
        if (!repository.existsById(model.getId()))
            throw new LogisticNotFoundException(${model.apiName}Entity.class.getSimpleName());

        <#if model.hasBusinessRule>
        this.businessRuleService.executeBusinessRule(model, BEFORE_UPDATE);
        </#if>
        return converter.convertToModel(repository.update(converter.convertToEntity(model)));
    }

    public void delete(Long id) {
        if (!repository.existsById(id))
            throw new LogisticNotFoundException(${model.apiName}Entity.class.getSimpleName());

        <#if model.hasBusinessRule>
        this.businessRuleService.executeBusinessRule(id, BEFORE_DELETE);
        </#if>
        repository.deleteById(id);
    }

    public List${TAG_MODEL} queryList(${model.apiName}QueryModel queryModel) {
        SortUtil.checkUnsorted(queryModel, SortUtil.DESC_DATE_CREATED);
        Predicate predicate = queryGenerator.generate(queryModel, ${model.apiName}EntityQuery.${model.apiName?uncap_first}Entity);
        return this.converter.convertToModelList(repository.findAll(predicate, queryModel.getPageable().getSort()));
    }

    public HvlPage${TAG_MODEL} queryPage(${model.apiName}QueryModel queryModel) {
        SortUtil.checkUnsorted(queryModel, SortUtil.DESC_DATE_CREATED);
        Predicate predicate = this.queryGenerator.generate(queryModel, ${model.apiName}EntityQuery.${model.apiName?uncap_first}Entity);
        return converter.convertToHvlPageModel(this.repository.findAll(predicate, queryModel.getPageable()));
    }

    public boolean exists(${model.apiName}QueryModel queryModel) {
        Predicate predicate = queryGenerator.generate(queryModel, ${model.apiName}EntityQuery.${model.apiName?uncap_first}Entity);
        return repository.exists(predicate);
    }

    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    public boolean existsByUuid(String uuid) {
        return repository.existsByUuid(uuid);
    }

    public ${model.apiName}Model getById(Long id) {
        return converter.convertToModel(repository.getById(id));
    }

    public ${model.apiName}Model getByUuid(String uuid) {
        return converter.convertToModel(repository.getByUuid(uuid));
    }
}
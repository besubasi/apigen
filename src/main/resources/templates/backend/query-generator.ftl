package ${packageName};

import com.querydsl.core.BooleanBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
<#if model.isView()>
import tr.com.havelsan.javarch.data.jpa.query.generator.HvlViewQueryGenerator;
<#else >
import tr.com.havelsan.javarch.data.jpa.query.generator.HvlEntityQueryGenerator;
</#if>

import tr.com.havelsan.javarch.session.context.HvlSessionContextHolder;
import ${model.commonPackage}.${model.apiPackage}.model.${model.apiName}QueryModel;
import ${model.servicePackage}.${model.apiPackage}.entity.query.${model.apiName}EntityQuery;

import java.util.Locale;

import static java.util.Optional.ofNullable;

<#assign TAG_QUERY_MODEL_ENTITY_QUERY = "<${model.apiName}QueryModel, ${model.apiName}EntityQuery>">
@Component
<#if model.isView()>
public class ${model.apiName}QueryGenerator extends HvlViewQueryGenerator${TAG_QUERY_MODEL_ENTITY_QUERY} {
<#else >
public class ${model.apiName}QueryGenerator extends HvlEntityQueryGenerator${TAG_QUERY_MODEL_ENTITY_QUERY} {
</#if>

    @Override
    protected void preparePredicate(BooleanBuilder expressionBuilder, ${model.apiName}QueryModel queryModel, ${model.apiName}EntityQuery query) {
        Locale locale = HvlSessionContextHolder.currentSession().getLocale();
        <#if model.extendedName == 'KovanActivable'>
        ofNullable(queryModel.getActive()).ifPresent(param -> expressionBuilder.and(query.active.eq(param)));
        </#if>
        <#if model.hasDefEntity>
        ofNullable(queryModel.getDefinition()).filter(StringUtils::isNotEmpty).ifPresent(param -> expressionBuilder.and(query.definitionMap.get(locale.getLanguage()).definition.containsIgnoreCase(param.toLowerCase(locale))));
        </#if>
        <#list model.propertyList as property>
        ofNullable(queryModel.get${property.name?cap_first}()).ifPresent(param -> expressionBuilder.and(query.${property.name}.eq(param)));
        </#list>

    }
}


package ${packageName};

import com.querydsl.core.BooleanBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
<#if apiModel.isView()>
import tr.com.havelsan.javarch.data.jpa.query.generator.HvlViewQueryGenerator;
<#else >
import tr.com.havelsan.javarch.data.jpa.query.generator.HvlEntityQueryGenerator;
</#if>

import tr.com.havelsan.javarch.session.context.HvlSessionContextHolder;
import ${apiModel.commonPackage}.${apiModel.apiPackage}.model.${apiModel.apiName}QueryModel;
import ${apiModel.servicePackage}.${apiModel.apiPackage}.entity.query.${apiModel.apiName}EntityQuery;

import java.util.Locale;

import static java.util.Optional.ofNullable;

<#assign TAG_QUERY_MODEL_ENTITY_QUERY = "<${apiModel.apiName}QueryModel, ${apiModel.apiName}EntityQuery>">

@Component
<#if apiModel.isView()>
public class ${apiModel.apiName}QueryGenerator extends HvlViewQueryGenerator${TAG_QUERY_MODEL_ENTITY_QUERY} {
<#else >
public class ${apiModel.apiName}QueryGenerator extends HvlEntityQueryGenerator${TAG_QUERY_MODEL_ENTITY_QUERY} {
</#if>

    @Override
    protected void preparePredicate(BooleanBuilder expressionBuilder, ${apiModel.apiName}QueryModel queryModel, ${apiModel.apiName}EntityQuery query) {
        Locale locale = HvlSessionContextHolder.currentSession().getLocale();
        <#if apiModel.extendedName == 'KovanActivable'>
        ofNullable(queryModel.getActive()).ifPresent(param -> expressionBuilder.and(query.active.eq(param)));
        </#if>
        <#if apiModel.hasDefEntity>
        ofNullable(queryModel.getDefinition()).filter(StringUtils::isNotEmpty).ifPresent(param -> expressionBuilder.and(query.definitionMap.get(locale.getLanguage()).definition.containsIgnoreCase(param.toLowerCase(locale))));
        </#if>
        <#list apiModel.propertyList as property>
        ofNullable(queryModel.get${property.name?cap_first}()).ifPresent(param -> expressionBuilder.and(query.${property.name}.eq(param)));
        </#list>

    }
}


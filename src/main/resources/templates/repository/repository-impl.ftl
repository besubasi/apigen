package ${conf.servicePackage}.${model.apiPackage}.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;
import ${conf.servicePackage}.${model.apiPackage}.entity.${model.apiName}Entity;
import ${conf.servicePackage}.${model.apiPackage}.model.${model.apiName}SearchModel;
import ${conf.servicePackage}.common.model.Page;
import ${conf.servicePackage}.common.model.Pageable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Optional.ofNullable;

<#assign TAG_ENTITY_AND_LONG = "<${model.apiName}Entity, Long>">
@Repository
public class ${model.apiName}RepositoryImpl extends SimpleJpaRepository${TAG_ENTITY_AND_LONG} implements ${model.apiName}Repository {

    private final EntityManager entityManager;

    public ${model.apiName}RepositoryImpl(EntityManager entityManager) {
        super(${model.apiName}Entity.class, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public List<${model.apiName}Entity> getList(${model.apiName}SearchModel searchModel) {
        return entityManager.createQuery(this.prepareQuery(searchModel)).getResultList();
    }

    @Override
    public Page<${model.apiName}Entity> getPage(${model.apiName}SearchModel searchModel) {
        long count = this.getCount(searchModel);
        if (count == 0)
            return new Page<>(Collections.emptyList(), searchModel.getPageable());

        Pageable pageable = searchModel.getPageable();
        List<${model.apiName}Entity> resultList = entityManager.createQuery(this.prepareQuery(searchModel))
            .setFirstResult(pageable.getPageNumber() * pageable.getPageSize())
            .setMaxResults(pageable.getPageSize())
            .getResultList();

        int totalPages = pageable.getPageSize() == 0 ? 1 : (int) Math.ceil((double) count / (double) pageable.getPageSize());
        return new Page<>(resultList, count, totalPages, pageable);
    }

    private CriteriaQuery<${model.apiName}Entity> prepareQuery(${model.apiName}SearchModel searchModel) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<${model.apiName}Entity> query = builder.createQuery(${model.apiName}Entity.class);

        Root<${model.apiName}Entity> ${model.apiName?uncap_first}Entity = query.from(${model.apiName}Entity.class);
        query.select(${model.apiName?uncap_first}Entity);
        this.prepareWhereCriteria(searchModel, builder, query, ${model.apiName?uncap_first}Entity);
        return query;
    }

    private long getCount(${model.apiName}SearchModel searchModel) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = builder.createQuery(Long.class);

        Root<${model.apiName}Entity> ${model.apiName?uncap_first}Entity = query.from(${model.apiName}Entity.class);
        query.select(builder.count(${model.apiName?uncap_first}Entity));
        this.prepareWhereCriteria(searchModel, builder, query, ${model.apiName?uncap_first}Entity);
        return entityManager.createQuery(query).getSingleResult();
    }

    private void prepareWhereCriteria(${model.apiName}SearchModel searchModel, CriteriaBuilder builder, CriteriaQuery<?> query, Root<${model.apiName}Entity> ${model.apiName?uncap_first}Entity) {
        List<Predicate> predicates = new ArrayList<>();

        <#list model.propertyList as property>
            <#if property.useSearchParameter>
        ofNullable(searchModel.get${property.name?cap_first}()).ifPresent(param -> predicates.add(builder.and(builder.equal(${model.apiName?uncap_first}Entity.get("${property.name}"), param))));
            </#if>
        </#list>

        if (CollectionUtils.isNotEmpty(predicates))
            query.where(predicates.toArray(new Predicate[0]));
    }

}
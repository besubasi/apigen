package ${conf.servicePackage}.${model.apiPackage}.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ${conf.servicePackage}.${model.apiPackage}.entity.${model.apiName}Entity;
import ${conf.servicePackage}.${model.apiPackage}.model.${model.apiName}SearchModel;
import ${conf.servicePackage}.common.model.Page;

import java.util.List;

<#assign TAG_ENTITY_AND_LONG = "<${model.apiName}Entity, Long>">
@Repository
public interface ${model.apiName}Repository extends JpaRepository${TAG_ENTITY_AND_LONG} {

    List<${model.apiName}Entity> getList(${model.apiName}SearchModel searchModel);

    Page<${model.apiName}Entity> getPage(${model.apiName}SearchModel searchModel);

}
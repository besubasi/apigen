package ${conf.servicePackage}.${model.apiPackage}.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ${conf.servicePackage}.${model.apiPackage}.entity.${model.apiName}Entity;

<#assign TAG_ENTITY_AND_LONG = "<${model.apiName}Entity, Long>">
@Repository
public interface ${model.apiName}Repository extends JpaRepository${TAG_ENTITY_AND_LONG} {

}
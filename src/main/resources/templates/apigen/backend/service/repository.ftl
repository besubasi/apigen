package ${conf.servicePackage}.${conf.moduleName}.${model.apiPackage}.repository;

import org.springframework.stereotype.Repository;
import tr.com.havelsan.javarch.data.jpa.repository.HvlJpaRepository;
import ${conf.servicePackage}.${conf.moduleName}.${model.apiPackage}.entity.${model.apiName}Entity;

<#assign TAG_ENTITY = "<${model.apiName}Entity>">
@Repository
public interface ${model.apiName}Repository extends HvlJpaRepository${TAG_ENTITY} {

}

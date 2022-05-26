package ${packageName};

import org.springframework.stereotype.Repository;
import tr.com.havelsan.javarch.data.jpa.repository.HvlJpaRepository;
import ${apiModel.servicePackage}.${apiModel.apiPackage}.entity.${apiModel.apiName}Entity;

<#assign TAG_ENTITY = "<${apiModel.apiName}Entity>">

@Repository
public interface ${apiModel.apiName}Repository extends HvlJpaRepository${TAG_ENTITY} {

}

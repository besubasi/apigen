package ${conf.servicePackage}.${model.modulePackage}.${model.apiPackage};

import org.springframework.stereotype.Repository;
import tr.com.havelsan.javarch.data.jpa.repository.HvlJpaRepository;

<#assign TAG_ENTITY = "<${model.apiName}Entity>">

@Repository
public interface ${model.apiName}Repository extends HvlJpaRepository${TAG_ENTITY} {

}

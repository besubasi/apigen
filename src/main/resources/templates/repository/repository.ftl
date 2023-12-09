package tr.com.subasi.guideassistant.app.${model.apiPackage}.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.subasi.guideassistant.app.city.entity.CityEntity;

<#assign TAG_ENTITY = "<${model.apiName}Entity, Long>">
@Repository
public interface ${model.apiName}Repository extends JpaRepository${TAG_ENTITY} {

}
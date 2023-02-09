package ${conf.servicePackage}.${conf.moduleName}.${model.apiPackage};

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import tr.com.havelsan.javarch.data.commons.pageable.HvlPage;

import ${conf.commonPackage}.${conf.moduleName}.${model.apiPackage}.${model.apiName}Model;

@Generated(
value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class ${model.apiName}ConverterImpl implements ${model.apiName}Converter {
    <#assign TAG_ENTITY = '<${model.apiName}Entity>'>
    <#assign TAG_MODEL = '<${model.apiName}Model>'>

    @Override
    public ${model.apiName}Model convertToModel(${model.apiName}Entity entity) {
        if (entity == null) {
            return null;
        }
        
        ${model.apiName}Model ${model.apiName?uncap_first}Model = new ${model.apiName}Model();

        ${model.apiName?uncap_first}Model.setId(entity.getId());
        ${model.apiName?uncap_first}Model.setUuid(entity.getUuid());
        ${model.apiName?uncap_first}Model.setVersion(entity.getVersion());
        ${model.apiName?uncap_first}Model.setDateCreated(entity.getDateCreated());
        ${model.apiName?uncap_first}Model.setDateUpdated(entity.getDateUpdated());
        ${model.apiName?uncap_first}Model.setCreatedBy(entity.getCreatedBy());
        ${model.apiName?uncap_first}Model.setUpdatedBy(entity.getUpdatedBy());

        return ${model.apiName?uncap_first}Model;
    }
    
    @Override
    public List${TAG_MODEL} convertToModelList(List${TAG_ENTITY} entities) {
        if (entities == null) {
            return null;
        }
        
        List${TAG_MODEL} list = new ArrayList${TAG_MODEL}(entities.size());
            for (${model.apiName}Entity ${model.apiName?uncap_first}Entity : entities) {
            list.add(convertToModel(${model.apiName?uncap_first}Entity));
        }
        
        return list;
    }
    
    @Override
    public Set${TAG_MODEL} convertToModelSet(Set${TAG_ENTITY} entities) {
        if (entities == null) {
            return null;
        }
        
        Set${TAG_MODEL} set = new HashSet${TAG_MODEL}(Math.max((int) (entities.size() / .75f) + 1, 16));
            for (${model.apiName}Entity ${model.apiName?uncap_first}Entity : entities) {
            set.add(convertToModel(${model.apiName?uncap_first}Entity));
        }
        
        return set;
    }
    
    @Override
    public HvlPage${TAG_MODEL} convertToHvlPageModel(HvlPage${TAG_ENTITY} hvlPageEntity) {
        if (hvlPageEntity == null) {
            return null;
        }
        
        HvlPage${TAG_MODEL} hvlPage = new HvlPage${TAG_MODEL}();
        
        hvlPage.setData(convertToModelList(hvlPageEntity.getData()));
        hvlPage.setTotalElements(hvlPageEntity.getTotalElements());
        hvlPage.setTotalPages(hvlPageEntity.getTotalPages());
        hvlPage.setPageable(hvlPageEntity.getPageable());
        
        return hvlPage;
    }
    
    @Override
    public ${model.apiName}Entity convertToEntity(${model.apiName}Model model) {
        if (model == null) {
            return null;
        }
        
        ${model.apiName}Entity ${model.apiName?uncap_first}Entity = new ${model.apiName}Entity();
        
        ${model.apiName?uncap_first}Entity.setUuid(model.getUuid());
        ${model.apiName?uncap_first}Entity.setVersion(model.getVersion());
        ${model.apiName?uncap_first}Entity.setDateCreated(model.getDateCreated());
        ${model.apiName?uncap_first}Entity.setDateUpdated(model.getDateUpdated());
        ${model.apiName?uncap_first}Entity.setCreatedBy(model.getCreatedBy());
        ${model.apiName?uncap_first}Entity.setUpdatedBy(model.getUpdatedBy());
        ${model.apiName?uncap_first}Entity.setId(model.getId());

        return ${model.apiName?uncap_first}Entity;
    }
    
    @Override
    public List${TAG_ENTITY} convertToEntityList(List${TAG_MODEL} model) {
        if (model == null) {
            return null;
        }
        
        List${TAG_ENTITY} list = new ArrayList${TAG_ENTITY}(model.size());
        for (${model.apiName}Model ${model.apiName?uncap_first}Model : model) {
            list.add(convertToEntity(${model.apiName?uncap_first}Model));
        }
        
        return list;
    }
    
    @Override
    public Set${TAG_ENTITY} convertToEntitySet(Set${TAG_MODEL} model) {
        if (model == null) {
            return null;
        }
        
        Set${TAG_ENTITY} set = new HashSet${TAG_ENTITY}(Math.max((int) (model.size() / .75f) + 1, 16));
        for (${model.apiName}Model ${model.apiName?uncap_first}Model : model) {
            set.add(convertToEntity(${model.apiName?uncap_first}Model));
        }
        
        return set;
    }


}

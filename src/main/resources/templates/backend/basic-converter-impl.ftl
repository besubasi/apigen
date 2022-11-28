package ${packageName};

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import tr.com.havelsan.javarch.data.commons.pageable.HvlPage;

import ${apiModel.commonPackage}.${apiModel.apiPackage}.model.${apiModel.apiName}Model;
import ${apiModel.servicePackage}.${apiModel.apiPackage}.entity.${apiModel.apiName}Entity;

@Generated(
value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class ${apiModel.apiName}BasicConverterImpl implements ${apiModel.apiName}BasicConverter {
    <#assign TAG_ENTITY = '<${apiModel.apiName}Entity>'>
    <#assign TAG_MODEL = '<${apiModel.apiName}Model>'>

    @Override
    public ${apiModel.apiName}Model convertToModel(${apiModel.apiName}Entity entity) {
        if (entity == null) {
            return null;
        }
        
        ${apiModel.apiName}Model ${apiModel.apiName?uncap_first}Model = new ${apiModel.apiName}Model();

        ${apiModel.apiName?uncap_first}Model.setId(entity.getId());
        ${apiModel.apiName?uncap_first}Model.setUuid(entity.getUuid());
        ${apiModel.apiName?uncap_first}Model.setVersion(entity.getVersion());
        ${apiModel.apiName?uncap_first}Model.setDateCreated(entity.getDateCreated());
        ${apiModel.apiName?uncap_first}Model.setDateUpdated(entity.getDateUpdated());
        ${apiModel.apiName?uncap_first}Model.setCreatedBy(entity.getCreatedBy());
        ${apiModel.apiName?uncap_first}Model.setUpdatedBy(entity.getUpdatedBy());

        return ${apiModel.apiName?uncap_first}Model;
    }
    
    @Override
    public List${TAG_MODEL} convertToModelList(List${TAG_ENTITY} entities) {
        if (entities == null) {
            return null;
        }
        
        List${TAG_MODEL} list = new ArrayList${TAG_MODEL}(entities.size());
            for (${apiModel.apiName}Entity ${apiModel.apiName?uncap_first}Entity : entities) {
            list.add(convertToModel(${apiModel.apiName?uncap_first}Entity));
        }
        
        return list;
    }
    
    @Override
    public Set${TAG_MODEL} convertToModelSet(Set${TAG_ENTITY} entities) {
        if (entities == null) {
            return null;
        }
        
        Set${TAG_MODEL} set = new HashSet${TAG_MODEL}(Math.max((int) (entities.size() / .75f) + 1, 16));
            for (${apiModel.apiName}Entity ${apiModel.apiName?uncap_first}Entity : entities) {
            set.add(convertToModel(${apiModel.apiName?uncap_first}Entity));
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
    public ${apiModel.apiName}Entity convertToEntity(${apiModel.apiName}Model model) {
        if (model == null) {
            return null;
        }
        
        ${apiModel.apiName}Entity ${apiModel.apiName?uncap_first}Entity = new ${apiModel.apiName}Entity();
        
        ${apiModel.apiName?uncap_first}Entity.setUuid(model.getUuid());
        ${apiModel.apiName?uncap_first}Entity.setVersion(model.getVersion());
        ${apiModel.apiName?uncap_first}Entity.setDateCreated(model.getDateCreated());
        ${apiModel.apiName?uncap_first}Entity.setDateUpdated(model.getDateUpdated());
        ${apiModel.apiName?uncap_first}Entity.setCreatedBy(model.getCreatedBy());
        ${apiModel.apiName?uncap_first}Entity.setUpdatedBy(model.getUpdatedBy());
        ${apiModel.apiName?uncap_first}Entity.setId(model.getId());

        return ${apiModel.apiName?uncap_first}Entity;
    }
    
    @Override
    public List${TAG_ENTITY} convertToEntityList(List${TAG_MODEL} model) {
        if (model == null) {
            return null;
        }
        
        List${TAG_ENTITY} list = new ArrayList${TAG_ENTITY}(model.size());
        for (${apiModel.apiName}Model ${apiModel.apiName?uncap_first}Model : model) {
            list.add(convertToEntity(${apiModel.apiName?uncap_first}Model));
        }
        
        return list;
    }
    
    @Override
    public Set${TAG_ENTITY} convertToEntitySet(Set${TAG_MODEL} model) {
        if (model == null) {
            return null;
        }
        
        Set${TAG_ENTITY} set = new HashSet${TAG_ENTITY}(Math.max((int) (model.size() / .75f) + 1, 16));
        for (${apiModel.apiName}Model ${apiModel.apiName?uncap_first}Model : model) {
            set.add(convertToEntity(${apiModel.apiName?uncap_first}Model));
        }
        
        return set;
    }


}

package ${packageName}.converter;

import tr.com.havelsan.javarch.data.converter.enumeration.HvlBaseEnumerationConverter;
import ${packageName}.${model.name};

<#assign TAG_HVL_BASE_ENUMERATION_CONVERTER = 'HvlBaseEnumerationConverter<Integer, ${model.name}>'>
public class ${model.name}Converter extends ${TAG_HVL_BASE_ENUMERATION_CONVERTER} {

    @Override
    public ${model.name} convertToEntityAttribute(Integer value) {
        return ${model.name}.fromDbValue(value);
    }
}
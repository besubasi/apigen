package ${packageName}.converter;

import tr.com.havelsan.javarch.data.converter.enumeration.HvlBaseEnumerationConverter;
import ${packageName}.${enumModel.name};

<#assign TAG_HVL_BASE_ENUMERATION_CONVERTER = 'HvlBaseEnumerationConverter<Integer, ${enumModel.name}>'>
public class ${enumModel.name}Converter extends ${TAG_HVL_BASE_ENUMERATION_CONVERTER} {

    @Override
    public ${enumModel.name} convertToEntityAttribute(Integer value) {
        return ${enumModel.name}.fromDbValue(value);
    }
}
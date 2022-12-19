package ${packageName};

import tr.com.havelsan.javarch.core.enumeration.HvlEnumeration;
import tr.com.havelsan.javarch.data.converter.enumeration.HvlEnumerationConverter;

import java.util.Arrays;

<#assign TAG_HVL_ENUMERATION_CONVERTER = 'HvlEnumerationConverter<Integer>'>
public enum ${model.name} implements ${TAG_HVL_ENUMERATION_CONVERTER}, HvlEnumeration {

<#list model.keyList as enumKey>
    <#if enumKey?is_last >
    ${enumKey.key}("", ${enumKey?counter});
    <#else >
    ${enumKey.key}("", ${enumKey?counter}),
    </#if>
</#list>

    private String label;
    private int code;

    ${model.name}(String label, int code) {
        this.label = label;
        this.code = code;
    }

    public static ${model.name} fromDbValue(Integer code) {
        if (code == null)
            return null;
        return Arrays.stream(values()).filter(enumValue -> code == enumValue.code()).findFirst()
        .orElseThrow(() -> new IllegalArgumentException(code + " not found"));
    }

    @Override
    public int code() {
        return this.code;
    }

    @Override
    public String label() {
        return this.label;
    }

    @Override
    public Integer toDbValue() {
        return this.code;
    }
}

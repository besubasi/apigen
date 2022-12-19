{
    "${model.name?uncap_first}": {
    <#list model.keyList as enumKey>
        <#if enumKey?is_last >
        "${enumKey.key}": "${enumKey.en}"
        <#else >
        "${enumKey.key}": "${enumKey.en}",
        </#if>
    </#list>
    }
}

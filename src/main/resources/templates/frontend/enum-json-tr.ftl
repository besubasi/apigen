{
    "${model.name?uncap_first}": {
    <#list model.keyList as enumKey>
        <#if enumKey?is_last >
        "${enumKey.key}": "${enumKey.tr}"
        <#else >
        "${enumKey.key}": "${enumKey.tr}",
        </#if>
    </#list>
    }
}

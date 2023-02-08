export enum ${model.name} {

<#list model.keyList as enumKey>
    ${enumKey.key} = '${enumKey.key}',
</#list>
}

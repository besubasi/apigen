export enum ${enumModel.name} {

<#list enumModel.keyList as enumKey>
    ${enumKey.key} = '${enumKey.key}',
</#list>
}

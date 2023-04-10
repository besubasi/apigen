<#assign CONTEXT_PATH = '{application.module.logistic.${conf.microServiceName}.services.${conf.moduleName}.${model.apiName?uncap_first}.contextPath}'>
<#assign CONTROLLER_PATH = '{application.module.logistic.${conf.microServiceName}.services.${conf.moduleName}.${model.apiName?uncap_first}.controllerPath}'>
          ${conf.moduleName}:
            ${model.apiName?uncap_first}:
              contextPath: /
              controllerPath: ${model.apiName?uncap_first}Service/${model.apiName?uncap_first}
              path: $${CONTEXT_PATH}$${CONTROLLER_PATH}
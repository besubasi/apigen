package ${conf.groovyPackage}.${conf.moduleName}.${model.apiPackage};

import ${conf.commonPackage}.${conf.moduleName}.${model.apiPackage}.${model.apiName}Model
import ${conf.servicePackage}.${conf.moduleName}.${model.apiPackage}.${model.apiName}Repository;

class ${model.apiName}Rules {

    ${model.apiName}Repository ${model.apiName?uncap_first}Repository

    def beforeCreate(${model.apiName}Model model) {

    }

    def beforeUpdate(${model.apiName}Model model) {

    }

    def beforeDelete(Long id) {

    }
}
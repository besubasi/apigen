package ${packageName}

import ${model.commonPackage}.${model.apiPackage}.model.${model.apiName}Model
import ${model.servicePackage}.${model.apiPackage}.repository.${model.apiName}Repository;

class ${model.apiName}Rules {

    ${model.apiName}Repository ${model.apiName?uncap_first}Repository

    def beforeCreate(${model.apiName}Model model) {

    }

    def beforeUpdate(${model.apiName}Model model) {

    }

    def beforeDelete(Long id) {

    }
}
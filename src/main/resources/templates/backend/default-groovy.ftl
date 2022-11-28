package ${packageName}

import ${apiModel.commonPackage}.${apiModel.apiPackage}.model.${apiModel.apiName}Model
import ${apiModel.servicePackage}.${apiModel.apiPackage}.repository.${apiModel.apiName}Repository;

class ${apiModel.apiName}Rules {

    ${apiModel.apiName}Repository ${apiModel.apiName?uncap_first}Repository

    def beforeCreate(${apiModel.apiName}Model model) {

    }

    def beforeUpdate(${apiModel.apiName}Model model) {

    }

    def beforeDelete(Long id) {

    }
}
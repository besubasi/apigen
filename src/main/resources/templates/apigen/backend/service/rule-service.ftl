package ${conf.servicePackage}.${conf.moduleName}.${model.apiPackage};

import groovy.lang.GroovyObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tr.com.havelsan.javarch.data.jpa.annotation.HvlTransactionalRollbackForCheckedException;
import tr.com.havelsan.kovan.logistic.core.rule.GroovyBusinessRuleService;
import javax.validation.constraints.NotNull;

import static ${conf.servicePackage}.constants.${conf.configurationConstant}.${conf.groovyPathConstant};

@HvlTransactionalRollbackForCheckedException
@Component
public class ${model.apiName}RuleService extends GroovyBusinessRuleService {

    public static final String GROOVY_CLASS_NAME = "${model.apiName}Rules.groovy";

    private final ${model.apiName}Repository ${model.apiName?uncap_first}Repository;

    @Autowired
    ${model.apiName}RuleService(${model.apiName}Repository ${model.apiName?uncap_first}Repository) {
        super(${conf.groovyPathConstant}, GROOVY_CLASS_NAME);
        this.${model.apiName?uncap_first}Repository = ${model.apiName?uncap_first}Repository;
    }

    @Override
    public void setProperties(@NotNull GroovyObject groovyObject) {
        groovyObject.setProperty("${model.apiName?uncap_first}Repository", this.${model.apiName?uncap_first}Repository);
    }
}

package ${packageName};

import groovy.lang.GroovyObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tr.com.havelsan.javarch.data.jpa.annotation.HvlTransactionalRollbackForCheckedException;
import tr.com.havelsan.kovan.logistic.core.rule.GroovyBusinessRuleService;
import ${apiModel.servicePackage}.${apiModel.apiPackage}.repository.${apiModel.apiName}Repository;
import javax.validation.constraints.NotNull;

@HvlTransactionalRollbackForCheckedException
@Component
public class ${apiModel.apiName}RuleService extends GroovyBusinessRuleService {

    public static final String GROOVY_CLASS_PATH = "/${packageName?replace('.','/')}/";
    public static final String GROOVY_CLASS_NAME = "${apiModel.apiName}Rules.groovy";

    private final ${apiModel.apiName}Repository ${apiModel.apiName?uncap_first}Repository;

    @Autowired
    ${apiModel.apiName}RuleService(${apiModel.apiName}Repository ${apiModel.apiName?uncap_first}Repository) {
        super(GROOVY_CLASS_PATH, GROOVY_CLASS_NAME);
        this.${apiModel.apiName?uncap_first}Repository = ${apiModel.apiName?uncap_first}Repository;
    }

    @Override
    public void setProperties(@NotNull GroovyObject groovyObject) {
        groovyObject.setProperty("${apiModel.apiName?uncap_first}Repository", this.${apiModel.apiName?uncap_first}Repository);
    }
}

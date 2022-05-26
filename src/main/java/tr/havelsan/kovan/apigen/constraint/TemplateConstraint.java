package tr.havelsan.kovan.apigen.constraint;

public final class TemplateConstraint {

    private TemplateConstraint() {
    }

    public static final String API_MODEL = "apiModel";
    public static final String COMMON_PATH = "commonPath";
    public static final String SERVICE_PATH = "servicePath";
    public static final String GROOVY_PATH = "groovyPath";
    public static final String PACKAGE_PATH = "packagePath";
    public static final String PACKAGE_NAME = "packageName";
    public static final String FILE_NAME_END_FIX = "fileNameEndFix";
    public static final String FILE_TYPE = "fileType";

    public static final String TEMPLATE_DIRECTORY = "templates";

    public static final String DEFAULT_JAVA_FTL = "default-java.ftl";
    public static final String DEFAULT_GROOVY_FTL = "default-groovy.ftl";
    public static final String CONSTRAINT_FTL = "constraint.ftl";
    public static final String ENTITY_FTL = "entity.ftl";
    public static final String ENTITY_QUERY_FTL = "entity-query.ftl";
    public static final String DEF_ENTITY_FTL = "def-entity.ftl";
    public static final String DEF_ENTITY_QUERY_FTL = "def-entity-query.ftl";
    public static final String MODEL_FTL = "model.ftl";
    public static final String QUERY_MODEL_FTL = "query-model.ftl";
    public static final String QUERY_GENERATOR_FTL = "query-generator.ftl";
    public static final String CONVERTER_FTL = "converter.ftl";
    public static final String CONVERTER_IMPL_FTL = "converter-impl.ftl";
    public static final String REPOSITORY_FTL = "repository.ftl";
    public static final String RULES_FTL = "rules.ftl";
    public static final String RULE_SERVICE_FTL = "rule-service.ftl";
    public static final String SERVICE_FTL = "service.ftl";
    public static final String SERVICE_IMPL_FTL = "service-impl.ftl";
    public static final String PUBLIC_REST_SERVICE_FTL = "public-rest-service.ftl";
    public static final String PRIVATE_REST_SERVICE_FTL = "private-rest-service.ftl";
    public static final String REST_CONTROLLER_FTL = "rest-controller.ftl";

}

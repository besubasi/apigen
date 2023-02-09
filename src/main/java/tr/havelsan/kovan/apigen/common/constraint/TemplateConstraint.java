package tr.havelsan.kovan.apigen.common.constraint;

public final class TemplateConstraint {

    private TemplateConstraint() {
    }

    public static final String MODEL = "model";
    public static final String CONF = "conf";
    public static final String ID = "id";
    public static final String COMMON_PATH = "commonPath";
    public static final String SERVICE_PATH = "servicePath";
    public static final String GROOVY_PATH = "groovyPath";
    public static final String PACKAGE_PATH = "packagePath";
    public static final String PACKAGE_NAME = "packageName";
    public static final String FILE_NAME_END_FIX = "fileNameEndFix";
    public static final String FILE_TYPE = "fileType";

    public static final String TEMPLATE_DIRECTORY = "templates";

    public static final String CONSTRAINT_FTL = "/apigen/backend/service/constraint.ftl";
    public static final String ENTITY_FTL = "/apigen/backend/service/entity.ftl";
    public static final String ENTITY_QUERY_FTL = "/apigen/backend/service/entity-query.ftl";
    public static final String DEF_ENTITY_FTL = "/apigen/backend/service/def-entity.ftl";
    public static final String DEF_ENTITY_QUERY_FTL = "/apigen/backend/service/def-entity-query.ftl";
    public static final String MODEL_FTL = "/apigen/backend/common/model.ftl";
    public static final String QUERY_MODEL_FTL = "/apigen/backend/common/query-model.ftl";
    public static final String QUERY_GENERATOR_FTL = "/apigen/backend/service/query-generator.ftl";
    public static final String CONVERTER_FTL = "/apigen/backend/service/converter.ftl";
    public static final String CONVERTER_IMPL_FTL = "/apigen/backend/service/converter-impl.ftl";
    public static final String BASIC_CONVERTER_FTL = "/apigen/backend/service/basic-converter.ftl";
    public static final String BASIC_CONVERTER_IMPL_FTL = "/apigen/backend/service/basic-converter-impl.ftl";
    public static final String REPOSITORY_FTL = "/apigen/backend/service/repository.ftl";
    public static final String RULES_FTL = "/apigen/backend/groovy/rules.ftl";
    public static final String RULE_SERVICE_FTL = "/apigen/backend/service/rule-service.ftl";
    public static final String SERVICE_FTL = "/apigen/backend/service/service.ftl";
    public static final String SERVICE_IMPL_FTL = "/apigen/backend/service/service-impl.ftl";
    public static final String PUBLIC_REST_SERVICE_FTL = "/apigen/backend/common/public-rest-service.ftl";
    public static final String PRIVATE_REST_SERVICE_FTL = "/apigen/backend/common/private-rest-service.ftl";
    public static final String REST_CONTROLLER_FTL = "/apigen/backend/service/rest-controller.ftl";

    public static final String ENUM_FTL = "/enumgen/backend/enum.ftl";
    public static final String ENUM_CONVERTER_FTL = "/enumgen/backend/enum-converter.ftl";
    public static final String ENUM_TS_FTL = "/enumgen/frontend/enum-ts.ftl";
    public static final String ENUM_JSON_TR_FTL = "/enumgen/frontend/enum-json-tr.ftl";
    public static final String ENUM_JSON_EN_FTL = "/enumgen/frontend/enum-json-en.ftl";

    public static final String MENU_SQL_SCRIPT_FTL = "/menugen/backend/menu-sql-script.ftl";
    public static final String MENU_CHANGE_SET_FTL = "/menugen/backend/menu-change-set.ftl";
}

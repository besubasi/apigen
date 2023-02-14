package tr.havelsan.kovan.apigen.common.constraint;

public final class TemplateConstraint {

    private TemplateConstraint() {
    }

    public static final String MODEL = "model";
    public static final String CONF = "conf";
    public static final String ID = "id";
    public static final String PACKAGE_NAME = "packageName";

    public static final String TEMPLATE_DIRECTORY = "templates";

    public static final String CONSTRAINT_FTL = "/api-gen/backend/service/constraint.ftl";
    public static final String ENTITY_FTL = "/api-gen/backend/service/entity.ftl";
    public static final String ENTITY_QUERY_FTL = "/api-gen/backend/service/entity-query.ftl";
    public static final String DEF_ENTITY_FTL = "/api-gen/backend/service/def-entity.ftl";
    public static final String DEF_ENTITY_QUERY_FTL = "/api-gen/backend/service/def-entity-query.ftl";
    public static final String MODEL_FTL = "/api-gen/backend/common/model.ftl";
    public static final String QUERY_MODEL_FTL = "/api-gen/backend/common/query-model.ftl";
    public static final String QUERY_GENERATOR_FTL = "/api-gen/backend/service/query-generator.ftl";
    public static final String CONVERTER_FTL = "/api-gen/backend/service/converter.ftl";
    public static final String CONVERTER_IMPL_FTL = "/api-gen/backend/service/converter-impl.ftl";
    public static final String BASIC_CONVERTER_FTL = "/api-gen/backend/service/basic-converter.ftl";
    public static final String BASIC_CONVERTER_IMPL_FTL = "/api-gen/backend/service/basic-converter-impl.ftl";
    public static final String REPOSITORY_FTL = "/api-gen/backend/service/repository.ftl";
    public static final String RULES_FTL = "/api-gen/backend/groovy/rules.ftl";
    public static final String RULE_SERVICE_FTL = "/api-gen/backend/service/rule-service.ftl";
    public static final String SERVICE_FTL = "/api-gen/backend/service/service.ftl";
    public static final String SERVICE_IMPL_FTL = "/api-gen/backend/service/service-impl.ftl";
    public static final String PUBLIC_REST_SERVICE_FTL = "/api-gen/backend/common/public-rest-service.ftl";
    public static final String PRIVATE_REST_SERVICE_FTL = "/api-gen/backend/common/private-rest-service.ftl";
    public static final String REST_CONTROLLER_FTL = "/api-gen/backend/service/rest-controller.ftl";

    public static final String ENUM_FTL = "/enum-gen/backend/enum.ftl";
    public static final String ENUM_CONVERTER_FTL = "/enum-gen/backend/enum-converter.ftl";
    public static final String ENUM_TS_FTL = "/enum-gen/frontend/enum-ts.ftl";
    public static final String ENUM_JSON_TR_FTL = "/enum-gen/frontend/enum-json-tr.ftl";
    public static final String ENUM_JSON_EN_FTL = "/enum-gen/frontend/enum-json-en.ftl";

    public static final String MENU_SQL_SCRIPT_FTL = "/menu-gen/backend/menu-sql-script.ftl";
    public static final String MENU_CHANGE_SET_FTL = "/menu-gen/backend/menu-change-set.ftl";
}

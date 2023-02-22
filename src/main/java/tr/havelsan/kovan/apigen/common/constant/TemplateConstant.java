package tr.havelsan.kovan.apigen.common.constant;

public interface TemplateConstant {

    String MODEL = "model";
    String CONF = "conf";
    String HELPER = "helper";
    String STATICS = "statics";
    String PACKAGE_NAME = "packageName";

    String TEMPLATE_DIRECTORY = "templates";

    String CONSTRAINT_FTL = "/api-gen/backend/service/constraint.ftl";
    String ENTITY_FTL = "/api-gen/backend/service/entity.ftl";
    String ENTITY_QUERY_FTL = "/api-gen/backend/service/entity-query.ftl";
    String DEF_ENTITY_FTL = "/api-gen/backend/service/def-entity.ftl";
    String DEF_ENTITY_QUERY_FTL = "/api-gen/backend/service/def-entity-query.ftl";
    String MODEL_FTL = "/api-gen/backend/common/model.ftl";
    String QUERY_MODEL_FTL = "/api-gen/backend/common/query-model.ftl";
    String QUERY_GENERATOR_FTL = "/api-gen/backend/service/query-generator.ftl";
    String CONVERTER_FTL = "/api-gen/backend/service/converter.ftl";
    String CONVERTER_IMPL_FTL = "/api-gen/backend/service/converter-impl.ftl";
    String BASIC_CONVERTER_FTL = "/api-gen/backend/service/basic-converter.ftl";
    String BASIC_CONVERTER_IMPL_FTL = "/api-gen/backend/service/basic-converter-impl.ftl";
    String REPOSITORY_FTL = "/api-gen/backend/service/repository.ftl";
    String RULES_FTL = "/api-gen/backend/groovy/rules.ftl";
    String RULE_SERVICE_FTL = "/api-gen/backend/service/rule-service.ftl";
    String SERVICE_FTL = "/api-gen/backend/service/service.ftl";
    String SERVICE_IMPL_FTL = "/api-gen/backend/service/service-impl.ftl";
    String PUBLIC_REST_SERVICE_FTL = "/api-gen/backend/common/public-rest-service.ftl";
    String PRIVATE_REST_SERVICE_FTL = "/api-gen/backend/common/private-rest-service.ftl";
    String REST_CONTROLLER_FTL = "/api-gen/backend/service/rest-controller.ftl";
    String YML_UPDATE_FTL = "/api-gen/backend/yml-update.ftl";

    String ENUM_FTL = "/enum-gen/backend/enum.ftl";
    String ENUM_CONVERTER_FTL = "/enum-gen/backend/enum-converter.ftl";
    String ENUM_TS_FTL = "/enum-gen/frontend/enum-ts.ftl";
    String ENUM_JSON_TR_FTL = "/enum-gen/frontend/enum-json-tr.ftl";
    String ENUM_JSON_EN_FTL = "/enum-gen/frontend/enum-json-en.ftl";

    String OAUTH_CHANGESET_FTL = "/changeset-gen/oauth-changeset.ftl";
    String MENU_CHANGESET_FTL = "/changeset-gen/menu-changeset.ftl";
}

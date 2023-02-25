package tr.havelsan.kovan.apigen.common.constant;

public interface TemplateConstant {

    String MODEL = "model";
    String MODEL_LIST = "modelList";
    String CONF = "conf";
    String HELPER = "helper";
    String STATICS = "statics";

    String TEMPLATE_DIRECTORY = "templates";

    String CONSTANT_FTL = "/apigen/backend/service/constant.ftl";
    String ENTITY_FTL = "/apigen/backend/service/entity.ftl";
    String ENTITY_QUERY_FTL = "/apigen/backend/service/entity-query.ftl";
    String DEF_ENTITY_FTL = "/apigen/backend/service/def-entity.ftl";
    String DEF_ENTITY_QUERY_FTL = "/apigen/backend/service/def-entity-query.ftl";
    String MODEL_FTL = "/apigen/backend/common/model.ftl";
    String QUERY_MODEL_FTL = "/apigen/backend/common/query-model.ftl";
    String QUERY_GENERATOR_FTL = "/apigen/backend/service/query-generator.ftl";
    String CONVERTER_FTL = "/apigen/backend/service/converter.ftl";
    String CONVERTER_IMPL_FTL = "/apigen/backend/service/converter-impl.ftl";
    String BASIC_CONVERTER_FTL = "/apigen/backend/service/basic-converter.ftl";
    String BASIC_CONVERTER_IMPL_FTL = "/apigen/backend/service/basic-converter-impl.ftl";
    String REPOSITORY_FTL = "/apigen/backend/service/repository.ftl";
    String RULES_FTL = "/apigen/backend/groovy/rules.ftl";
    String RULE_SERVICE_FTL = "/apigen/backend/service/rule-service.ftl";
    String SERVICE_FTL = "/apigen/backend/service/service.ftl";
    String SERVICE_IMPL_FTL = "/apigen/backend/service/service-impl.ftl";
    String PUBLIC_REST_SERVICE_FTL = "/apigen/backend/common/public-rest-service.ftl";
    String PRIVATE_REST_SERVICE_FTL = "/apigen/backend/common/private-rest-service.ftl";
    String REST_CONTROLLER_FTL = "/apigen/backend/service/rest-controller.ftl";
    String YML_UPDATE_FTL = "/apigen/backend/yml-update.ftl";

    String ENUM_FTL = "/enum-gen/backend/enum.ftl";
    String ENUM_CONVERTER_FTL = "/enum-gen/backend/enum-converter.ftl";
    String ENUM_TS_FTL = "/enum-gen/frontend/enum-ts.ftl";
    String ENUM_JSON_TR_FTL = "/enum-gen/frontend/enum-json-tr.ftl";
    String ENUM_JSON_EN_FTL = "/enum-gen/frontend/enum-json-en.ftl";

    String OAUTH_CHANGESET_FTL = "/changeset-gen/oauth-changeset.ftl";
    String MENU_CHANGESET_FTL = "/changeset-gen/menu-changeset.ftl";
}

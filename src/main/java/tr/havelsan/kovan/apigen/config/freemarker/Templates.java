package tr.havelsan.kovan.apigen.config.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import javax.inject.Singleton;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import static tr.havelsan.kovan.apigen.constraint.TemplateConstraint.*;

@Singleton
public class Templates {

    public static Template CONSTRAINT;
    public static Template ENTITY;
    public static Template ENTITY_QUERY;
    public static Template DEF_ENTITY;
    public static Template DEF_ENTITY_QUERY;
    public static Template MODEL;
    public static Template QUERY_MODEL;
    public static Template QUERY_GENERATOR;
    public static Template CONVERTER;
    public static Template CONVERTER_IMPL;
    public static Template BASIC_CONVERTER;
    public static Template BASIC_CONVERTER_IMPL;
    public static Template REPOSITORY;
    public static Template RULES;
    public static Template RULE_SERVICE;
    public static Template SERVICE;
    public static Template SERVICE_IMPL;
    public static Template PUBLIC_REST_SERVICE;
    public static Template PRIVATE_REST_SERVICE;
    public static Template REST_CONTROLLER;
    public static Template ENUM;
    public static Template ENUM_CONVERTER;
    public static Template ENUM_TS;
    public static Template ENUM_JSON_TR;
    public static Template ENUM_JSON_EN;
    public static Template MENU_SQL_SCRIPT;
    public static Template MENU_CHANGE_SET;

    public static void initTemplates() throws IOException {

        var templatesFile = new File(Objects.requireNonNull(Templates.class.getClassLoader().getResource(TEMPLATE_DIRECTORY)).getFile());
        var configuration = new Configuration();
        configuration.setDirectoryForTemplateLoading(templatesFile);
        configuration.setDefaultEncoding(StandardCharsets.UTF_8.name());
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        CONSTRAINT = configuration.getTemplate(CONSTRAINT_FTL);
        ENTITY = configuration.getTemplate(ENTITY_FTL);
        ENTITY_QUERY = configuration.getTemplate(ENTITY_QUERY_FTL);
        DEF_ENTITY = configuration.getTemplate(DEF_ENTITY_FTL);
        DEF_ENTITY_QUERY = configuration.getTemplate(DEF_ENTITY_QUERY_FTL);
        MODEL = configuration.getTemplate(MODEL_FTL);
        QUERY_MODEL = configuration.getTemplate(QUERY_MODEL_FTL);
        QUERY_GENERATOR = configuration.getTemplate(QUERY_GENERATOR_FTL);
        CONVERTER = configuration.getTemplate(CONVERTER_FTL);
        CONVERTER_IMPL = configuration.getTemplate(CONVERTER_IMPL_FTL);
        BASIC_CONVERTER = configuration.getTemplate(BASIC_CONVERTER_FTL);
        BASIC_CONVERTER_IMPL = configuration.getTemplate(BASIC_CONVERTER_IMPL_FTL);
        REPOSITORY = configuration.getTemplate(REPOSITORY_FTL);
        RULES = configuration.getTemplate(RULES_FTL);
        RULE_SERVICE = configuration.getTemplate(RULE_SERVICE_FTL);
        SERVICE = configuration.getTemplate(SERVICE_FTL);
        SERVICE_IMPL = configuration.getTemplate(SERVICE_IMPL_FTL);
        PUBLIC_REST_SERVICE = configuration.getTemplate(PUBLIC_REST_SERVICE_FTL);
        PRIVATE_REST_SERVICE = configuration.getTemplate(PRIVATE_REST_SERVICE_FTL);
        REST_CONTROLLER = configuration.getTemplate(REST_CONTROLLER_FTL);
        ENUM = configuration.getTemplate(ENUM_FTL);
        ENUM_CONVERTER = configuration.getTemplate(ENUM_CONVERTER_FTL);
        ENUM_TS = configuration.getTemplate(ENUM_TS_FTL);
        ENUM_JSON_TR = configuration.getTemplate(ENUM_JSON_TR_FTL);
        ENUM_JSON_EN = configuration.getTemplate(ENUM_JSON_EN_FTL);
        MENU_SQL_SCRIPT = configuration.getTemplate(MENU_SQL_SCRIPT_FTL);
        MENU_CHANGE_SET = configuration.getTemplate(MENU_CHANGE_SET_FTL);
    }

}

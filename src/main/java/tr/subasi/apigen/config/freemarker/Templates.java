package tr.subasi.apigen.config.freemarker;

import freemarker.ext.beans.BeansWrapper;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import jakarta.inject.Singleton;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.TimeZone;

import static tr.subasi.apigen.common.constant.TemplateConstant.*;

@Singleton
public class Templates {

    public static Template CONSTANT;
    public static Template ENTITY;
    public static Template MODEL;
    public static Template SEARCH_MODEL;
    public static Template CONVERTER;
    public static Template REPOSITORY;
    public static Template SERVICE;
    public static Template SERVICE_IMPL;
    public static Template REST_SERVICE;
    public static Template REST_CONTROLLER;

    public static void initTemplates() throws IOException {

        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);
        configuration.setDirectoryForTemplateLoading(new File(Objects.requireNonNull(Templates.class.getClassLoader().getResource(TEMPLATE_DIRECTORY)).getFile()));
        configuration.setDefaultEncoding(StandardCharsets.UTF_8.name());
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        configuration.setWrapUncheckedExceptions(true);
        configuration.setFallbackOnNullLoopVariable(false);
        configuration.setSQLDateAndTimeTimeZone(TimeZone.getDefault());

        BeansWrapper objectWrapper = (BeansWrapper) configuration.getObjectWrapper();
        configuration.setSharedVariable(STATICS, objectWrapper.getStaticModels());

        CONSTANT = configuration.getTemplate(CONSTANT_FTL);
        ENTITY = configuration.getTemplate(ENTITY_FTL);
        MODEL = configuration.getTemplate(MODEL_FTL);
        SEARCH_MODEL = configuration.getTemplate(SEARCH_MODEL_FTL);
        CONVERTER = configuration.getTemplate(CONVERTER_FTL);
        REPOSITORY = configuration.getTemplate(REPOSITORY_FTL);
        SERVICE = configuration.getTemplate(SERVICE_FTL);
        SERVICE_IMPL = configuration.getTemplate(SERVICE_IMPL_FTL);
        REST_SERVICE = configuration.getTemplate(REST_SERVICE_FTL);
        REST_CONTROLLER = configuration.getTemplate(REST_CONTROLLER_FTL);
    }

}

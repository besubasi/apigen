package tr.subasi.apigen.common.util;

import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

public class TemplateUtil {


    public static String getContent(Template template, Map<String, Object> parameterMap) {
        final StringWriter stringWriter = new StringWriter();
        try {
            template.process(parameterMap, stringWriter);
        } catch (TemplateException | IOException e) {
            stringWriter.getBuffer().setLength(0);
        }
        return stringWriter.toString();
    }

}

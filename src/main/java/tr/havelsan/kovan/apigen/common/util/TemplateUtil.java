package tr.havelsan.kovan.apigen.common.util;

import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class TemplateUtil {


    public static String getString(Template template, Map<String, Object> parameterMap) {
        final StringWriter stringWriter = new StringWriter();
        try {
            template.process(parameterMap, stringWriter);
        } catch (TemplateException | IOException e) {
            stringWriter.getBuffer().setLength(0);
        }
        return stringWriter.toString();
    }

    public static byte[] getContent(Template template, Map<String, Object> parameterMap) {
        return TemplateUtil.getString(template, parameterMap).getBytes(StandardCharsets.UTF_8);
    }

}

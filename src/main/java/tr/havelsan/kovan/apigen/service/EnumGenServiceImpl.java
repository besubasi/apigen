package tr.havelsan.kovan.apigen.service;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import tr.havelsan.kovan.apigen.config.freemarker.Templates;
import tr.havelsan.kovan.apigen.util.ApiGenUtil;

import javax.inject.Singleton;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import static tr.havelsan.kovan.apigen.constraint.ApiGenConstraint.*;
import static tr.havelsan.kovan.apigen.constraint.TemplateConstraint.*;

@Singleton
public class EnumGenServiceImpl extends AbstractEnumGenService {


    @ConfigProperty(name = ENV_COMMON_PATH)
    String commonPath;

    @ConfigProperty(name = ENV_FRONTEND_PATH)
    String frontendPath;

    final StringWriter stringWriter = new StringWriter();

    @Override
    void createBackendEnum() {
        String packagePath = enumModel.getCommonPackage().replaceAll("\\.", "\\" + File.separator);
        var filePath = Paths.get(commonPath + File.separator + packagePath + File.separator + enumModel.getName() + FILE_JAVA);
        ApiGenUtil.createDirectory(Paths.get(commonPath + File.separator + packagePath));
        ApiGenUtil.writeFile(filePath, this.getContentFromTemplate(Templates.ENUM, this.prepareTemplateParameters(packagePath, enumModel.getCommonPackage())));
    }

    @Override
    void createBackendEnumConverter() {
        String packagePath = enumModel.getCommonPackage().replaceAll("\\.", "\\" + File.separator);
        var filePath = Paths.get(commonPath + File.separator + packagePath + File.separator + PACKAGE_CONVERTER + File.separator + enumModel.getName() + END_FIX_CONVERTER + FILE_JAVA);
        ApiGenUtil.createDirectory(Paths.get(commonPath + File.separator + packagePath));
        ApiGenUtil.writeFile(filePath, this.getContentFromTemplate(Templates.ENUM_CONVERTER, this.prepareTemplateParameters(packagePath, enumModel.getCommonPackage())));
    }

    @Override
    void createFrontendEnum() {
        String sharedPath = enumModel.getSharedName() + File.separator + enumModel.getSharedPackage().replaceAll("\\.", "\\" + File.separator);
        var filePath = Paths.get(frontendPath + File.separator + sharedPath + File.separator + this.getTsFileName() + FILE_TYPE_SCRIPT);
        ApiGenUtil.createDirectory(Paths.get(frontendPath + File.separator + sharedPath));
        ApiGenUtil.writeFile(filePath, this.getContentFromTemplate(Templates.ENUM_TS, this.prepareTemplateParameters(sharedPath, enumModel.getCommonPackage())));
    }

    @Override
    void createFrontendEnumJsonTr() {
        String sharedPath = enumModel.getSharedName() + File.separator + "src" + File.separator + "assets" + File.separator + "i18n" + File.separator + "tr";
        var filePath = Paths.get(frontendPath + File.separator + sharedPath + File.separator + this.getTsFileName() + FILE_JSON);
        ApiGenUtil.createDirectory(Paths.get(frontendPath + File.separator + sharedPath));
        ApiGenUtil.writeFile(filePath, this.getContentFromTemplate(Templates.ENUM_JSON_TR, this.prepareTemplateParameters(sharedPath, enumModel.getCommonPackage())));
    }

    @Override
    void createFrontendEnumJsonEn() {
        String sharedPath = enumModel.getSharedName() + File.separator + "src" + File.separator + "assets" + File.separator + "i18n" + File.separator + "en";
        var filePath = Paths.get(frontendPath + File.separator + sharedPath + File.separator + this.getTsFileName() + FILE_JSON);
        ApiGenUtil.createDirectory(Paths.get(frontendPath + File.separator + sharedPath));
        ApiGenUtil.writeFile(filePath, this.getContentFromTemplate(Templates.ENUM_JSON_EN, this.prepareTemplateParameters(sharedPath, enumModel.getCommonPackage())));
    }

    @Override
    void updateFrontendPublicApiTs() throws IOException {
        String exportPath = enumModel.getSharedPackage().replaceAll("\\.", "\\" + File.separator).replaceAll("src", ".") + File.separator + this.getTsFileName();
        var publicApiTsPath = Paths.get(frontendPath + File.separator + enumModel.getSharedName() + File.separator + "src" + File.separator + "public.api.ts");
        var content = Files.readString(publicApiTsPath);
        String stringBuilder = content + System.lineSeparator() + System.lineSeparator() + "export * from '" + exportPath + "';";
        ApiGenUtil.writeFile(publicApiTsPath, stringBuilder.getBytes(StandardCharsets.UTF_8));
    }

    private String getTsFileName() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(enumModel.getName().charAt(0));
        for (int i = 1; i < enumModel.getName().length(); i++)
            stringBuilder.append(Character.isUpperCase(enumModel.getName().charAt(i)) ? "-" : "").append(enumModel.getName().charAt(i));

        return stringBuilder.toString().toLowerCase();
    }


    private Map<String, Object> prepareTemplateParameters(String packagePath, String packageName) {
        return Map.of(
                ENUM_MODEL, enumModel,
                COMMON_PATH, commonPath,
                FRONTEND_PATH, frontendPath,
                PACKAGE_PATH, packagePath,
                PACKAGE_NAME, packageName);
    }

    private byte[] getContentFromTemplate(Template template, Map<String, Object> parameterMap) {
        stringWriter.getBuffer().setLength(0);
        try {
            template.process(parameterMap, stringWriter);
        } catch (TemplateException | IOException e) {
            stringWriter.getBuffer().setLength(0);
            var defaultTemplate = FILE_GROOVY.equals(parameterMap.get(FILE_TYPE)) ? Templates.DEFAULT_GROOVY : Templates.DEFAULT_JAVA;
            try {
                defaultTemplate.process(parameterMap, stringWriter);
            } catch (TemplateException | IOException e2) {
                e.printStackTrace();
                System.out.println(" ******************************* ");
                e2.printStackTrace();
            }
        }
        return stringWriter.toString().getBytes(StandardCharsets.UTF_8);
    }

}

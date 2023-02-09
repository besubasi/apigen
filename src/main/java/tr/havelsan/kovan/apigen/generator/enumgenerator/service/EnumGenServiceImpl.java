package tr.havelsan.kovan.apigen.generator.enumgenerator.service;

import tr.havelsan.kovan.apigen.config.freemarker.Templates;

import javax.inject.Singleton;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static tr.havelsan.kovan.apigen.common.constraint.ApiGenConstraint.*;
import static tr.havelsan.kovan.apigen.common.util.ApiGenUtil.createDirectory;
import static tr.havelsan.kovan.apigen.common.util.ApiGenUtil.writeFile;
import static tr.havelsan.kovan.apigen.common.util.PathUtil.*;
import static tr.havelsan.kovan.apigen.common.util.TemplateUtil.getContent;

@Singleton
public class EnumGenServiceImpl extends AbstractEnumGenService {

    @Override
    void createBackendEnum() {
        String directoryPath = getCommonPath(enumModel.getMicroservice()) + File.separator + convertPackageToPath(enumModel.getCommonPackage());
        createDirectory(Paths.get(directoryPath));
        String filePath = directoryPath + File.separator + enumModel.getName() + FILE_JAVA;
        writeFile(Paths.get(filePath), getContent(Templates.ENUM, map));
    }

    @Override
    void createBackendEnumConverter() {
        String directoryPath = getCommonPath(enumModel.getMicroservice()) + File.separator + convertPackageToPath(enumModel.getCommonPackage()) + File.separator + PACKAGE_CONVERTER;
        createDirectory(Paths.get(directoryPath));
        String filePath = directoryPath + File.separator + enumModel.getName() + END_FIX_CONVERTER + FILE_JAVA;
        writeFile(Paths.get(filePath), getContent(Templates.ENUM_CONVERTER, map));
    }

    @Override
    void createFrontendEnum() {
        String directoryPath = getFrontendSharedSrcLibPath(enumModel.getMicroservice()) + File.separator + convertPackageToPath(enumModel.getSharedPackage());
        createDirectory(Paths.get(directoryPath));
        String filePath = directoryPath + File.separator + this.getTsFileName() + FILE_TYPE_SCRIPT;
        writeFile(Paths.get(filePath), getContent(Templates.ENUM_TS, map));
    }

    @Override
    void createFrontendEnumJsonTr() {
        String filePath = geti18nTrPath(enumModel.getMicroservice()) + File.separator + this.getTsFileName() + FILE_JSON;
        writeFile(Paths.get(filePath), getContent(Templates.ENUM_JSON_TR, map));
    }

    @Override
    void createFrontendEnumJsonEn() {
        String filePath = geti18nEnPath(enumModel.getMicroservice()) + File.separator + this.getTsFileName() + FILE_JSON;
        writeFile(Paths.get(filePath), getContent(Templates.ENUM_JSON_EN, map));
    }

    @Override
    void updateFrontendPublicApiTs() throws IOException {
        var publicApiTsPath = Paths.get(getPublicApiTsPath(enumModel.getMicroservice()));
        var content = Files.readString(publicApiTsPath);
        String exportLine = "export * from './lib/" + convertPackageToPath(enumModel.getSharedPackage()) + File.separator + this.getTsFileName() + "';";
        String updatedContent = content + System.lineSeparator() + System.lineSeparator() + exportLine;
        writeFile(publicApiTsPath, updatedContent.getBytes(StandardCharsets.UTF_8));
    }

    private String getTsFileName() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(enumModel.getName().charAt(0));
        for (int i = 1; i < enumModel.getName().length(); i++)
            stringBuilder.append(Character.isUpperCase(enumModel.getName().charAt(i)) ? "-" : "").append(enumModel.getName().charAt(i));

        return stringBuilder.toString().toLowerCase();
    }

}

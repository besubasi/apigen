package tr.havelsan.kovan.apigen.generator.enumgenerator.service;

import tr.havelsan.kovan.apigen.common.util.FileUtil;
import tr.havelsan.kovan.apigen.common.util.PathUtil;
import tr.havelsan.kovan.apigen.config.freemarker.Templates;

import javax.inject.Singleton;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static tr.havelsan.kovan.apigen.generator.apigenerator.constant.ApiGeneratorConstant.*;
import static tr.havelsan.kovan.apigen.common.util.PathUtil.*;
import static tr.havelsan.kovan.apigen.common.util.TemplateUtil.getContent;

@Singleton
public class EnumGeneratorServiceImpl extends AbstractEnumGeneratorService {

    @Override
    void createBackendEnum() throws IOException {
        String directoryPath = getCommonPackagePath(enumGeneratorModel.getMicroservice()) + File.separator + convertPackageToPath(enumGeneratorModel.getCommonSubPackage());
        FileUtil.createDirectory(Paths.get(directoryPath));
        String filePath = directoryPath + File.separator + enumGeneratorModel.getName() + FILE_JAVA;
        FileUtil.writeFile(Paths.get(filePath), getContent(Templates.ENUM, map));
    }

    @Override
    void createBackendEnumConverter() throws IOException {
        String directoryPath = getCommonPackagePath(enumGeneratorModel.getMicroservice()) + File.separator + convertPackageToPath(enumGeneratorModel.getCommonSubPackage()) + File.separator + PACKAGE_CONVERTER;
        FileUtil.createDirectory(Paths.get(directoryPath));
        String filePath = directoryPath + File.separator + enumGeneratorModel.getName() + END_FIX_CONVERTER + FILE_JAVA;
        FileUtil.writeFile(Paths.get(filePath), getContent(Templates.ENUM_CONVERTER, map));
    }

    @Override
    void createFrontendEnum() throws IOException {
        String directoryPath = getFrontendSharedSrcLibPath(enumGeneratorModel.getMicroservice()) + File.separator + convertPackageToPath(enumGeneratorModel.getSharedPackage());
        FileUtil.createDirectory(Paths.get(directoryPath));
        String filePath = directoryPath + File.separator + this.getTsFileName() + FILE_TYPE_SCRIPT;
        FileUtil.writeFile(Paths.get(filePath), getContent(Templates.ENUM_TS, map));
    }

    @Override
    void createFrontendEnumJsonTr() throws IOException {
        String filePath = geti18nTrPath(enumGeneratorModel.getMicroservice()) + File.separator + this.getTsFileName() + FILE_JSON;
        FileUtil.writeFile(Paths.get(filePath), getContent(Templates.ENUM_JSON_TR, map));
    }

    @Override
    void createFrontendEnumJsonEn() throws IOException {
        String filePath = geti18nEnPath(enumGeneratorModel.getMicroservice()) + File.separator + this.getTsFileName() + FILE_JSON;
        FileUtil.writeFile(Paths.get(filePath), getContent(Templates.ENUM_JSON_EN, map));
    }

    @Override
    void updateFrontendPublicApiTs() throws IOException {
        var publicApiTsPath = Paths.get(getPublicApiTsPath(enumGeneratorModel.getMicroservice()));
        var content = Files.readString(publicApiTsPath);
        String exportLine = "export * from './lib/" + convertPackageToPath(enumGeneratorModel.getSharedPackage()) + File.separator + this.getTsFileName() + "';";
        String updatedContent = content + System.lineSeparator() + System.lineSeparator() + exportLine;
        FileUtil.writeFile(publicApiTsPath, updatedContent);
    }

    private String getTsFileName() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(enumGeneratorModel.getName().charAt(0));
        for (int i = 1; i < enumGeneratorModel.getName().length(); i++)
            stringBuilder.append(Character.isUpperCase(enumGeneratorModel.getName().charAt(i)) ? "-" : "").append(enumGeneratorModel.getName().charAt(i));

        return stringBuilder.toString().toLowerCase();
    }

}

package tr.havelsan.kovan.apigen.generator.changesetgenerator.service;

import freemarker.ext.beans.BeansWrapper;
import tr.havelsan.kovan.apigen.common.util.TemplateUtil;
import tr.havelsan.kovan.apigen.config.freemarker.Templates;
import tr.havelsan.kovan.apigen.generator.changesetgenerator.model.HelperModel;
import tr.havelsan.kovan.apigen.generator.changesetgenerator.model.MenuChangesetModel;
import tr.havelsan.kovan.apigen.generator.changesetgenerator.model.OauthChangesetModel;

import javax.inject.Singleton;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import static tr.havelsan.kovan.apigen.common.constant.TemplateConstant.*;
import static tr.havelsan.kovan.apigen.common.util.ApiGenUtil.writeFile;
import static tr.havelsan.kovan.apigen.common.util.PathUtil.getMenuChangeLogPath;
import static tr.havelsan.kovan.apigen.common.util.PathUtil.getOauthChangeLogPath;

@Singleton
public class ChangesetGeneratorServiceImpl implements ChangesetGeneratorService {

    private static final String DATABASE_CHANGE_LOG_CLOSE_TAG = "</databaseChangeLog>";

    @Override
    public String generateOauthChangeset(OauthChangesetModel oauthChangesetModel) throws IOException {
        String oauthChangeSet = TemplateUtil.getContent(Templates.OAUTH_CHANGESET,
                Map.of(MODEL, oauthChangesetModel, HELPER, new HelperModel(), STATICS, BeansWrapper.getDefaultInstance().getStaticModels()));

        Path path = Paths.get(getOauthChangeLogPath());
        String content = Files.readString(path);
        content = content.replace(DATABASE_CHANGE_LOG_CLOSE_TAG, oauthChangeSet + DATABASE_CHANGE_LOG_CLOSE_TAG);

        writeFile(path, content);
        return oauthChangeSet;
    }

    @Override
    public String generateMenuChangeset(MenuChangesetModel menuChangesetModel) throws IOException {
        String menuChangeSet = TemplateUtil.getContent(Templates.MENU_CHANGESET,
                Map.of(MODEL, menuChangesetModel, HELPER, new HelperModel()));

        Path path = Paths.get(getMenuChangeLogPath());
        String content = Files.readString(path);
        content = content.replace(DATABASE_CHANGE_LOG_CLOSE_TAG, menuChangeSet + DATABASE_CHANGE_LOG_CLOSE_TAG);

        writeFile(path, content);
        return menuChangeSet;
    }

}

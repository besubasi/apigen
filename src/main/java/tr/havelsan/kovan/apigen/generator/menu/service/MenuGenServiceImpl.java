package tr.havelsan.kovan.apigen.generator.menu.service;

import tr.havelsan.kovan.apigen.config.freemarker.Templates;
import tr.havelsan.kovan.apigen.generator.menu.model.MenuChangeSetModel;
import tr.havelsan.kovan.apigen.generator.menu.model.MenuSqlScriptModel;
import tr.havelsan.kovan.apigen.util.TemplateUtil;

import javax.inject.Singleton;
import java.util.Map;
import java.util.UUID;

import static tr.havelsan.kovan.apigen.constraint.TemplateConstraint.ID;
import static tr.havelsan.kovan.apigen.constraint.TemplateConstraint.MODEL;

@Singleton
public class MenuGenServiceImpl implements MenuGenService {

    @Override
    public String generateSqlScript(MenuSqlScriptModel menuSqlScriptModel) {
        return new String(TemplateUtil.getContent(Templates.MENU_SQL_SCRIPT, Map.of(MODEL, menuSqlScriptModel)));
    }

    @Override
    public String generateChangeSet(MenuChangeSetModel menuChangeSetModel) {
        return new String(TemplateUtil.getContent(Templates.MENU_CHANGE_SET, Map.of(MODEL, menuChangeSetModel, ID, UUID.randomUUID())));
    }


}

package tr.havelsan.kovan.apigen.generator.menu.service;

import tr.havelsan.kovan.apigen.generator.menu.model.MenuChangeSetModel;
import tr.havelsan.kovan.apigen.generator.menu.model.MenuSqlScriptModel;

import java.io.IOException;

public interface MenuGenService {

    String generateSqlScript(MenuSqlScriptModel menuSqlScriptModel) throws IOException;

    String generateChangeSet(MenuChangeSetModel menuChangeSetModel) throws IOException;

}

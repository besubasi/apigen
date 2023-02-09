package tr.havelsan.kovan.apigen.generator.menugenerator.service;

import tr.havelsan.kovan.apigen.generator.menugenerator.model.MenuChangeSetModel;
import tr.havelsan.kovan.apigen.generator.menugenerator.model.MenuSqlScriptModel;

import java.io.IOException;

public interface MenuGenService {

    String generateSqlScript(MenuSqlScriptModel menuSqlScriptModel) throws IOException;

    String generateChangeSet(MenuChangeSetModel menuChangeSetModel) throws IOException;

}

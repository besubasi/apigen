package tr.havelsan.kovan.apigen.generator.changesetgenerator.service;

import tr.havelsan.kovan.apigen.generator.changesetgenerator.model.MenuChangesetModel;
import tr.havelsan.kovan.apigen.generator.changesetgenerator.model.OauthChangesetModel;

import java.io.IOException;

public interface ChangesetGeneratorService {

    String generateOauthChangeset(OauthChangesetModel oauthChangesetModel) throws IOException;

    String generateMenuChangeset(MenuChangesetModel menuChangesetModel) throws IOException;

}

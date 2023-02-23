package tr.havelsan.kovan.apigen.menu.service;

import java.io.IOException;
import java.net.URISyntaxException;

public interface ApiGenMenuItemService {

    Object readFromJsonFile() throws IOException, URISyntaxException;

}

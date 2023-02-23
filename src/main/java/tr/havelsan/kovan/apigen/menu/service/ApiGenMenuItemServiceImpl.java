package tr.havelsan.kovan.apigen.menu.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Singleton;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

@Singleton
public class ApiGenMenuItemServiceImpl implements ApiGenMenuItemService {

    private static final String APIGEN_MENU_JSON_PATH = "data/apigen-menu.json";

    @Override
    public Object readFromJsonFile() throws IOException, URISyntaxException {
        URL resource = ApiGenMenuItemServiceImpl.class.getClassLoader().getResource(APIGEN_MENU_JSON_PATH);
        if (resource == null)
            return null;
        String json = Files.readString(Paths.get(resource.toURI()));
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, Object.class);
    }
}

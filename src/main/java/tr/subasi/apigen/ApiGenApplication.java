package tr.subasi.apigen;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;
import tr.subasi.apigen.config.freemarker.Templates;
import tr.subasi.apigen.common.util.PathUtil;

import java.io.IOException;

import static tr.subasi.apigen.generator.constant.ApiGeneratorConstant.ENV_REPOSITORY_PATH;

@ApplicationScoped
public class ApiGenApplication {

    private static final Logger LOGGER = Logger.getLogger(ApiGenApplication.class);

    @ConfigProperty(name = ENV_REPOSITORY_PATH)
    String repositoryPath;

    void onStart(@Observes StartupEvent ev) throws IOException {
        Templates.initTemplates();
        PathUtil.setRepositoryPath(repositoryPath);
        LOGGER.info("Repository Path : " + repositoryPath);
    }

    void onStop(@Observes ShutdownEvent ev) {
        LOGGER.info("The application is stopping...");
    }


}

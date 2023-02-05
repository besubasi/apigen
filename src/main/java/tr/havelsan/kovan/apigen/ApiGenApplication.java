package tr.havelsan.kovan.apigen;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;
import tr.havelsan.kovan.apigen.config.freemarker.Templates;
import tr.havelsan.kovan.apigen.util.PathUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import java.io.IOException;

import static tr.havelsan.kovan.apigen.constraint.ApiGenConstraint.ENV_REPOSITORY_PATH;

@ApplicationScoped
public class ApiGenApplication {

    private static final Logger LOGGER = Logger.getLogger(ApiGenApplication.class);

    @ConfigProperty(name = ENV_REPOSITORY_PATH)
    String repositoryPath;

    void onStart(@Observes StartupEvent ev) throws IOException {
        Templates.initTemplates();
        PathUtil.setRepositoryPath(repositoryPath);
        System.out.println("Repository Path : " + repositoryPath);
    }

    void onStop(@Observes ShutdownEvent ev) {
        LOGGER.info("The application is stopping...");
    }


}

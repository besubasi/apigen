package tr.subasi.apigen;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;
import tr.subasi.apigen.common.util.PathUtil;
import tr.subasi.apigen.config.freemarker.Templates;

import java.io.IOException;

import static tr.subasi.apigen.generator.constant.ApiGeneratorConstant.ENV_REPOSITORY_PATH;
import static tr.subasi.apigen.generator.constant.ApiGeneratorConstant.ENV_SERVICE_PACKAGE;

@ApplicationScoped
public class ApiGenApplication {

    private static final Logger LOGGER = Logger.getLogger(ApiGenApplication.class);

    @ConfigProperty(name = ENV_REPOSITORY_PATH)
    String repositoryPath;

    @ConfigProperty(name = ENV_SERVICE_PACKAGE)
    String servicePackage;

    void onStart(@Observes StartupEvent ev) throws IOException {
        Templates.initTemplates();
        PathUtil.setRepositoryPath(repositoryPath);
        PathUtil.setServicePackage(servicePackage);
        LOGGER.info("Repository Path : " + repositoryPath);
        LOGGER.info("Service Package : " + servicePackage);
    }

    void onStop(@Observes ShutdownEvent ev) {
        LOGGER.info("The application is stopping...");
    }


}

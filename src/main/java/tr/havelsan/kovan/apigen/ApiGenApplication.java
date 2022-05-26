package tr.havelsan.kovan.apigen;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.jboss.logging.Logger;
import tr.havelsan.kovan.apigen.config.freemarker.Templates;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.io.IOException;

@ApplicationScoped
public class ApiGenApplication {


    @Inject
    Templates templates;

    private static final Logger LOGGER = Logger.getLogger("ListenerBean");

    void onStart(@Observes StartupEvent ev) throws IOException {
        LOGGER.info("The application is starting...");
        templates.initTemplates();
    }

    void onStop(@Observes ShutdownEvent ev) {
        LOGGER.info("The application is stopping...");
    }


}

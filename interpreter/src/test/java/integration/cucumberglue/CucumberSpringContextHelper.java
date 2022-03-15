package integration.cucumberglue;

import interpretermain.Main;
import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.java.Log;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@Log
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {Main.class, CucumberTestHelper.class})
@CucumberContextConfiguration
@ComponentScan("integration.cucumberglue")
public class CucumberSpringContextHelper {
    private static final Logger LOG = LoggerFactory.getLogger(CucumberSpringContextHelper.class);

    @BeforeAll
    void contextLoads() {
        LOG.info(() -> "STARTING CONTEXT INIT FOR INTEGRATION TEST");
    }
}

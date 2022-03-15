package integration;

import integration.cucumberglue.CucumberTestHelper;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IntepreterStepsDefinitions {
    WebDriver driver;
    @Autowired
    private CucumberTestHelper cucumberTestHelper;

    @Given("Open the Firefox and launch the application")
    public void openTheFirefoxAndLaunchTheApplication() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\chewb\\Documents\\java\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:" + cucumberTestHelper.RANDOM_PORT + "/index.xhtml");
    }

    @And("Intepreter page will be displated")
    public void intepreterPageWillBeDisplated() {
        String actualString = driver.findElement(By.id("welcome_text")).getText();
        assertTrue(actualString.contains("Hello World PrimeFaces"));
    }

    @And("User chooses Javascript")
    public void user_chooses_Javascript() {
        driver.findElement(By.id("editorForm:group_label")).click();
        WebElement uiInterpreterMenu = driver.findElement(By.id("editorForm:group_items"));
        WebElement link = uiInterpreterMenu.findElement(By.cssSelector("[data-label=JavaScript]"));
        link.click();
    }

    @When("User input and submit {int} * {int} operation")
    public void user_input_and_submit_operation(Integer int1, Integer int2) {
        driver.findElement(By.id("editorForm:editorId_editor")).click();
        driver.findElement(By.id("editorForm:editorId_editor"))
            .findElement(By.className("ql-editor"))
            .sendKeys(String.format("%d * %d", int1, int2));
        driver.findElement(By.id("editorForm:interpretButton")).click();

    }

    @Then("He will see {int}")
    public void he_will_see(Integer int1) {
        new WebDriverWait(driver, 3L).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                WebElement outputText = d.findElement(By.id("editorForm:interpretOutput"));
                return String.valueOf(int1).equals(outputText.getAttribute("value"));
            }
        });
    }

    @After
    public void exitGracefully() {
        driver.quit();
    }
}

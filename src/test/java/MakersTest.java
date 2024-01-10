import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MakersTest {
    private static ChromeDriver driver;

    @BeforeAll
    static void launchBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-debugging-pipe");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
    }

    // Your tests will go here!
    @Test
    void shouldPrintPageTitle() {
        driver.get("https://makers.tech");
        Assertions.assertEquals(driver.getTitle(),"Welcome to Makers");
    }

    @AfterAll
    static void closeBrowser() {
        driver.quit();
    }
}

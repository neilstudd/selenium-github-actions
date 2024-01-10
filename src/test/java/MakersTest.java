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
        driver = new ChromeDriver();
    }

    // Your tests will go here!
    @Test
    void shouldPrintPageTitle() {
        driver.get("https://makers.tech");
        Assertions.assertEquals(driver.getTitle(),"We Are Makers. Building The Future.");
    }

    @AfterAll
    static void closeBrowser() {
        driver.quit();
    }
}
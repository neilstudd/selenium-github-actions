import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakersTest {
    private static ChromeDriver driver;

    @BeforeAll
    static void launchBrowser() {
        WebDriverManager.firefoxdriver().setup();
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
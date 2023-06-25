import model.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


@RunWith(Parameterized.class)

public class CheckStatusTest {

    private WebDriver driver;

    private final String orderNumber;

    public CheckStatusTest(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Parameters
    public static Object[][] getData(){
        return new Object[][]{
                {"165"}, {"00026Ajk64623000"},
        };
    }

    @Before
        public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @Test
    public void checkStatusOnExistingOrderShowsError() {
    MainPage mainPage = new MainPage(driver);
    mainPage.open();
    mainPage.clickCheckOrderButton();
    mainPage.enterOrderNumber(orderNumber);
    mainPage.clickGoButton();
    Assert.assertTrue(mainPage.isImageNotFoundDisplayed());
    }

   @After
   public void tearDown(){
        driver.quit();
}
}


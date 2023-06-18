import io.github.bonigarcia.wdm.WebDriverManager;
import model.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


@RunWith(Parameterized.class)
public class OrderTest {

    private WebDriver driver;
    private final String name;
    private final String secondName;
    private final String address;
    private final String phoneNumber;

    public OrderTest (String name, String secondName, String address, String phoneNumber){
        this.name = name;
        this.secondName = secondName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    @Parameters
    public static Object[][] getData(){
        return new Object[][]{
                {"Анджелина", "Джоли", "Белые пески, 5", "+79108893663"},
                {"Брэд", "Питт", "Белые пески, 5", "+79108894552"},
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
    public void checkTextQuestionOne() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickOrderButton();
        mainPage.enterName(name);
        mainPage.enterSecondName(secondName);
        mainPage.enterAddress(address);
        mainPage.enterPhoneNumber(phoneNumber);
        mainPage.clickFieldMetroStation();
        mainPage.clickFieldMetroStation();
        mainPage.clickFurtherButton();
    }

    @After
    public void TearDown(){
        driver.quit();
    }
}

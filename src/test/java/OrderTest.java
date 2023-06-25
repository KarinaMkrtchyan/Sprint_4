import io.github.bonigarcia.wdm.WebDriverManager;
import model.MainPage;
import model.RentInfoPage;
import model.UserInfoPage;
import org.junit.After;
import org.junit.Assert;
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
    private final boolean isButtonTop;
    private final String name;
    private final String secondName;
    private final String address;
    private final String phoneNumber;
    private final String orderDate;
    private final String comment;

    public OrderTest (boolean isButtonTop, String name, String secondName, String address, String phoneNumber, String orderDate, String comment){
        this.isButtonTop = isButtonTop;
        this.name = name;
        this.secondName = secondName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.orderDate = orderDate;
        this.comment = comment;
    }
    @Parameters
    public static Object[][] getData(){
        return new Object[][]{
                {true, "Анджелина", "Джоли", "Белые пески, 5", "+79108893663", "07.07.2023", "Домофон не работает, звоните на телефон"},
                {false, "Брэд", "Питт", "Белые пески, 5", "+79108894552", "07.07.2023", ""},
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
        mainPage.clickOrderButton(isButtonTop);
        UserInfoPage userInfoPage = new UserInfoPage(driver);
        userInfoPage.enterName(name);
        userInfoPage.enterSecondName(secondName);
        userInfoPage.enterAddress(address);
        userInfoPage.enterPhoneNumber(phoneNumber);
        userInfoPage.enterMetroStation();
        userInfoPage.clickFurtherButton();
        RentInfoPage rentInfoPage = new RentInfoPage(driver);
        rentInfoPage.enterDate(orderDate);
        rentInfoPage.enterDuration();
        rentInfoPage.chooseColour();
        rentInfoPage.addComment(comment);
        rentInfoPage.makeAnOrder();
        rentInfoPage.confirmOrder();
        Assert.assertTrue(rentInfoPage.checkSuccessOfTheOrder());
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}

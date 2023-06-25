package model;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RentInfoPage {
    public static final By DATE_FIELD = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    public static final By  DURATION_DROPDOWN = By.xpath(".//span[@class = 'Dropdown-arrow']");
    public static final By  GREY_COLOUR_SCOOTER = By.id("grey");
    public static final By  COMMENT_FIELD = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
    public static final By  ORDER_BUTTON = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    public static final By CONFIRMATION_BUTTON = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");
    public static final By ORDER_DONE = By.xpath(".//div[text() = 'Заказ оформлен']");
    private final WebDriver driver;
    public RentInfoPage(WebDriver driver) {
        this.driver = driver;
    }
    public void enterDate(String rentDate) {
        driver.findElement(DATE_FIELD).sendKeys(rentDate);
    }
    public void enterDuration() {
        driver.findElement(DURATION_DROPDOWN).click();
        driver.findElement(By.xpath(".//*[text() = 'четверо суток']")).click();
    }
    public void chooseColour() {
        driver.findElement(GREY_COLOUR_SCOOTER).click();
    }
    public void addComment(String comment) {
        driver.findElement(COMMENT_FIELD).sendKeys(comment);
    }
    public void makeAnOrder() {
        driver.findElement(ORDER_BUTTON).click();
    }
    public void confirmOrder() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(CONFIRMATION_BUTTON));
        driver.findElement(CONFIRMATION_BUTTON).click();
    }
    public boolean checkSuccessOfTheOrder() {
        WebElement orderIsDone = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(ORDER_DONE));
        return orderIsDone.isDisplayed();
    }

}

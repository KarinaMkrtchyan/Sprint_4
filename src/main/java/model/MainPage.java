package model;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPage {
    private static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    private static final By QUESTIONS_ABOUT_IMPORTANT = By.xpath("/html/body/div/div/div/div[5]");
    private static final By CREATE_ORDER_BUTTON_TOP = By.xpath(".//button[@class = 'Button_Button__ra12g']");
    public static final By CREATE_ORDER_BUTTON_BOTTOM = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    private static final By CHECK_STATUS_ORDER_BUTTON = By.xpath("//button[@class=\"Header_Link__1TAG7\"]");
    private static final By ORDER_NUMBER_INPUT_FIELD = By.xpath(".//input[@placeholder=\"Введите номер заказа\"]");
    private static final By GO_BUTTON = By.xpath(".//button[@class=\"Button_Button__ra12g Header_Button__28dPO\"]");
    private static final By NOT_FOUND_IMAGE = By.cssSelector("div.Track_NotFound__6oaoY > img");

    private final WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(PAGE_URL);
    }

    public void scrollToQuestions() {
        driver.findElement(QUESTIONS_ABOUT_IMPORTANT);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(QUESTIONS_ABOUT_IMPORTANT));
    }

    public void checkAnswer(String number) {
        driver.findElement(By.id("accordion__heading-" + number)).click();
        driver.findElement(By.id("accordion__panel-" + number)).isDisplayed();
    }

    public void clickOrderButton(boolean isButtonTop) {
        if (isButtonTop) {
            driver.findElement(CREATE_ORDER_BUTTON_TOP).click();
        } else {
            driver.findElement(CREATE_ORDER_BUTTON_BOTTOM);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(CREATE_ORDER_BUTTON_BOTTOM));
            driver.findElement(CREATE_ORDER_BUTTON_BOTTOM).click();
        }
    }

    public void clickCheckOrderButton(){
        driver.findElement(CHECK_STATUS_ORDER_BUTTON).click();
    }

    public void enterOrderNumber(String orderNumber) {
        WebElement inputField = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(ORDER_NUMBER_INPUT_FIELD));
        inputField.sendKeys(orderNumber);
    }

    public void clickGoButton() {
        driver.findElement(GO_BUTTON).click();
    }

    public boolean isImageNotFoundDisplayed() {
        WebElement NotFoundImage = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(NOT_FOUND_IMAGE));
        return NotFoundImage.isDisplayed();
    }

}

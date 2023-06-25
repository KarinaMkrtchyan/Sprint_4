package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserInfoPage {
    private static final By NAME_INPUT_FIELD = By.xpath(".//input[@placeholder=\"* Имя\"]");
    private static final By SECOND_NAME_INPUT_FIELD = By.xpath(".//input[@placeholder=\"* Фамилия\"]");
    private static final By ADDRESS_INPUT_FIELD = By.xpath(".//input[@placeholder=\"* Адрес: куда привезти заказ\"]");
    private static final By PHONE_NUMBER_INPUT_FIELD = By.xpath(".//input[@placeholder=\"* Телефон: на него позвонит курьер\"]");
    private static final By METRO_STATION_FIELD = By.xpath(".//input[@placeholder = '* Станция метро']");
    private static final By ONWARDS_BUTTON = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button");

    private final WebDriver driver;
    public UserInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterName(String name) {
        WebElement inputField = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(NAME_INPUT_FIELD));
        inputField.sendKeys(name);
    }

    public void enterSecondName(String secondName) {
        WebElement inputField = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(SECOND_NAME_INPUT_FIELD));
        inputField.sendKeys(secondName);
    }

    public void enterAddress(String address) {
        WebElement inputField = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(ADDRESS_INPUT_FIELD));
        inputField.sendKeys(address);
    }

    public void enterPhoneNumber(String phoneNumber) {
        WebElement inputField = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(PHONE_NUMBER_INPUT_FIELD));
        inputField.sendKeys(phoneNumber);
    }
    public void enterMetroStation() {
        driver.findElement(METRO_STATION_FIELD).click();
        driver.findElement(By.xpath(".//*[text()='Лубянка']")).click();
    }

    public void clickFurtherButton(){
        driver.findElement(ONWARDS_BUTTON).click();
    }
}

package model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//Главная страница сайта
public class MainPage {
    private static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    //Адрес сайта
    private static final By QUESTIONS_ABOUT_IMPORTANT = By.xpath("/html/body/div/div/div/div[5]");
    //раздел [Вопросы о важном]
    private static final By ORDER_BUTTON = By.xpath("/html/body/div/div/div/div[1]/div[2]/button[1]");
    //кнопка [Заказать]
    private static final By NAME_INPUT_FIELD = By.xpath(".//input[@placeholder=\"* Имя\"]");
    //Поле для ввода имени
    private static final By SECOND_NAME_INPUT_FIELD = By.xpath(".//input[@placeholder=\"* Фамилия\"]");
    //Поле для ввода фамилии
    private static final By ADDRESS_INPUT_FIELD = By.xpath(".//input[@placeholder=\"* Адрес: куда привезти заказ\"]");
    //Поле для ввода адреса
    private static final By PHONE_NUMBER_INPUT_FIELD = By.xpath(".//input[@placeholder=\"* Телефон: на него позвонит курьер\"]");
    //Поле для ввода номера телефона
    private static final By METRO_STATION_FIELD = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/div/div/input");
    //Поле для выбора станции метро
    private static final By ONWARDS_BUTTON = By.xpath("/html/body/div/div/div[2]/div[3]/button");
    //Кнопка [Далее]
    private static final By CHECK_STATUS_ORDER_BUTTON = By.xpath("//button[@class=\"Header_Link__1TAG7\"]");
    //Кнопка "Статус заказа"
    private static final By ORDER_NUMBER_INPUT_FIELD = By.xpath(".//input[@placeholder=\"Введите номер заказа\"]");
    //Поле для ввода номера заказа
    private static final By GO_BUTTON = By.xpath(".//button[@class=\"Button_Button__ra12g Header_Button__28dPO\"]");
    //Кнопка "Go" для статуса заказа
    private static final By NOT_FOUND_IMAGE = By.cssSelector("div.Track_NotFound__6oaoY > img");
    //Информационное сообщение "Такого заказа нет"

    private final WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Открыть страницу:
    public void open() {
        driver.get(PAGE_URL);
    }

    //Прокрутить страницу до раздела [Вопросы о важном]:
    public void scrollToQuestions() {
        driver.findElement(QUESTIONS_ABOUT_IMPORTANT);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(QUESTIONS_ABOUT_IMPORTANT));
    }

    // Кликнуть на кнопку [Заказать]:
    public void clickOrderButton(){
        driver.findElement(ORDER_BUTTON).click();
    }

    //Ввести имя:
    public void enterName(String name) {
        WebElement inputField = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(NAME_INPUT_FIELD));
        inputField.sendKeys(name);
    }

    //Ввести фамилию:
    public void enterSecondName(String secondName) {
        WebElement inputField = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(SECOND_NAME_INPUT_FIELD));
        inputField.sendKeys(secondName);
    }

    //Ввести адрес:
    public void enterAddress(String address) {
        WebElement inputField = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(ADDRESS_INPUT_FIELD));
        inputField.sendKeys(address);
    }

    //Ввести номер телефона:
    public void enterPhoneNumber(String phoneNumber) {
        WebElement inputField = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(PHONE_NUMBER_INPUT_FIELD));
        inputField.sendKeys(phoneNumber);
    }

    //Кликнуть на поле [Станция метро]:
    public void clickFieldMetroStation() {
        driver.findElement(METRO_STATION_FIELD).click();
    }

    //Кликнуть на кнопку [Далее]:
    public void clickFurtherButton(){
        driver.findElement(ONWARDS_BUTTON).click();
    }

    // Кликнуть на кнопку [Статус заказа]:
    public void clickCheckOrderButton(){
        driver.findElement(CHECK_STATUS_ORDER_BUTTON).click();
    }

    //Ввести номер заказа:
    public void enterOrderNumber(String orderNumber) {
        WebElement inputField = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(ORDER_NUMBER_INPUT_FIELD));
        inputField.sendKeys(orderNumber);
    }

    //Кликнуть на кнопку [Go]:
    public void clickGoButton() {
        driver.findElement(GO_BUTTON).click();
    }

    //Проверить, что отображается информационное окно:
    public boolean isImageNotFoundDisplayed() {
        WebElement NotFoundImage = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(NOT_FOUND_IMAGE));
        return NotFoundImage.isDisplayed();
    }

}

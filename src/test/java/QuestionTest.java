import io.github.bonigarcia.wdm.WebDriverManager;
import model.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


@RunWith(Parameterized.class)

public class QuestionTest {
    private WebDriver driver;
    private static final By QUESTION_ONE = By.id("accordion__heading-0");
    private static final By ANSWER_ONE = By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[1]/div[2]/p");
    private static final By QUESTION_TWO = By.id("accordion__heading-1");
    private static final By ANSWER_TWO = By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[2]/div[2]/p");
    private static final By QUESTION_THREE = By.id("accordion__heading-2");
    private static final By ANSWER_THREE = By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[3]/div[2]/p");
    private static final By QUESTION_FOUR = By.id("accordion__heading-3");
    private static final By ANSWER_FOUR = By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[4]/div[2]/p");
    private static final By QUESTION_FIVE = By.id("accordion__heading-4");
    private static final By ANSWER_FIVE = By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[5]/div[2]/p");
    private static final By QUESTION_SIX = By.id("accordion__heading-5");
    private static final By ANSWER_SIX = By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[6]/div[2]/p");
    private static final By QUESTION_SEVEN = By.id("accordion__heading-6");
    private static final By ANSWER_SEVEN = By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[7]/div[2]/p");
    private static final By QUESTION_EIGHT = By.id("accordion__heading-7");
    private static final By ANSWER_EIGHT = By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[8]/div[2]/p");


    private final By questionNumber;
    private final By answerNumber;
    private final String expectedText;

    public QuestionTest (By questionNumber, By answerNumber, String expectedText) {
        this.questionNumber = questionNumber;
        this.answerNumber = answerNumber;
        this.expectedText = expectedText;
    }

    public void clickQuestion() {
        driver.findElement(questionNumber).click();
    }

    public String getTextCorrect() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(answerNumber));
        String text = driver.findElement(answerNumber).getText();
        System.out.println(text);
        return text;
    }


    @Parameters
    public static Object[][] getData(){
        return new Object[][]{
                {QUESTION_ONE, ANSWER_ONE, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {QUESTION_TWO, ANSWER_TWO, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {QUESTION_THREE, ANSWER_THREE, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {QUESTION_FOUR, ANSWER_FOUR, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {QUESTION_FIVE, ANSWER_FIVE, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {QUESTION_SIX, ANSWER_SIX, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {QUESTION_SEVEN, ANSWER_SEVEN, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {QUESTION_EIGHT, ANSWER_EIGHT, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
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
        MainPage mainPage = new MainPage(driver); //
        mainPage.open();
        mainPage.scrollToQuestions();
        clickQuestion();
        String text = getTextCorrect();
        Assert.assertEquals(expectedText, text);
    }

    @After
    public void TearDown(){
        driver.quit();
    }
}
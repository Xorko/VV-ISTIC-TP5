package fr.istic.vv.tp5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class PollPageTest {

    @Test
    void test() throws InterruptedException {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(option);

        driver.get("http://localhost/answer/qayGhL8nLL3W2U0FQBCXUQ8x");

        PollPage pollPage = new PollPage(driver);

        pollPage.setName("John Doe");

        pollPage.setEmail("john.doe@mail.fr");

        pollPage.pressIcsFlowAccessibleButton();

        pollPage.setCalendarView();

        pollPage.selectCalendarViewDateOptions();

        pollPage.setTableView();

        pollPage.selectTableViewDateOptions();

        pollPage.pressSubmitButton();

        pollPage.setPollCommentAuthor("John Doe");

        pollPage.setPollComment("This is a comment");

        pollPage.pressAddCommentButton();


        Thread.sleep(1000);

        driver.quit();
    }

}
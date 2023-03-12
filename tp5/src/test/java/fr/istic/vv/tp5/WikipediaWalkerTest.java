package fr.istic.vv.tp5;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.util.concurrent.TimeUnit.SECONDS;

public class WikipediaWalkerTest {

    private static final String WIKIPEDIA_URL = "https://en.wikipedia.org/wiki/Main_Page";
    private static final String LINK_XPATH_SELECTOR = "//main//a[starts-with(@href, '/wiki/') and not(@disabled)]";

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        Configuration.browserCapabilities = options;

        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open(WIKIPEDIA_URL);
        getWebDriver().manage().timeouts().implicitlyWait(Duration.of(10, SECONDS.toChronoUnit()));
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    private SelenideElement getRandomLinkElement() {
        ElementsCollection links = $$x(LINK_XPATH_SELECTOR);
        
        int randomIndex = new Random().nextInt(links.size());

        return links.get(randomIndex);
    }

    private void takeScreenshot(String fileName) {
        File screenshot = Screenshots.takeScreenShotAsFile();

        try {
            FileUtils.copyFile(screenshot, new File("/tmp/" + fileName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void clickOnRandomLink10Times() {
        for (int i = 0; i < 10; i++) {
            takeScreenshot("screenshot_" + i);

            SelenideElement linkToClick = getRandomLinkElement();

            JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
            js.executeScript("arguments[0].style.visibility='visible'; arguments[0].click();", linkToClick);

            try {
                if (linkToClick.isDisplayed() && linkToClick.isEnabled()) {
                    linkToClick.click();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("Titre de la page : " + title());
        }
    }
}

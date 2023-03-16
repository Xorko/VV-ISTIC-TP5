package fr.istic.vv.tp5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertFalse;

class BugTest {

    @Test
    void test() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(option);

        // Adapt the url to your needs
        driver.get("http://localhost/create");


        // It should be impossible to go to the second page if the first page is not filled
        By secondPageButton = By.xpath("//a[span[contains(text(), 'Choix de la date')]]");
        driver.findElement(secondPageButton).click();

        boolean isSecondPage = driver.findElement(By.xpath("//li[a[span[contains(text(), 'Choix de la date')]]]")).isSelected();

        // The test fails because the second page is accessible
        assertFalse(isSecondPage);
    }
}

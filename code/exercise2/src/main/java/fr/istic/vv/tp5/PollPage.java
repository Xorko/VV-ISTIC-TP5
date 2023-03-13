package fr.istic.vv.tp5;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PollPage {
    WebDriver driver;

    public PollPage(WebDriver driver) {
        this.driver = driver;
    }

    By name = By.id("name");

    By email = By.id("email");

    By icsFlowAccessibleButton = By.id("icsFlow");

    By culinaryPreference = By.id("foodPreference");

    By calendarView = By.id("calendarView");

    By tableView = By.id("tableView");

    By dateOptionsCheckbox = By.id("dateOptions");

    By submitButton = By.id("submit");

    By authorComment = By.id("authorComment");

    By commentAuthor = By.id("commentAuthor");

    By comment = By.id("comment");

    public void setName(String name) {
        driver.findElement(this.name).sendKeys(name);
    }

    public void setEmail(String email) {
        driver.findElement(this.email).sendKeys(email);
    }

    public void setIcsFlowAccessibleButton() {
        driver.findElement(this.icsFlowAccessibleButton).click();
    }

    public void setCulinaryPreference() {
        driver.findElement(this.culinaryPreference).click();
    }

    public void setCalendarView() {
        driver.findElement(this.calendarView).click();
    }

    public void setTableView() {
        driver.findElement(this.tableView).click();
    }

    public void setDateOptionsCheckbox() {
        driver.findElement(this.dateOptionsCheckbox).click();
    }

    public void setSubmitButton() {
        driver.findElement(this.submitButton).click();
    }

    public void setAuthorComment(String authorComment) {
        driver.findElement(this.authorComment).sendKeys(authorComment);
    }

    public void setCommentAuthor(String commentAuthor) {
        driver.findElement(this.commentAuthor).sendKeys(commentAuthor);
    }

    public void setComment(String comment) {
        driver.findElement(this.comment).sendKeys(comment);
    }

    public void submit() {
        driver.findElement(this.submitButton).click();
    }

}

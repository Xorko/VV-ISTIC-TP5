package fr.istic.vv.tp5;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PollPage {
    WebDriver driver;

    public PollPage(WebDriver driver) {
        this.driver = driver;
    }

    By name = By.id("nom");

    By email = By.id("mail");

    By icsFlowAccessibleButton = By.className("p-inputswitch-slider");

    By calendarView = By.xpath("//div[i[contains(text(), 'Vue Calendrier')]]");

    By calendarViewDateOptions = By.xpath("//div[@class='fc-event-time']");

    By tableView = By.xpath("//div[i[contains(text(), 'Vue Tableau')]]");

    By tableViewDateOptions = By.xpath("(//div[@class='p-checkbox-box'])[1]");

    By submitButton = By.xpath("//span[contains(text(), 'Soumettre voeux')]");

    By pollCommentAuthor = By.id("comment");

    By pollComment = By.id("commentdesc");

    // get span containing the text "Ajouter un commentaire"
    By addCommentButton = By.xpath("//span[contains(text(), 'Ajouter commentaire')]");

    public void setName(String name) {
        driver.findElement(this.name).sendKeys(name);
    }

    public void setEmail(String email) {
        driver.findElement(this.email).sendKeys(email);
    }

    public void pressIcsFlowAccessibleButton() {
        driver.findElement(this.icsFlowAccessibleButton).click();
    }

    public void setCalendarView() {
        driver.findElement(this.calendarView).click();
    }

    public void selectCalendarViewDateOptions() {
        driver.findElement(this.calendarViewDateOptions).click();
    }

    public void setTableView() {
        driver.findElement(this.tableView).click();
    }

    public void selectTableViewDateOptions() {
        driver.findElement(this.tableViewDateOptions).click();
    }

    public void pressSubmitButton() {
        driver.findElement(this.submitButton).click();
    }

    public void setPollCommentAuthor(String pollCommentAuthor) {
        driver.findElement(this.pollCommentAuthor).sendKeys(pollCommentAuthor);
    }

    public void setPollComment(String pollComment) {
        driver.findElement(this.pollComment).sendKeys(pollComment);
    }

    public void pressAddCommentButton() {
        driver.findElement(this.addCommentButton).click();
    }

}

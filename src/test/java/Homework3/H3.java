package Homework3;
import io.github.bonigarcia.wdm.WebDriverManager;
import javafx.scene.web.WebEngine;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class H3 {

    public static void main(String[] args) throws InterruptedException {

        /*SRB - Ulogujte se na demoqa preko cookies-a, dodati dve knjige na svoj nalog,
        zatim se izlogovati brisanjem cookies-a. Ulogovati se ponovo preko log-in forme i potvrditi
        da se knjige i dalje nalaze na nalogu.*/

        /*ENG - Log in to demoqa using cookies, add two books to your account,
        then log out by deleting the cookies. Log in again through the login form and
        confirm that the books are still on the account.*/

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/login");

        Cookie userID = new Cookie("userID", "52c83e70-8ec1-42fb-85c7-8ae3cfa10e19");
        Cookie expires = new Cookie("expires", "2023-01-24T16%3A39%3A15.008Z");
        Cookie token = new Cookie("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6ImlyaW5haG90b21za2kiLCJwYXNzd29yZCI6IkBQb21vcmFuZHplMTIzIiwiaWF0IjoxNjczOTg4NDIxfQ.trp9PkEZKe4Cw-kRJKrMHBzp08OHcf_4YKG9r1poPnU");

        driver.manage().addCookie(userID);
        driver.manage().addCookie(expires);
        driver.manage().addCookie(token);

        driver.navigate().refresh();

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript ("scroll(0, 1000)");

        List<WebElement> button = driver.findElements(By.className("text"));
        for (int i = 0; i < button.size(); i++) {
            if (button.get(i).getText().equals("Book Store")) {
                button.get(i).click();
                break;
            }
        }

        jse.executeScript ("scroll(0, 200)");
        wait.until((ExpectedConditions.presenceOfElementLocated(By.id("see-book-Git Pocket Guide"))));
        wait.until((ExpectedConditions.elementToBeClickable(driver.findElement(By.id("see-book-Git Pocket Guide")))));
        WebElement book1 = driver.findElement(By.id("see-book-Git Pocket Guide"));
        book1.click();

        jse.executeScript ("scroll(0, 1000)");
        List<WebElement> addButton = driver.findElements(By.id("addNewRecordButton"));
        for (int i = 0; i < addButton.size(); i++) {
            if (addButton.get(i).getText().equals("Add To Your Collection")) {
                addButton.get(i).click();
                break;
            }
        }

        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        wait.until((ExpectedConditions.presenceOfElementLocated(By.id("addNewRecordButton"))));
        wait.until((ExpectedConditions.elementToBeClickable(driver.findElement(By.id("addNewRecordButton")))));
        List<WebElement> backButton = driver.findElements(By.id("addNewRecordButton"));
        for (int i = 0; i < backButton.size(); i++) {
            if (backButton.get(i).getText().equals("Back To Book Store")) {
                backButton.get(i).click();
                break;
            }
        }

        WebElement book2 = driver.findElement(By.id("see-book-Learning JavaScript Design Patterns"));
        book2.click();
        jse.executeScript ("scroll(0, 1000)");

        List<WebElement> addButton1 = driver.findElements(By.id("addNewRecordButton"));
        for (int i = 0; i < addButton1.size(); i++) {
            if (addButton1.get(i).getText().equals("Add To Your Collection")) {
                addButton1.get(i).click();
                break;
            }
        }

        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        wait.until((ExpectedConditions.presenceOfElementLocated(By.id("addNewRecordButton"))));
        wait.until((ExpectedConditions.elementToBeClickable(driver.findElement(By.id("addNewRecordButton")))));
        List<WebElement> backButton1 = driver.findElements(By.id("addNewRecordButton"));
        for (int i = 0; i < backButton1.size(); i++) {
            if (backButton1.get(i).getText().equals("Back To Book Store")) {
                backButton1.get(i).click();
                break;
            }
        }

        driver.manage().deleteCookie(userID);
        driver.manage().deleteCookie(expires);
        driver.manage().deleteCookie(token);

        driver.navigate().refresh();
        Thread.sleep(2000);
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();

        jse.executeScript ("scroll(0, 200)");
        WebElement username = driver.findElement(By.id("userName"));
        username.sendKeys("irinahotomski");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("@Pomorandze123");
        WebElement login = driver.findElement(By.id("login"));
        login.click();

        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.className("action-buttons")).isDisplayed());
    }

}

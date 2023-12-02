package Homework4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class H4 {

    /*SRB - Napraviti testove koristeci anotacije, u prvom testu se dodaje jedna knjiga,
    u drugom dve, u trecem tri, itd.*/

    /*ENG - Create tests using annotations. In the first test, add one book, in the second test,
    add two books, in the third test, add three books, and so on.*/

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor jse;

    @BeforeClass
    public void setup (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        jse = (JavascriptExecutor) driver;
        driver.navigate().to("https://demoqa.com/login");
    }

    @BeforeMethod
    public void pocetak (){
        WebElement username = driver.findElement(By.id("userName"));
        username.sendKeys("irinahotomski");
        WebElement password = driver.findElement(By.id("password"));
        jse.executeScript("scroll(0,200)");
        password.sendKeys("@Pomorandze123");
        WebElement login = driver.findElement(By.id("login"));
        login.click();
    }

    @Test
    public void book1 () throws InterruptedException {
        Thread.sleep(2000);
        jse.executeScript ("scroll(0, 1000)");
        List<WebElement> bookStoreButton = driver.findElements(By.className("text"));
        for (int i = 0; i < bookStoreButton.size(); i++) {
            if (bookStoreButton.get(i).getText().equals("Book Store")) {
                bookStoreButton.get(i).click();
                break;
            }
        }

        wait.until((ExpectedConditions.presenceOfElementLocated(By.id("see-book-Git Pocket Guide"))));
        wait.until((ExpectedConditions.elementToBeClickable(driver.findElement(By.id("see-book-Git Pocket Guide")))));
        WebElement book1 = driver.findElement(By.id("see-book-Git Pocket Guide"));
        book1.click();
        Thread.sleep(2000);
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

        List<WebElement> profileButton = driver.findElements(By.className("text"));
        for (int i = 0; i < profileButton.size(); i++) {
            if (profileButton.get(i).getText().equals("Profile")) {
                profileButton.get(i).click();
                break;
            }
        }

        Thread.sleep(2000);
        WebElement knjiga1 = driver.findElement(By.id("see-book-Git Pocket Guide"));
        Assert.assertTrue(knjiga1.isDisplayed());
    }

    @Test
    public void book2 () throws InterruptedException {
        Thread.sleep(2000);
        jse.executeScript ("scroll(0, 1000)");

        List<WebElement> bookStoreButton = driver.findElements(By.className("text"));
        for (int i = 0; i < bookStoreButton.size(); i++) {
            if (bookStoreButton.get(i).getText().equals("Book Store")) {
                bookStoreButton.get(i).click();
                break;
            }
        }

        wait.until((ExpectedConditions.presenceOfElementLocated(By.id("see-book-Git Pocket Guide"))));
        wait.until((ExpectedConditions.elementToBeClickable(driver.findElement(By.id("see-book-Git Pocket Guide")))));
        WebElement book1 = driver.findElement(By.id("see-book-Git Pocket Guide"));
        book1.click();
        Thread.sleep(2000);
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

        List<WebElement> backButton = driver.findElements(By.id("addNewRecordButton"));
        for (int i = 0; i < backButton.size(); i++) {
            if (backButton.get(i).getText().equals("Back To Book Store")) {
                backButton.get(i).click();
                break;
            }
        }

        Thread.sleep(2000);
        jse.executeScript ("scroll(0, 1000)");
        wait.until((ExpectedConditions.presenceOfElementLocated(By.id("see-book-Learning JavaScript Design Patterns"))));
        wait.until((ExpectedConditions.elementToBeClickable(driver.findElement(By.id("see-book-Learning JavaScript Design Patterns")))));
        WebElement book2 = driver.findElement(By.id("see-book-Learning JavaScript Design Patterns"));
        book2.click();
        Thread.sleep(2000);
        jse.executeScript ("scroll(0, 1000)");

        List<WebElement> addButton2 = driver.findElements(By.id("addNewRecordButton"));
        for (int i = 0; i < addButton2.size(); i++) {
            if (addButton2.get(i).getText().equals("Add To Your Collection")) {
                addButton2.get(i).click();
                break;
            }
        }

        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        List<WebElement> profileButton = driver.findElements(By.cssSelector(".btn.btn-light "));
        for (int i = 0; i < profileButton.size(); i++) {
            if (profileButton.get(i).getText().equals("Profile")) {
                profileButton.get(i).click();
                break;
            }
        }

        Thread.sleep(2000);
        WebElement knjiga1 = driver.findElement(By.id("see-book-Git Pocket Guide"));
        Assert.assertTrue(knjiga1.isDisplayed());
        WebElement knjiga2 = driver.findElement(By.id("see-book-Learning JavaScript Design Patterns"));
        Assert.assertTrue(knjiga2.isDisplayed());
    }

    @Test
    public void book3 () throws InterruptedException {
        Thread.sleep(2000);
        jse.executeScript("scroll(0, 1000)");

        List<WebElement> bookStoreButton = driver.findElements(By.className("text"));
        for (int i = 0; i < bookStoreButton.size(); i++) {
            if (bookStoreButton.get(i).getText().equals("Book Store")) {
                bookStoreButton.get(i).click();
                break;
            }
        }

        wait.until((ExpectedConditions.presenceOfElementLocated(By.id("see-book-Git Pocket Guide"))));
        wait.until((ExpectedConditions.elementToBeClickable(driver.findElement(By.id("see-book-Git Pocket Guide")))));
        WebElement book1 = driver.findElement(By.id("see-book-Git Pocket Guide"));
        book1.click();
        Thread.sleep(2000);
        jse.executeScript("scroll(0, 1000)");

        List<WebElement> addButton = driver.findElements(By.id("addNewRecordButton"));
        for (int i = 0; i < addButton.size(); i++) {
            if (addButton.get(i).getText().equals("Add To Your Collection")) {
                addButton.get(i).click();
                break;
            }
        }

        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        List<WebElement> backButton = driver.findElements(By.id("addNewRecordButton"));
        for (int i = 0; i < backButton.size(); i++) {
            if (backButton.get(i).getText().equals("Back To Book Store")) {
                backButton.get(i).click();
                break;
            }
        }

        Thread.sleep(2000);
        jse.executeScript("scroll(0, 1000)");
        wait.until((ExpectedConditions.presenceOfElementLocated(By.id("see-book-Learning JavaScript Design Patterns"))));
        wait.until((ExpectedConditions.elementToBeClickable(driver.findElement(By.id("see-book-Learning JavaScript Design Patterns")))));
        WebElement book2 = driver.findElement(By.id("see-book-Learning JavaScript Design Patterns"));
        book2.click();
        Thread.sleep(2000);
        jse.executeScript("scroll(0, 1000)");

        List<WebElement> addButton2 = driver.findElements(By.id("addNewRecordButton"));
        for (int i = 0; i < addButton2.size(); i++) {
            if (addButton2.get(i).getText().equals("Add To Your Collection")) {
                addButton2.get(i).click();
                break;
            }
        }

        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        List<WebElement> backButton1 = driver.findElements(By.id("addNewRecordButton"));
        for (int i = 0; i < backButton1.size(); i++) {
            if (backButton1.get(i).getText().equals("Back To Book Store")) {
                backButton1.get(i).click();
                break;
            }
        }

        Thread.sleep(2000);
        jse.executeScript("scroll(0, 1000)");
        wait.until((ExpectedConditions.presenceOfElementLocated(By.id("see-book-Designing Evolvable Web APIs with ASP.NET"))));
        wait.until((ExpectedConditions.elementToBeClickable(driver.findElement(By.id("see-book-Designing Evolvable Web APIs with ASP.NET")))));
        WebElement book3 = driver.findElement(By.id("see-book-Designing Evolvable Web APIs with ASP.NET"));
        book3.click();
        Thread.sleep(2000);
        jse.executeScript("scroll(0, 1000)");

        List<WebElement> addButton3 = driver.findElements(By.id("addNewRecordButton"));
        for (int i = 0; i < addButton3.size(); i++) {
            if (addButton3.get(i).getText().equals("Add To Your Collection")) {
                addButton3.get(i).click();
                break;
            }
        }

        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        List<WebElement> profileButton = driver.findElements(By.cssSelector(".btn.btn-light "));
        for (int i = 0; i < profileButton.size(); i++) {
            if (profileButton.get(i).getText().equals("Profile")) {
                profileButton.get(i).click();
                break;
            }
        }

        Thread.sleep(2000);
        WebElement knjiga1 = driver.findElement(By.id("see-book-Git Pocket Guide"));
        Assert.assertTrue(knjiga1.isDisplayed());
        WebElement knjiga2 = driver.findElement(By.id("see-book-Learning JavaScript Design Patterns"));
        Assert.assertTrue(knjiga2.isDisplayed());
    }

    @AfterMethod
    public void kraj (){
        jse.executeScript ("scroll(0, 1000)");

        List<WebElement> deleteButton = driver.findElements(By.id("submit"));
        for (int i = 0; i < deleteButton.size(); i++) {
            if (deleteButton.get(i).getText().equals("Delete All Books")) {
                deleteButton.get(i).click();
                break;
            }
        }

        WebElement ok = driver.findElement(By.id("closeSmallModal-ok"));
        ok.click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        jse.executeScript ("scroll(1000, 0)");

        List<WebElement> logoutButton = driver.findElements(By.id("submit"));
        for (int i = 0; i < logoutButton.size(); i++) {
            if (logoutButton.get(i).getText().equals("Log out")) {
                logoutButton.get(i).click();
                break;
            }
        }
    }

    @AfterClass
    public void terminate (){
        driver.quit();
    }

}

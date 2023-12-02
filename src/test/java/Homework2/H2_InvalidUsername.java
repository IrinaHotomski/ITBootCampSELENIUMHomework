package Homework2;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class H2_InvalidUsername {

    public static void main(String[] args) {

        //SRB - Pokriti sve negativne case-eve za login i napraviti posebnu klasu za svaki case gde ne prolazi log-in.
        //ENG - Cover all negative cases for login and create a separate class for each case where the login fails.


        //SRB - Pogreasan Username
        //ENG - Invalid Username

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practicetestautomation.com/");

        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();

        WebElement testLoginPage = driver.findElement(By.linkText("Test Login Page"));
        testLoginPage.click();

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("pomorandze");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Password123");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement errorMessage = driver.findElement(By.id("error"));
        Assert.assertTrue(errorMessage.isDisplayed());

        String expectedURL = "https://practicetestautomation.com/practice-test-login/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        WebElement submitButton1 = driver.findElement(By.id("submit"));
        Assert.assertTrue(submitButton1.isDisplayed());

    }
}

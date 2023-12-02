package Homework1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class H1 {

    public static void main(String[] args) throws InterruptedException {

        //SRB - Otici na YouTube preko Google-a i pustiti pesmu po Vasem izboru.

        //ENG - Go to YouTube via Google and play one song of your choice.

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.google.com");
        WebElement searchBox = driver.findElement(By.className("gLFyf"));
        searchBox.sendKeys("youtube");
        searchBox.sendKeys(Keys.ENTER);

        WebElement YT = driver.findElement(By.cssSelector(".LC20lb.MBeuO.DKV0Md"));
        YT.click();

        Thread.sleep(3000);

        WebElement YTSearch = driver.findElement(By.name("search_query"));
        YTSearch.sendKeys("Stoja potopicu ovaj splav");
        YTSearch.sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        WebElement pesma = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-search/div[1]/ytd-two-column-search-results-renderer/div[2]/div/ytd-section-list-renderer/div[2]/ytd-item-section-renderer/div[3]/ytd-video-renderer[1]/div[1]/div/div[1]/div/h3/a/yt-formatted-string"));
        pesma.click();

    }
}

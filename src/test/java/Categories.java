import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Categories {

    @BeforeEach
    public void startBrowser() {
        // Junit library provides all the Test Beforeeach and aftereach etc
        WebDriverManager.chromedriver().setup();
        // ChromeDriver driver = new ChromeDriver();
        driver = new ChromeDriver();
        driver.get("https://www.tvnz.co.nz");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterEach

    public void quitBrowser() {
        driver.close();
        driver.quit();
    }
    WebDriver driver = null;   // globally declare

    @Test

    public void categoriesList() throws InterruptedException, IOException {

        Actions builder = new Actions(driver);
        WebElement categories = driver.findElement(By.xpath("//li[@id='Categories']"));
        // builder.clickAndHold(categories).perform();     /*** Experimenting the Actions method ***/
        // builder.contextClick(categories).perform();     /*** Experimenting the Actions method ***/




        builder.clickAndHold(categories).build().perform();
        builder.moveToElement(categories).build().perform();


        TakesScreenshot screenshot = (TakesScreenshot) driver ;
        screenshot.getScreenshotAs(OutputType.FILE);
        File scrFile = screenshot.getScreenshotAs(OutputType.FILE);
        File desFile = new File("/Users/rsingara/GitHub/target/test1.png");
        FileUtils.copyFile(scrFile,desFile);
        List<WebElement> categorieslist = driver.findElements(By.xpath("//li[@id='Categories']//div [@class='SiteNav-sub']/ul/li//a"));
        //li[@id='Categories']//div [@class='SiteNav-sub']/ul/li//a/span
        //li[@id='Categories']//div [@class='SiteNav-sub']/ul/li//a
        System.out.println(categorieslist.size());
        //System.out.println(categories.getAttribute("innerHTML"));

        for(WebElement e:categorieslist ) {
            builder.moveToElement(categorieslist.get(0)).build().perform();
            System.out.println(e.getText());
        }

    }
}

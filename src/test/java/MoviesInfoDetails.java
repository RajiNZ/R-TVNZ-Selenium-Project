import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MoviesInfoDetails {

    //on the movies belt -> Hover the mouse on any movie and find the synopsis,   or Click on the View mor

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
    public void hoverState() throws InterruptedException {


        Actions builder = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60), Duration.ofSeconds(5));
//         WebElement element = driver.findElement(By.xpath("//div[.='More movies']"));
//         wait.until(ExpectedConditions.elementToBeSelected(element));
        builder.moveToElement(driver.findElements(By.xpath("//h2[@id='anchor-Movies']/../../..//div[@class='swiper-wrapper']//a/div")).get(0)).build().perform();
        WebElement element = driver.findElement(By.xpath("//h2[@data-anchor='Movies']/../../..//span[@aria-label='Next slide']/div[@class='swiper-button-next swiper-no-swiping']"));
        wait.until(ExpectedConditions.elementToBeClickable(element));

        while (element.isDisplayed()) {
            element.click();
            Thread.sleep(1000);
        }

        List<WebElement> movies = driver.findElements(By.xpath("//h2[@id='anchor-Movies']/../../..//div[@class='swiper-wrapper']//a/div"));
        Thread.sleep(3000);
        for (WebElement e : movies) {
            System.out.println(e.getAttribute("id"));
        }
        Thread.sleep(3000);
        //    System.out.println(movies.get(0).getAttribute("innerHTML"));
        /*for (WebElement e : movies) {
            System.out.println(e.getAttribute("id"));
        }*/

    }


    @Test
    public void viewMoreTest() throws AWTException, InterruptedException {

        Actions builder = new Actions(driver);
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60), Duration.ofSeconds(5));
        List<WebElement> movies = driver.findElements(By.xpath("//h2[@id='anchor-Movies']/../../..//div[@class='swiper-wrapper']//a/div"));
        Thread.sleep(3000);
        //   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60), Duration.ofSeconds(5));
        builder.moveToElement(movies.get(1)).perform();
        Thread.sleep(3000);
        movies.get(1).getAttribute("innerHTML");
        // System.out.println(movies.get(1).getAttribute("innerHTML"));
        movies.get(1).findElement(By.cssSelector("div.QuickInfo-actions *> a.Button--primary")).click();
        driver.getCurrentUrl();
        driver.getTitle();
        Thread.sleep(3000);
        System.out.println("Print the View more current URL: " +driver.getCurrentUrl());
        System.out.println("Print the View more get Title : " + driver.getTitle());

    }



    @Test
    public void getSynopsis() throws InterruptedException {
        Actions builder = new Actions(driver);
        //   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60), Duration.ofSeconds(5));
        List<WebElement> movies = driver.findElements(By.xpath("//h2[@id='anchor-Movies']/../../..//div[@class='swiper-wrapper']//a/div"));

        Thread.sleep(3000);
        builder.moveToElement(movies.get(1)).perform();
        Thread.sleep(3000);
        System.out.println(movies.get(1).getAttribute("innerHTML"));
        WebElement synopsis = driver.findElement(By.cssSelector("div.QuickInfo-synopsis"));
        System.out.println("Print Synopsis: "  +synopsis.getText());

    }


    @Test

    public void contextClick() throws InterruptedException, IOException {

        Actions builder = new Actions(driver);
        //   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60), Duration.ofSeconds(5));
        List<WebElement> movies = driver.findElements(By.xpath("//h2[@id='anchor-Movies']/../../..//div[@class='swiper-wrapper']//a/div"));
        Thread.sleep(3000);
        builder.moveToElement(movies.get(1)).perform();
        Thread.sleep(3000);
        TakesScreenshot screenshot = (TakesScreenshot) driver ;
        screenshot.getScreenshotAs(OutputType.FILE);
        File scrFile = screenshot.getScreenshotAs(OutputType.FILE);
        File desFile = new File("/Users/rsingara/GitHub/target/test.png");

        FileUtils.copyFile(scrFile,desFile);
        //  movies.get(1).sendKeys(Keys.ESCAPE);



    }


}

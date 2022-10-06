import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TopPicksShowsTest {




    @BeforeEach

    public void startBrowser(){
        // Junit library provides all the Test Beforeeach and aftereach etc
        WebDriverManager.chromedriver().setup();
        // ChromeDriver driver = new ChromeDriver();
        driver = new ChromeDriver();
        driver.get("https://www.tvnz.co.nz");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterEach

    public void quitBrowser(){
        driver.close();
        driver.quit();

    }

    WebDriver driver = null;   // globally declare
    static String email = null;
    static String password = null;





    @Test

    public void showTopPicks() {


        List<WebElement> toppicksShows = driver.findElements(By.xpath("//h2[@data-anchor='TopPicks']/../../..//div[@class='swiper-wrapper']//a/div"));
        // List<WebElement> toppicksShows = driver.findElements(By.xpath("//h2[@data-anchor='TopPicks']/../../..//div[@class='ember-view']//a/div"));
        //Assertions.assertTrue(elements.size()>0,"Homepage Categories are displayed");

        for (WebElement e : toppicksShows) {
            String toppicksShowlist = e.getAttribute("id");
            System.out.println(toppicksShowlist);


        }
    }

}

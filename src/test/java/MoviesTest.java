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

public class MoviesTest {

    //Homework Task1 : Print movies from the movie belt on the homepage

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

    @Test

    public void moviesShows() throws InterruptedException {


       // List<WebElement> moviesBelt= driver.findElements(By.xpath("//h2[@id='anchor-Movies']/../../..//div[@id='ember818']//a/div"));
        List<WebElement> moviesBelt= driver.findElements(By.xpath("//h2[@id='anchor-Movies']/../../..//div[@class='swiper-wrapper']//a/div"));
        for (WebElement e: moviesBelt) {
            String allMoviesList = e.getAttribute("id");
            System.out.println(allMoviesList);
        }
    }

}

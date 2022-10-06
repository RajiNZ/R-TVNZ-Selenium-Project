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

public class LiveTVShowsTest {

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

        public void liveTVShows() throws InterruptedException {

            driver.findElement(By.xpath("//span[@title='Live TV & Guide']")).click();
            List<WebElement> liveshows = driver.findElements(By.xpath("//h1[@class='PageHeader-title']/../../../../../..//div[@class='Belt-body  ']/ul/li//div[@class='Tile-title u-mB-0']/span"));
            Thread.sleep(3000);
            for(WebElement e: liveshows){
                String allliveShows= e.getText();
                Thread.sleep(3000);
                System.out.println(allliveShows);
            }

        }

    }



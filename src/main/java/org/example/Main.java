package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.tvnz.co.nz");
        driver.manage().window().fullscreen();
        System.out.println("Landed on TVNZ Homepage in Chrome Browser");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // click on login method and enter user name

       // driver.findElement(By.linkText("Login")).click();

        driver.findElement(By.xpath(" //a[text()='Login']")).click();
        driver.manage().window().fullscreen();
        //a[text()='Login']
        driver.findElement(By.id("email")).sendKeys("playeruser@guerrillamail.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.close();  // closes the browser
        driver.quit();   // it is null means ready for Garbage collection

        /*WebDriverManager.firefoxdriver().setup();
        FirefoxDriver fdriver = new FirefoxDriver();
        fdriver.get("https://www.tvnz.co.nz");
        System.out.println("Landed on TVNZ Homepage in Firefox Browser ");*/
    }
}

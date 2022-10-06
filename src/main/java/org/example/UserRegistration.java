package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class UserRegistration {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.tvnz.co.nz");
        driver.manage().window().fullscreen();
        System.out.println("Landed on TVNZ Homepage in Chrome Browser");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Click New account for user Registration
        driver.findElement(By.xpath(" //a[text()='Login']")).click();
        driver.findElement(By.xpath("//span[text()='Sign up now']")).click();
        driver.manage().window().fullscreen();
        driver.findElement(By.id("email")).sendKeys("atestna@gmail.com");
     //   driver.findElement(By.xpath("//input[@id='email']")).sendKeys("atestna@gmail.com");
        driver.findElement((By.xpath("//input[@id='password']"))).sendKeys("Test123456789");
        driver.findElement((By.xpath("//input[@id='firstName']"))).sendKeys("Test-AccountOne");
        driver.findElement((By.xpath("//input[@id='lastName']"))).sendKeys("Test-TVNZ");
        driver.findElement((By.xpath("//button[@role='button'][1]//parent::div"))).click();
        driver.findElement((By.xpath("//div[@id='downshift-0-item-20']"))).click();
       /*  These two xpath works for gender */
        driver.findElement((By.xpath("//div[@name='gender']//following::button[1]"))).click();
        driver.findElement((By.xpath("//div[@id='gender']//following::div[1]"))).click();


        /* Below is different method */
       // driver.findElement((By.xpath("//label[@for='downshift-1-input']//following::button[1]"))).click();



        /* End of line is different method */

        driver.findElement(By.xpath("//span[contains(text(),'I agree to play')]")).click();
        driver.findElement(By.xpath("//input[@id='latestNews']//following::div[1]")).click();
        driver.findElement(By.xpath("//span[@class='Button-text']")).click();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.close();  // closes the browser
        driver.quit();   // it is null means ready for Garbage collection





        // driver.findElement((By.xpath("///div[@name='latestNews']//following::div[2]"))).click();
      //  driver.findElement((By.xpath("//input[@id='latestNews']"))).click();

        // this didn't work though -//div[contains(text(),'I don't want to miss out !')]
        ////div[@class='Checkbox-label']//following::div[2] - this didn't work


        ////label[@for='houseRules']//following::div[1]


//        driver.findElement((By.xpath("///span[text()='Year of birth']"))).click();
//        driver.findElement((By.xpath("//div[@id='downshift-0-item-18']"))).click();
       // driver.findElement((By.xpath("//button[@role='button'][2]//parent::div"))).click();











    }
}

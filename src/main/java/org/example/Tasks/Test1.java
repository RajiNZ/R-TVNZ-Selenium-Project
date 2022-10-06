package org.example.Tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


//Task2: Try all possible options - is displayed , clear , get accessible value etc submit submit methods etc

public class Test1 {


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
        WebElement emailElement = driver.findElement(By.id("email"));
        WebElement emailPrompt = driver.findElement(By.xpath("//label[@for='email']/span"));

        emailElement.sendKeys("atestna@gmail.com");
        //**********************************************Email Address *****************************************//

        boolean isShown = emailElement.isDisplayed();
        System.out.println("email Isdisplayed  true or false is : " +isShown);
        String emailtxt1 = emailElement.getAttribute("value");
        String emailtxt3 = emailElement.getAttribute("id");
        System.out.println("Email GetAttribute is : " +emailtxt3);


        String emailTxt2 = emailPrompt.getText();
        System.out.println("Email GetAttribute is : " +emailtxt1);
        System.out.println("Email getText is : " +emailTxt2);
        driver.findElement(By.id("email")).clear();
        String emailAName= emailElement.getAccessibleName();
        System.out.println("Email getAccessible Name is: " +emailAName);
        String ecssValColor= emailElement.getCssValue("color");

        System.out.println("Email cssvalue for color:" +ecssValColor);

        String ecssValFont= emailElement.getCssValue("font-size");
        System.out.println("Email cssvalue for font-size: " +ecssValFont);

        String ecssValFontStyle= emailElement.getCssValue("font-size");
        System.out.println("Email cssvalue for FontStyle: " +ecssValFontStyle);

        String ecssValtextStyle= emailElement.getCssValue("text");
        System.out.println("Email cssvalue for text: " +ecssValtextStyle);
        //******************************************************************************************************//
        driver.findElement((By.xpath("//input[@id='password']"))).sendKeys("Test123456789");




    /*    //   driver.findElement(By.xpath("//input[@id='email']")).sendKeys("atestna@gmail.com");

        driver.findElement((By.xpath("//input[@id='firstName']"))).sendKeys("Test-AccountOne");
        driver.findElement((By.xpath("//input[@id='lastName']"))).sendKeys("Test-TVNZ");
        driver.findElement((By.xpath("//button[@role='button'][1]//parent::div"))).click();
        driver.findElement((By.xpath("//div[@id='downshift-0-item-20']"))).click();
        *//*  These two xpath works for gender *//*
        driver.findElement((By.xpath("//div[@name='gender']//following::button[1]"))).click();
        driver.findElement((By.xpath("//div[@id='gender']//following::div[1]"))).click();


        *//* Below is different method *//*
        // driver.findElement((By.xpath("//label[@for='downshift-1-input']//following::button[1]"))).click();



        *//* End of line is different method *//*

        driver.findElement(By.xpath("//span[contains(text(),'I agree to play')]")).click();
        driver.findElement(By.xpath("//input[@id='latestNews']//following::div[1]")).click();
        driver.findElement(By.xpath("//span[@class='Button-text']")).click();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.close();  // closes the browser
        driver.quit();   // it is null means ready for Garbage collection
*/

    }


}

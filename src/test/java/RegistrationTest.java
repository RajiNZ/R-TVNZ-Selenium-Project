
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.day12.TestParameterising;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collector;

public class RegistrationTest {

    public String RandomAlphabeticString(int stringLength) {
        int leftLimit = 97; // letter'a'
        int rightLimit = 122; // letter 'z't
        // int targetStringLength =10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit((stringLength))
                // .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;

    }

    public int GenerateBirthYear(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

    //Task1: Create a Randomgenerator method to pick the gender from three options random gender values from the list of values

    public String GenerateGenderSelection() {
        //  Random randomOption = new Random();
        List<String> genderOptions = Arrays.asList("Male","Female","Diverse");
        Random r = new Random();
        String randomitem = genderOptions.get(r.nextInt(genderOptions.size()));
        return randomitem;
    }



    @Test
    public void Registration(){
        //new TestParameterising().registration("ccc", "ddd", "mm@rrr.com", "2001", "Male", "11111112");
        // new TestParameterising().registration(RandomAlphabeticString(3), RandomAlphabeticString(4), RandomAlphabeticString(5)+"@rrr.com",String.valueOf(GenerateBirthYear(1920,2000)), RandomAlphabeticString(5), RandomAlphabeticString(8));
        // registration(String fname, String lName, String email_address, String yearofBirth, String gender, String password)
        String fName = RandomAlphabeticString(3);
        String lName = RandomAlphabeticString(4);
        String remail = RandomAlphabeticString(5)+"@rrr.com";
        String yearOfBirth = String.valueOf(GenerateBirthYear(1920,2001));
        String gender = GenerateGenderSelection();
        String pwd = RandomAlphabeticString(8);
        new TestParameterising().registration(fName, lName,remail,yearOfBirth, gender, pwd);
    }

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

    public void registrationWithCodeInTestMethod(){
          // WebDriverManager.chromedriver().setup();
         //  ChromeDriver driver = new ChromeDriver();
        //   driver.get("https://www.tvnz.co.nz");
        //  driver.manage().window().maximize();

        // using dependency injection

        email = RandomAlphabeticString(5) + "@rrr.com";
        password = RandomAlphabeticString(8);


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
       if (driver.findElement(By.xpath("//a[text()='Login']")).isDisplayed()){
           driver.findElement(By.xpath("//a[text()='Login']")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.findElement(By.xpath("//span[text()='Sign up now']")).click();
            driver.findElement(By.id("email")).sendKeys(RandomAlphabeticString(5) + "@rrr.com");
            driver.findElement((By.xpath("//input[@id='password']"))).sendKeys(RandomAlphabeticString(8));
            //driver.findElement(By.xpath("//label[@for='password']//child::input")).sendKeys("11111111");
            driver.findElement((By.xpath("//input[@id='firstName']"))).sendKeys(RandomAlphabeticString(3));
            // driver.findElement(By.xpath("//div[@name='firstName']//child::input[1]")).sendKeys("OneOne");

            driver.findElement((By.xpath("//input[@id='lastName']"))).sendKeys(RandomAlphabeticString(4));
            // driver.findElement(By.xpath("//div[@name='lastName']//child::input[1]")).sendKeys("TVNZ");

            driver.findElement(By.xpath("//div[@name='yearOfBirth']")).click();
            driver.findElement(By.xpath("//div[.='" + String.valueOf(GenerateBirthYear(1920, 2001) + "']"))).click();
            driver.findElement(By.xpath("//div[@name='gender']")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.findElement(By.xpath("//div[@id='gender']/div[.='" + GenerateGenderSelection() + "']")).click();

            driver.findElement(By.xpath("//span[contains(text(),'I agree to play')]")).click();
            //  driver.findElement(By.xpath("//label[@for='houseRules']//span")).click();

            driver.findElement(By.xpath("//input[@id='latestNews']//following::div[1]")).click();
            //  driver.findElement(By.xpath("//label[@for='latestNews']/div/div")).click();
            driver.findElement(By.xpath("//button[.='Sign Me Up']")).click();
        } else {
            System.out.println("Page not displayed");
        }
//        driver.close();
//        driver.quit();
    }

    @Test

    public void logIn() throws InterruptedException{

      //  Thread.sleep(3000);
        Assertions.assertTrue(driver.findElement(By.xpath("//a[text()='Login']")).isDisplayed(), "Home Page is not displayed ");
        System.out.println(driver.findElement(By.xpath("//li[@id= 'Categories']//a[text()=\"Natural World\"]")).isDisplayed());            // we use backslash  if we use double quote
       // System.out.println(driver.findElement(By.xpath("//li[@id= 'Categories']//a[text()='Natural World']"));

        driver.findElement(By.xpath("//a[text()='Login']")).click();
        System.out.println(driver.getCurrentUrl());
        Assertions.assertTrue(driver.findElement(By.id("email")).isDisplayed(),"Email field is not available");
     //   Thread.sleep(3000);
        Assertions.assertTrue( driver.findElement(By.id("email")).isDisplayed());
        driver.findElement(By.xpath("//div[@class='Input-error']")).isDisplayed();
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
      //  Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='Submit']")).click();
        //  driver.findElement(By.xpath("//span[.='Login']/..")).click();




    }



    @Test
    public void logInAssertion(){

       List<WebElement> elements = driver.findElements(By.xpath("//a[text()='Logins']"));  // "Logins" is not therre so size will be 0
       Assertions.assertTrue(elements.size()==0,"Homepage is not displayed");  // this will pass as it returns nothing
   //    Assertions.assertTrue(elements.size()>0,"Homepage is not displayed");  // this will pass as it returns nothing

      //  Assertions.assertTrue(driver.findElement(By.xpath("//li[@id= 'Categories']//a[text()='Natural World']")).isDisplayed(), "Home Page is not displayed ");
        System.out.println(driver.findElement(By.xpath("//li[@id= 'Categories']//a[text()=\"Natural World\"]")).isDisplayed());            // we use backslash  if we use double quote
        // System.out.println(driver.findElement(By.xpath("//li[@id= 'Categories']//a[text()='Natural World']"));
        driver.findElement(By.xpath("//a[text()='Login']")).click();
        System.out.println(driver.getCurrentUrl());
        Assertions.assertTrue(driver.findElement(By.id("email")).isDisplayed(),"Email field is not available");
        //   Thread.sleep(3000);
        Assertions.assertTrue( driver.findElement(By.id("email")).isDisplayed());

    }

    @Test
    public  void homeCategoriesList() {


        //List<WebElement> elements = driver.findElements(By.xpath("//li[@id= 'Categories']//li"));
        // List<WebElement> elements = driver.findElements(By.xpath("//li[@id= 'Categories']//div"));
        List<WebElement> elements = driver.findElements(By.xpath("//li[@id= 'Categories']//li//a"));
        //Assertions.assertTrue(elements.size()>0,"Homepage Categories are displayed");

        for (WebElement categoryList : elements) {
            String cat1 = categoryList.getAttribute("href");
            List<String> cat2 = new ArrayList<>();
            cat2.add(cat1);
            System.out.println(cat2);

        }

    }

    @Test
    public  void homeCategoriesList2() {


        //List<WebElement> elements = driver.findElements(By.xpath("//li[@id= 'Categories']//li"));
        // List<WebElement> elements = driver.findElements(By.xpath("//li[@id= 'Categories']//div"));
        List<WebElement> elements = driver.findElements(By.xpath("//li[@id= 'Categories']//li//a"));
        //Assertions.assertTrue(elements.size()>0,"Homepage Categories are displayed");

        for (WebElement categoryList : elements) {
            String cat1 = categoryList.getAttribute("text");
            System.out.println(cat1);

        }

    }

    @Test

    public void showTopPicks() {


       List<WebElement> toppicksShows = driver.findElements(By.xpath("//h2[@data-anchor='TopPicks']/../../..//div[@class='swiper-wrapper']//a/div"));
       // List<WebElement> toppicksShows = driver.findElements(By.xpath("//h2[@data-anchor='TopPicks']/../../..//div[@class='ember-view']//a/div"));
        //Assertions.assertTrue(elements.size()>0,"Homepage Categories are displayed");

        for (WebElement e : toppicksShows) {
            String slist = e.getAttribute("id");
            System.out.println(slist);


        }
    }

@Test

    public  void loginDisplayed(){
        boolean loginShown=  driver.findElement(By.xpath("//a[text()='Login']")).isDisplayed();
        System.out.println("Login field is displayed true / false is : " +loginShown);


    }


}

//Task Get all categories and printout the names of the  categories

// Homework: Get all print movie names from Movie belt
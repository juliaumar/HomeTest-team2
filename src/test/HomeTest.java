import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomeTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/Users/juliaumar/Desktop/Selenium/libs/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
    @Test(testName = "test-1")
    public void testPageTitle(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://interview-prep-test.herokuapp.com/");
        WebElement login = driver.findElement(By.xpath("//*[@placeholder='Enter Username']"));
        login.sendKeys("test@yahoo.com");
        WebElement password = driver.findElement(By.xpath("//*[@name='password']"));
        password.sendKeys("test123");
        driver.findElement(By.xpath("//*[@type='submit']")).click();

        String expected = "Interview App";
        Assert.assertEquals(driver.getTitle(), expected);
    }
    @Test(testName ="test-2")
    public void testUserAccess(){
        driver.get("https://interview-prep-test.herokuapp.com/");
        WebElement login = driver.findElement(By.xpath("//*[@placeholder='Enter Username']"));
        login.sendKeys("test@yahoo.com");
        WebElement password = driver.findElement(By.xpath("//*[@name='password']"));
        password.sendKeys("test123");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
      //  Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Manage Access']")).isEnabled());
        Assert.assertTrue( driver.findElement(By.xpath("//*[@id=\"root\"]/div/nav/a")).isEnabled());

    }
    @Test(testName="test-3")
    public void testDefaultDashboard(){
        driver.get("https://interview-prep-test.herokuapp.com/");
        WebElement login = driver.findElement(By.xpath("//*[@placeholder='Enter Username']"));
        login.sendKeys("test@yahoo.com");
        WebElement password = driver.findElement(By.xpath("//*[@name='password']"));
        password.sendKeys("test123");
        driver.findElement(By.xpath("//*[@type='submit']")).click();


        List<WebElement>dashBoards = driver.findElements(By.xpath("//*[@type='submit']"));
        for (WebElement dashBoard:dashBoards) {
            Assert.assertTrue(dashBoard.isEnabled());
        }
        }
        @Test(testName = "test-4")
        public void InterviewRelatedStatements(){

                driver.get("https://interview-prep-test.herokuapp.com/");
    WebElement login = driver.findElement(By.xpath("//*[@placeholder='Enter Username']"));
        login.sendKeys("test@yahoo.com");
    WebElement password = driver.findElement(By.xpath("//*[@name='password']"));
        password.sendKeys("test123");
        driver.findElement(By.xpath("//*[@type='submit']")).click();

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/div[1]/button")).click();
        driver.findElement(By.id("inputArea1")).sendKeys("Always finish your Homework");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[3]/div[1]/form/button")).click();
    String Actual  = driver.findElement(By.xpath("//*[text()='Always finish your Homework']")).getText();
    String expected="Always finish your Homework";
        Assert.assertEquals(expected,Actual);

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/div[2]/button")).click();
        driver.findElement(By.id("inputArea2")).sendKeys("dont give up");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[3]/div[2]/form/button")).click();
    String actual1 = driver.findElement(By.xpath("//*[text()='dont give up']")).getText();
    String expected1 = "dont give up";
        Assert.assertEquals(expected1,actual1);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[3]/div[1]/div/div[2]/div[3]")).click();
            driver.findElement(By.xpath("//*[@id='root']/div/div/div[2]/div[3]/div[2]/div/div[4]/div[3]/span")).click();

    }
    @Test(testName = "test-5")
    public void DashboardQuestions(){
        driver.get("https://interview-prep-test.herokuapp.com/");
        WebElement login = driver.findElement(By.xpath("//*[@placeholder='Enter Username']"));
        login.sendKeys("test@yahoo.com");
        WebElement password = driver.findElement(By.xpath("//*[@name='password']"));
        password.sendKeys("test123");
        driver.findElement(By.xpath("//*[@type='submit']")).click();

        //Coding
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div/form[1]/a[2]/button/img")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"question\"]")).sendKeys("What is better Java or  Selenium");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/div/form/div[2]/button")).click();

        driver.navigate().back();

        //SoftSkills
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div/form[1]/a[3]/button/img")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/div/form/div[1]/input")).sendKeys("How to use Git Hub");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/div/form/div[2]/button")).click();













    }

    @AfterMethod
    public void tearDown(){
        driver.close();

    }

}


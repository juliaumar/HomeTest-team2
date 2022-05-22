import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    @Test(testName = "SignIn User Input")
    public void testSignIn(){
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
    @AfterMethod
    public void tearDown(){
        driver.close();

    }

}


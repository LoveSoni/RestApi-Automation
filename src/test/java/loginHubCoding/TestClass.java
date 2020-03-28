package loginHubCoding;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class TestClass {
    public WebDriver driver;
    private String url = "https://staging.dev.logichub.com/dashboard";
    private String userName = "Love";
    private String password = "Monster123@energy";
    private String DEFAULT_STATUS = "To Do";
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromiumdriver().setup();
        driver = new ChromeDriver();
        driver.get("https://staging.dev.logichub.com/dashboard");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        //login to application
        driver.findElement(By.name("email")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Login']")).click();
    }

    @Test
    public void verify(){
        String text = driver.getTitle();
       Assert.assertEquals(text,"LogicHub - Login","user is not on home page");
    }

    public void wait(int time){
        try{
            Thread.sleep(1000*time);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void moveToCasesAndCrateNewCase(){
        SoftAssert softAssert = new SoftAssert();
        String priority = "//li[@text='Low']";
        wait(8);
        driver.findElement(By.xpath("//span[contains(text(),'Case Management')]")).click();
        driver.findElements(By.xpath("//span[contains(text(),'Cases')]")).get(0).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Cases']")).isDisplayed());
        driver.findElement(By.xpath("//i[contains(@title,'Create New Case')]")).click();
        wait(8);
       WebElement caseElement = driver.findElement(By.xpath("//div[@class='rc-select-selection__rendered']"));
       caseElement.click();
       wait(1);
       driver.findElement(By.xpath("//li[@text='Default']")).click();
       wait(4);
       driver.findElement(By.xpath("//div[@class='lh-case__side-panel__field-value']/input")).sendKeys("test message");
       wait(1);
       driver.findElement(By.xpath("(//div[@class='rc-select-selection__rendered'])[3]")).click();
       driver.findElement(By.xpath(priority)).click();
       driver.findElement(By.xpath("//button[@type='submit']")).click();
       wait(5);
       // Assertion to make user issue created is correct
       String createdBy = driver.findElement(By.xpath("(//td[@class='lh-text--no-wrap lh-show-hover '])[4]")).getText();
       softAssert.assertEquals(createdBy,userName);
       String status =  driver.findElement(By.xpath("(//td[@class='lh-text--no-wrap lh-show-hover '])[3]")).getText();
       softAssert.assertEquals(status,DEFAULT_STATUS);
       String Priority = driver.findElement(By.xpath("(//td[@class='lh-text--no-wrap lh-show-hover '])[2]")).getText();
       softAssert.assertEquals(priority,"Low");
       // Edit the test case
        wait(5);
      // after that delete the created case
        driver.findElement(By.xpath("(//i[@class='anticon anticon-ellipsis menu-icon ant-dropdown-trigger'])[1]")).click();
        driver.findElement(By.xpath("//li[@role='menuitem'][2]")).click();
        wait(2);
//        Alert alert = driver.switchTo().alert();
//        System.out.print("Text on alert box"+alert.getText());
//        alert.accept();
       driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
    }


    @AfterMethod
    public void tearDown(){
       // driver.quit();
    }
}

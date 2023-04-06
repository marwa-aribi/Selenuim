package DemotestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class FirstAutomateTest{
    WebDriver driver ;
    @BeforeMethod
    public void Setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.lambdatest.com/selenium-playground/");

    }
    @AfterMethod
    public  void TearDown(){
        // driver.quit();
    }
    @Test(priority=1)
    public void TesttableSotandSearch(){
        driver.findElement(By.linkText("Table Sort & Search")).click();
        driver.findElement(By.xpath("//*[@id=\"example_filter\"]/label/input")).sendKeys("A. Ramos");
    }
    @Test(priority=2)
    public void BootstrapDataPicker(){
        driver.findElement(By.linkText("Bootstrap Date Picker")).click();
        driver.findElement(By.id("birthday")).sendKeys("11/06/2008");

    }
}


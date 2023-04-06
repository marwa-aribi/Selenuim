package SelenuimE2E;



import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public class BaseTest {
    protected WebDriver driver;
    @Parameters("Browser")
    @BeforeMethod
    public void SetUp(String browser){
        if(browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);

        }


        else if(browser.equals("edge")) {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
    }
        else {
            WebDriverManager.firefoxdriver().setup();

            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();

        driver.get("https://ecommerce-playground.lambdatest.io/");
    }}
    // @AfterMethod
    //public void TearsDown(){
        //driver.quit();
    //}




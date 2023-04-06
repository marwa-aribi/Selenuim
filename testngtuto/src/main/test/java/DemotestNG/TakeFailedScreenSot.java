package DemotestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;


public class TakeFailedScreenSot {
    WebDriver driver;
    @BeforeMethod
    public void Setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.lambdatest.com/selenium-playground/");
    }
    @Test
    public void TestsimpleFromDemo(){
        driver.findElement(By.linkText("Simple Form Demo")).click();
        driver.findElement(By.xpath("//*[@id=\"user-message\"]")).sendKeys("Great Lamdatest !!!!!");
        driver.findElement(By.id("showInput")).click();
        String actualmessage =driver.findElement(By.id("message")).getText();
        Assert.assertEquals(actualmessage,"Great Lamdatest !!!!!","\n Message is not the same \n");
    }
    @AfterMethod
    public void takeScreenshotForFailures() {

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File(System.getProperty("user.dir") +
                "/screen/SceenShot/TestPass.png");
        try {
            FileHandler.copy(source,destination);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }}


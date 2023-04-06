package DemotestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionDemo {
    SoftAssert SoftAssert = new SoftAssert();
    WebDriver driver;
    @BeforeMethod
    public void Setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.lambdatest.com/selenium-playground/");

    }
    @Test
    public  void TestionCheckBox(){
        driver.findElement(By.linkText("Checkbox Demo")).click();
        driver.findElement(By.id("isAgeSelected")).click();
        String actualMessage = driver.findElement(By.id("txtAge")).getText();
        Assert.assertTrue(actualMessage.contains("Success"), "\n Message does not contain succes \n");
    }
    @Test
    public void TestRadioBoton(){
        driver.findElement(By.linkText("Radio Buttons Demo")).click();
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/section[3]/div/div/div[2]/div[2]/div[2]/div/div[1]/div[1]/label[3]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/section[3]/div/div/div[2]/div[2]/div[2]/div/div[1]/div[2]/label[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/section[3]/div/div/div[2]/div[2]/div[2]/div/div[1]/button")).click();
        String actualGender = driver.findElement(By.cssSelector("#__next > div.wrapper > section.mt-50 > div > div > div.w-8\\/12.smtablet\\:w-full.px-15.smtablet\\:mt-20 > div:nth-child(4) > div.input-body.px-10.py-20 > div > div.w-4\\/12.smtablet\\:w-full.rigth-input > p.mb-20.font-medium > span")).getText();
        String actualAgeGroup = driver.findElement(By.cssSelector("#__next > div.wrapper > section.mt-50 > div > div > div.w-8\\/12.smtablet\\:w-full.px-15.smtablet\\:mt-20 > div:nth-child(4) > div.input-body.px-10.py-20 > div > div.w-4\\/12.smtablet\\:w-full.rigth-input > p:nth-child(2) > span")).getText();
        SoftAssert.assertEquals(actualGender,"Male","\n Actual Gender in not Correct \n");
        SoftAssert.assertTrue(actualAgeGroup.contains("34"),"\n Actual Gendre Group is Not correct\n");
    }
}

package SelenuimE2E;

import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class CreateNewProfile extends BaseTest{
    public WebDriver driver;
    private String username = "marwa.aribi";
    private String accessKey = "NExb1rH7oTuKQtCjDdzT1uCbxMOu35VVreXp5zVB62QApAPbtU";
    private String hub = "@hub.lambdatest.com/wd/hub";
    DesiredCapabilities caps = new DesiredCapabilities();

    By MyaccountMenu =  By.xpath("//*[@id=\"widget-navbar-217834\"]/ul/li[6]/a/div/span");
    By ContinueButton = By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/a");
    By Firstname = By.id("input-firstname");
    By Lastname = By.id("input-lastname");
    By Email = By.id("input-email");
    By Telephone = By.id("input-telephone");
    By Password = By.id("input-password");
    By ConfirmPassword = By.id("input-confirm");
    By CheckBox  =By.xpath("//*[@id=\"content\"]/form/div/div/div/label");
    By BtnContinuer = By.xpath("//*[@id=\"content\"]/form/div/div/input");
    By BtnLogout = By.xpath("//*[@id=\"widget-navbar-217834\"]/ul/li[6]/ul/li[6]/a/div/span");

    @Parameters(value={"Browser", "version", "platform"})
    @BeforeMethod
    public void setUp(String browser, String version, String platform) {
        caps.setCapability("build", "1.0");
        caps.setCapability("name", "SelenuimE2E");
        caps.setCapability("platform", platform);
        caps.setCapability("version", version);
        caps.setCapability("browserName", browser);
        caps.setCapability("network", true);
        caps.setCapability("console", true);
        caps.setCapability("visual", true);
        caps.setCapability("video", true);

        try {
            driver = new RemoteWebDriver(
                    new URL("https://" + username + ":" +
                            accessKey + hub), caps);
        } catch(MalformedURLException exc) {
            exc.printStackTrace();
        }
        driver.get("https://ecommerce-playground.lambdatest.io/");
    }

    @Test
    public  void Test1CreateProfile(){
        //driver.findElement(By.xpath("//*[@id=\"widget-navbar-217834\"]/ul/li[6]/a")).click();
        Click(MyaccountMenu);
        Click(ContinueButton);
        Type(Firstname,"Marwa");
        Type(Lastname,"Aribi");
        Type(Email,RandomGenerateEmail());
        Type(Telephone,"21624373445");
        Type(Password,"marwa123");
        Type(ConfirmPassword,"marwa123");
        Click(CheckBox);
        Click(BtnContinuer);
        Actions act =new Actions(driver);
        act.moveToElement(find(MyaccountMenu)).perform();
        Click(BtnLogout);


    }

    private WebElement find(By locator){

        return driver.findElement(locator);
    }
    private void Click(By locator){

        find(locator).click();
    }
    private  void Type (By locator, String text){

        find(locator).sendKeys(text);
    }
    private  String RandomGenerateEmail(){
        return RandomStringUtils.random(4,true,true)+"@gmail.com";
    }
}

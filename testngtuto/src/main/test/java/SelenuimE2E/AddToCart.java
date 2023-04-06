package SelenuimE2E;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AddToCart extends BaseTest{
    public WebDriver driver;
    private String username = "marwa.aribi";
    private String accessKey = "NExb1rH7oTuKQtCjDdzT1uCbxMOu35VVreXp5zVB62QApAPbtU";
    private String hub = "@hub.lambdatest.com/wd/hub";
    DesiredCapabilities caps = new DesiredCapabilities();

    By Email = By.id("input-email");
    By Password = By.id("input-password");
    By BtnLog = By.xpath("//*[@id=\"content\"]/div/div[2]/div/div/form/input[1]");
    By MyaccountMenu =  By.xpath("//*[@id=\"widget-navbar-217834\"]/ul/li[6]/a/div/span");
    By SearchFiled = By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div[2]/input");
    By SearchBtn = By.xpath("//*[@id=\"search\"]/div[2]/button");
    By Iphone = By.xpath("//*[@id=\"mz-product-grid-image-79-212469\"]/div/div[1]/img");
    By BtnAddCart = By.xpath("//*[@id=\"entry_216842\"]/button");
    By CheckOut = By.xpath("//div[@id='notification-box-top']//a[contains(text(),'Checkout')]");
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
    public void Test2AddCart(){
        Click(MyaccountMenu);
        Type(Email,"marwaaribi@outlook.com");
        Type(Password,"marwa123456");
        Click(BtnLog);
        Type(SearchFiled,"Iphone");
        Click(SearchBtn);
        Click(Iphone);
        Click(BtnAddCart);
        WebDriverWait wait   = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(CheckOut));
        Click(CheckOut);
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

package DemotestNG;

import com.google.common.base.Function;
import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.tracing.opentelemetry.SeleniumSpanExporter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicWaits {
    WebDriver driver;

    @BeforeMethod
    public void Setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.lambdatest.com/selenium-playground/");
    }

    @Test
    public void TestDynamicWait() {
        By img = By.xpath("//*[@id=\"loading\"]/img");
        driver.findElement(By.linkText("Dynamic Data Loading")).click();
        driver.findElement(By.id("save")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(img));

        boolean ImageDisplayed = driver.findElement(img).isDisplayed();
        Assert.isTrue(ImageDisplayed, "\n image is not displyaed in the AUT \n");
    }

    @Test
    public void FluentWait() {
        driver.findElement(By.linkText("JQuery Download Progress bars")).click();
        driver.findElement(By.id("downloadButton")).click();
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30L))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement progress = driver.findElement(By.xpath("//*[@id=\"dialog\"]/div[1]"));
                String ProgressBarText = progress.getText();

                if (ProgressBarText.equals("Complete!")) {
                    System.out.println("Progress Is Complete!");
                    return progress;
                } else {
                    System.out.println(progress.getText());
                    return null;
                }
            }
        });
    }
@Test
    public void TestImplictWait(){
    driver.manage().timeouts().implicitlyWait(
            Duration.ofSeconds(5));
    driver.get("http://the-internet.herokuapp.com/dynamic_loading");
    driver.findElement(By.partialLinkText("Example 2")).click();
    driver.findElement(By.xpath("//div[@id='start']/button")).click();

    By helloWord = By.xpath("//div[@id='finish']/h4[text()='Hello World!']");
    String actualMessage = driver.findElement(helloWord).getText();

    org.testng.Assert.assertEquals(actualMessage, "Hello World!",
            "\n Message Is Not Hello World! \n");
}
}

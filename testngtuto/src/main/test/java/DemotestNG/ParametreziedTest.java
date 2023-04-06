package DemotestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class ParametreziedTest {
    WebDriver driver ;
    @Parameters({"URL"})
    @BeforeClass
public void SetUP( String url){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get(url);
}
//Click to file downloas
    @Test
    @Parameters ({"Tasks","TestResult"})
    public void TestFileDownlowd (String task ,String testresult){
        driver.findElement(By.linkText("File Download")).click();
        //enterer les donnees

        driver.findElement(By.id("textbox")).sendKeys(task+ "Exection!"+testresult );
        //click boutton generate
        driver.findElement(By.id("create")).click();
        //click  download link
        driver.findElement(By.id("link-to-download")).click();
    }
    @AfterClass
    public  void TearsDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
}
}

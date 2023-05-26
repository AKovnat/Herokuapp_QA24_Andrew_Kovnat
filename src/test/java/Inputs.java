import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class Inputs {
    private static final String URL = "https://the-internet.herokuapp.com/inputs";
    private WebDriver driver;

    @BeforeClass

    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @BeforeMethod
    public void navigate() {
        driver.get(URL);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();

    }


    @Test
    public void inputsTest() {
        WebElement inputs = driver.findElement(By.tagName("input"));
        inputs.sendKeys("10");

        String keyResult = driver.findElement(By.tagName("input")).getAttribute("value");
        Assert.assertEquals(keyResult, "10");
        inputs.sendKeys(Keys.ARROW_UP);

        String upKeyResult = driver.findElement(By.tagName("input")).getAttribute("value");
        Assert.assertEquals(upKeyResult, "11");
        inputs.sendKeys(Keys.ARROW_DOWN);

        String downKeyResult = driver.findElement(By.tagName("input")).getAttribute("value");
        Assert.assertEquals(downKeyResult, "10");

        inputs.clear();
        inputs.sendKeys("nqvenrpinp");
        String lettersResult = driver.findElement(By.tagName("input")).getAttribute("value");
        Assert.assertEquals(lettersResult, "");


    }
}



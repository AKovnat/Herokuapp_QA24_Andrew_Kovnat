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



public class Typos {
    private static final String URL = "https://the-internet.herokuapp.com/typos";
    private WebDriver driver;

    @BeforeClass

    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @AfterClass
    public void tearDown() {
        driver.quit();

    }

    @BeforeMethod
    public void navigate() {
        driver.get(URL);
    }

    @Test
    public void typosTest() {
        String typos = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p[2]")).getText();
        Assert.assertEquals(typos, "Sometimes you'll see a typo, other times you won't.", "Error:'won,t' is misspelled");
    }
}

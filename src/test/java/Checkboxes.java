import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class Checkboxes {
    private static final String URL = "https://the-internet.herokuapp.com/checkboxes";
    private WebDriver driver;

    @BeforeClass

    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


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
    public void checkBoxesTest() {

        List<WebElement> checkBoxes = driver.findElements(By.cssSelector("[type=checkbox]"));
        Assert.assertFalse(checkBoxes.get(0).isSelected());
        Assert.assertTrue(checkBoxes.get(1).isSelected());
        checkBoxes.get(1).click();
        Assert.assertFalse(checkBoxes.get(1).isSelected());
    }
}




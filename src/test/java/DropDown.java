import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DropDown {
    private static final String URL = "https://the-internet.herokuapp.com/dropdown";
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
    public void dropDownTest() {
        WebElement dropDown = driver.findElement(By.cssSelector("#dropdown"));
        Select select = new Select(dropDown);

        List<WebElement> options = select.getOptions();
        select.selectByVisibleText("Option 1");

        Assert.assertTrue(options.get(1).isSelected());
        select.selectByVisibleText("Option 2");

        Assert.assertTrue(options.get(2).isSelected());
        Assert.assertEquals(options.size(), 3);
        Assert.assertEquals(options.get(0).getText(), "Please select an option");
        Assert.assertEquals(options.get(1).getText(), "Option 1");
        Assert.assertEquals(options.get(2).getText(), "Option 2");

        select.selectByVisibleText("Option 1");
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Option 1");

        select.selectByVisibleText("Option 2");
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Option 2");


    }
}
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


public class AddRemoveElements {

    private static final String URL = "https://the-internet.herokuapp.com/add_remove_elements/";
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
    public void AddRemoveElements() {
        WebElement AddButton = driver.findElement(By.xpath("//button[text()='Add Element']"));
        AddButton.click();
        AddButton.click();
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']"));
        Assert.assertEquals(deleteButtons.size(), 2);
        deleteButtons.get(0).click();
        List<WebElement> deleteButtons1 = driver.findElements(By.xpath("//button[text()='Delete']"));
        Assert.assertEquals(deleteButtons1.size(), 1);




    }

}



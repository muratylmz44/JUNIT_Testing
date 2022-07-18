package JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C04AssertYoutube {

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.youtube.com/");


    }

    @Test
    public void TitleTest() {
        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();
        Assert.assertEquals("Sayfa Title'i  beklenenden Farklı", expectedTitle, actualTitle);

    }

    @Test
    public void YoutubeResmiTesti() {
        WebElement logo =driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));
        Assert.assertFalse("Logo Görünmüyor",logo.isDisplayed());


    }
    @Test
    public  void SearchTesti(){
        WebElement Search= driver.findElement(By.id("search-input"));
        Assert.assertTrue("Arama kutusuna Ulaşılamıyor",Search.isEnabled());


    }
    @AfterClass
    public static void tearDown(){

        driver.close();
    }


}
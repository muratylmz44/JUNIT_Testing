package JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C02_Before_After {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


    }

    @Test
    public void Amazon(){
        driver.get("https://www.amazon.com");

    }
    @Test
    public void TechPro(){
        driver.get("https://www.techproeducation.com");

    }
    @Test
    public void Facebook(){
        driver.get("https://www.facebook.com");

    }
    @After
    public void tearDown(){
        driver.close();
    }


}

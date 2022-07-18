package JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

 public class C03_Assert {
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.bestbuy.com");
       // https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak
       // asagidaki testleri yapin
        // Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        // titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        // logoTest => BestBuy logosunun görüntülendigini test edin
        // FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin




    }
        @Test
        public void UrlTest(){
        String exceptedURL="https://www.bestbuy.com/";
        String actualURL=driver.getCurrentUrl();
            Assert.assertEquals("İstenen URL BULUNAMADI",exceptedURL,actualURL);

     }
        @Test
        public  void TitleTest(){

        String actualTitle=driver.getTitle();
        String IstenmeyenKelime="Rest";

        Assert.assertFalse("İstenmeyen Kelime(REST) Titlide Var",actualTitle.contains(IstenmeyenKelime));
        }
        @Test
        public  void LogoTest (){
            WebElement Logo = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
            Assert.assertTrue("Logo Görünmüyor",Logo.isDisplayed());

        }


     @Test
     public  void FransizcaTextTest (){
         WebElement Fransizca = driver.findElement(By.xpath("//button[text()='Français']"));
         Assert.assertTrue("Logo Görünmüyor",Fransizca.isDisplayed());

     }







        @AfterClass
        public static void tearDown (){
        driver.close();
        }




}

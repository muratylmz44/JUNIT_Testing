package germanmugat;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class test01 {


    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // https://www.walmart.com adresine gidin

        driver.get("https://www.walmart.com/");


        //sayfayı refresh yapın

        driver.navigate().refresh();

        //Sayfa başlığının titlein save içerip içermediğini kontrol edin

        String actualTitle = driver.getTitle();
        String ArananKelime="Save" ;

        if (actualTitle.contains(ArananKelime )) {

            System.out.println("Title"+ ArananKelime + "kelimeyi içeriyor PASS" );
        }else
            System.out.println("Title"+ ArananKelime + "kelimeyi içermiyor FAILED" );

        }






        //Sayfa başlığının Walmart.com | Save Money. Live Better a eşit olduğunu kontrol edin

        String ExpectedTitle="Walmart.com | Save Money. Live Better";




        //Url nin Walmart.com  içerdiğini kontrol edin

        //Nutella için search yapın

        //kaç sonuç bulunduğunu yazdırın

        // kapatın



    }


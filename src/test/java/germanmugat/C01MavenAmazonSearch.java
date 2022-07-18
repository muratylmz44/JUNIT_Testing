package germanmugat;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class C01MavenAmazonSearch {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver() ;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        //Amazona gidin
        driver.get("https://www.amazon.com.tr/ref=nav_logo");
        // Search tag ini bulun
        WebElement SearchBox = driver.findElement(By.id("twotabsearchtextbox")) ;
        //Search tagına İphone 12 pro yazdırın ve aratın
        SearchBox.sendKeys("İphone 12 Pro"+ Keys.ENTER);
        //sonucu yazdırın
        WebElement SonucSayısı = driver.findElement(By.xpath("//div[@class= 'a-section a-spacing-small a-spacing-top-small' ]"));
        System.out.println(SonucSayısı.getText());

        //Search yapılan ilk sonucu Tıklayın Burada İndex ile devam ettik [1] diyerek ve .click ile hızlıca

        driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")).click();

        // navigate back ile geri gelmemiz lazımdı Çünkü yapacağımız listeyi yani tüm spanların olduğu sayfa önceki sayfadaydı
        driver.navigate().back();

        //list ile listeledik

        List<WebElement> TümListe = driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']")) ;

        // for eavh ile sıralama yaptık
        for (WebElement each: TümListe
             ) {
            // ve get text ile listesyi yazdırdık
            System.out.println(each.getText());

            
        }
        // ve finish .close ile açık olan browseri kapattık .quit ile tüm açık sayfalar kapanırdı.
            driver.close();

    }

}

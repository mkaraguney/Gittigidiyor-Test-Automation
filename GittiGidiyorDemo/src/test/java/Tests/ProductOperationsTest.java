package Tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.ProductDetailModel;
import utilities.Utilites;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class ProductOperationsTest {

    public WebDriver driver;
    final static Logger logger = Logger.getLogger(String.valueOf(LoginPageTest.class));
    public Utilites utilites;

    @Before
    public void setupDriver(){
        utilites = new Utilites();
        System.setProperty(utilites.browserType,utilites.projectPath);
        driver = new FirefoxDriver();
        String url = utilites.url;
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
    }
    @Test
    public void TestSearch() throws InterruptedException {

        /* Arama çubuğunda 'Bilgisayar' ifadesinin aranması */
        ProductDetailModel productDetailModel = new ProductDetailModel(driver);
        productDetailModel.searchBox("Bilgisayar");
        productDetailModel.searchButton();
        logger.info("Bilgisayar keyword'ü aratıldı.");

        /* Arama sonuç sayfalarında 2. sayfanın açılması ve rastgele bir ürünün açılması */
        productDetailModel.scrollDown("window.scrollBy(0,9000)");
        productDetailModel.nextPage();
        logger.info("Arama sonuçlarında 2. sayfaya geçildi.");


        List<WebElement> productList = productDetailModel.productList();
        String productPrice = productDetailModel.productPrice();
        productList.get(0).click();
        productDetailModel.scrollDown("window.scrollBy(0,300)");
        logger.info("Arama sonuçlarında ürün seçildi.");

        productDetailModel.id();
        productDetailModel.scrollDown("window.scrollBy(0,0)");
        Thread.sleep(5000);

        productDetailModel.basketTitle();

        String basketPrice = productDetailModel.basketPrice();
        Assert.assertEquals(productPrice,basketPrice);
        productDetailModel.amount("2",Keys.ENTER);
        logger.info("Ürün tutarı karşılaştırıldı.");
        //Thread.sleep(3000);

        String value = productDetailModel.amountValue("value");
        Assert.assertEquals(value,"2");
        productDetailModel.clickDeleteButton();
        Thread.sleep(2000);
        String basketEmpty = productDetailModel.findEmptyBasketKeyword();
        Assert.assertEquals(basketEmpty,"Sepetinizde ürün bulunmamaktadır.");
        logger.info("Sepet Boşaltıldı.");

    }
    @After
     public void quitDriver(){
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.quit();
    }
}

package Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.ProductDetailModel;
import utilities.Utilites;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class LoginPageTest {

    public  WebDriver driver;
    final static Logger logger = Logger.getLogger(String.valueOf(LoginPageTest.class));
    public Utilites utilites;

    @Before
    public void setupDriver(){
        utilites = new Utilites();
        System.setProperty(utilites.browserType,utilites.projectPath);
        driver = new FirefoxDriver();
        String url = utilites.url;
        driver.get(url);
        logger.info("Test edilecek sayfa : " + driver.getTitle());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }
    @Test
    public void TestHome(){
        ProductDetailModel productOperationModel = new ProductDetailModel(driver);
        productOperationModel.clickSignButton();
        productOperationModel.clickSignInButton();
        productOperationModel.findUserName("gittigidiyordeneme@hotmail.com");
        logger.info("Kullanıcı Adı Girildi.");
        productOperationModel.findPassword("Deneme123456");
        logger.info("Şifre Girildi.");
        productOperationModel.loginButton();
        logger.info("Sisteme Giriş Yapıldı.");
    }
    @After
    public void quitDriver(){
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.quit();
    }
}

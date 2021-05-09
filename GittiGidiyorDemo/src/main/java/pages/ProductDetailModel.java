package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductDetailModel extends BaseModel {

    By signBtn = By.xpath(".//*[@id='main-header']/div[3]/div/div/div[1]/div[3]/div/div[1]/div[1]");
    By signIn = By.xpath(".//html/body/div[1]/header/div[3]/div/div/div/div[3]/div/div[1]/div[2]/div/div/div/a");
    By userNameField = By.id("L-UserNameField");
    By passwordField = By.id("L-PasswordField");
    By loginButton = By.id("gg-login-enter");
    By searchBox = By.xpath(".//html/body/div[1]/header/div[3]/div/div/div/div[2]/form/div/div[1]/div[2]/input");
    By searchButton = By.xpath(".//html/body/div[1]/header/div[3]/div/div/div/div[2]/form/div/div[2]/button");
    By nextPage = By.xpath("//ul[@class='clearfix']/li[2]/a[text()='2']");
    By productList = By.xpath("//div/ul[@class='catalog-view clearfix products-container']/li/a/div/p");
    By productPrice = By.xpath("//div/ul[@class='catalog-view clearfix products-container']/li/a/div/div//p");
    By id = By.id("add-to-basket");
    By basketTitle = By.xpath("//span[@class='basket-title']");
    By basketPrice = By.xpath("//p[@class='new-price']");
    By amount = By.xpath("//select[@class='amount']");
    By amountValue = By.xpath("//select[@class='amount']");
    By deleteButton = By.xpath("//div[@class='row']/a[@title='Sil']/i");
    By emptyBasketKeyword = By.xpath("//h2[text()='Sepetinizde ürün bulunmamaktadır.']");

    public ProductDetailModel(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickSignButton(){
        WebElement webElement = webDriver.findElement(signBtn);
        click(signBtn,200);
    }

    public void clickSignInButton(){
        WebElement webElement = webDriver.findElement(signIn);
        click(signIn,100);
    }

    public void findUserName(String mail){
        WebElement webElement = webDriver.findElement(userNameField);
        click(userNameField,100);
        webElement.sendKeys(mail);
    }

    public void findPassword(String password){
        WebElement webElement = webDriver.findElement(passwordField);
        click(passwordField,100);
        webElement.sendKeys(password);
    }

    public void loginButton(){
        WebElement webElement = webDriver.findElement(loginButton);
        click(loginButton,200);
    }

    public void searchBox(String keyword){
        WebElement webElement = webDriver.findElement(searchBox);
        click(searchBox,200);
        webElement.sendKeys(keyword);
    }

    public void searchButton(){
        WebElement webElement = webDriver.findElement(searchButton);
        click(searchButton,200);
    }

    public void nextPage(){
        WebElement webElement = webDriver.findElement(nextPage);
        click(nextPage,200);
    }

    public List<WebElement> productList(){
        List<WebElement> webElement = webDriver.findElements(productList);
        //click(productList,200);
        return webElement;
    }

    public String productPrice(){
        WebElement webElement  = webDriver.findElement(productPrice);
        String value = getText(productPrice);
        return value;
    }

    public void id(){
        WebElement webElement = webDriver.findElement(id);
        click(id,200);
    }

    public void basketTitle(){
        WebElement webElement = webDriver.findElement(basketTitle);
        click(basketTitle,200);
    }

    public String basketPrice(){
        WebElement webElement = webDriver.findElement(basketPrice);
        String value = getText(basketPrice);
        return value;
    }

    public void amount(String keyValue, Keys keyAction){
        WebElement webElement = webDriver.findElement(amount);
        click(amount,200);
        webElement.sendKeys(keyValue);
        webElement.sendKeys(keyAction);
    }

    public String amountValue(String attributeValue){
        String value = webDriver.findElement(amountValue).getAttribute(attributeValue);
        return value;
    }

    public void clickDeleteButton(){
        WebElement webElement = webDriver.findElement(deleteButton);
        click(deleteButton,100);
    }

    public String findEmptyBasketKeyword(){
        WebElement webElement = webDriver.findElement(emptyBasketKeyword);
        String value = getText(emptyBasketKeyword);
        return value;
    }
}

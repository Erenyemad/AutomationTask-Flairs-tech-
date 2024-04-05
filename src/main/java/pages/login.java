package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class login {
    WebDriver driver;
    private final By userName=By.name("username");
    private final By Password =By.name("password");
    private final By loginButton=By.xpath("//button[@type='submit']");

    public login(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);

    }
    public void EnterUsername(String username){
        driver.findElement(userName).sendKeys(username);

    }

    public void EnterPassword(String password){
        driver.findElement(Password).sendKeys(password);

    }
    public Admin clickOnLoginButton(){
       driver.findElement(loginButton).click();
        return new Admin(driver);
    }




}

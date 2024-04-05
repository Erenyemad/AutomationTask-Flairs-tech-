package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class Admin {
    WebDriver driver;
    private final By AdminTab = By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']");
    private final By addButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
    private final By employeeName = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input");
    private final By userName=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input");
    private  final By password=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input");
    private final By confirmPassword=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input");
    private  final By saveButton=By.xpath("//button[@type='submit']");
    private  final By searchButton=By.xpath("//button[@type='submit']");
    private  final By deleteIcon=By.xpath("//i[@class='oxd-icon bi-trash']");
    private  final By deleteConfirmationMessageButton=By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']");
     private final By dropdownUserRole=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div");
     private final By adminSelect=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]/div[2]");
     private final By dropdownStatus=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div");
     private final By EnableSelect=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div[2]/div[2]");
     private final By suggestionEmployeeName=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[1]/span");
    private final By userNameSearchBox=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input");
    private final By resetButton=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[1]");
    public int getNumberOfRecords()  {
        List<WebElement>records=driver.findElements(By.xpath("//div[@role='row']"));
        int numberOfRecords = records.size()-1;
        System.out.println("Number of records found: " + numberOfRecords);
        return numberOfRecords;
    }

    public Admin(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnAdminTab() {
        driver.findElement(AdminTab).click();
    }

    public void clickOnAddButton() {
        driver.findElement(addButton).click();
    }

    public void selectUserRole(){

        driver.findElement(dropdownUserRole).click();
        driver.findElement(adminSelect).click();


    }

    public void SelectEmployee() {

        driver.findElement(employeeName).sendKeys("a");
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[1]/span")));
        driver.findElement(suggestionEmployeeName).click();

    }

    public void selectStatus() {

        driver.findElement(dropdownStatus).click();
        driver.findElement(EnableSelect).click();
    }

    public void enterUserName(String username)  {

        driver.findElement(userName).sendKeys(username);



    }

    public void EnterValidPassword(String pass){
        driver.findElement(password).sendKeys(pass);


    }
    public void EnterValidConfirmationPassword(String confirm_pass){
        driver.findElement(confirmPassword).sendKeys(confirm_pass);


    }

    public void clickOnSaveButton(){

        driver.findElement(saveButton).click();
    }

    public void searchByUserName(String username){
        driver.findElement(userNameSearchBox).sendKeys(username);
        driver.findElement(searchButton).click();
    }

    public void deleteUser(){
        driver.findElement(deleteIcon).click();
        driver.findElement(deleteConfirmationMessageButton).click();

    }

    public void clickOnResetButton(){

        driver.findElement(resetButton).click();
    }
}


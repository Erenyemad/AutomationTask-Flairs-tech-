package tests.login;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.Admin;
import pages.login;
import java.time.Duration;



public class loginStepdefs{
   public WebDriver driver;
    public Admin AdminPage;
    public login LoginPage;

    @Given("I navigate to the OrangeHRM login page")
    public void iNavigateToTheOrangeHRMLoginPage() {
        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));

    }
    @When("I enter username as {string} and password as {string}")
    public void iEnterUsernameAsAndPasswordAs(String username, String password){
     LoginPage =new login(driver);
     LoginPage.EnterUsername(username);
     LoginPage.EnterPassword(password);


    }

    @And("I click on the login button")
    public void iClickOnTheLoginButton() {
       AdminPage=LoginPage.clickOnLoginButton();
        
    }

    @Then("I click on Admin tab on the left side menu")
    public void iClickOnAdminTabOnTheLeftSideMenu() {
        AdminPage.clickOnAdminTab();
        
    }

    @And("I get the number of records found")
    public void iGetTheNumberOfRecordsFound(){
        AdminPage.getNumberOfRecords();
    }

    @And("I click on add button")
    public void iClickOnAddButton()  {

     AdminPage.clickOnAddButton();
        
    }
    @And("I fill the required data")
    public void iFillTheRequiredData(){
        AdminPage.selectUserRole();
        AdminPage.SelectEmployee();
        AdminPage.selectStatus();
        AdminPage.enterUserName("marina");
        AdminPage.EnterValidPassword("Eiro@876");
        AdminPage.EnterValidConfirmationPassword("Eiro@876");
    }


    @And("I click on save button")
    public void iClickOnSaveButton() {
     AdminPage.clickOnSaveButton();
        
    }

    @Then("I verify that the number of records increased by {int}")
    public void iVerifyThatTheNumberOfRecordsIncreasedBy(int increaseValue){
        int initialRecords = AdminPage.getNumberOfRecords();
        int newRecords = initialRecords + 1;
        int actualIncrease = newRecords - initialRecords;
        Assert.assertEquals(increaseValue, actualIncrease);
        
    }

    @And("I search with the username for the new user")
    public void iSearchWithTheUsernameForTheNewUser() {
        AdminPage.searchByUserName("marina");
    }

    @And("I delete the new user")
    public void iDeleteTheNewUser() {
     AdminPage.deleteUser();
        
    }

    @Then("I verify that the number of records decreased by {int}")
    public void iVerifyThatTheNumberOfRecordsDecreasedBy(int decreaseValue) {
        AdminPage.clickOnResetButton();
        int initialRecords = AdminPage.getNumberOfRecords();
        int newRecords = initialRecords - 1 ;
        int actualDecrease = initialRecords - newRecords;
        Assert.assertEquals(decreaseValue, actualDecrease);

    }


 @Then("User should be logged in successfully")
 public void userShouldBeLoggedInSuccessfully() {

     driver.quit();
 }


}

package tests.login;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "/Users/ereny/Downloads/Ereny-Emad-master/src/test/java/tests/login/login.feature",
        monochrome = true
)
public class LoginRunner extends AbstractTestNGCucumberTests { }
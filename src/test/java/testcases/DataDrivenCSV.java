package testcases;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.HomePageSteps;

import java.io.File;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("/Users/giangthao/Desktop/WorkSpace/DataDriven/src/test/resources/testdata/data.csv")
@Concurrent(threads = "2")
public class DataDrivenCSV {
    private String username;
    private String password;
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Managed
    WebDriver driver;

    @Steps
    HomePageSteps home;

    @Title("Executing Login Test")
    @Test
    //@Screenshots(onlyOnFailures=true)
    public void loginTest() {

        home.doLogin(username);
        System.out.printf(username);
        home.doEnterPassword(password);
        System.out.printf(password);

    }
}

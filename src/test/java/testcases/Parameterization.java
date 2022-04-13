package testcases;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.TestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.HomePageSteps;

import java.util.Arrays;
import java.util.Collection;

@RunWith(SerenityParameterizedRunner.class)
public class Parameterization {
    private String username;
    private String password;
    public Parameterization(String username, String password){
        this.username=username;
        this.password=password;

    }
    @TestData
    public static Collection<Object[]> testData(){
        Object[][] data = new Object[2][2];
        data[0][0] ="trainer@gmail.com";
        data[0][1] ="traidd";


        data[1][0] ="giangthaonexle@gmail.com";
        data[1][1] ="giangthaonexle@gmail.com";

        return Arrays.asList(data);


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

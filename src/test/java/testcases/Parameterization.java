package testcases;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.TestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.HomePageSteps;
import utilities.ExcelReader;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;

@Narrative(text = {"In order to Run parameterized test","As a Serenity Runner",
"We need to Integrate Excel Reading"})
@RunWith(SerenityParameterizedRunner.class)
@Concurrent(threads = "2")
public class Parameterization {
    private String username;
    private String password;
    public Parameterization(String username, String password){
        this.username=username;
        this.password=password;

    }
    @TestData
    public static Collection<Object[]> testData(){
        String path = "src"+ File.separator+"test"+File.separator+"resources"+File.separator+"testdata"+File.separator+"data.xlsx";
        ExcelReader excel = new ExcelReader(path);
        String SheetName = "LoginTest";
        int rows = excel.getRowCount(SheetName);
        int cols = excel.getColumnCount(SheetName);
        excel.getCellData(SheetName,0,2);
        System.out.println("Row are: "+rows+" Cols are: "+cols);
        Object[][] data = new Object[rows-1][cols];
/*        data[0][0] ="trainer@gmail.com";
        data[0][1] ="traidd";


        data[1][0] ="giangthaonexle@gmail.com";
        data[1][1] ="giangthaonexle@gmail.com"; */
/*
        data[0][0] =excel.getCellData(SheetName,0,2);
        data[0][1] =excel.getCellData(SheetName,1,2);


        data[1][0] =excel.getCellData(SheetName,0,3);
        data[1][1] =excel.getCellData(SheetName,1,3);*/
        for(int rowNum=2; rowNum<=rows; rowNum++){
            for(int colNum =0; colNum<cols;colNum++){
                data[rowNum-2][colNum] =excel.getCellData(SheetName,colNum,rowNum);
            }
        }

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

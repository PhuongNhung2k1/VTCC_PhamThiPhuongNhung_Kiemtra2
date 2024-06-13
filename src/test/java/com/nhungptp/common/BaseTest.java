package com.nhungptp.common;

import com.nhungptp.drivers.DriverManager;
import com.nhungptp.helpers.PropertiesHelper;
import com.nhungptp.listeners.TestListener;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

@Listeners({TestListener.class})
public class BaseTest {
    
    @BeforeMethod
    @Parameters({"browserName"})
    public void createDriver(@Optional("chrome") String browserName) {

        WebDriver driver;

        if (!PropertiesHelper.getValue("BROWSER").isEmpty() || PropertiesHelper.getValue("BROWSER") != null) {
            browserName = PropertiesHelper.getValue("BROWSER");
        }

        switch (browserName.trim().toLowerCase()) {
            case "chrome":
                System.out.println("Launching Chrome browser...");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.out.println("Launching Firefox browser...");
                driver = new FirefoxDriver();
                break;
            case "edge":
                System.out.println("Launching Edge browser...");
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
                driver = new ChromeDriver();
        }

        DriverManager.setDriver(driver); //Set to ThreadLocal

        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(PropertiesHelper.getValue("PAGE_LOAD_TIMEOUT"))));
    }

    public void takeScreenAndRecordVideo(){
        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);

        File theDir = new File("./screenshots/");
        if (!theDir.exists()) {
            theDir.mkdirs();
        }

        try {
            FileHandler.copy(source, new File("./screenshots/testLoginSuccess.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Screenshot success !!");

    }
    @AfterMethod
    public void closeDriver(ITestResult iTestResult) {
        DriverManager.quit();
    }

}

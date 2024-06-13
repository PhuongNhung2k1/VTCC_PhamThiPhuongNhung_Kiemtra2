package com.nhungptp.BaiKiemtra2.testcases;

import com.nhungptp.BaiKiemtra2.pages.LoginPage;
import com.nhungptp.common.BaseTest;
import com.nhungptp.helpers.CaptureHelper;
import com.nhungptp.helpers.ExcelHelper;
import com.nhungptp.keywords.WebUI;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("Regression Test v1.0.0")
public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @Feature("Login Test")
    @Description("Test case Login success")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://www.atlassian.com/software/jira/tc_01")
    @Issue("link to issue")
    @Test(priority = 1)
    public void testLoginSuccess() {

        WebUI.sleep(1);
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/AccountLogin.xlsx", "Login");

        loginPage = new LoginPage();
        loginPage.loginCRM(excelHelper.getCellData("EMAIL", 1),
                excelHelper.getCellData("PASSWORD", 1));
        loginPage.verifyLoginSuccess();
        loginPage.logout();
        loginPage.verifyRedirectToLoginPage();

        excelHelper.setCellData("Passed", "STATUS", 1);
        CaptureHelper.captureScreenshot("LoginSuccess");

//        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
//        File source = ts.getScreenshotAs(OutputType.FILE);
//
//        File theDir = new File("./screenshots/");
//        if (!theDir.exists()) {
//            theDir.mkdirs();
//        }
//
//        try {
//            FileHandler.copy(source, new File("./screenshots/testLoginSuccess.png"));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        System.out.println("Screenshot success !!");


    }

    @Feature("Login Test")
    @Description("Test case Login Fail With Email Invalid")
    @Severity(SeverityLevel.TRIVIAL)
    @Test(priority = 2)
    public void testLoginFailWithEmailInvalid() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/AccountLogin.xlsx", "Login");

        loginPage = new LoginPage();
        loginPage.loginCRM(excelHelper.getCellData("EMAIL", 2),
                excelHelper.getCellData("PASSWORD", 2));
        loginPage.verifyLoginFail("Invalid email or password");

        excelHelper.setCellData("Passed", "STATUS", 2);
        WebUI.sleep(1);
    }

    @Test(priority = 3)
    public void testLoginFailWithEmailNull() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/AccountLogin.xlsx", "Login");

        loginPage = new LoginPage();
        loginPage.loginCRM(excelHelper.getCellData("EMAIL", 3),
                excelHelper.getCellData("PASSWORD", 3));
        loginPage.verifyLoginFail("The Email Address field is required. 123");

        excelHelper.setCellData("Passed", "STATUS", 3);
        WebUI.sleep(1);
    }

    @Test(priority = 4)
    public void testLoginFailWithPasswordInvalid() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/AccountLogin.xlsx", "Login");

        loginPage = new LoginPage();
        loginPage.loginCRM(excelHelper.getCellData("EMAIL", 4),
                excelHelper.getCellData("PASSWORD", 4));
        loginPage.verifyLoginFail("Invalid email or password");

        excelHelper.setCellData("Passed", "STATUS", 4);
    }

    @Test(priority = 5)
    public void testLoginFailWithPasswordNull() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/AccountLogin.xlsx", "Login");

        loginPage = new LoginPage();
        loginPage.loginCRM(excelHelper.getCellData("EMAIL", 5),
                excelHelper.getCellData("PASSWORD", 5));
        loginPage.verifyLoginFail("The Password field is required.");

        excelHelper.setCellData("Passed", "STATUS", 5);
        WebUI.sleep(1);
    }
}

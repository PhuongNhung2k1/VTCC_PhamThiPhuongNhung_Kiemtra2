package com.nhungptp.BaiKiemtra2.pages;

import com.nhungptp.helpers.PropertiesHelper;
import com.nhungptp.keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage extends CommonPage {

    private String URL = "https://cms.anhtester.com/login";

    public LoginPage() {
    }

    private By headerPage = By.xpath("//h1[normalize-space()='Login']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By errorMessage = By.xpath("//div[contains(@class,'alert alert-danger')]");

    public LoginPage loginCRM(String email, String password) {
        WebUI.openURL(PropertiesHelper.getValue("URL"));
        WebUI.waitForPageLoaded();
        WebUI.setText(inputEmail, email);
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(buttonLogin);

        return new LoginPage();
    }

    public void verifyLoginSuccess() {
        Assert.assertFalse(WebUI.getCurrentUrl().contains("authentication"), "FAIL. Vẫn đang ở trang Login");
    }

    public void verifyLoginFail(String errorMassageContent) {
        Assert.assertTrue(WebUI.getCurrentUrl().contains("authentication"), "FAIL. Không còn ở trang Login");
        Assert.assertTrue(WebUI.isDisplayed(errorMessage), "Error message NOT displays");
        Assert.assertEquals(WebUI.getElementText(errorMessage), errorMassageContent, "Content of error massage NOT match.");
    }


}

package com.nhungptp.BaiKiemtra2.pages;

import com.nhungptp.keywords.WebUI;
import org.openqa.selenium.By;

public class CommonPage {

    public CommonPage() {
    }

    public By inputSearch = By.xpath("//input[@id='search_input']");
    public By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");

    public By menuProject = By.xpath("//span[normalize-space()='Projects']");
    public By dropdownProfile = By.xpath("//a[contains(@class,'dropdown-toggle profile')]");
    public By itemLogout = By.xpath("//a[contains(@class,'dropdown-toggle profile')]/following-sibling::ul//a[normalize-space()='Logout']");

    // vao trang produt
    public By menuProduct = By.xpath("//span[normalize-space()='Products']");
    public By menuAddNewProduct = (By.xpath("//span[normalize-space()='Add New Product']"));;



    public AddNewProductPage openProductPage() {
        WebUI.clickElement(menuProduct);
        WebUI.clickElement(menuAddNewProduct);
        WebUI.waitForPageLoaded();

        return new AddNewProductPage();
    }


    public LoginPage logout() {
        WebUI.clickElement(dropdownProfile);
        WebUI.sleep(1);
        WebUI.clickElement(itemLogout);
        WebUI.waitForPageLoaded();

        return new LoginPage();
    }

    public void searchCommon(String text){
        WebUI.setText(inputSearch, text);
    }


}

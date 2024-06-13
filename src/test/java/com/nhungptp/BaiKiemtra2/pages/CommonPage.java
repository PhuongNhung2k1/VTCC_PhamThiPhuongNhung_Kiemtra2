package com.nhungptp.BaiKiemtra2.pages;

import com.nhungptp.keywords.WebUI;
import org.openqa.selenium.By;

public class CommonPage {

    public CommonPage() {
    }

    public By inputSearch = By.xpath("//input[@id='search_input']");
    // vao trang produt
    public By menuProduct = By.xpath("//span[normalize-space()='Products']");
    public By menuAddNewProduct = (By.xpath("//span[normalize-space()='Add New Product']"));;



    public AddNewProductPage openProductPage() {
        WebUI.clickElement(menuProduct);
        WebUI.clickElement(menuAddNewProduct);
        WebUI.waitForPageLoaded();

        return new AddNewProductPage();
    }

    public void searchCommon(String text){
        WebUI.setText(inputSearch, text);
    }


}

package com.nhungptp.BaiKiemtra2.testcases;

import com.nhungptp.BaiKiemtra2.pages.LoginPage;
import com.nhungptp.common.BaseTest;
import org.testng.annotations.Test;

public class AddNewProductTest extends BaseTest {
    LoginPage loginPage;


    @Test
    public void testAddNewProduct() {
        loginPage = new LoginPage();

        //Fluent design pattern
        loginPage.loginCRM("admin@example.com", "123456")
                .openProductPage()
                .addNewProductFail()
                .addNewProduct();

//        loginPage.loginCRM("admin@example.com", "123456")
//                .openCustomerPage()
//                .verifyRedirectToCustomerPage()
//                .addNewCustomer(CUSTOMER_NAME)
//                .verifyAddNewCustomer(CUSTOMER_NAME);

    }

}


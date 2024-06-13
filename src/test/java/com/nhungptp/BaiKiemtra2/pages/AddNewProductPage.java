package com.nhungptp.BaiKiemtra2.pages;

import com.nhungptp.helpers.CaptureHelper;
import com.nhungptp.keywords.WebUI;
import org.openqa.selenium.By;


public class AddNewProductPage extends CommonPage {


    public AddNewProductPage() {
    }

    String Product_name = "npp";

    private By menuProduct = By.xpath("//span[normalize-space()='Products']");

    private By inputProductName = By.xpath("//input[@placeholder='Product Name']");
    private By menuAddNewProduct = By.xpath("//span[normalize-space()='Add New Product']");

    //choose category
    //click vao dropdown >> chon Sport shoes

    private By findCategoryLabel = By.xpath("//div[contains(text(),'Sport shoes')]");
    private By chooseCategoryValue = By.xpath("//li//a[@id='bs-select-1-1']");

    //

    private By categoryName = By.xpath("//label[normalize-space()='Category ']/following-sibling::div//button");

    //choose brand
    private By brandName = By.xpath("//label[normalize-space()='Brand']/following-sibling::div//button");
    private By chooseBrandValue = By.xpath("//a[@id='bs-select-2-1']");

    //product unit
    private By inputUnitproduct = By.xpath("//input[@placeholder='Unit (e.g. KG, Pc etc)']");

    //product weight
    private By inputWeight = By.xpath("//input[@placeholder='0.00']");

    // input minipurchase
    private By minimumPurchaseQty = By.xpath("//input[@name='min_qty']");

    //Input Tags and enter
    private By inputTag = By.xpath("//span[@role='textbox']");

    // file GalleryImage

    private By findGalleryImage = By.xpath("//label[normalize-space()='Gallery Images (600x600)']/following-sibling::div");
    private By chooseGalleryImage = By.xpath("//div[@title='anh.png']");
    private By clickAddGalleryImage = By.xpath("//button[normalize-space()='Add Files']");
    // file Thumbnail Image

    private By findThumbnailImage = By.xpath("//label[normalize-space()='Thumbnail Image (300x300)']/following-sibling::div//div[2]");
    private By chooseThumbnailImage = By.xpath("//div[@title='Cosy.png']//img[@class='img-fit']");
    private By clickThumbnailImage = By.xpath("//button[normalize-space()='Add Files']");

    //video provider
    private By findToVideoProvider = By.xpath("//div[contains(text(),'Youtube')]");
    private By choseVideoProvider = By.xpath("//li//a[@id='bs-select-3-1']");

    //dan link vao
    private By videoLink = By.xpath("//input[@placeholder='Product Name']");

    //field color

    private By showChoseColors = By.xpath("//div[@class='col-md-1']//label[@class='aiz-switch aiz-switch-success mb-0']");
    private By clickViewColor = By.xpath("(//div[contains(text(),'Nothing selected')])[1]");
    private By choseColorValue = By.xpath("//li//a[@id='bs-select-4-3']");

    //choose attribute
    private By Attributes = By.xpath("//button[@class='btn dropdown-toggle btn-light bs-placeholder']");

    //unit price
    private By inputUnitPrice = By.xpath("//input[@placeholder='Unit price']");
    private By discountDatRange = By.xpath("//input[@placeholder='Product Name']");

    //low stock quantity
    private By inputLowQuantity = By.xpath("//input[@name='low_stock_quantity']");
    //select date range

    private By clickDate = By.xpath("//input[@placeholder='Select Date']");
    private By chooseStartDate = By.xpath("//td[@class='today active start-date active end-date available']");
    private By chooseEndDate = By.xpath("//td[@class='today available in-range']");
    private By addSaveDate = By.xpath("//td[@class='today active start-date active end-date available']");

    //Discount
    private By inputDiscount = By.xpath("//input[@placeholder='Discount']");

    //send key
    private By inputSku = By.xpath("//input[@placeholder='SKU']");
    private By inputProductQuantity = By.xpath("//input[@placeholder='Quantity']");


    private By externalLink = By.xpath("//input[@placeholder='External link']");

    private By externalLinkButton = By.xpath("//input[@placeholder='External link button text']");

    //Product description

    private By productDescription = By.xpath("//div[@role='textbox']");

    //input metaTitle
    private By metaTitle = By.xpath("//input[@placeholder='Meta Title']");

    //description meta title
    private By metaDescription = By.xpath("//textarea[@name='meta_description']");
    //meta image
    private By linkToMetaImage = By.xpath("//label[normalize-space()='Meta Image']//following-sibling::div");
    private By clickMetaImage = By.xpath("//div[@title='images.jpg']//img[@class='img-fit']");
    private By addMetaImage = By.xpath("//button[normalize-space()='Add Files']");

    private By lowSTockQuantity = By.xpath("//input[@placeholder='Product Name']");
    private By showStockQuantity = By.xpath("//input[@placeholder='Product Name']");
    private By showStockWithtextOnly = By.xpath("//input[@placeholder='Product Name']");
    private By hideStock = By.xpath("//input[@placeholder='Product Name']");
    private By CashOnDeliverStatus = By.xpath("//input[@placeholder='Product Name']");

    //turn on status featur
//    private By featureStatus = By.xpath("//input[@name='featured']");
    private By featureStatus = By.xpath("(//label[contains(text(),'Status')])[2]//following-sibling::div/label/input");

    //Today
    private By showTodayDeal = By.xpath("(//label[contains(text(),'Status')])[3]//following-sibling::div//input");

    private By addToFlashTitle = By.xpath("//label[normalize-space()='Add To Flash']/following-sibling::div//button");
    private By discountType = By.xpath("//label[normalize-space()='Discount Type']/following-sibling::div//button");
    private By FlashDiscounttype = By.xpath("//input[@placeholder='Product Name']");
    //send key shipday
    private By estimateShipday = By.xpath("//input[@placeholder='Shipping Days']]");

    private By numberTax = By.xpath("//input[@placeholder='Tax']");
    private By chosevalueTax = By.xpath("//label[normalize-space()='Tax']/following-sibling::div//button");

    private By Vax = By.xpath("//input[@placeholder='Product Name']");
    private By buttonSavePush = By.xpath("//button[normalize-space()='Save & Publish']");

    //Search product
    private By searchProduct = By.xpath("//span[normalize-space()='Product has been inserted successfully']");
    private By inputNameProductToSearch = By.xpath("//input[@id='search']");
//    private By searchProduct = By.xpath("//span[normalize-space()='Product has been inserted successfully']");
//   check alert message
//       Assert.assertTrue(driver.findElement(By.xpath("//span[normalize-space()='Product has been inserted successfully']")).isDisplayed(),"the alert message success not display");

    public AddNewProductPage addNewProductFail(){
        WebUI.setText(inputProductName, "");
        WebUI.clickElement(buttonSavePush);

        WebUI.sleep(1);
        return this;
    }

    public AddNewProductPage addNewProduct() {

        WebUI.waitForPageLoaded();
        WebUI.setText(inputProductName, Product_name);

        WebUI.clickElement(findCategoryLabel);
        WebUI.clickElement(chooseCategoryValue);

        WebUI.sleep(1);
        WebUI.clickElement(brandName);
        WebUI.clickElement(chooseBrandValue);

        WebUI.setText(inputUnitproduct, "Kg");

        //weight
        WebUI.setText(inputWeight, "0,5");

        WebUI.setText(minimumPurchaseQty, "1");

        //set Tag
        WebUI.setText(inputTag, "Clother");
        WebUI.pressENTER();

        WebUI.clickElement(findGalleryImage);
        WebUI.clickElement(chooseGalleryImage);
        WebUI.clickElement(clickAddGalleryImage);

        WebUI.sleep(2);
        WebUI.clickElement(findThumbnailImage);
        WebUI.clickElement(chooseThumbnailImage);
        WebUI.clickElement(clickThumbnailImage);
        WebUI.sleep(1);
        //product video
        WebUI.clickElement(findToVideoProvider);
        WebUI.clickElement(choseVideoProvider);
        //video link
        WebUI.sleep(1);

        WebUI.clickElement(showChoseColors);
        WebUI.clickElement(clickViewColor);
        WebUI.clickElement(choseColorValue);
        WebUI.clickElement(showChoseColors);

        WebUI.sleep(1);
        WebUI.setText(inputUnitPrice, "200");

        WebUI.sleep(2);

//        WebUI.clickElement(featureStatus);

        WebUI.sleep(1);


//        WebUI.clickElement(clickDate);
//        WebUI.clickElement(chooseEndDate);
//        WebUI.clickElement(chooseEndDate);
//
//        WebUI.clickElement(addSaveDate);

        //discout
        WebUI.setText(inputDiscount, "5");
        WebUI.sleep(1);
        WebUI.setText(inputProductQuantity, "20");
        WebUI.sleep(1);
        WebUI.setText(inputSku, "9");
        WebUI.setText(externalLink, "https://viettel.com.vn");
        WebUI.sleep(1);

        //product description
        WebUI.setText(productDescription, "Product description");
        WebUI.sleep(2);
        //meta tile
        WebUI.setText(metaTitle, "This is meta title");
        WebUI.sleep(2);
        //Description title
        WebUI.setText(metaDescription, "This is meta description");
        WebUI.sleep(2);

        //meta image
        WebUI.clickElement(linkToMetaImage);
        WebUI.clickElement(clickMetaImage);
        WebUI.clickElement(addMetaImage);
        WebUI.sleep(2);

        //show today
//        WebUI.clickElement(showTodayDeal);
        //stock quantity
        WebUI.setText(inputLowQuantity, "5");
        CaptureHelper.captureScreenshot("AddProductSucess");
        ///SAVE product
        WebUI.clickElement(buttonSavePush);
        WebUI.sleep(1);
        CaptureHelper.captureScreenshot("AddNewProductSuccess");

        WebUI.setText(inputNameProductToSearch, Product_name);
        WebUI.pressENTER();
        WebUI.sleep(3);
        CaptureHelper.captureScreenshot("SearchSuccess");
        return this;

    }
}


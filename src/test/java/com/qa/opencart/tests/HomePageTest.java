package com.qa.opencart.tests;


import com.qa.opencart.base.BaseTest;
import com.qa.opencart.tests.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.*;

public class HomePageTest extends BaseTest {

    @Test
    public void homePageTitleTest() {
        String actualTitle = homePage.getHomePageTitle();
        Assert.assertEquals(actualTitle, AppConstants.HOME_PAGE_TITLE);
    }

    @Test
    public void homePageUrlTest() {
        String actualUrl = homePage.getHomePageUrl();
        Assert.assertEquals(actualUrl, prop.getProperty("url"));
    }

    @Test
    public void searchTest() {
        String actualSearchHeader = homePage.doSearch("imac");
        Assert.assertEquals(actualSearchHeader, "Search - imac");
    }

    @DataProvider
    public Object[][] getProductData() {
        return new Object[][]{
                {"Macbook"},
                {"imac"},
                {"Samsung"}
        };
    }

    @Test(dataProvider = "getProductData")
    public void searchTestDataprovider(String productName) {
        String actualSearchHeader = homePage.doSearch(productName);
        Assert.assertEquals(actualSearchHeader, "Search - " + productName);
    }


}
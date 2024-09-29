package com.qa.opencart.base;

import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {

    PlaywrightFactory pf;
    Page page;
    public Properties prop;

    protected HomePage homePage;
    protected LoginPage loginPage;

    @BeforeTest
    public void setUp() {
        pf = new PlaywrightFactory();
        prop = pf.init_prop();
        page = pf.initBroser(prop);
        homePage = new HomePage(page);
    }


    @AfterTest
    public void tearDown() {
        // page.context().browser().close();
    }


}

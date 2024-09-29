package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.tests.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test(priority = 1)
    public void loginPageNavigationTest() {
        loginPage = homePage.navigateToLoginpage();
        String actualLoginPageTitle = loginPage.getLoginPageTitle();
        Assert.assertEquals(actualLoginPageTitle, AppConstants.LOGIN_PAGE_TITLE);
    }

    @Test(priority = 2)
    public void forgetPwdLinkExistTest() {
      loginPage.forgetPwdLinkExist();
    }

    @Test(priority = 3)
    public void appLoginTest() throws InterruptedException {
        Assert.assertTrue(loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password")));
    }




}
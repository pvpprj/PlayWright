package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    private Page page;

    //1. String locator -OR

    private String emailId = "//input[@id='input-email']";
    private String password = "//input[@id='input-password']";
    private String loginButton = "//input[@value='Login']";
    private String forgotPassword = "//div[@class='form-group']//a[normalize-space()='Forgotten Password']";
    private String logoutLink = "//a[@class='list-group-item'][normalize-space()='Logout']";

    //2. Page Constructor
    public LoginPage(Page page) {
        this.page = page;
    }

    //3. Page actions/methods
    public String getLoginPageTitle() {
        String title = page.title();
        System.out.println("Login Page title = " + title);
        return title;
    }

    public boolean forgetPwdLinkExist() {
        return page.isVisible(forgotPassword);
    }

    public boolean doLogin(String appUserName, String appPassword) {
        System.out.println("App credentials: " + appUserName + " : " + appPassword);
        page.fill(emailId, appUserName);
        page.fill(password, appPassword);
        page.click(loginButton);

        if (page.isVisible(logoutLink)) {
            System.out.println("User is Successfully Logged in......");
            return true;
        }
        else
            return false;
    }


}

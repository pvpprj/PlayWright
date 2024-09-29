package com.qa.opencart.pages;

import com.microsoft.playwright.*;

public class HomePage {

    private Page page;

    //1. String locator -OR

    private String search = "input[name='search']";
    private String searchIcon = "div#search button";
    private String searchPageHeader = "div#content h1";
    private String loginLink = "a:text('Login')";
    private String myAccountLink ="a[title='My Account']";

    //2. Page Constructor
    public HomePage(Page page) {
        this.page = page;
    }

    //3. Page actions/methods
    public String getHomePageTitle() {
        String title = page.title();
        System.out.println("Page title = "+title);
        return  title;
    }

    public String getHomePageUrl() {
        String url = page.url();
        System.out.println("Page Url = "+url);
        return  url;
    }

    public String doSearch(String productName) {
        page.fill(search, productName);
        page.click(searchIcon);
        String header = page.textContent(searchPageHeader);
        System.out.println("Search Header = "+header);
        return header;
    }

    public LoginPage navigateToLoginpage(){
        page.click(myAccountLink);
        page.click(loginLink);
        return new LoginPage(page);
    }




}


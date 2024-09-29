package PlayWrightPractice_1_29;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Z_18_FillFormUsingRelative_locator {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

//        page.navigate("https://sso.teachable.com/secure/9521/identity/sign_up/email");
//        page.locator("input:below(label:text('Full Name'))").first().fill("Test123");
//        page.locator("input:below(label:text('Email'))").first().fill("Email12345");
//        page.locator("input:below(label:text('Password'))").first().fill("Password123");

//        page.navigate("https://selectorshub.com/xpath-practice-page/");
//        page.locator("input:below(label:text('User Email'))").first().fill("Test123");
//        page.locator("input:below(label:text('Password'))").first().fill("Email12345");
//        page.locator("input:below(label:text('Company'))").first().fill("Password123");
//        page.locator("input:below(label:text('Mobile Number'))").first().fill("Password123");

        page.navigate("https://www.spicejet.com/profile/sign-up");

        page.locator("div:has-text('Mr'):below(:text('Title'))").first().click();
        page.locator("input:below(:text('First and Middle Name'))").first().fill("First Name");
        page.locator("input:below(:text('Last Name'))").first().fill("Last Name");

        System.out.println("-------------------Pass-----------------------------------");
    }
}

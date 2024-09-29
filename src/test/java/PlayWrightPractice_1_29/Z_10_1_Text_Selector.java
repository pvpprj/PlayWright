package PlayWrightPractice_1_29;

import com.microsoft.playwright.*;

public class Z_10_1_Text_Selector {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page= browser.newPage();
        page.navigate("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

//       Locator email = page.locator("input#input-email");
//        email.click(); email.fill("Test");
//        page.locator("input#input-password").fill("Password");
//        page.locator("form input:has-text('Login')").click();

        page.locator("//input[@value='Login']").click();

        System.out.println("------------------------Done Z_10_1_Text_Selector------------------------------");
       // page.close();
    }
}
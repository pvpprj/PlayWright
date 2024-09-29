package PlayWrightPractice_1_29;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class Z_8_BrowserContext {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext br1 = browser.newContext();
        Page page1 = br1.newPage();
        page1.navigate("https://www.orangehrm.com/orangehrm-30-day-trial/");
        page1.fill("#Form_getForm_Name","Rahul");
        System.out.println("Title = "+page1.title());

        BrowserContext br2 = browser.newContext();
        Page page2 = br2.newPage();
        page2.navigate("https://academy.naveenautomationlabs.com/");
        page2.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();
        page2.frameLocator("#microfe-popup-login").getByText("Sign up").click();
        page2.frameLocator("#microfe-popup-login").getByPlaceholder("Name").fill("Test123");
        System.out.println("Title = "+page2.title());

//        page1.close();        br1.close();
//        page2.close();   br2.close();


    }
}
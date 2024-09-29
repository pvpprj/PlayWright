package PlayWrightPractice_1_29;

import com.microsoft.playwright.*;

public class Z_29_WindowPopUp {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext br1 =browser.newContext();
        Page page = br1.newPage();
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Page popup= page.waitForPopup(()->{
            page.click("//div[@class='orangehrm-login-footer-sm']/a[3]");
        });
        popup.waitForLoadState();

        System.out.println("pop up window Title = "+popup.title());
        popup.close();
        System.out.println("Parent up window Title = "+page.title());
        page.close();


       /* BrowserContext br1 =browser.newContext();
        BrowserContext br2 =browser.newContext();

        Page page1 = br1.newPage();
        Page page2 = br2.newPage();

        page1.navigate("https://academy.naveenautomationlabs.com/");
        page2.navigate("https://www.amazon.in/");*/

        System.out.println("----------------------Done--------------------------");
    }
}


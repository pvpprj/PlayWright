package PlayWrightPractice_1_29;

import com.microsoft.playwright.*;

public class Z_29_2_new__blank_Window {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext br1 =browser.newContext();
        Page page = br1.newPage();
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Page popup= page.waitForPopup(()->{
            page.click("a[target='_blank']"); // open a new tab windows as blank
        });

        popup.waitForLoadState();
        popup.navigate("https://www.google.com/");

        System.out.println("pop up window Title = "+popup.title());
        //    popup.close();
        System.out.println("Parent up window Title = "+page.title());
        //  page.close();



        System.out.println("----------------------Done--------------------------");
    }
}


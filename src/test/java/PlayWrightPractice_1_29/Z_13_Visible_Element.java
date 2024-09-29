package PlayWrightPractice_1_29;

import com.microsoft.playwright.*;
import com.microsoft.playwright.Playwright;

import java.util.List;

public class Z_13_Visible_Element {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://www.amazon.com");

        List ll = page.locator("a:visible").allInnerTexts();
        System.out.println("Size -------- " + ll.size());

        for (int i = 0; i < ll.size(); i++) {
            System.out.println(ll.get(i));
        }

        int total = page.locator("xpath=//img >> visible=true").count();
        System.out.println("total count = " + total);
        System.out.println("------------------------------------------------------");
        System.out.println("------------------------------------------------------");

        int ff = page.locator("xpath=//img >> visible=true").count();
        System.out.println("Size -------- " + ff);

    }
}
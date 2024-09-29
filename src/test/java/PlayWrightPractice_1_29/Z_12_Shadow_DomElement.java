package PlayWrightPractice_1_29;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Z_12_Shadow_DomElement {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

       /* page.navigate("https://books-pwakit.appspot.com/");
        page.locator("book-app[apptitle='BOOKS'] #input").fill("Testing Book");
        String ss = page.locator("book-app[apptitle='BOOKS'] .books-desc").textContent();
        System.out.println(ss);*/

        page.navigate("https://selectorshub.com/iframe-in-shadow-dom/");
        page.locator("div[id='page'] #kils").fill("Test");


        System.out.println("-------------------Pass-----------------------------------");
    }
}

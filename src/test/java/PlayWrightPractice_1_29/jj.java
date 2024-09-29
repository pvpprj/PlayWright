package PlayWrightPractice_1_29;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class jj {
    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
            Page page= browser.newPage();
            page.navigate("https://playwright.com/");



        }
    }
}

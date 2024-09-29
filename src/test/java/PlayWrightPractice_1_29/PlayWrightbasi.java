package PlayWrightPractice_1_29;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

public class PlayWrightbasi {

    Playwright playwright = Playwright.create();
    Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
    Page page = browser.newPage();

    @Test
    public void TestCase1() {
        page.navigate("https://www.amazon.in");

        String title =page.title();
        System.out.println("Page title is = "+title);

       String url= page.url();
        System.out.println("Page url is = "+title);

        browser.close();
    }
}

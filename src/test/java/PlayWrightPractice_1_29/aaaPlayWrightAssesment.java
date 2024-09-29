package PlayWrightPractice_1_29;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.Assert;
import org.testng.annotations.*;

public class aaaPlayWrightAssesment {
    Playwright playwright;
    Browser browser;
    Page page;

    @BeforeClass
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setChannel("chrome"));
    }
    @Test
    public void TestCase1() {
        page = browser.newPage();
        page.navigate("https://ecommerce-playground.lambdatest.io/");
        String pageTitle = page.title();
        Assert.assertEquals(pageTitle, "Your Store");
    }

    @AfterClass
    public void tearDown() {
        browser.close();
    }

}
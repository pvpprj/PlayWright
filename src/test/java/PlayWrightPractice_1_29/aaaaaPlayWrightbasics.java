package PlayWrightPractice_1_29;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class aaaaaPlayWrightbasics {

    Playwright   playwright = Playwright.create();
    Browser  browser  =playwright.chromium().launch();
    Page  page = browser.newPage();

    @Test
    public void TestCase1() {
//        page = browser.newPage();
        page.navigate("https://ecommerce-playground.lambdatest.io/");
        String pageTitle = page.title();
        Assert.assertEquals(pageTitle, "Your Store");
    }

    @AfterClass
    public void tearDown() {
        browser.close();
    }

  /*  @BeforeClass
    public void setUp() {
        playwright = Playwright.create();
        browser  =playwright.chromium().launch();
    }*/

}

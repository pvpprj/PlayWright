package PlayWrightPractice_1_29;

import com.microsoft.playwright.*;

public class Z_21_ScopeLocators {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

//        page.navigate("https://datatables.net/extensions/select/examples/checkbox/checkbox.html");
//        Locator row = page.locator("table#example tr");
//        row.locator(":scope", new Locator.LocatorOptions().
//                setHasText("Ashton Cox")).locator(".dt-select-checkbox").click();
//
//        row.locator(":scope").allTextContents().forEach(e -> System.out.println(e));

        page.navigate("https://primeng.org/");
        Locator row = page.locator("table#pn_id_1-table tr");
        row.locator(":scope",new Locator.LocatorOptions().setHasText(" Art Venere ")).locator(".p-checkbox-box").click();

        row.locator(":scope").allTextContents().forEach(e->System.out.println(e));


    }
}
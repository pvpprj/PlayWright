package PlayWrightPractice_1_29;

import com.microsoft.playwright.*;

public class Z_15_has_Element {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.orangehrm.com/orangehrm-30-day-trial/");

        Locator loc = page.locator("select#Form_getForm_Country:has(option[value='India'])");
        loc.allTextContents().forEach(e->System.out.println(e));



    }
}
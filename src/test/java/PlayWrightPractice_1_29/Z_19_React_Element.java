package PlayWrightPractice_1_29;

import com.microsoft.playwright.*;

import java.util.List;

public class Z_19_React_Element {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://www.netflix.com/in/");
        Locator email = page.locator("_react=Anonymous[name='email'] >> input").first();
        email.click();
        email.fill("Test.com");

        Locator submit = page.locator("_react=Anonymous[type='submit'] >> div").first();
        submit.click();
        //  submit.fill("Test");

        Locator footer = page.locator("_react=Anonymous[className=' default-ltr-cache-gvst1o']");
        List<String> footerList = footer.allTextContents();

        for (String ss : footerList) {
            System.out.println(ss);

        }


        System.out.println("-------------------Pass-----------------------------------");
    }
}

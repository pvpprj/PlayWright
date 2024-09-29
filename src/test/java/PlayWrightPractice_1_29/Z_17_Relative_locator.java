package PlayWrightPractice_1_29;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.*;

import java.util.List;

public class Z_17_Relative_locator {
    static Page page;

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();

        page.navigate("https://selectorshub.com/xpath-practice-page/");

//        page.locator("input[type='checkbox']:left-of(:text('Joe.Root'))").first().click();
        selectUser("Joe.Root");
        selectUser("John.Smith");
//        String role = page.locator("td:right-of(:text('Joe.Root'))").first().textContent();
//        System.out.println("user role: " + role);
        System.out.println(userRole("Joe.Root"));

        String aboveUser = page.locator("a:above(:text('Joe.Root'))").first().textContent();
        System.out.println("aboveUser: " + aboveUser);

        String belowUser = page.locator("a:below(:text('Joe.Root'))").first().textContent();
        System.out.println("belowUser: " + belowUser);

        Locator nearElements = page.locator("td:near(:text('Joe.Root'),400)");

        List<String> nearEleText = nearElements.allInnerTexts();
        for (String text : nearEleText) {
            System.out.println(text);
        }

        System.out.println("-------------------Pass-----------------------------------");
    }

    public static void selectUser(String user_name) {
        page.locator("input[type='checkbox']:left-of(:text('" + user_name + "'))").first().click();
    }

    public static String userRole(String user_name) {
        return page.locator("td:right-of(:text('" + user_name + "'))").first().textContent();
    }


}

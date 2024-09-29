package PlayWrightPractice_1_29;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.*;

public class Z_17_NthElementSelector {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.bigbasket.com/");

         Locator firstEle= page.locator("div.flex li a >> nth=1");
        String firstElement=firstEle.textContent();
         System.out.println("firstElement = "+firstElement);
         firstEle.click();

//        Locator LastEle= page.locator("div.flex li a >> nth=-1");
//        String LastElement=LastEle.textContent();
//        System.out.println("LastElement = "+LastElement);

        System.out.println("-------------------Pass-----------------------------------");
    }
}

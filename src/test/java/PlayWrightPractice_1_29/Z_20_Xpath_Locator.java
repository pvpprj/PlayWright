package PlayWrightPractice_1_29;

import com.microsoft.playwright.*;

public class Z_20_Xpath_Locator {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

//        page.navigate("https://www.amazon.com/");
//        page.locator("xpath= //input[@id='twotabsearchtextbox']").fill("Iphone");

        page.navigate("https://selectorshub.com/xpath-practice-page/");

//        String Username ="Garry.White";
//        page.locator("//a[text()='"+Username+"']/..//preceding-sibling::td/input").click();

        Locator checkBox = page.locator("//table[@id='resultTable']//input[@type='checkbox']");
        for(int i=0;i<checkBox.count();i++){
            checkBox.nth(i).click();
        }

        System.out.println("-------------------Pass-----------------------------------");
    }
}

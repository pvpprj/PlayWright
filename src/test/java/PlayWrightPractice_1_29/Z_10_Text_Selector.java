package PlayWrightPractice_1_29;

import com.microsoft.playwright.*;

public class Z_10_Text_Selector {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page= browser.newPage();
        page.navigate("https://www.orangehrm.com/orangehrm-30-day-trial/");

     //   page.locator("text =Contact Sales").last().click();
     Locator link = page.locator("text =Privacy Policy") ;
        for (int i=0;i< link.count();i++){
            System.out.println(link.nth(i).textContent());
            String policy = link.nth(i).textContent();
            if(policy.contains(" Service Privacy Policy"))  {
                link.nth(i).click();
                break;
            }      }

        System.out.println("------------------------Done Z_10_Text_Selector------------------------------");
    }
}

package PlayWrightPractice_1_29;

import com.microsoft.playwright.*;

import java.util.List;

public class Z_9_Locator_Concept {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();
        page.navigate("https://www.orangehrm.com/orangehrm-30-day-trial/");
//        page.navigate("https://academy.naveenautomationlabs.com/");
         //   page.navigate("https://in.bookmyshow.com/explore/home/mumbai");

        // Single Element
//        Locator contact_Sales = page.locator("text =Contact Sales");
//       int count = contact_Sales.count();
//        System.out.println("count = "+count);
//        contact_Sales.last().click();

        // Multiple Element
          Locator country = page.locator("select#Form_getForm_Country option");
        System.out.println("Count = "+country.count());

//        for (int i = 0; i < country.count(); i++) {
//            String cou = country.nth(i).textContent();
//            System.out.println(cou);
//        }

        List<String> optionCountry = country.allTextContents();
//          for (String list : optionCountry) {
//              System.out.println(list);
//          }

        optionCountry.forEach(ele -> System.out.println(ele));


//        Locator signIn = page.locator("text =Sign in");
//        signIn.hover();        signIn.click();

//        Locator login = page.locator("text =Login");
//        login.hover();        login.click();



        System.out.println("------------------------Done------------------------------");





    }
}

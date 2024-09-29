package PlayWrightPractice_1_29;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Z_11_FrameHandle {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page= browser.newPage();
       // page.navigate("https://www.londonfreelance.org/courses/frames/index.html");
//        String ss = page.frameLocator("//frame[@name='main']").locator("h2").textContent();
//        System.out.println("Header = "+ss);
//        String header =   page.frame("main").locator("h2").textContent();
//        System.out.println("Header = "+header);

        page.navigate("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");

        page.locator("//img[@title='Vehicle-Registration-Forms-and-Examples']").click();

        page.frameLocator("//iframe[contains(@id,'frame-one')]").locator("//input[@id='RESULT_TextField-8']").fill("Rahul");
//input[@id='RESULT_TextField-8']

        System.out.println("-------------------Pass-----------------------------------");



    }
}

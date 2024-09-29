package PlayWrightPractice_1_29;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;

public class Z_28_Video_Record {
    public static void main(String[] args) {
        //  mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="codegen https://academy.naveenautomationlabs.com/"

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext context = browser.newContext(new Browser.NewContextOptions().
                setRecordVideoDir(Paths.get("myvideos/")));

        Page page = context.newPage();
        page.navigate("https://academy.naveenautomationlabs.com/");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();
        page.frameLocator("#microfe-popup-login").getByText("Sign up").click();
        page.frameLocator("#microfe-popup-login").getByPlaceholder("Name").click();
        page.frameLocator("#microfe-popup-login").getByPlaceholder("Name").click();
        page.frameLocator("#microfe-popup-login").getByPlaceholder("Name").fill("Test123");
        page.frameLocator("#microfe-popup-login").getByPlaceholder("Email address").click();
        page.frameLocator("#microfe-popup-login").getByPlaceholder("Email address").fill("test@gmail.com");
        page.frameLocator("#microfe-popup-login").getByPlaceholder("Password").click();
        page.frameLocator("#microfe-popup-login").getByPlaceholder("Password").fill("Test@12345");
        page.frameLocator("#microfe-popup-login").getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("India: + 91")).click();
        page.frameLocator("#microfe-popup-login").getByPlaceholder("Enter your number").click();
        page.frameLocator("#microfe-popup-login").getByPlaceholder("Enter your number").fill("+91 98672-66823");
        page.frameLocator("#microfe-popup-login").getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("Next")).click();
        page.frameLocator("#microfe-popup-login").getByText("We already have this email ID registered with us. Welcome back! Please click on ").click();
        page.frameLocator("#microfe-popup-login").locator("#loginPopupCloseBtn svg").click();

        browser.close();
        page.close();
        playwright.close();

        System.out.println("----------------------------Done----------------------------");

    }
}

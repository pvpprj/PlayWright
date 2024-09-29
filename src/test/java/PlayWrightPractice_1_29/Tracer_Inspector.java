package PlayWrightPractice_1_29;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;

public class Tracer_Inspector {
    public static void main(String[] args) {

        // mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="show-trace trace.zip"

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
     context.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true).setSources(true));

            Page page = context.newPage();
            page.navigate("https://academy.naveenautomationlabs.com/");
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();
            page.frameLocator("#microfe-popup-login").getByText("Sign up").click();
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Name").click();
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Name").fill("Test");
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Name").press("Tab");
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Email address").fill("test@gmail.com");
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Email address").press("Tab");
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Password").fill("Test@123");
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Password").press("Tab");
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Enter your number").click();
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Enter your number").fill("+91 98266-626262");
            page.frameLocator("#microfe-popup-login").getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("Next")).click();
            page.frameLocator("#microfe-popup-login").locator("#loginPopupCloseBtn svg").click();

            System.out.println("------------------Pass----------------------------");
            context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace.zip")));
        }
    }
}

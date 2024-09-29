package PlayWrightPractice_1_29;

import com.microsoft.playwright.*;
import java.nio.file.Paths;

public class Z_22_Automatic_Login {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();

        Page page = context.newPage();
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        page.fill("input[name='username']","Admin");
        page.fill("input[name='password']","admin123");
        page.click("button:text('Login')");

        context.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("applogin.json")));


        System.out.println("-------------------Pass-----------------------------------");
    }
}
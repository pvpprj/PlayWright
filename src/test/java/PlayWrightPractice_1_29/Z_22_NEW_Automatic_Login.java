package PlayWrightPractice_1_29;

import com.microsoft.playwright.*;
import java.nio.file.Paths;

public class Z_22_NEW_Automatic_Login {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("applogin.json")));

        Page page = context.newPage();
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
}
package PlayWrightPractice_1_29;

import com.microsoft.playwright.*;

import java.awt.*;

public class Z_26_MaximizeBrowser {
    public static void main(String[] args) {

        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screensize.getWidth();
        int hight = (int) screensize.getHeight();
        System.out.println(width+" : "+hight);

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(width, hight));
        Page page = context.newPage();

        page.navigate("https://www.amazon.in/");


    }
}

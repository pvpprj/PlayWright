package com.qa.opencart.factory;

import com.microsoft.playwright.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Properties;

public class PlaywrightFactory {

    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    static Page page;
    Properties prop;

    public static ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
    public static ThreadLocal<BrowserContext> tlBrowserContext = new ThreadLocal<>();
    public static ThreadLocal<Page> tlPage = new ThreadLocal<>();
    public static ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();

    public static Page getPage() {
        System.out.println("getPage return = "+tlPage.get());
        return tlPage.get();
    }

    public static Playwright getPlaywright() {
        return tlPlaywright.get();
    }

    public static Browser getBrowser() {
        return tlBrowser.get();
    }

    public static BrowserContext getBrowserContext() {
        return tlBrowserContext.get();
    }


    public Page initBroser(Properties prop) {

        String browserName = prop.getProperty("browser").trim();
        System.out.println("Browser name is = " + browserName);

        playwright = Playwright.create();

        switch (browserName) {
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "safari":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                break;
            default:
                System.out.println("Please pass the right browser name ........");
                break;
        }

        browserContext = browser.newContext();
        page = browserContext.newPage();
        page.navigate(prop.getProperty("url"));
        return page;
    }

    /*
    This method used to initialize the properties from config file
    * */

    public Properties init_prop() {
        try {
            FileInputStream ip = new FileInputStream("./src/test/resources/config.properties");
            prop = new Properties();
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    public static String takeScreenshot() {
        String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
        //  getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
        return path;

       /* byte[] buffer = getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
        String base64Path = Base64.getEncoder().encodeToString(buffer);
        return base64Path;*/
    }


}
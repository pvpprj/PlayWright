package PlayWrightPractice_1_29;

import com.microsoft.playwright.*;

public class Z_23_JsPopUpHandle {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");

        // To enter some value in pop up fiels and accepted or dismiss.
        page.onDialog(dialog -> {
            String text = dialog.message();
            System.out.println(text);
            dialog.accept("Hi Rahul Here");
//            dialog.dismiss();
        });

        page.click("//but    ton[text()='Click for JS Alert']");
        String alert = page.textContent("p[id='result']");
        System.out.println(alert);

        page.click("//button[text()='Click for JS Confirm']");
         alert = page.textContent("p[id='result']");
        System.out.println(alert);

        page.click("//button[text()='Click for JS Prompt']");
        alert = page.textContent("p[id='result']");
        System.out.println(alert);



        System.out.println("-------------------Pass-----------------------------------");
    }
}

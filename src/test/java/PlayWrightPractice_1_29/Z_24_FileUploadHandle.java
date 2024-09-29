package PlayWrightPractice_1_29;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.FilePayload;

import java.nio.charset.StandardCharsets;

public class Z_24_FileUploadHandle {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
     //   page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");

        // input type="file"

        // Select one File
//        page.setInputFiles("input#filesToUpload", Paths.get("C:\\Users\\Rahul Gupta\\Desktop\\Dummy\\Test 4.txt"));
//        Thread.sleep(3000);
//        page.setInputFiles("input#filesToUpload", new Path[0]);  //de Select file

        // Select multiple File
//        page.setInputFiles("input#filesToUpload",
//                new Path[]{
//                Paths.get("Test 1.txt"),
//                Paths.get("Test 2.txt"),
//                Paths.get("Test 3.txt")    });

        // Run time file upload
//        page.setInputFiles("input#filesToUpload",new FilePayload("Rahul.text","text/plain"
//        , "This is rahul here".getBytes(StandardCharsets.UTF_8)));

//        --------------------------------------------------------------------------------

        page.navigate("https://cgi-lib.berkeley.edu/ex/fup.html");
        page.setInputFiles("input[name='upfile']",new FilePayload("Rahul.text","text/plain"
        , "This is rahul here".getBytes(StandardCharsets.UTF_8)));

        page.click("input[value='Press']");

        System.out.println("-------------------Pass-----------------------------------");
    }
}
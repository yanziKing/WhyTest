package Browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDrivers {
    public static WebDriver driver;
    private String  driverLocatedPath = System.getProperty("user.dir");

    public WebDrivers(BrowsersType browsersType) {
        // 通过传入字符类型确定需启动浏览器
        switch(browsersType) {
            case chrome:
                System.setProperty("webdriver.chrome.driver", driverLocatedPath +
                        "\\Drivers\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                driver = new ChromeDriver(options);
                break;

            case firefox:
                System.setProperty("webdriver.firefox.bin", driverLocatedPath +
                        "\\Drivers\\geckodriver1.exe");
                driver = new FirefoxDriver();
                break;

            case ie:
                System.setProperty("webdriver.ie.driver", driverLocatedPath +
                        "\\Drivers\\IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                break;

            default:
                System.out.println("parameter Error!!!");
        }
    }
}

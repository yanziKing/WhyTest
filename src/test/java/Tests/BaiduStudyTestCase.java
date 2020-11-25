package Tests;

import Browsers.BrowsersType;
import Browsers.WebDrivers;
import CasePageOperation.BaiduCasePageOperator;
import ImportXpathClasses.baiduXpathTagImport;
import TestEnv.Parameters;
import log4j.log4jControler;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BaiduStudyTestCase {
    private final log4jControler log = new log4jControler(BaiduStudyTestCase.class);
    private WebDriver driver;
    private String url = "https://www.baidu.com/";
    private BaiduCasePageOperator BaiduPage = new BaiduCasePageOperator();
    private String Keyword = Parameters.KEYWORLD;
    private final String userAcount = Parameters.LoginUserName;
    private final String pWD = Parameters.LoginPwd;
    private final String caseName = "BaiduStudyTestCase";
	/*private Date data = new Date();
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy--MM--dd hh:mm:ss");*/

    @BeforeClass
    public void openUrl() {
        log.info("--Init driver");
        WebDrivers webDrivers = new WebDrivers(BrowsersType.chrome);
        driver = webDrivers.driver;
        log.info("Open url :" + url + ".");
        driver.get(url);
//      driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Long.valueOf(fpo.baiduTag.rPMS.getValue("timeOut")), TimeUnit.SECONDS);
//		System.out.println(sdf.format(data));
    }

    @Test
    public void methodA() throws InterruptedException {
        try {
        log.info("--Test case script start run");
//		BaiduPage.baiDuWindowop();
		BaiduPage.studyMethodA(Keyword);
//      BaiduPage.baiDuSearchSetting();
//      BaiduPage.baiduLoginMethod(userAcount, pWD);
//      Assert.assertTrue(BaiduPage.assertLogin(), "AssertFail!!!");
        } catch (Exception e) {
            log.error("--Case script run failed!!!");
            log.getScreenShotFile(caseName);
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void methodB() throws InterruptedException {
    baiduXpathTagImport baiduXpathTagImport = new baiduXpathTagImport();
    baiduXpathTagImport.seleniumMethod.waitSleep(5);
    log.info("--Test case run end succeed!!");
    driver.quit();
//		System.out.println(sdf.format(data));
    }
}

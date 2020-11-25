package CasePageOperation;

import Browsers.WebDrivers;
import ImportXpathClasses.baiduXpathTagImport;
import Tests.BaiduStudyTestCase;
import log4j.log4jControler;
import org.openqa.selenium.Dimension;

public class BaiduCasePageOperator {
    private baiduXpathTagImport baiduTag = new baiduXpathTagImport();
    private final log4jControler log = new log4jControler(BaiduCasePageOperator.class);

    public void baiDuWindowop() throws InterruptedException {
        Dimension dimension = new Dimension(700, 700);
        log.info("--Sets the specified screen size");
        WebDrivers.driver.manage().window().setSize(dimension);
        baiduTag.seleniumMethod.waitSleep(3);

        log.info("--Screen maximization");
        WebDrivers.driver.manage().window().maximize();
        baiduTag.seleniumMethod.waitSleep(3);

    }

    public void studyMethodA(String text) throws InterruptedException {

        log.info("--Input box text:" + text);
        baiduTag.BaiduSearchBox.inputText(text);
        baiduTag.seleniumMethod.waitSleep(3);

        log.info("--Delete the excess text");
        baiduTag.BaiduSearchBox.deleteKeysText();
        baiduTag.seleniumMethod.waitSleep(3);

        log.info("--Double click on the selected text:" + text);
        baiduTag.BaiduSearchBox.mouseDoubleClick();
        baiduTag.seleniumMethod.waitSleep(3);

        log.info("--Cut the selected text:" + text);
        baiduTag.BaiduSearchBox.cutInputText();
        baiduTag.seleniumMethod.waitSleep(3);

        log.info("--Copy the selected text:" + text);
        baiduTag.BaiduSearchBox.copyInputText();
        baiduTag.seleniumMethod.waitSleep(3);

        log.info("--Click the search button");
        baiduTag.BaiduSearchButton.clickElement();
        baiduTag.seleniumMethod.waitSleep(3);

        log.info("--Back the first page");
        WebDrivers.driver.navigate().back();
    }

    public void baiDuSearchSetting() throws InterruptedException {
        // 鼠标移动至  设置按钮 上方
        baiduTag.BaiduSettingButton.mouseMoveToElement();
        baiduTag.seleniumMethod.waitSleep(3);

        // 选择搜索设置
        baiduTag.BaiduSearchSettingButton.clickElement();
        baiduTag.seleniumMethod.waitSleep(3);

        // 选择高级搜索设置
        baiduTag.BaiduAdvancedSettingButton.clickElement();
        baiduTag.seleniumMethod.waitSleep(3);

        // 选择   所有格式
//		baiduTag.BaiduDocumentionSelectbox.selectBoxIndex(i);

        // 点击普通弹窗
        baiduTag.BaiduDocumentionSelectbox.clickElement();
        baiduTag.seleniumMethod.waitSleep(3);

        // 选择所有格式
        baiduTag.BaiduDocumentionAllFormat.clickElement();
    }

    // 百度登录Case
    public void baiduLoginMethod(String acount, String pwd) throws InterruptedException {
        // 点击登录按钮
        baiduTag.BaiduLoginButton.clickElement();
        baiduTag.seleniumMethod.waitSleep(3);

        // 选择用户名或密码登录
        baiduTag.BaiduSelectUserName.clickElement();
        baiduTag.seleniumMethod.waitSleep(3);

        // 输入登录用户名
        baiduTag.BaiduUserNameInputBox.inputText(acount);
        baiduTag.seleniumMethod.waitSleep(3);

        // 输入登录密码
        baiduTag.BaiduPwdInputBox.inputText(pwd);
        baiduTag.seleniumMethod.waitSleep(3);

        // 点击登录按钮
        baiduTag.BaiduLoginUserButton.clickElement();
        baiduTag.seleniumMethod.waitSleep(3);
    }

    // LoginAssert
    public boolean assertLogin() throws InterruptedException {
        String xpath = baiduTag.BaiduSecurityVerifyTag.getXpath();
        baiduTag.seleniumMethod.waitSleep(3);
        boolean assertResult = baiduTag.seleniumMethod.eleEmpty(xpath);
        return assertResult;
    }
}

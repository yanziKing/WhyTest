package ImportXpathClasses;

import SeleniumBaseFunc.ReadProperties;
import SeleniumBaseFunc.SeleniumMethod;
import TagOperationMethod.ButtonTag;
import TagOperationMethod.InputTag;

public class baiduXpathTagImport {
    public SeleniumMethod seleniumMethod = new SeleniumMethod();

    private String dataPathFile = System.getProperty("user.dir") +
            "\\src\\main\\resources\\UIXpath.properties";

    private ReadProperties rPM = new ReadProperties(dataPathFile);

    public InputTag BaiduSearchBox = new InputTag(rPM.getValue("Baidu.FirstPage.SearchBox"));

    public ButtonTag BaiduSearchButton = new ButtonTag(rPM.getValue("Baidu.FirstPage.SearchButton"));



    // Example:  SearchSet
    public ButtonTag BaiduSettingButton = new ButtonTag(rPM.getValue("Baidu.FirstPage.SetButton"));

    public ButtonTag BaiduSearchSettingButton = new ButtonTag(rPM.getValue("Baidu.SetButton.SearchSet"));

    public ButtonTag BaiduAdvancedSettingButton = new ButtonTag(rPM.getValue("Baidu.Advance.search.Settings"));

    public ButtonTag BaiduDocumentionSelectbox = new ButtonTag(rPM.getValue("Baidu.Documention.SelectionBox"));

    public ButtonTag BaiduDocumentionAllFormat = new ButtonTag(rPM.getValue("Baidu.Search.AllFormat"));

    // LoginBaidu
    public ButtonTag BaiduLoginButton = new ButtonTag(rPM.getValue("Baidu.Login.Button"));

    public ButtonTag BaiduSelectUserName = new ButtonTag(rPM.getValue("Baidu.Select.UserName.Button"));

    public InputTag BaiduUserNameInputBox = new InputTag(rPM.getValue("Baidu.UserName.InputBox"));

    public InputTag BaiduPwdInputBox = new InputTag(rPM.getValue("Baidu.Pwd.InputBox"));

    public ButtonTag BaiduLoginUserButton = new ButtonTag(rPM.getValue("Baidu.Login.User.Button"));

    public ButtonTag BaiduSecurityVerifyTag = new ButtonTag(rPM.getValue("Baidu.SecurityVerify.TagB"));
}

package TagOperationMethod;

import SeleniumBaseFunc.SeleniumMethod;
import log4j.log4jControler;

public class InputTag extends SeleniumMethod {
    private final log4jControler log = new log4jControler(InputTag.class);

    private String xpath=null;

    public String getXpath() {
        return this.xpath;
    }

    public InputTag(String xpath) {
        this.xpath = xpath;
    }

    public void inputText(String text) {
        waitElementClick(this.xpath);
        log.debug("--clear input box xpath:" + this.xpath);
        clearText(getElement(this.xpath));
        log.debug("--input box write text  xpath:" + this.xpath);
        inputText(getElement(this.xpath), text);
    }

    public void deleteKeysText() {
        waitElementClick(this.xpath);
        log.debug("--Delete text key xpath：" + this.xpath);
        keySpace(getElement(this.xpath));
    }

    public void mouseDoubleClick() {
        waitElementClick(this.xpath);
        log.debug("--mouse double click xpath:" + this.xpath);
        doubleClick(getElement(this.xpath));
    }

    public void cutInputText() {
        waitElementClick(this.xpath);
        log.debug("--Keys cut text xpath:" + this.xpath);
        keyControlX(getElement(this.xpath));
    }

    public void copyInputText() {
        waitElementClick(this.xpath);
        log.debug("--Keys copy text xpath:" + this.xpath);
        keyControlV(getElement(this.xpath));
    }
}

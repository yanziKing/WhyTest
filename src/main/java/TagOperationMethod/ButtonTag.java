package TagOperationMethod;

import SeleniumBaseFunc.SeleniumMethod;
import log4j.log4jControler;

public class ButtonTag extends SeleniumMethod {
    private final log4jControler log = new log4jControler(ButtonTag.class);

    private String xpath=null;

    public String getXpath() {
        return this.xpath;
    }

    public ButtonTag(String xpath) {
        this.xpath = xpath;
    }

    // Click Method
    public void clickElement() {
        log.debug("--clik element xpath:" + this.xpath);
        waitElementClick(this.xpath);
        clickElement(getElement(this.xpath));
    }

    public void mouseMoveToElement() {
        log.debug("--mouse elemove element xpath:" + this.xpath);
        waitElementClick(this.xpath);
        moveElement(getElement(this.xpath));
    }
}

package SeleniumBaseFunc;

import Browsers.WebDrivers;
import TestEnv.Parameters;
import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.sql.Time;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class SeleniumMethod {

    public WebElement getElement(String xpath) {
        return WebDrivers.driver.findElement(By.xpath(xpath));
    }

    public List<WebElement> getElements(String xpath) {
        return WebDrivers.driver.findElements(By.xpath(xpath));
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public void clearText(WebElement element) {
        element.clear();
    }

    public void inputText(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void waitElement(String xpath) {
        WebDriverWait wait = new WebDriverWait(WebDrivers.driver, Parameters.TIMEOUT);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    public void waitElementClick(String xpath) {
        WebDriverWait wait = new WebDriverWait(WebDrivers.driver, Parameters.TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    // Actions
    public void clikAndHolder(WebElement elementA, WebElement elementB) {
        Actions actions = new Actions(WebDrivers.driver);
        actions.clickAndHold(elementA).
                click(elementB).
                release().
                perform();
    }

    public void moveElement(WebElement element) {
        Actions actions = new Actions(WebDrivers.driver);
        actions.moveToElement(element).perform();
    }

    public void dragAndDrop(WebElement elementA, WebElement elementB) {
        Actions actions = new Actions(WebDrivers.driver);
        actions.dragAndDrop(elementA, elementB).perform();
    }

    public void keyUpElement(WebElement elementA, WebElement elementB) {
        Actions actions = new Actions(WebDrivers.driver);
        actions.keyDown(Keys.CONTROL).
                click(elementA).
                click(elementB).
                keyUp(Keys.CONTROL).perform();
    }

    public void contextClick(WebElement ele) {
        Actions actions = new Actions(WebDrivers.driver);
        actions.contextClick(ele).build().perform();
    }

    public void doubleClick(WebElement ele) {
        Actions actions = new Actions(WebDrivers.driver);
        actions.doubleClick(ele).perform();
    }

    // Select 处理下拉列表常用的方法：
    public void selectListIndex(WebElement ele, int i) {
        Select select = new Select(ele);
        select.selectByIndex(i);
    }

    public void selectListValue(WebElement ele, String value) {
        Select select = new Select(ele);
        select.selectByValue(value);;
    }

    public void selectListText(WebElement ele, String text) {
        Select select = new Select(ele);
        select.selectByVisibleText(text);
    }

    // 键盘操作
    public void keyControlA(WebElement ele) {
        ele.sendKeys(Keys.CONTROL, "a");
    }

    public void keyControlX(WebElement ele) {
        ele.sendKeys(Keys.CONTROL, "x");
    }

    public void keySpace(WebElement ele) {
        ele.sendKeys(Keys.BACK_SPACE);
    }

    public void keyControlC(WebElement ele) {
        ele.sendKeys(Keys.CONTROL, "c");
    }

    public void keyControlV(WebElement ele) {
        ele.sendKeys(Keys.CONTROL, "v");
    }

    // 常见的断言判断
    public boolean eleSelect(String xpath) {
        boolean result = false;
        try {
            if (WebDrivers.driver.findElement(By.xpath(xpath)).isSelected()) {
                result = true;
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }

    public boolean eleDisplayed(String xpath) {
        boolean result = false;
        try {
            if (WebDrivers.driver.findElement(By.xpath(xpath)).isDisplayed()) {
                result = true;
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }

    public boolean eleEmpty(String xpath) {
        boolean result = false;
        try {
            if (!WebDrivers.driver.findElements(By.xpath(xpath)).isEmpty()) {
                result = true;
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }

    public void rencentTaskWait(final String xpath) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(WebDrivers.driver).
                withTimeout(500, TimeUnit.SECONDS).
                pollingEvery(1, TimeUnit.SECONDS).
                ignoring(NoSuchElementException.class).
                withMessage("driver timeOut load Succeed!");

        wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath(xpath));
            }
        });
    }

    public void waitSleep(int i) throws InterruptedException {
        Thread.sleep(1000 * i);
    }
}

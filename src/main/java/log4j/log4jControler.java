package log4j;

import Browsers.WebDrivers;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.apache.commons.io.FileUtils;

import javax.xml.crypto.Data;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class log4jControler {
    private Logger logger = null;
    private Properties pro = new Properties();

    public log4jControler(Class<?> T) {
        this.loadLogFile(T);
    }

    public void loadLogFile(Class<?> T) {
        String logFileLocated = System.getProperty("user.dir") +
                "\\src\\main\\resources\\log4j.properties";
        if(logger==null) {
            try {
                File file = new File(logFileLocated);
                InputStream in = new FileInputStream(file);
                InputStreamReader isr = new InputStreamReader(in);
                BufferedReader br = new BufferedReader(isr);
                pro.load(br);
            } catch (IOException e) {
                e.printStackTrace();
            }
            PropertyConfigurator.configure(pro);
            logger = Logger.getLogger(T);
        }
    }

    public void info(String meg) {
        logger.info(meg);
    }
    public void error(String meg) {
        logger.error(meg);
    }
    public void warn(String meg) {
        logger.warn(meg);
    }
    public void debug(String meg) {
        logger.debug(meg);
    }

    // Save screenshotfile Method
    public void getScreenShotFile(String shotCaseName) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//        Calendar cl = Calendar.getInstance();
        Date date = new Date();
//        String time = sdf.format(cl.getTime());
        String time = sdf.format(date);

        String shotLocated = System.getProperty("user.dir") +
                "\\src\\main\\resources\\testCaseRunScreenShou\\" +time + shotCaseName + ".png";
        File screenShotFile = ((TakesScreenshot)WebDrivers.driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShotFile, new File(shotLocated));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

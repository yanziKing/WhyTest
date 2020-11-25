package SeleniumBaseFunc;

import java.io.*;
import java.util.Properties;

public class ReadProperties {
    private Properties properties = new Properties();
    private String value;

    public ReadProperties(String dataLocated) {
        this.loadData(dataLocated);
    }
    public void loadData(String dataLocated) {
        File file = new File(dataLocated);
        try {
            InputStream in = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(isr);
            properties.load(br);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getValue(String key) {
        value = properties.getProperty(key).trim();
        try {
            value = new String(value.getBytes("UTF-8"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return value;
    }

 /*   public static void main(String[] args) {
        String dataPath = System.getProperty("user.dir") +
                "\\src\\main\\resources\\UIXpath.properties";

        ReadProperties rp = new ReadProperties(dataPath);
        String value = rp.getValue("test.Data");
        System.out.println(value);
    }*/
}

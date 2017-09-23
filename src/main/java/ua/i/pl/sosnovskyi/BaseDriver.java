package ua.i.pl.sosnovskyi;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


/**
 * Created by A Sosnovskyi on 21.09.2017.
 */
public abstract class BaseDriver {
    private final static String driverPath = System.getProperty("user.dir");
    private final static String separator = System.getProperty("file.separator");
//    private static WebDriver chromeDriver;
//    private static WebDriver ffDriver;
//    private static WebDriver iEDriver;

    private static WebDriver getChromeDriver() {
        //================================================================================
        //        System.out.println(driverPath);
//        Properties properties=System.getProperties();
//        properties.list(System.out);
//        String driverPath=System.getProperty("driver.executable");
//        if(driverPath==null){
//            throw new RuntimeException("Path to ChromeDriver is not specified!!!");
//        }
//        ClassLoader classLoader = BaseDriver.class.getClass().getClassLoader();
//        String path  = classLoader.
//      //  String path  = classLoader.getResource("chromedriver.exe").getPath();
//        System.out.println(path);
        //================================================================================
        String key = System.getProperty("webdriver.chrome.driver");
        if (key == null) {
            System.setProperty("webdriver.chrome.driver",
                    driverPath + separator + "target" + separator + "classes" + separator + "chromedriver.exe");
//            chromeDriver =
        }
        return new ChromeDriver();
    }

    ;

    private static WebDriver getFFDriver() {
        String key = System.getProperty("webdriver.gecko.driver");
        if (key == null) {
            System.setProperty("webdriver.gecko.driver",
                    driverPath + separator + "target" + separator + "classes" + separator + "geckodriver.exe");
//            ffDriver=new FirefoxDriver();
        }
        return new FirefoxDriver();
    }

    ;

    private static WebDriver getIEDriver() {
        String key = System.getProperty("webdriver.ie.driver");
        if (key == null) {
            System.setProperty("webdriver.ie.driver",
                    driverPath + separator + "target" + separator + "classes" + separator + "IEDriverServer.exe");
//            iEDriver=new InternetExplorerDriver();
        }
        return new InternetExplorerDriver();
    }

    ;

    public static WebDriver getDriver(String arg) {
        if (arg == null) {
            return getChromeDriver();
        } else {
            switch (arg) {
                case "chrome":
                    return getChromeDriver();
                case "gecko":
                    return getFFDriver();
                case "ie":
                    return getIEDriver();
                default:
                    throw new RuntimeException("Wrong browser name");
            }

        }
    }
}

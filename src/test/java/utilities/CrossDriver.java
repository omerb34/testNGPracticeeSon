package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class CrossDriver {
    static WebDriver driver;
    private CrossDriver(){

    }
    public static WebDriver getDriver(String browser) {
        browser=(browser==null) ? ConfigReader.getProperty("browser") :browser;
        //yukarıdaki cod browsera bir deger atanmamısa calısmaktadır.
        if (driver == null) {//EĞER DRIVER'A DEĞER ATANMAMIŞSA DEĞER ATA, EĞER DEĞER ATANMIŞŞSA DRİVER'I AYNI SAYFADA RETURN ET
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver=new EdgeDriver();
                    break;
            }


        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) { //Driver'a değer atanmışsa
            driver.close();
            driver = null;
        }
    }

    public static void quitDriver() {
        if (driver != null) { //Driver'a değer atanmışsa
            driver.quit();
            driver = null;
        }
    }
}

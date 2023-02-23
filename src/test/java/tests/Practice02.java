package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HerokuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Practice02 {



    @DataProvider
    public static Object[][] kullanici() {
        return new Object[][]{{ConfigReader.getProperty("email1"),ConfigReader.getProperty("password1")},
                {ConfigReader.getProperty("email2"),ConfigReader.getProperty("password2")},
                {ConfigReader.getProperty("email3"),ConfigReader.getProperty("password3")}

        };
    }

    @Test(dataProvider = "kullanici")
    public void testName(String email,String password) throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("herokuUrl"));
        HerokuPage herokuPage= new HerokuPage();
        herokuPage.email.sendKeys(email);
        herokuPage.password.sendKeys(password);
        herokuPage.loginButton.click();
        Thread.sleep(5000);
        Assert.assertTrue(herokuPage.errorMessage.isDisplayed());
        Thread.sleep(5000);
        Driver.closeDriver();





    }
}
 /*
    Negative Test
    1.  https://id.heroku.com/login sayfasina gidin
    2.  Data provider kullanarak mail adres ve passwordleri giriniz
    3.  Login butonuna tiklayiniz
    4.  "There was a problem with your login." texti gorunur olduğunu test edin
    5.  sayfalari kapatiniz

 */
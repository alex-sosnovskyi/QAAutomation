package ua.i.pl.sosnovskyi.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ua.i.pl.sosnovskyi.BaseDriver;
import ua.i.pl.sosnovskyi.utils.Properties;

import java.util.List;

/**
 * Created by A Sosnovskyi on 22.09.2017.
 */
public class CheckMainMenuTest {
//    private static WebDriver driver = BaseDriver.getDriver(Properties.getBrowser());
private static void menuTest(int length, WebDriver driver) throws InterruptedException{
    for(int i=0; i<length; i++){
        List<WebElement> link= null;
        try {
           WebElement sidebar = driver.findElement(By.id("nav-sidebar"));
            link = sidebar.findElements(By.className("maintab"));
        } catch (NoSuchElementException e) {
            try {
                WebElement  sidebar=driver.findElement(By.className("nav-bar"));
                link=sidebar.findElements(By.className("link-levelone"));
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        try {
            if (link != null) {
                link.get(i).click();
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        String oldPage = driver.getCurrentUrl();
        Thread.sleep(5000);
        System.out.println(driver.getTitle());
        System.out.println("refreshig page!");
        driver.navigate().refresh();
        Thread.sleep(5000);
        System.out.println("After refreshing page "+driver.getTitle());
        String currentPage=driver.getCurrentUrl();
        System.out.println("Is it the same page? -"+oldPage.equals(currentPage));
        System.out.println("==================================================================");
    }
}
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = BaseDriver.getDriver(Properties.getBrowser());
        LoginTest.maximize(driver);
        Thread.sleep(1000);
        LoginTest.navigate(driver, Properties.getBaseAdminUrl());
        LoginTest.logIn("webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw", driver);
//       String currentPage =LoginTest.getCurrentUrl(driver);
      //  String title = driver.getTitle();
        WebElement sidebar = driver.findElement(By.id("nav-sidebar"));
        List<WebElement> li = sidebar.findElements(By.className("maintab"));
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        menuTest(li.size(), driver);
//        ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        Thread.sleep(5000);
        LoginTest.exit(driver);
    }
}

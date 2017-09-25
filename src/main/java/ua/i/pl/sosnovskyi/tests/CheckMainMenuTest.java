package ua.i.pl.sosnovskyi.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ua.i.pl.sosnovskyi.BaseDriver;
import ua.i.pl.sosnovskyi.utils.Properties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by A Sosnovskyi on 22.09.2017.
 */
public class CheckMainMenuTest {
//    private static WebDriver driver = BaseDriver.getDriver(Properties.getBrowser());
public static void menuTest(int size){

}
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = BaseDriver.getDriver(Properties.getBrowser());
        LoginTest.maximize(driver);
        Thread.sleep(1000);
        LoginTest.navigate(driver, Properties.getBaseAdminUrl());
        LoginTest.logIn("webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw", Thread.currentThread(), driver);
        String currentPage = LoginTest.getCurrentUrl(driver);
        String title = driver.getTitle();
    //    System.out.println(title);
        WebElement sidebar = driver.findElement(By.id("nav-sidebar"));
        List<WebElement> li = sidebar.findElements(By.className("maintab"));

//        for (WebElement element: links) {
//            String oldPage = driver.getCurrentUrl();
//            element.click();
//            Thread.sleep(5000);
//            System.out.println(driver.getTitle());
//            driver.navigate().refresh();
//            Thread.sleep(5000);
//            currentPage=driver.getCurrentUrl();
//            System.out.println(oldPage.compareTo(currentPage));
//            System.out.println("==================================================================");
//        }
//=========================================================================================================================
        int length=li.size();
        for(int i=0; i<length; i++){
          //  System.out.println("Iteration number " +i);
            List<WebElement> link= null;
            try {
                sidebar = driver.findElement(By.id("nav-sidebar"));
                link = sidebar.findElements(By.className("maintab"));
            } catch (NoSuchElementException e) {
                try {
                    sidebar=driver.findElement(By.className("nav-bar"));
                    link=sidebar.findElements(By.className("link-levelone"));
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
            link.get(i).click();
            String oldPage = driver.getCurrentUrl();
            Thread.sleep(5000);
            System.out.println(driver.getTitle());
            System.out.println("refreshig page!");
            driver.navigate().refresh();
            Thread.sleep(5000);
            System.out.println("After refreshing page "+driver.getTitle());
            currentPage=driver.getCurrentUrl();
            System.out.println("Is it the same page? -"+oldPage.equals(currentPage));
            System.out.println("==================================================================");

        }
        //==================================================================================================================
//        li.get(5).click();
//        String oldPage = driver.getCurrentUrl();
//
//        Thread.sleep(5000);
//        System.out.println(driver.getTitle());
//        System.out.println("refreshig page!");
//        driver.navigate().refresh();
//        Thread.sleep(5000);
//        System.out.println("After refreshing page "+driver.getTitle());
//        currentPage=driver.getCurrentUrl();
//        System.out.println("Page after refreshing is the same? -"+oldPage.equals(currentPage));
//        System.out.println("==================================================================");
//        sidebar = driver.findElement(By.id("nav-sidebar"));
//        li = sidebar.findElements(By.className("maintab"));
//        li.get(5).click();

        Thread.sleep(5000);
        LoginTest.exit(driver);
    }
}

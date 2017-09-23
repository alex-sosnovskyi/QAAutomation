package ua.i.pl.sosnovskyi.tests;

import org.openqa.selenium.By;
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

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = BaseDriver.getDriver(Properties.getBrowser());
        LoginTest.maximize(driver);
        Thread.sleep(1000);
        LoginTest.navigate(driver, Properties.getBaseAdminUrl());
        LoginTest.logIn("webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw", Thread.currentThread(), driver);
        String currentPage=LoginTest.getCurrentUrl(driver);
        String title=driver.getTitle();
        System.out.println(title);
        WebElement sidebar = driver.findElement(By.id("nav-sidebar"));
        List<WebElement> li = sidebar.findElements(By.className("maintab"));

//           links.stream().forEach(System.out::println);
        List<WebElement> links=new ArrayList<>();
        for (WebElement element:li) {
            WebElement a = element.findElement(By.tagName("a"));
           links.add(a);
//            Thread.sleep(1000);
//            System.out.println(title=driver.getTitle());
//            System.out.println(a.getAttribute("href"));
//            System.out.println("--------------------------------------------------");
//            Thread.sleep(1000);
        }


        //driver.navigate().refresh();

        Thread.sleep(10000);
        LoginTest.exit(driver);
    }
}

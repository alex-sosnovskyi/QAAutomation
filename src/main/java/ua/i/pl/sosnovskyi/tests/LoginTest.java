package ua.i.pl.sosnovskyi.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ua.i.pl.sosnovskyi.BaseDriver;
import ua.i.pl.sosnovskyi.utils.Properties;

/**
 * Created by A Sosnovskyi on 22.09.2017.
 */
public class LoginTest {
    private static WebDriver driver = BaseDriver.getDriver(Properties.getBrowser());

//    public WebDriver getDriver() {
//        return driver;
//    }

    public static void navigate(String url) {
        driver.navigate().to(url);
    }

    public static void exit() {
        driver.quit();
    }

    public static void maximize() {
        driver.manage().window().maximize();
    }

    public static void logIn(String login, String password, Thread currentThread) throws InterruptedException {
        WebElement loginForm = driver.findElement(By.id("login_form"));
        WebElement email = loginForm.findElement(By.name("email"));
        WebElement passwrd = loginForm.findElement(By.name("passwd"));
        WebElement submit = loginForm.findElement(By.name("submitLogin"));
        email.sendKeys(login);
        currentThread.sleep(1000);
        passwrd.sendKeys(password);
        Thread.sleep(1000);
        submit.click();
        Thread.sleep(1000);
    }

    public static String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public static void logOut(Thread current) throws InterruptedException {
        WebElement pictAdmin = driver.findElement(By.id("employee_infos"));
        WebElement dropDownHref = pictAdmin.findElement(By.tagName("a"));
        dropDownHref.click();
        current.sleep(1000);
        WebElement logOutAdmin = driver.findElement(By.id("header_logout"));
        logOutAdmin.click();
    }

    public static void main(String[] args) throws InterruptedException {
//        System.out.println(Properties.getBrowser());
        maximize();
        Thread.sleep(1000);
        navigate(Properties.getBaseAdminUrl());
        logIn("webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw", Thread.currentThread());
        String currentUrl = getCurrentUrl();
        logOut(Thread.currentThread());
        Thread.sleep(10000);
        exit();
    }
}

package com.fang.Demo1.emailproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class EmailLogin {

    WebDriver driver;

    @BeforeMethod
    public void openBrowsers(){
        System.setProperty("webdriver.firefox.driver","D:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public static void loginSussess(WebDriver driver,String loginname,String password){
        driver.get("https://mail.163.com/");
        driver.findElement(By.linkText("密码登录")).click();
        //移交权限
        WebElement frame = driver.findElement(By.xpath("//*[@id='loginDiv']/iframe"));
        driver.switchTo().frame(frame);
        driver.findElement(By.name("email")).sendKeys(loginname);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.linkText("登  录")).click();
    }


//    @AfterMethod
//    public void closeBrowser(){
//        driver.quit();
//    }
}

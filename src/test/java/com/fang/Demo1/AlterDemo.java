package com.fang.Demo1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlterDemo {

    WebDriver driver;

    @BeforeMethod
    public void openWeb() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("file:///G:/java+selenium/index.html");
        Thread.sleep(2000);
    }

    @Test
    public void alterTest1() throws InterruptedException {
        WebElement alert = driver.findElement(By.className("alert"));
        alert.click();
        //因为无法定位弹框里面元素，所以将控制权移交给alter
        Alert alertin = driver.switchTo().alert();
        Thread.sleep(2000);
        alertin.accept();
    }

    @Test
    public void confirmTest() throws InterruptedException {
        WebElement confirm = driver.findElement(By.className("confirm"));
        confirm.click();
        //移交权限给alter
        Alert alterin2 = driver.switchTo().alert();
        Thread.sleep(2000);
        //点击确定
        alterin2.accept();
        Thread.sleep(2000);
        //再次点击确定
        alterin2.accept();
    }

    @Test
    public void confirmTest02() throws InterruptedException {
        WebElement confirm2 = driver.findElement(By.className("confirm"));
        confirm2.click();
        //移交权限给alter
        Alert alterin3 = driver.switchTo().alert();
        Thread.sleep(2000);
        //点击取消
        alterin3.dismiss();
        Thread.sleep(2000);
        //再点确定
        alterin3.accept();
    }

    @Test
    public void promptTest() throws InterruptedException {
        WebElement confirm3 = driver.findElement(By.className("prompt"));
        confirm3.click();
        Alert alterin4 = driver.switchTo().alert();
        Thread.sleep(2000);
        //在弹框中输入内容
        alterin4.sendKeys("111");
        Thread.sleep(1000);
        //点击确定
        alterin4.accept();
        Thread.sleep(1000);
        //再次点击确定
        alterin4.accept();
        //重新移交权限给driver,并点击登陆界面
        driver.switchTo().defaultContent();
        driver.findElement(By.linkText("登陆界面")).click();
    }


    @AfterMethod
    public void closeWeb() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}

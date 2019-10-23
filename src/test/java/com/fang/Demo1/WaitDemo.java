package com.fang.Demo1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitDemo {
    WebDriver driver;

    @BeforeMethod
    public void openWeb() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("file:///G:/java+selenium/index.html");
        //全局/显示等待，所有的地方起作用，如果10s之内就正常，那就无需等待，否则会等待20s，然后抛超时异常
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void waitTest(){
        driver.findElement(By.className("wait")).click();
        //隐式等待，如果没有满足until后面的值，会等待5s，然后抛超时异常，如果5s之内就正常了，那就无需等待
        WebDriverWait webDriverWait = new WebDriverWait(driver,5);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.className("red")));
        String text = driver.findElement(By.xpath("//*[@id=\"display\"]/div[1]")).getText();
        System.out.println(text);
    }

    @AfterMethod
    public void closeWeb() throws InterruptedException {
        driver.quit();
    }
}

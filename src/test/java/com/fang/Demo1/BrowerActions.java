package com.fang.Demo1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowerActions {

    WebDriver driver;

    @BeforeMethod
    public void openBrowsers(){
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void openUrl() throws InterruptedException {
        //打开百度的url
        driver.get("https://www.baidu.com");
        //等待3秒
        Thread.sleep(3000);
    }

    @Test
    public void webBack() throws InterruptedException {
        driver.get("https://www.baidu.com");
        //等待3秒
        Thread.sleep(3000);
        //浏览器后退
        driver.navigate().back();
        Thread.sleep(3000);
    }

    @Test
    public void webForward() throws InterruptedException {
        driver.get("https://www.baidu.com");
        Thread.sleep(3000);
        //浏览器后退
        driver.navigate().back();
        Thread.sleep(3000);
        //浏览器前进
        driver.navigate().forward();
        Thread.sleep(2000);
    }

    @Test
    public  void webRefresh() throws InterruptedException {
        driver.get("https://www.baidu.com");
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);
    }

    @Test
    public void webUrlEquals() throws InterruptedException {
        driver.get("https://www.baidu.com");
        Thread.sleep(2000);
        //获取当前url
        String url = driver.getCurrentUrl();
        //判断url是否正确
        Assert.assertEquals(url,"https://www.baidu.com/");
    }

    @Test
    public void webWindowSize() throws InterruptedException {
        //实例化Dimension，设置窗口大小
        Dimension dimension = new Dimension(300,300);
        driver.manage().window().setSize(dimension);
        driver.get("https://www.baidu.com");
        //最大化
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @AfterMethod
    public void closeBrowser(){
        //关闭退出浏览器
        driver.quit();
    }
}

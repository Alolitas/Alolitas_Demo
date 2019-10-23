package com.fang.Demo1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeDemo {
    WebDriver driver;

    @BeforeMethod
    public void openWeb() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("file:///G:/java+selenium/index.html");
        Thread.sleep(2000);
    }

    @Test
    public void iframeTest() throws InterruptedException {
        //iframe窗口的跳转
        driver.get("file:///D:/testing/webdriver_demo/selenium_html/index.html");
        driver.findElement(By.id("user")).sendKeys("this is iframe");
        Thread.sleep(3000);
        //把控制权转交给iframe界面，，id或者属性值为aa的iframe窗口,下面一个方法是没有Id和属性值的情况
        driver.switchTo().frame("aa");
        //点击iframe窗口的Linktext为baidu的按钮
        driver.findElement(By.linkText("baidu")).click();
        //把控制权回到顶部页面
        driver.switchTo().defaultContent();
        Thread.sleep(3000);
        driver.findElement(By.id("user")).clear();
        driver.findElement(By.id("user")).sendKeys("this is another iframe");
    }

    @Test
    public void iframeTest1() throws InterruptedException {
        //iframe窗口的跳转，运行整个方法时，由于是testng来执行的脚本，是根据方法名的ASKI值来先后执行的，所以是先运行iframetest
        driver.get("file:///D:/testing/webdriver_demo/selenium_html/index.html");
        driver.findElement(By.id("user")).sendKeys("this is iframe");
        //把控制权转交给iframe界面，如果没有id和属性值，把整个iframe当作一个元素来定位
        WebElement element = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[15]/td[2]/iframe"));
        driver.switchTo().frame(element);
        //点击iframe窗口的Linktext为baidu的按钮
        driver.findElement(By.linkText("baidu")).click();
        //把控制权回到顶部页面,任何界面回到顶部页面都是defaultContent方法，回到另一个页面都是frame方法，只能一级一级的跳
        driver.switchTo().defaultContent();
        Thread.sleep(3000);
        driver.findElement(By.id("user")).clear();
        driver.findElement(By.id("user")).sendKeys("this is another iframe");

    }
    @AfterMethod
    public void closeWeb() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}

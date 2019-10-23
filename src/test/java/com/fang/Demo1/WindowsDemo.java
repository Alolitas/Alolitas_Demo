package com.fang.Demo1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowsDemo {

    WebDriver driver;

    @BeforeMethod
    public void openWeb() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("file:///G:/java+selenium/index.html");
        Thread.sleep(2000);
    }

    @Test
    //多窗口处理
    public void windowsTest() throws InterruptedException {
        driver.findElement(By.className("open")).click();
        //获取第一个页面的句柄
        String handle1 = driver.getWindowHandle();
        //for循环判断是否为第一个页面的句柄，如果不是就移交权限
        for (String handle2:driver.getWindowHandles()) {
            if(handle1.equals(handle2)){
                continue;
            }else {driver.switchTo().window(handle2);}
        }
        //下面是采用迭代器的方式实现for循环
/*      Set<String> allHandle=driver.getWindowHandles();
        Iterator iterator=allHandle.iterator();
        for (int i=0;i<allHandle.size();i++){
            String handle=iterator.next().toString();
            if (handle1.equals(handle));
            continue;
            driver.switchTo().window(handle);
        }*/
        Thread.sleep(100);
        //移交权限后可以操作第二个页面
        driver.findElement(By.id("kw")).sendKeys("selenium");
        driver.findElement(By.id("su")).click();
        Thread.sleep(1000);
        //关闭当前页面
        driver.close();
    }

    @AfterMethod
    public void closeWeb() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}

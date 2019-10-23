package com.fang.Demo1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InputAction {

    WebDriver driver;

    @BeforeMethod
    public void openWeb() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.baidu.com");
        Thread.sleep(2000);
    }

    @Test
    //打开百度，输入“selenium”，点击搜索
    public void clickSort() throws InterruptedException {
        driver.findElement(By.id("kw")).sendKeys("selenium");
        Thread.sleep(2000);
        driver.findElement(By.id("su")).click();
        Thread.sleep(2000);
    }
    @Test
    /**
     * 打开百度，输入“selenium”
     * 清空内容
     * 输入“Java”，点击搜索，判断title信息是否相同
     */
    public void clickSort2() throws InterruptedException {
        WebElement key = driver.findElement(By.id("kw"));
        key.sendKeys("selenium");
        Thread.sleep(2000);
        key.clear();
        key.sendKeys("java");
        WebElement button = driver.findElement(By.id("su"));
        button.click();
        Thread.sleep(2000);
        //判断title
        String title = driver.getTitle();
        Thread.sleep(2000);
        Assert.assertEquals(title,"java_百度搜索");
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }
}

package com.fang.Demo1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectOptionDemo {
    WebDriver driver;

    @BeforeMethod
    public void openWeb() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("file:///G:/java+selenium/index.html");
        Thread.sleep(2000);
    }

    @Test
    //下拉框选择操作
    public void selectTest() throws InterruptedException {
        WebElement moreSelect = driver.findElement(By.id("moreSelect"));
        Thread.sleep(2000);
        Select select = new Select(moreSelect);
        select.selectByIndex(3); //根据索引值
        Thread.sleep(1000);
        select.selectByValue("huawei");//根据value值
        Thread.sleep(1000);
        select.selectByVisibleText("vivo");//根据文本值
    }

    @AfterMethod
    public void closeWeb() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}

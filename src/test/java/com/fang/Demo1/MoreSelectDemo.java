package com.fang.Demo1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class MoreSelectDemo {
    WebDriver driver;

    @BeforeMethod
    public void openWeb() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void moreSelectTest() {
        //下拉框多选
        driver.get("file:///G:/java+selenium/index.html");
        WebElement element = driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
        List<WebElement> list=element.findElements(By.tagName("option"));
        Actions actions=new Actions(driver);
        //按住shift键，点击第二个和第四个来执行
        actions.keyDown(Keys.SHIFT).click(list.get(0)).click(list.get(3)).keyUp(Keys.SHIFT).perform();
        //按住control选第二个和第四个
        actions.keyDown(Keys.CONTROL).click(list.get(1)).click(list.get(3)).keyUp(Keys.CONTROL).perform();
    }
    @Test
    public void upload() {
        //文件上传,文件下载在另一个class中
        driver.get("file:///G:/java+selenium/index.html");
        WebElement element = driver.findElement(By.id("load"));
        element.sendKeys("D:\\testing\\LoadRunner.pdf");
    }

    @AfterMethod
    public void closeWeb() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}

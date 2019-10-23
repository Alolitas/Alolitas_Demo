package com.fang.Demo1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class MyActionDemo {

    WebDriver driver;

    @BeforeMethod
    public void openWeb() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    //右击和双击
    public void rightClickTest(){
        driver.get("http://www.baidu.com");
        WebElement rightclick = driver.findElement(By.id("su"));
        //右击操作用到Action类
        Actions actions = new Actions(driver);
        actions.contextClick(rightclick).perform(); //右击某个元素，如果不传的话默认左上角
        actions.doubleClick().build().perform(); //双击，如果不写build也是可以的
    }

    @Test
    //鼠标移动操作
    public void moveTest(){
        //鼠标移动操作
        driver.get("http://www.baidu.com");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"u_sp\"]/a[1]"));
        Actions actions=new Actions(driver);
        actions.moveToElement(element).perform();
    }

    @Test
    public void dragTest() throws InterruptedException {
        //鼠标拖拽操作
        driver.get("file:///G:/java+selenium/dragAndDrop.html");
        WebElement element = driver.findElement(By.id("drag"));
        Thread.sleep(3000);
        Actions actions=new Actions(driver);
        actions.dragAndDropBy(element,500,800).perform();
    }

    @Test
    public void dropTest1() {
        //鼠标拖拽操作
        driver.get("file:///G:/java+selenium/dragAndDrop.html");
        WebElement element1 = driver.findElement(By.id("drag"));
        WebElement element2 = driver.findElement(By.linkText("banban"));
        Actions actions=new Actions(driver);
        //按住元素1，然后拖到到元素2，再释放元素1，执行
        actions.clickAndHold(element1).moveToElement(element2).release(element1).perform();
    }

    @Test
    public void robotTest() throws AWTException {
        driver.get("http://www.baidu.com");
        //robot使用,按住ctrl+S键然后释放
        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_S);
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_ALT);
        robot.keyRelease(KeyEvent.VK_S);
    }

    @AfterMethod
    public void closeWeb() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}

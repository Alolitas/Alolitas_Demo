package com.fang.Demo1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FingElements {

    WebDriver driver;

    @BeforeMethod
    public void openWeb(){
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.baidu.com");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    //通过id定位单个元素
    public void findElement01(){
       WebElement wbe = driver.findElement(By.id("su"));
        System.out.println(wbe);
    }

    @Test
    //通过linkTest定位单个元素
    public void findElement02(){
        WebElement wbe2 = driver.findElement(By.linkText("新闻"));
        System.out.println(wbe2.getText());
    }

    @Test
    //通过tagName定位多个元素
    public void findElements(){
        List<WebElement> list = driver.findElements(By.tagName("a"));
        //遍历定位的元素
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).getText());
        }
    }

    @AfterMethod
    public void closeWeb(){
        driver.quit();
    }
}

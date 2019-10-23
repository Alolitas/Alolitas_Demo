package com.fang.Demo1;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by lenovo on 2016/10/15.包括点击，搜索，是否存在，是否可用，逐个输出打印
 */
public class Action {
    WebDriver driver;
    @BeforeTest
    public void openchrome(){

        System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
        driver=new ChromeDriver();
    }
    @Test
    public void testClick(){
        driver.get("http://www.baidu.com/");
        //具体用什么方式获取定位，看自己获取哪一种简单就采用哪一种获取方式，获取的这个必须要唯一
        WebElement nuomilink=driver.findElement(By.name("tj_trnuomi"));
        nuomilink.click();
    }
    @Test
    public void sendkeyTest()throws InterruptedException{
        driver.get("http://www.baidu.com/");
        //定位到这个地方，然后右键点击检查，此处也可以用name,
        WebElement element1=driver.findElement(By.id("kw"));
        //往百度搜索框输入selenium
        element1.sendKeys("selenium");
        driver.findElement(By.id("su")).click();
        Thread.sleep(5000);
        element1.clear(); //清空刚才输入的内容
    }
    @Test
    public void AssertTrue()throws InterruptedException{
        driver.get("http://www.baidu.com/");
        //id为su的这个控件是否显示在这个界面上
        Boolean isDisplay=driver.findElement(By.id("su")).isDisplayed();
        System.out.println(isDisplay);
        //校验百度首页是否存在这个元素
        Assert.assertTrue(isDisplay);
    }
    @Test
    public void AssertEable()throws InterruptedException{
        driver.get("http://www.baidu.com/");
        Boolean isEable=driver.findElement(By.id("su")).isEnabled();
        System.out.println(isEable);
        //校验百度首页是否可点击这个元素
        Assert.assertTrue(isEable);
    }
    @Test
    public void ScreenShot() throws IOException{
        driver.get("http://www.baidu.com/");
        //对百度首页进行截图,这个方法先记下来
        File file= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("D:\\testing\\webdriver_demo\\baidu.png"));
        //复制一份截图到另一个文件夹
        FileHandler.copy(new File("D:\\testing\\webdriver_demo\\baidu.png"),new File("D:\\testing\\baidu.png"));
        //下面是对上面两句命令的解释
/*        //        获取当前项目路径
        String currentPath = System.getProperty("user.dir");
//        强制转换driver为TakesScreenshot类型
        TakesScreenshot takename = (TakesScreenshot) driver;
//        截图
        File file = takename.getScreenshotAs(OutputType.FILE);
//        保存到D盘
        FileUtils.copyFile(file,new File("D:/test2.png"));
*/
    }
    @Test
    public void getTextTest()throws InterruptedException{
        driver.get("http://www.baidu.com/");
        //如何获取xpath,在chrome浏览器中定位到该位置代码，然后右键点击copy->copy xpath
        List<WebElement> listText=driver.findElements(By.xpath("//*[@id=\"u1\"]/a"));
        //逐个输出打印
        for(int i=0;i<listText.size();i++){
            String test=listText.get(i).getText();
            System.out.println(test);
        }
    }
    @AfterTest
    public void closedchrome()throws InterruptedException{
        Thread.sleep(5000);
        driver.quit();
    }

}

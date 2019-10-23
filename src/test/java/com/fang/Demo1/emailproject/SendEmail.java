package com.fang.Demo1.emailproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SendEmail {

    WebDriver driver;

    @BeforeMethod
    public void openBrowsers(){
        System.setProperty("webdriver.firefox.driver","D:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void sendEmails(){
        //调用登陆方法
        EmailLogin.loginSussess(driver,"15895806533","77460099");
        //验证是否登陆成功,查看是否有“退出”按钮
        boolean quit = driver.findElement(By.linkText("退出")).isDisplayed();
        Assert.assertTrue(quit);
        //定位写信按钮
        driver.findElement(By.xpath("//*[@id=\"dvNavTop\"]/ul/li[2]/span[2]")).click();
        driver.findElement(By.xpath("//*[@aria-label=\"邮件主题输入框，请输入邮件主题\"]/input"))
                .sendKeys("这是一封测试邮件，来自方");
        driver.findElement(By.xpath(".//*[@aria-label='收件人地址输入框，请输入邮件地址，多人时地址请以分号隔开']"))
                .sendKeys("951779129@qq.com");
        //点击附件，上传文件
        driver.findElement(By.xpath("//*[@title=\"一次可发送2000张照片，600首MP3，一部高清电影\"]/input")).sendKeys("C:\\Users\\Alolita\\Downloads\\picture1.jpg");
        //输入正文，是一个ifram，将控制权转交
        WebElement textwrite = driver.findElement(By.className("APP-editor-iframe"));
        driver.switchTo().frame(textwrite);
        driver.findElement(By.xpath("/html/body")).sendKeys("君不见，黄河之水天上来，奔流到海不复回。\n" +
                                                                            "君不见，高堂明镜悲白发，朝如青丝暮成雪。\n" +
                                                                            "人生得意须尽欢，莫使金樽空对月。\n" +
                                                                            "天生我材必有用，千金散尽还复来。\n" +
                                                                            "烹羊宰牛且为乐，会须一饮三百杯。\n" +
                                                                            "岑夫子，丹丘生，将进酒，杯莫停。");
        //控制权交回
        driver.switchTo().defaultContent();
        //点击发送
        driver.findElement(By.xpath(".//*[text()='发送']")).click();
        //校验是否发送成功
        boolean displayed = driver.findElement(By.xpath("//*[text()='发送成功']")).isDisplayed();
        Assert.assertTrue(displayed);
    }
}

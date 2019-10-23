package com.fang.Demo1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OpenBrowers1 {

    //启动谷歌浏览器
    @Test
    public void openChrome(){
        //设置chromedriver路径
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
    }
}

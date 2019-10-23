package com.fang.Demo1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class GrideTest {
    @Test
    public void gridTest() throws MalformedURLException, InterruptedException {
        /*DesiredCapabilities fireFoxDC=DesiredCapabilities.firefox();
        //指定机器的ip和hub端口，wd/hub必须要写
        WebDriver driver=new RemoteWebDriver(new URL("http://192.168.191.3:4444/wd/hub"),fireFoxDC);*/
        DesiredCapabilities chromeDC=DesiredCapabilities.chrome();
        //指定机器的ip和hub端口，wd/hub必须要写
        WebDriver driver=new RemoteWebDriver(new URL("http://192.168.137.1:4445/wd/hub"),chromeDC);
        driver.get("http://www.baidu.com");
        Thread.sleep(5000);
    }
}
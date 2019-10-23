package com.fang.Demo1;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class GridHub {
    @DataProvider(name = "browser1")
    public  Object[][] data(){
        //return返回的后面要加引号，必须是Object类
        return new Object[][]{
                {"http://192.168.137.1:3333","chrome"},
                {"http://192.168.137.1:5555","firefox"}
        };
    }
    @Test(dataProvider = "browser1")
    public void testData(String url,String browser) throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = null;
        if (browser=="chrome"){
            desiredCapabilities=DesiredCapabilities.chrome();
        }else if(browser=="firefox"){
            desiredCapabilities=DesiredCapabilities.firefox();
        }else {
            desiredCapabilities=DesiredCapabilities.internetExplorer();
        }
        WebDriver driver=new RemoteWebDriver(new URL(url+"/wd/hub"),desiredCapabilities);
        driver.get("http://www.baidu.com");
        Thread.sleep(5000);
        driver.quit();
    }


}

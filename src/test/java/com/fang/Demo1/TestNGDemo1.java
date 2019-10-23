package com.fang.Demo1;

import org.testng.annotations.*;

public class TestNGDemo1 {

    @BeforeTest
    public void beforeTest(){
        System.out.println("这是BeforeTest注解");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("这是BeforeMeyhod注解");
    }
    @Test
    public void testDemo1(){
        System.out.println("这是TestDemo1,case1");
    }
    @Test
    public void testDemo2(){
        System.out.println("这是TestDemo2,case2");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("这是AfterTest注解");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("这是AfterMwthod注解");
    }
}

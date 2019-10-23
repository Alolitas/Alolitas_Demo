package com.fang.Demo1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGDemo2 {
    @Test
    public void assertEquals(){
        int a=2;
        int b=4;
        Assert.assertEquals(a,b,"两数不相等");
    }

    @Test
    public void assertNotEquals(){
        int a=2;
        int b=4;
        Assert.assertNotEquals(a,b);
    }

    @Test
    public void assertFalse(){
        boolean a = false;
        Assert.assertFalse(a);
    }
}

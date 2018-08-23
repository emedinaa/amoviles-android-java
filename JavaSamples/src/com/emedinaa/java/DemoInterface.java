package com.emedinaa.java;

import com.emedinaa.java.interfaces.MyInterface;

public class DemoInterface implements MyInterface {

    @Override
    public void method1() {
        System.out.println("implementation of method1");
    }

    @Override
    public void method2() {
        System.out.println("implementation of method2");
    }
}

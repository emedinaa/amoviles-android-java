package com.emedinaa.java;

import com.emedinaa.java.interfaces.MyInfA;
import com.emedinaa.java.interfaces.MyInfB;

//public class DemoInterfaceAB implements MyInfA {
public class DemoInterfaceAB implements MyInfB {

    @Override
    public void method2() {
        System.out.println("method2");
    }

    @Override
    public void method1() {
        System.out.println("method1");
    }
}

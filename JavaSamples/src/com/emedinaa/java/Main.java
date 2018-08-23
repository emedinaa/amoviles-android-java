package com.emedinaa.java;

import com.emedinaa.java.entity.Car;
import com.emedinaa.java.entity.Ford;
import com.emedinaa.java.entity.PersonEntity;
import com.emedinaa.java.entity.Sum;
import com.emedinaa.java.interfaces.MyInfB;
import com.emedinaa.java.interfaces.MyInterface;
import com.emedinaa.java.interfaces.MyView;

public class Main {

    public static void main(String args[]){

        /*Sum sum= new Sum();
        System.out.println("Sum 2 :"+sum.add(10,20));
        System.out.println("Sum 3 :"+sum.add(10,20,30));

        Car car= new Ford();
        int num= car.speedLimit();
        System.out.println("Speed Limit is: "+num);

        MyInterface demo= new DemoInterface();
        demo.method1();

        MyInfB demoAB= new DemoInterfaceAB();
        demoAB.method1();*/

        PersonEntity personEntity= new PersonEntity("40898479");
        System.out.println("personEntity "+personEntity.toString());

        personEntity.setDni("42078293");
        System.out.println("personEntity "+personEntity.toString());

        PersonEntity personEntity1= new PersonEntity("Eduardo","Medina");
        System.out.println("personEntity "+personEntity1.toString());

        Car car= new Ford();
        System.out.println("car "+car.speedLimit());


        Sum sum= new Sum();
        System.out.println("Sum 2 :"+sum.add(10,20));
        System.out.println("Sum 3 :"+sum.add(10,20,30));

        MyView logInView= new LogInView();
        logInView.draw();

        MyView homeView= new HomeView();
        homeView.draw();
    }
}

package com.emedinaa.java;

import com.emedinaa.java.interfaces.MyView;

public class LogInView implements MyView {
    @Override
    public void draw() {
        System.out.println("Drawing...");
    }

    @Override
    public void showMessage(String message) {
        System.out.println("show message...");
    }

    @Override
    public void showLoading() {
        System.out.println("show loading...");
    }

    @Override
    public void hideLoading() {
        System.out.println("hide loading...");
    }
}

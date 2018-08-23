package com.emedinaa.java;

import com.emedinaa.java.interfaces.MyView;

public class HomeView implements MyView {
    @Override
    public void draw() {
        System.out.println("Not draw...");
    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}

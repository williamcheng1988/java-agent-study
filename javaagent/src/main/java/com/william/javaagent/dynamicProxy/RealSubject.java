package com.william.javaagent.dynamicProxy;

public class RealSubject implements Subject {

    @Override
    public void hello1(String str) {
        System.out.println("This is hello1:" + str);
    }

    @Override
    public void hello2(String str) {
        System.out.println("This is hello2:" + str);
    }
}
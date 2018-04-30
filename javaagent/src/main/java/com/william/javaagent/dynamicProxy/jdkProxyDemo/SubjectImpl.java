package com.william.javaagent.dynamicProxy.jdkProxyDemo;

/**
 * User: William Cheng
 * Create Time: 2018/4/30 17:48
 * Description:
 */
public class SubjectImpl implements ISubject {
    @Override
    public void hello1(String str) {
        System.out.println("This is hello1:" + str);
    }
    @Override
    public void hello2(String str) {
        System.out.println("This is hello2:" + str);
    }
}
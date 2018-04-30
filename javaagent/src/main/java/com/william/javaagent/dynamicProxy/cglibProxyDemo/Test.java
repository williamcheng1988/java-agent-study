package com.william.javaagent.dynamicProxy.cglibProxyDemo;

import net.sf.cglib.proxy.Enhancer;

/**
 * User: William Cheng
 * Create Time: 2018/4/30 18:49
 * Description: cglib 动态代理测试
 */
public class Test {

    public static void main(String[] args) {
        Subject subject = (Subject) new CglibProxy(new Subject()).getProxyInstance();
        subject.say("张三");
    }
}
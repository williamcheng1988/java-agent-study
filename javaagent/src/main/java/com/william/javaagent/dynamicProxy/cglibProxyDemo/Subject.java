package com.william.javaagent.dynamicProxy.cglibProxyDemo;

/**
 * User: William Cheng
 * Create Time: 2018/4/30 18:02
 * Description:
 */
public class Subject {

    public void say(String name){
        System.out.println(name + " say hello ...");
    }
}
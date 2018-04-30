package com.william.javaagent.dynamicProxy;

import com.william.javaagent.dynamicProxy.cglibProxyDemo.Subject;
import com.william.javaagent.dynamicProxy.jdkProxyDemo.ISubject;
import com.william.javaagent.dynamicProxy.jdkProxyDemo.SubjectImpl;

/**
 * User: William Cheng
 * Create Time: 2018/4/30 19:33
 * Description:
 */
public class TestDynamicProxy {


    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        ISubject object1 = MyDynamicProxy.getAgent(new SubjectImpl());
        object1.hello1("李四");
        object1.hello2("王五");

        System.out.println("");
        System.out.println("----------------------------优美的分割线----------------------------");
        System.out.println("");

        Subject object2 = MyDynamicProxy.getAgent(new Subject());
        object2.say("张三");
    }

}
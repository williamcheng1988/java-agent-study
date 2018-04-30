package com.william.javaagent.dynamicProxy.jdkProxyDemo;

/**
 * User: William Cheng
 * Create Time: 2018/4/30 17:49
 * Description: jdk 动态代理测试
 */
public class Test {

    public static void main(String[] args) {
        ISubject subject = (ISubject) new JdkProxy(new RealSubject()).getProxyInstance();

        System.out.println(subject.getClass().getName());
        subject.hello1("张三");
        System.out.println();
        System.out.println();
        subject.hello2("李四");
    }
}


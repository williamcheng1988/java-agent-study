package com.william.javaagent.dynamicProxy;

import com.william.javaagent.dynamicProxy.cglibProxyDemo.CglibProxy;
import com.william.javaagent.dynamicProxy.cglibProxyDemo.Subject;
import com.william.javaagent.dynamicProxy.jdkProxyDemo.JdkProxy;
import com.william.javaagent.dynamicProxy.jdkProxyDemo.SubjectImpl;

/**
 * User: William Cheng
 * Create Time: 2018/4/30 19:43
 * Description:
 */
public class MyDynamicProxy {

    public static <T> T getAgent(Object o) throws IllegalAccessException, InstantiationException {
        Class<?> clazz = o.getClass();
        Class<?> interfaces[] = clazz.getInterfaces();//获得Dog所实现的所有接口
        if (interfaces != null && interfaces.length > 0) {
            System.out.println("jdk 动态代理生成方式");
            return (T)new JdkProxy(o).getProxyInstance();
        } else {
            System.out.println("cglib 动态代理生成方式");
            return (T)new CglibProxy(o).getProxyInstance();
        }
    }
}
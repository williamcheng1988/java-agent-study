package com.william.javaagent.dynamicProxy.cglibProxyDemo;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy {

    private Object targetObject;

    public CglibProxy(Object targetObject) {
        this.targetObject = targetObject;
    }

    public Object getProxyInstance() {
        Enhancer enhance = new Enhancer();//作用是创建一段动态地类字节码
        enhance.setSuperclass(targetObject.getClass());//设置父类，也就是使用传递过来的类来创建代理类
        enhance.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            //方法拦截前可以执行比如说权限检查之类的
            System.out.println("invoke before ...");

            //代理类调用父类的方法
            Object object = methodProxy.invokeSuper(o, objects);

            //方法拦截后可以执行比如说日志输出等等
            System.out.println("invoke after ...");

            return object;
        });//这个回调函数就是把调用的方法改为CglibProxy中的 inteceptor 方法，并称此行为为增强目标类
        return enhance.create();
    }
}
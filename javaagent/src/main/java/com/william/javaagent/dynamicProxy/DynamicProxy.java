package com.william.javaagent.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {
    //　这个就是我们要代理的真实对象
    private Object subject;

    //    构造方法，给我们要代理的真实对象赋初值
    public DynamicProxy(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object object, Method method, Object[] args)
            throws Throwable {
        //在代理真实对象前,可以进行一些前置处理
        System.out.println("DynamicProxy invoke begin.............王五预测张三会马失前蹄");

        System.out.println("invoke method:" + method);

        //    当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
        method.invoke(subject, args);

        //在代理真实对象后,可以进行一些后置处理
        System.out.println("DynamicProxy invoke end.............赵六也来个马后炮");

        return null;
    }

}
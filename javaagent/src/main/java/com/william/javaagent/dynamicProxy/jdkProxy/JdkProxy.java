package com.william.javaagent.dynamicProxy.jdkProxy;

import java.lang.reflect.Proxy;

/**
 * 动态代理对象，无需实现任何接口
 * 通过传入任何类型的目标对象并指定接口
 * 调用JDK接口动态创建代理对象
 */
public class JdkProxy {

    private Object targetObject;

    public JdkProxy(Object targetObject) {
        this.targetObject = targetObject;
    }

    public Object getProxyInstance() {
        //InvocationHandler:事件处理器，即对目标对象方法的执行
        return Proxy.newProxyInstance(
                targetObject.getClass().getClassLoader(), //和目标对象的类加载器保持一致
                targetObject.getClass().getInterfaces(), //目标对象实现的接口，因为需要根据接口动态生成对象
                (proxy, method, args) -> {
                    System.out.println("前拦截...");

                    Object result = method.invoke(targetObject, args);

                    System.out.println("后拦截...");
                    return result;
                });
    }
}
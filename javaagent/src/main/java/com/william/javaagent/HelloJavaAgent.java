package com.william.javaagent;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

/**
 * User: William Cheng
 * Create Time: 2018/4/1 11:57
 * Description:  java agent 普通测试
 */
public class HelloJavaAgent {

    public static void premain(String arg, Instrumentation instrumentation) {
        //程序启动时，指定运行参数
        System.out.println("hello1 java agent, send by " + arg);

        /*instrumentation.addTransformer(new ClassFileTransformer() {
            public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
                return null;
            }
        });*/
    }
}
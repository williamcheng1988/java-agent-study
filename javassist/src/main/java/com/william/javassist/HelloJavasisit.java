package com.william.javassist;

import javassist.*;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

/**
 * User: William Cheng
 * Create Time: 2018/4/1 12:46
 * Description: javassist 测试
 */
public class HelloJavasisit {

    public static void premain(String arg, Instrumentation instrumentation) {
        //程序启动时，指定运行参数
        System.out.println("hello javassist, created by " + arg);

        instrumentation.addTransformer(new ClassFileTransformer() {
            public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
                String myClassName = "com.william.service.BizService";
                if (!className.replaceAll("/", ".").equals(myClassName)) {
                    return null;
                }
                ClassPool pool = new ClassPool();
                pool.insertClassPath(new LoaderClassPath(loader));
                try {
                    CtClass ctl = pool.get(myClassName);
                    CtMethod method = ctl.getDeclaredMethod("fetchBizInfo");
                    method.insertBefore("System.out.println(\"当前时间：\"+System.currentTimeMillis());");
                    //method.insertAfter("throw new RuntimeException(\"自定义异常\");");
                    method.setBody("{return \"new result...\";}");
                    method.insertAfter("fetchBizDomain($$);");//调用另外一个方法  $$代表所有参数
                    method.insertAfter("System.out.println(\"重新定义后的返回值：\"+$_);");
                    //method.insertAfter("System.out.println(\"重新定义后的返回值：\"+$_);");

                    CtMethod method2 = ctl.getDeclaredMethod("fetchBizDomain");
                    method2.insertAfter("System.out.println(\"fetchBizDomain的返回值：\"+$_);");

                    return ctl.toBytecode();
                } catch (NotFoundException e) {
                    e.printStackTrace();
                } catch (CannotCompileException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        });
    }
}
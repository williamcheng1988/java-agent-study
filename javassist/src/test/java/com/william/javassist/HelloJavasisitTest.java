package com.william.javassist;

import com.william.service.BizService;

import java.lang.management.ManagementFactory;

/**
 * User: William Cheng
 * Create Time: 2018/4/1 12:47
 * Description:
 */
public class HelloJavasisitTest {

    public static void main(String[] args) {
        System.out.println("javassit dynamicProxy service begin...");
        System.out.println("输出进程ID："+ ManagementFactory.getRuntimeMXBean().getName());

        //new BizService().fetchBizInfo("1", "2");

        try {
            while (true) {
                Thread.sleep(1000);
                new BizService().fetchBizInfo("1", "2");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("javassit dynamicProxy service end...");
    }

    /*@Ignore
    @Test
    public void updateMethod() throws NotFoundException, CannotCompileException, IOException {
        ClassPool pool = new ClassPool();
        pool.appendSystemPath();
        CtClass ctl = pool.get("com.william.service.BizService");
        CtMethod mehod = ctl.getDeclaredMethod("fetchBizInfo");
        mehod.insertBefore("System.out.println(\"dynamicProxy update method fetchBizInfo\");");
        CtField f = new CtField(pool.get(String.class.getName()), "abc", ctl);
        ctl.addField(f);
        File file = new File(System.getProperty("user.dir") + "/target/BizService.class");
        file.createNewFile();
        Files.write(file.toPath(), ctl.toBytecode());
    }*/

    /*@Ignore
    @Test
    public void update() throws NotFoundException, CannotCompileException, IOException {
        ClassPool pool = new ClassPool();
        pool.appendSystemPath();
        CtClass ctl = pool.get("com.tuling.demo.dynamicProxy.UserServiceImpl");
        CtMethod mehod = ctl.getDeclaredMethod("addUser");
//        mehod.insertBefore("System.out.println($0);");
//        mehod.insertBefore("System.out.println($1);");
//        mehod.insertBefore("System.out.println($2);");
        mehod.insertBefore(" fetchBizDomain($$);");
        ctl.toClass();
        new BizService().fetchBizInfo("1", "2");
    }*/

}
package com.william.javaattach;

import com.sun.tools.attach.VirtualMachine;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Ignore;

import java.lang.management.ManagementFactory;

/**
 * Unit test for simple AttachAgent.
 */
public class AttachAgentTest {

    /*public static void main(String[] args) throws Exception {
        String targetPid = "8468";
        VirtualMachine vm = VirtualMachine.attach(targetPid);
        //vm.loadAgent(System.getProperty("user.dir") + "/target/tuling-apm-demo-1.0-SNAPSHOT.jar", "toagent");
        vm.loadAgent("D:\\github\\javassist-study\\javaattach\\target\\javaattach-0.0.1-SNAPSHOT.jar", "toagent");
    }*/

    public static void main(String[] args) throws InterruptedException {
        System.out.println("输出进程ID："+ ManagementFactory.getRuntimeMXBean().getName());
        while (true) {
            Thread.sleep(100);
        }
    }

    @Ignore
    @org.junit.Test
    public void agentAttach() throws Exception {
        String targetPid = "9500";
        VirtualMachine vm = VirtualMachine.attach(targetPid);
        vm.loadAgent(System.getProperty("user.dir") + "/target/javaattach-0.0.1-SNAPSHOT.jar",
                "toagent");
        /*VirtualMachine.attach(System.getProperty("user.dir") + "/target/javaattach-0.0.1-SNAPSHOT.jar");
        while (true) {
            Thread.sleep(1000);
        }*/
        //vm.loadAgentLibrary(System.getProperty("user.dir") + "/target/javaattach-0.0.1-SNAPSHOT.jar");
    }
}

package com.william.service;

/**
 * User: William Cheng
 * Create Time: 2018/4/1 12:50
 * Description:  测试模拟服务类
 */
public class BizService implements IBizService {

    public String fetchBizInfo(String arg1, String arg2) {
        System.out.println("fetchBizInfo ...");
        return "fetchBizInfo result";
    }

    public String fetchBizDomain(String arg1, String arg2) {
        System.out.println("fetchBizDomain ...");
        return "fetchBizDomain result:" + arg1 + "," + arg2;
    }

}
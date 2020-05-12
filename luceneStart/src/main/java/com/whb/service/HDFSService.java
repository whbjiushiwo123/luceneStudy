package com.whb.service;

// 服务提供商的具体实现1：HDFS实现

public class HDFSService implements IService {
    @Override
    public String sayHello() {
        return "Hello HDFSService";
    }

    @Override
    public String getScheme() {
        return "hdfs";
    }
}

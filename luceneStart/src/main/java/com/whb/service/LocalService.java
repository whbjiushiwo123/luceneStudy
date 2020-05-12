package com.whb.service;
// 服务提供商的具体实现2：Local实现

public class LocalService implements  IService {
    @Override
    public String sayHello() {
        return "Hello LocalService";
    }

    @Override
    public String getScheme() {
        return "local";
    }
}

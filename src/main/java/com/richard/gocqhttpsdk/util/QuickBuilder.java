package com.richard.gocqhttpsdk.util;

import com.richard.gocqhttpsdk.pojo.Request;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class QuickBuilder {
    public static  Request request(String action)
    {
        return new Request(action,null,null);
    }
    public static Request request(String action,String... args)
    {
        if (args.length%2!=0)
        {
            log.error("request 快速创建时候，args部分数量不为双数");
            return null;
        };//只能双数
        Map<String ,String> params=new HashMap<>();
        for (int i=0;i< args.length;i=i+2)
        {
            params.put(args[i],args[i+1]);
        }
        return new Request(action,params,null);
    }

}

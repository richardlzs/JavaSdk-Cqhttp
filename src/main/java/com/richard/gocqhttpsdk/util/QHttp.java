package com.richard.gocqhttpsdk.util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.richard.gocqhttpsdk.pojo.Request;
import com.richard.gocqhttpsdk.pojo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class QHttp {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private QuickParser quickParser;

    @Autowired
    private Gson gson;

    @Value("${com.richard.sdk.url}")
    private String url;

    public String post(String endpoint,Object forPost)
    {
        return restTemplate.postForObject(url+endpoint,forPost,String.class);
    }



    public Map<String,String> post(String endpoint, String... args)
    {
        Request request = QuickBuilder.request(endpoint, args);
        Map<String,String> params=request.getParams();
        String s = restTemplate.postForObject(url + endpoint, params, String.class);
        TypeToken<Response<Map<String, String>>> typeToken = new TypeToken<Response<Map<String, String>>>() {};
        Response<Map<String,String>> mapResponse = gson.fromJson(s, typeToken );
        if (!(mapResponse.getRetcode()==1||mapResponse.getRetcode()==0))
        {
            log.error("Api调用失败："+endpoint+ Arrays.toString(args)+"----->"+s);
            return null;
        }

        log.info(endpoint+ Arrays.toString(args)+"----->"+mapResponse.getData());
        return mapResponse.getData();
    }


    public <T> T postForT (String endpoint,Class<T> reponseType, String... args)
    {
        Request request = QuickBuilder.request(endpoint, args);
        Map<String,String> params=request.getParams();
        String s = restTemplate.postForObject(url + endpoint, params, String.class);
        JsonObject jsonObject= JsonParser.parseString(s).getAsJsonObject();

        TypeToken<T> typeToken = TypeToken.get(reponseType);
        if (!(jsonObject.get("retcode").getAsInt()==0||jsonObject.get("retcode").getAsInt()==1))
        {
            log.error("Api调用失败："+endpoint+ Arrays.toString(args)+"----->"+s);
            return null;
        }

        T data = gson.fromJson(jsonObject.get("data"), typeToken.getType());
        log.info(endpoint+ Arrays.toString(args)+"----->"+data.toString());
        return data;
    }

    public <T> ArrayList<T> postForArrayList(String endpoint, Class<T> elementType, String... args)
    {
        Request request = QuickBuilder.request(endpoint, args);
        Map<String,String> params=request.getParams();
        String s = restTemplate.postForObject(url + endpoint, params, String.class);
        JsonObject jsonObject= JsonParser.parseString(s).getAsJsonObject();
        if (!(jsonObject.get("retcode").getAsInt()==0||jsonObject.get("retcode").getAsInt()==1))
        {
            log.error("Api调用失败："+endpoint+ Arrays.toString(args)+"----->"+s);
            return null;
        }
        Type type = TypeToken.getParameterized(ArrayList.class, elementType).getType();
        ArrayList<T> data = gson.fromJson(jsonObject.get("data"),type);
        log.info(endpoint+ Arrays.toString(args)+"----->"+data.toString());
        return data;
    }


    /**
     * api无返回值时候使用
     * @param endpoint 终结点
     * @param args 参数
     * @return 是否成功处理，异步操作会返回true
     */
    public boolean postForSuccess(String endpoint, String... args)
    {
        Request request = QuickBuilder.request(endpoint, args);
        Map<String,String> params=request.getParams();
        String s = restTemplate.postForObject(url + endpoint, params, String.class);
        if (s==null)return false;
        int retcode=JsonParser.parseString(s).getAsJsonObject().get("retcode").getAsInt();
        if (retcode==0||retcode==1)//成功或异步处理
        {
            log.info(endpoint+ Arrays.toString(args)+"-----> true");
            return true;
        }
        else
        {
            log.error("Api调用失败："+endpoint+ Arrays.toString(args)+"----->"+s);
            return false;
        }

    }


}

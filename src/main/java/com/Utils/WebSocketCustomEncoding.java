package com.Utils;

import com.Entity.poistion;
import com.alibaba.fastjson.JSON;


import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class WebSocketCustomEncoding implements Encoder.Text<poistion> {
    @Override
    public String encode(poistion poistion) {
        assert poistion!=null;
        return JSON.toJSONString(poistion.Poistion);
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }
}

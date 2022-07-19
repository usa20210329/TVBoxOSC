package com.github.tvbox.osc.util;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.AbsCallback;
import com.lzy.okgo.model.Response;
import com.orhanobut.hawk.Hawk;
import com.github.tvbox.osc.util.LOG;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import com.github.tvbox.osc.util.HawkConfig;

/**
 * @author anaer
 */
public class PushHelper {

    public static void debugPush(String message){
        if(Hawk.get(HawkConfig.DEBUG_OPEN, false)){
            push(message);
        }
    }

    /**
     * 推送消息
     * @param message
     */
    public static void push(String message) {
        OkGo.<String>get("https://api2.pushdeer.com/message/push?pushkey=PDU3423TORUEz2NZHKZVIpSlb2ErGJcERTunXneI&text="
        + URLEncoder.encode(message)).execute(new AbsCallback<String>() {
            @Override
            public String convertResponse(okhttp3.Response response) throws Throwable {
                return response.body().string();
            }

            @Override
            public void onSuccess(Response<String> response) {
               LOG.i(response.body()); 
            }
        });
    }

}

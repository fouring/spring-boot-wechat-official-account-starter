package com.four.flower.wechat.oa.http;


import com.four.flower.wechat.oa.directive.Directive;
import com.four.flower.wechat.oa.exception.ChannelException;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;


/**
 * @author xiejing
 */
@Slf4j
public class HttpClient {

    private static OkHttpClient client;

    static {
        client = new OkHttpClient.Builder()
                .readTimeout(15, TimeUnit.SECONDS)
                .connectTimeout(15, TimeUnit.SECONDS)
                .build();
    }


    /**
     * post with json param
     *
     * @param directive
     * @return JSONObject
     */
    public static String execute(Directive directive) throws IOException {
        Request request = directive.buildOkHttpRequest();
        Response response = client.newCall(request).execute();
        return parseResponse(response);
    }

    /**
     * @param response
     * @return
     */
    private static String parseResponse(Response response) throws IOException {
        ResponseBody responseBody = response.body();
        if (Objects.nonNull(responseBody)) {
            String data = responseBody.string();
            log.info("response data : {}", data);
            return data;
        }
        throw new ChannelException(response.message());
    }


}
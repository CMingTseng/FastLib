package com.fast.library.sample.http;

import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.http.POST;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 说明：接口服务
 * <p>
 * 作者：fanly
 * <p>
 * 类型：Class
 * <p>
 * 时间：2016/6/12 10:26
 * <p>
 * 版本：verson 1.0
 */
public class ServerAPI {

    private static API api = null;
    private static String baseUrl = "http://121.43.96.52:8080/trusttee/";

    private static API getAPI(){
        if (api == null){
            api = new RetrofitClient.Builder().baseUrl(baseUrl)
                    .setTimeout(5000)
//                    .setTrustAll(true)
                    .build()
                    .init()
                    .retrofitBuilder()
                    .addConverterFactory(StringConverterFactroy.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build()
                    .create(API.class);
        }
        return api;
    }

    public interface API{
        //获取服务器时间
        @POST("TimeServlet")
        Observable<String> getServerTime();
    }

    public static Observable<String> getServerTime(){
        return getAPI().getServerTime()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}

package com.example.mvpchouqu3.net;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * 单例模式
 *
 * retrofit + rxjava
 */
public class HttpUtils {
    private static HttpUtils httpUtils;
    private Retrofit.Builder builder;

    public HttpUtils() {
        initRetrofit();
    }
    public static HttpUtils getInstance(){
        if (httpUtils==null){
            synchronized (HttpUtils.class){
                if (httpUtils==null){
                    httpUtils=new HttpUtils();
                }
            }
        }
        return httpUtils;
    }
    /**
     * 初始化retrofit
     */
    private void initRetrofit(){
        builder = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());
    }
/**
 * ApiService.class
 *
 */
public <T> T getApiService(String url,Class<T> tClass){
    return builder.baseUrl(url).build().create(tClass);//真正创建了retrofit的对象
}

    /**
     * 调度线程--切换线程
     * @return--compose
     */
    public static ObservableTransformer schedulersTransformer(){
        return new ObservableTransformer() {
            @Override
            public ObservableSource apply(Observable upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

}

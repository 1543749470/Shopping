package com.example.mvpchouqu3.mvp_login;

import android.util.Log;

import com.example.mvpchouqu3.LoginService;
import com.example.mvpchouqu3.net.HttpUtils;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginModelImp implements LoginModel{
    private static final String TAG = "LoginModelImp";
    @Override
    public void getLoginData(String name, String psw, final CallBack callBack) {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(LoginService.loginUrl)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .build();
//        LoginService loginService = retrofit.create(LoginService.class);
        HttpUtils.getInstance().getApiService(LoginService.loginUrl,LoginService.class)
                .getLogin(name,psw)
                .compose(HttpUtils.schedulersTransformer())
//                .subscribe(new Observer() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.e(TAG, "onSubscribe: 网络请求前调用，，用于初始化某事件" );
//                    }
//
//                    @Override
//                    public void onNext(Object o) {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//        loginService.getLogin(name,psw).subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "onSubscribe: " );
                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Log.e(TAG, "onNext: "+string );
                            callBack.getLoginDataSuccess(string);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: "+e.getMessage() );
                        callBack.getLoginDataFilade(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "onComplete: " );
                    }
                });
    }
}

package com.example.mvpchouqu3;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginService {

//    登录接口：http://yun918.cn/study/public/index.php/login
//    post 参数（String username,String password） 注：username可以是注册的用户名或手机号

    String loginUrl ="http://yun918.cn/";
    @FormUrlEncoded
    @POST("study/public/index.php/login")
    Observable<ResponseBody>  getLogin(@Field("username") String name, @Field("password") String psw);
}

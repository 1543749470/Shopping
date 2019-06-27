package com.example.shopping2;


import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    String getUrl="http://www.qubaobei.com/";
    @GET("ios/cf/dish_list.php?stage_id=1&limit=20&page=1")
    Call<NewBeans> getU();
}

package com.example.mvpchouqu3.mvp_login;

import com.example.mvpchouqu3.mvp_base.BaseModel;

public interface LoginModel extends BaseModel {
    void getLoginData(String name,String psw,CallBack callBack);
}

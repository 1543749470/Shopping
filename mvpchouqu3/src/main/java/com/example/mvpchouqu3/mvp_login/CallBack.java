package com.example.mvpchouqu3.mvp_login;

public interface CallBack<T> {
    void getLoginDataSuccess(T json);
    void getLoginDataFilade(String error);
}

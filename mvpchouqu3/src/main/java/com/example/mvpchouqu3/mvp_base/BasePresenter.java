package com.example.mvpchouqu3.mvp_base;

public abstract class BasePresenter<V extends BaseView,M extends BaseModel>{
    protected  V view;
    protected  M model;

    public BasePresenter(V view) {
        this.view = view;
        model=initModel();
    }

    protected abstract M initModel();
    //解绑 view
    public abstract void detachView();
}

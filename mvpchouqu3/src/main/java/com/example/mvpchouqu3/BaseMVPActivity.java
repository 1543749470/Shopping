package com.example.mvpchouqu3;

import com.example.mvpchouqu3.mvp_base.BasePresenter;

public abstract class BaseMVPActivity<P extends BasePresenter>extends  SimpleActivity {
    protected P presenter;
    protected abstract P initPresenter();

    @Override
    protected void initPre() {
        presenter=initPresenter();
    }
}

package com.example.mvpchouqu3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.mvpchouqu3.mvp_login.LoginPresenter;
import com.example.mvpchouqu3.mvp_login.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseMVPActivity<LoginPresenter> implements LoginView {


    @BindView(R.id.Bt)
    Button Bt;
    @BindView(R.id.Tv)
    TextView Tv;

    @Override
    protected LoginPresenter initPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }
    @OnClick(R.id.Bt)
    public void onClick(){
        presenter.getLoginAction("11","11");
    }
    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void updateUISuccess(String result) {
        Tv.setText(result);
    }

    @Override
    public void showError(String error) {
        Tv.setText(error);
    }


}

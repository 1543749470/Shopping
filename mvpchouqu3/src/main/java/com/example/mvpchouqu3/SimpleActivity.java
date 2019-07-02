package com.example.mvpchouqu3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class SimpleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());

        ButterKnife.bind(this);
        initPre();
        initListener();
        initData();
    }

    protected abstract void initData();

    protected abstract void initListener();

    protected abstract void initPre();


    protected abstract int getLayout();
}

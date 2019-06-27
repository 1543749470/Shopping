package com.example.shopping2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Toolbar mMyToolbar;
    private RecyclerView mMyRec;
    /**
     * .......
     */
    private TextView mYuan;
    private MyRecAdapter myRecAdapter;
    int mainy=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initToolbar();
        initData();
    }

    private static final String TAG = "MainActivity";
    private void initData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.getUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getU().enqueue(new Callback<NewBeans>() {
            @Override
            public void onResponse(Call<NewBeans> call, Response<NewBeans> response) {
                List<DataBean> data = response.body().getData();
                Log.e(TAG, "onNext: "+data );

                myRecAdapter.addData(data);
            }

            @Override
            public void onFailure(Call<NewBeans> call, Throwable t) {

            }
        });
    }

    private void initToolbar() {
        mMyToolbar.setTitle("");
    }

    private void initView() {
        mMyToolbar = (Toolbar) findViewById(R.id.myToolbar);
        mMyRec = (RecyclerView) findViewById(R.id.myRec);
        mYuan = (TextView) findViewById(R.id.yuan);
        mMyRec.setLayoutManager(new LinearLayoutManager(this));
        mMyRec.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        myRecAdapter = new MyRecAdapter(this);
        mMyRec.setAdapter(myRecAdapter);
        myRecAdapter.setOnItemClickListener(new MyRecAdapter.OnItemClickListener() {
            @Override
            public void onClickListener(View v,DataBean dataBean) {
                int num = dataBean.getNum();
                CheckBox checkBox = v.findViewById(R.id.rec_check);
                if (checkBox.isChecked()){
                    mainy+=num;
                }else {
                    mainy-=num;
                }
                mYuan.setText(mainy+"$");
                myRecAdapter.notifyDataSetChanged();
            }
        });
    }
}

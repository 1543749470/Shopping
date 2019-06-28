package com.example.danli;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.danli.factory.Shape;
import com.example.danli.factory.ShapeFactory;
import com.example.danli.factory2.AbstractFactory;
import com.example.danli.factory2.Color;
import com.example.danli.factory2.ColorFactory;
import com.example.danli.factory2.FactroyProducer;
import com.example.danli.single.SingleTon1;
import com.example.danli.single.SingleTon2;
import com.example.danli.single.SingleTon3;
import com.example.danli.single.SingleTon4;
import com.example.danli.single.SingleTon5;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 单例模式
     */
    private Button mSingleClick;
    /**
     * 工厂模式
     */
    private Button mFactoryClick;
    /**
     * 抽象工厂模式
     */
    private Button mFactory2Click;
    /**
     * 建造者模式
     */
    private Button mBulderClick;
    /**
     * 观察者模式
     */
    private Button mObserveClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mSingleClick = (Button) findViewById(R.id.single_click);
        mSingleClick.setOnClickListener(this);
        mFactoryClick = (Button) findViewById(R.id.factory_click);
        mFactoryClick.setOnClickListener(this);
        mFactory2Click = (Button) findViewById(R.id.factory2_click);
        mFactory2Click.setOnClickListener(this);
        mBulderClick = (Button) findViewById(R.id.bulder_click);
        mBulderClick.setOnClickListener(this);
        mObserveClick = (Button) findViewById(R.id.observe_click);
        mObserveClick.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.single_click:
                testSingle();
                break;
            case R.id.factory_click:
                testFactory();
                break;
            case R.id.factory2_click:
                testFactory2();
                break;
            case R.id.bulder_click:
                break;
            case R.id.observe_click:
                break;
        }
    }

    private void testFactory2() {
        AbstractFactory factory = FactroyProducer.getFactory(FactroyProducer.COLOR);
        Color color = factory.getColor(ColorFactory.GREEN);
        color.fill();
    }

    private void testFactory() {
        Shape shape = ShapeFactory.getShape(ShapeFactory.SQUARE);
        shape.draw();
    }

    private void testSingle() {
        SingleTon1.getInstance().doSomeThing();
        SingleTon2.getInstance().doSomething();
        SingleTon3.getInstance().doSomething();
        SingleTon4.getInstance().doSomething();
        SingleTon5.INSTANCE.doSomething();
    }
}

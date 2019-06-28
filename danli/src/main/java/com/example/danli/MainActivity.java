package com.example.danli;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.danli.builder.Computer;
import com.example.danli.builder.MacBook;
import com.example.danli.factory.Shape;
import com.example.danli.factory.ShapeFactory;
import com.example.danli.factory2.AbstractFactory;
import com.example.danli.factory2.Color;
import com.example.danli.factory2.ColorFactory;
import com.example.danli.factory2.FactroyProducer;
import com.example.danli.observable.CuiHhua;
import com.example.danli.observable.SingleMan;
import com.example.danli.single.SingleTon1;
import com.example.danli.single.SingleTon2;
import com.example.danli.single.SingleTon3;
import com.example.danli.single.SingleTon4;
import com.example.danli.single.SingleTon5;
import com.example.danli.template.FootBall;

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
    /**
     * 模板模式
     */
    private Button mTemplateClick;

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
        mTemplateClick = (Button) findViewById(R.id.template_click);
        mTemplateClick.setOnClickListener(this);
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
                testBulider();
                break;
            case R.id.observe_click:
                testObserver();
                break;
            case R.id.template_click:
                testTemplate();
                break;
        }
    }

    private void testTemplate() {
        FootBall footBall = new FootBall();
        footBall.play();
    }

    private static final String TAG = "MainActivity";
    private void testBulider() {
        Computer build = new MacBook.MacBookBuilder()
                .setBroad("1111")
                .setDisplay("22222")
                .setOS("33333")
                .build();

        Log.e(TAG, "testBulider: "+build.toString() );
    }

    private void testObserver() {
        CuiHhua cuiHhua = new CuiHhua();
        SingleMan singleMan = new SingleMan();
        SingleMan singleMan1 = new SingleMan();
        SingleMan singleMan2 = new SingleMan();

        cuiHhua.addObserver(singleMan);//发生订阅关系
        cuiHhua.addObserver(singleMan1);//发生订阅关系
        cuiHhua.addObserver(singleMan2);//发生订阅关系

        cuiHhua.createEvent("啧啧啧");
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

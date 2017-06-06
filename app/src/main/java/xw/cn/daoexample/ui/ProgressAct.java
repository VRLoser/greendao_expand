package xw.cn.daoexample.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import xw.cn.daoexample.R;
import xw.cn.daoexample.view.progressview.CircleProgressView;

/**
 * Created by Xw on 2017/6/6.
 */

public class ProgressAct extends AppCompatActivity{

    private CircleProgressView circleView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress_act);
        circleView= (CircleProgressView) findViewById(R.id.circle_view);


    }
}

package com.linsh.demo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.linsh.circleprogress.CircleProgress;
import com.linsh.circleprogress.ParallelCircleProgress;
import com.linsh.circleprogress.SeriesCircleProgress;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CircleProgress mCircleProgress;
    private SeriesCircleProgress mSeriesCircleProgress;
    private ParallelCircleProgress mParallelCircleProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mCircleProgress = (CircleProgress) findViewById(R.id.circleprogress);
        mCircleProgress.setProgressWidth(20);
        mCircleProgress.setProgressColor(Color.BLUE);
        mCircleProgress.setOnClickListener(this);

        mSeriesCircleProgress = (SeriesCircleProgress) findViewById(R.id.seriescircleprogress);
        mSeriesCircleProgress.setProgressWidth(20);
        mSeriesCircleProgress.setProgressColor(new int[]{Color.RED, Color.BLUE, Color.YELLOW});
        mSeriesCircleProgress.setOnClickListener(this);

        mParallelCircleProgress = (ParallelCircleProgress) findViewById(R.id.parallelcircleprogress);
        mParallelCircleProgress.setProgressWidth(10);
        mParallelCircleProgress.setProgressColor(new int[]{Color.RED, Color.BLUE, Color.YELLOW});
        mParallelCircleProgress.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        onClick(mCircleProgress);
        onClick(mSeriesCircleProgress);
        onClick(mParallelCircleProgress);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.circleprogress:
                mCircleProgress.setProgressWithAnimation(mCircleProgress.isSelected() ? 0 : 60);
                mCircleProgress.setSelected(!mCircleProgress.isSelected());
                break;
            case R.id.seriescircleprogress:
                mSeriesCircleProgress.setProgressWithAnimation(mSeriesCircleProgress.isSelected() ? new int[3] : new int[]{40, 30, 20});
                mSeriesCircleProgress.setSelected(!mSeriesCircleProgress.isSelected());
                break;
            case R.id.parallelcircleprogress:
                mParallelCircleProgress.setProgressWithAnimation(mParallelCircleProgress.isSelected() ? new int[3] : new int[]{100, 50, 20});
                mParallelCircleProgress.setSelected(!mParallelCircleProgress.isSelected());
                break;
            default:
                break;
        }
    }
}

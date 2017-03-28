package com.linsh.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        int color1 = getResources().getColor(R.color.progressColor1);
        int color2 = getResources().getColor(R.color.progressColor2);
        int color3 = getResources().getColor(R.color.progressColor3);
        int color4 = getResources().getColor(R.color.progressColor4);
        int[] colors = {color1, color2, color3, color4};

        mCircleProgress = (CircleProgress) findViewById(R.id.circleprogress);
        mCircleProgress.setProgressColor(color1);
        mCircleProgress.setOnClickListener(this);

        mSeriesCircleProgress = (SeriesCircleProgress) findViewById(R.id.seriescircleprogress);
        mSeriesCircleProgress.setProgressColor(colors);
        mSeriesCircleProgress.setOnClickListener(this);

        mParallelCircleProgress = (ParallelCircleProgress) findViewById(R.id.parallelcircleprogress);
        mParallelCircleProgress.setProgressColor(colors);
        mParallelCircleProgress.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.circleprogress:
                mCircleProgress.setProgressWithAnimation(mCircleProgress.isSelected() ? 0 : 100);
                mCircleProgress.setSelected(!mCircleProgress.isSelected());
                break;
            case R.id.seriescircleprogress:
                mSeriesCircleProgress.setProgressWithAnimation(mSeriesCircleProgress.isSelected() ? new int[3] : new int[]{40, 30, 20, 10});
                mSeriesCircleProgress.setSelected(!mSeriesCircleProgress.isSelected());
                break;
            case R.id.parallelcircleprogress:
                mParallelCircleProgress.setProgressWithAnimation(mParallelCircleProgress.isSelected() ? new int[3] : new int[]{100, 70, 40, 10});
                mParallelCircleProgress.setSelected(!mParallelCircleProgress.isSelected());
                break;
            default:
                break;
        }
    }

    public void animating(View view) {
        onClick(mCircleProgress);
        onClick(mSeriesCircleProgress);
        onClick(mParallelCircleProgress);
    }
}

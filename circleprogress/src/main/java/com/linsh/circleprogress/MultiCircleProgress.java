package com.linsh.circleprogress;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import com.linsh.circleprogress.utils.LshArrayUtils;

import java.util.ArrayList;

/**
 * Created by Senh Linsh on 17/3/28.
 */

public abstract class MultiCircleProgress extends BaseCircleProgress {

    public MultiCircleProgress(Context context) {
        super(context);
    }

    public MultiCircleProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttr(attrs);
    }

    public MultiCircleProgress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttr(attrs);
    }

    private void initAttr(AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.MultiCircleProgress);
        int progress1 = typedArray.getInteger(R.styleable.MultiCircleProgress_progress1, 0);
        int progressColor1 = typedArray.getColor(R.styleable.MultiCircleProgress_progressColor1, 0);
        int progress2 = typedArray.getInteger(R.styleable.MultiCircleProgress_progress2, 0);
        int progressColor2 = typedArray.getColor(R.styleable.MultiCircleProgress_progressColor2, 0);
        int progress3 = typedArray.getInteger(R.styleable.MultiCircleProgress_progress3, 0);
        int progressColor3 = typedArray.getColor(R.styleable.MultiCircleProgress_progressColor3, 0);

        ArrayList<Integer> progresses = new ArrayList<>();
        ArrayList<Integer> progressColors = new ArrayList<>();
        if (progress1 != 0 || progressColor1 != 0) {
            progresses.add(progress1);
            progressColors.add(progressColor1);
        }
        if (progress2 != 0 || progressColor2 != 0) {
            progresses.add(progress2);
            progressColors.add(progressColor2);
        }
        if (progress3 != 0 || progressColor3 != 0) {
            progresses.add(progress3);
            progressColors.add(progressColor3);
        }
        if (progresses.size() > 0) {
            setProgress(LshArrayUtils.toArray(progresses));
            setProgressColor(LshArrayUtils.toArray(progressColors));
        }

        typedArray.recycle();
    }

    @Override
    public void setProgress(int[] progress) {
        super.setProgress(progress);
    }

    @Override
    public void setProgressColor(int[] colors) {
        super.setProgressColor(colors);
    }

    @Override
    public void setProgressWithAnimation(int[] progresses) {
        super.setProgressWithAnimation(progresses);
    }

    @Override
    public void setProgressWithAnimation(int[] progresses, long duration) {
        super.setProgressWithAnimation(progresses, duration);
    }
}

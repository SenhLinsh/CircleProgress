package com.linsh.circleprogress;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;


/**
 * Created by Senh Linsh on 17/3/15.
 */
public class SeriesCircleProgress extends MultiCircleProgress {


    public SeriesCircleProgress(Context context) {
        super(context);
    }

    public SeriesCircleProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SeriesCircleProgress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDrawProgress(Canvas canvas, float startAngle, float endAngle) {
        float sweepAngle;
        for (int i = 0; i < mCurrentProgresses.length; i++) {
            sweepAngle = mCurrentProgresses[i] * 3.6f;
            if (mProgressColors != null && i < mProgressColors.length) {
                mPaint.setColor(mProgressColors[i]);
            } else {
                mPaint.setColor(DEFAULT_COLOR);
            }
            canvas.drawArc(mRectF, startAngle, sweepAngle, false, mPaint);
            startAngle += sweepAngle;
        }
        if (Math.round(startAngle) < endAngle) {
            mPaint.setColor(mEmptyColor);
            canvas.drawArc(mRectF, startAngle, endAngle - startAngle, false, mPaint);
        }
    }
}

package com.linsh.circleprogress;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;


/**
 * Created by Senh Linsh on 17/3/15.
 */
public class ParallelCircleProgress extends MultiCircleProgress {

    private RectF mCurRectF = new RectF();

    public ParallelCircleProgress(Context context) {
        super(context);
    }

    public ParallelCircleProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ParallelCircleProgress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDrawProgress(Canvas canvas, float startAngle, float endAngle) {
        float sweepAngle;
        mCurRectF.left = mRectF.left;
        mCurRectF.right = mRectF.right;
        mCurRectF.top = mRectF.top;
        mCurRectF.bottom = mRectF.bottom;

        for (int i = 0; i < mCurrentProgresses.length; i++) {
            sweepAngle = mCurrentProgresses[i] * 3.6f;
            if (mProgressColors != null && i < mProgressColors.length) {
                mPaint.setColor(mProgressColors[i]);
            } else {
                mPaint.setColor(DEFAULT_COLOR);
            }
            canvas.drawArc(mCurRectF, startAngle, sweepAngle, false, mPaint);

            if (Math.round(sweepAngle) < endAngle) {
                mPaint.setColor(mEmptyColor);
                canvas.drawArc(mCurRectF, startAngle + sweepAngle, endAngle - startAngle - sweepAngle, false, mPaint);
            }

            mCurRectF.left += mStrokeWidth;
            mCurRectF.right -= mStrokeWidth;
            mCurRectF.top += mStrokeWidth;
            mCurRectF.bottom -= mStrokeWidth;
        }
    }
}

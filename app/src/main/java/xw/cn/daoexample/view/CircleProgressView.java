package xw.cn.daoexample.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import xw.cn.daoexample.R;

/**
 * Created by weixia on 2017/6/5.
 */

public class CircleProgressView extends View{
    //属性
    private float progress=0;
    private float strokeWidth=getResources().getDimension(R.dimen.activity_horizontal_margin);
    private float backgroundStrokeWidth=getResources().getDimension(R.dimen.activity_vertical_margin);
    private int color = Color.BLACK;
    private int backgroundColor=Color.GRAY;

    //用来画视图的对象
    private int startAngle=-90;
    private RectF rectF;
    private Paint backgroundPaint;
    private Paint showgroundPaint;

    //初始化方法
    public CircleProgressView(Context context) {
        super(context);

    }

    public CircleProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }


    private void init(Context context,AttributeSet attrs){
        rectF=new RectF();
        TypedArray typedArray=context.getTheme().obtainStyledAttributes(attrs,R.styleable.CircleProgressView,0,0);

        try{
            progress=typedArray.getFloat(R.styleable.CircleProgressView_cpb_progress,progress);
            strokeWidth=typedArray.getDimension(R.styleable.CircleProgressView_cpb_progressbar_width,strokeWidth);
            backgroundStrokeWidth=typedArray.getDimension(R.styleable.CircleProgressView_cpb_progressbar_background_width,backgroundStrokeWidth);
            color=typedArray.getColor(R.styleable.CircleProgressView_cpb_progressbar_color,color);
            backgroundColor=typedArray.getColor(R.styleable.CircleProgressView_cpb_progressbar_color,backgroundColor);
        }finally {
            typedArray.recycle();
        }
        backgroundPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        backgroundPaint.setColor(backgroundColor);
        backgroundPaint.setStyle(Paint.Style.STROKE);
        backgroundPaint.setStrokeWidth(backgroundStrokeWidth);

        showgroundPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        showgroundPaint.setColor(color);
        showgroundPaint.setStyle(Paint.Style.STROKE);
        showgroundPaint.setStrokeWidth(strokeWidth);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);





    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int height=getDefaultSize(getSuggestedMinimumHeight(),heightMeasureSpec);
        int width=getDefaultSize(getSuggestedMinimumWidth(),widthMeasureSpec);
        int min=Math.min(width,height);
        setMeasuredDimension(min,min);
        float highStroke=(strokeWidth>backgroundStrokeWidth)?strokeWidth:backgroundStrokeWidth;
        rectF.set(0+highStroke/2,min-highStroke/2,min-highStroke/2,min-highStroke/2);

    }

    public void setProgress(float progress){
        this.progress=(progress<=100)?progress:100;
        invalidate();
    }

    public float getStrokeWidth(){
        return strokeWidth
    }

    public void setStrokeWidth(float strokeWidth){
        this.strokeWidth=strokeWidth;
    }








}

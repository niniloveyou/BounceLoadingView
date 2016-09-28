package deadline.bounceloadingview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

/**
 * @author deadline
 * @time 2016/9/26
 */
public class BounceLoadingView extends View {

    private static final String TAG = BounceLoadingView.class.getSimpleName();

    private static final int SHADOW_COLOR = Color.GRAY;

    private int mShadowColor = SHADOW_COLOR;

    private Paint mBitmapPaint;
    private Paint mShadowPaint;


    //建议图片大小相同
    private ArrayList<Bitmap> mBitmapList;
    private Bitmap mCurrentBitmap;

    private RectF mShadowRectF;

    private float mPercent;

    private float mHalfShadowHeight;
    private float mHalfShadowWidth;

    public BounceLoadingView(Context context) {
        this(context, null);
    }

    public BounceLoadingView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BounceLoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public BounceLoadingView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void setup() {

        mPercent = 1f;
        mShadowRectF = new RectF();
        mBitmapList = new ArrayList<>();

        mShadowPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mShadowPaint.setStyle(Paint.Style.FILL);
        mShadowPaint.setColor(mShadowColor);
    }


    public void addBitmap(@NonNull Bitmap bitmap){
        mBitmapList.add(bitmap);
    }
    public void setBitmaps(ArrayList<Bitmap> bitmaps){
       if(bitmaps != null){
           mBitmapList.addAll(bitmaps);
       }
    }

    public void start(){

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mShadowRectF.set(getWidth() / 2 * mPercent,
                0.9f * getHeight() - 0.1f * mPercent * getHeight(),
                getWidth() * (1+ mPercent) / 2,
                0.9f * getHeight() + 0.1f * mPercent * getHeight());
        canvas.drawOval(mShadowRectF, mShadowPaint);
    }
}

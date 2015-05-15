package cat.santi.mod.onedot.entities;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;

/**
 *
 */
public abstract class AbstractEntity implements
        Entity {

    protected static final int CIRCLE = 0;
    protected static final int SQUARE = 1;

    protected PointF mPosition;

    private float mSize;
    private Paint mPaint;

    public AbstractEntity(PointF position, int size) {
        if (size < 1)
            size = 1;
        mPosition = position;
        mSize = size;
        initPaint();
    }

    @Override
    public PointF getPosition() {
        return mPosition;
    }

    @Override
    public void process(Rect surface, double delta) {
        if(this instanceof Movable)
            ((Movable) this).move(surface, delta);
    }

    @Override
    public boolean shouldBeRemoved() {
        return false;
    }

    protected Paint getPaint() {
        return mPaint;
    }

    protected void drawInternal(Canvas canvas) {
        drawInternal(canvas, null, CIRCLE);
    }

    protected void drawInternal(Canvas canvas, Bitmap bitmap) {
        drawInternal(canvas, bitmap, CIRCLE);
    }

    protected void drawInternal(Canvas canvas, Bitmap bitmap, int shape) {
        if (bitmap != null) {
            int w = bitmap.getScaledWidth(canvas);
            int h = bitmap.getScaledHeight(canvas);
            canvas.drawBitmap(bitmap, mPosition.x - (w / 2), mPosition.y - (h / 2), mPaint);
        } else {
            switch (shape) {
                case CIRCLE:
                    canvas.drawCircle(mPosition.x, mPosition.y, mSize, mPaint);
                    break;
                case SQUARE:

                    float left = mPosition.x - mSize;
                    float top = mPosition.y - mSize;
                    float right = mPosition.x + mSize;
                    float bottom = mPosition.y + mSize;
                    canvas.drawRect(left, top, right, bottom, mPaint);
            }

        }
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }
}
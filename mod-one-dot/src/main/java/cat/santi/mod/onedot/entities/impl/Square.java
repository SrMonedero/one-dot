package cat.santi.mod.onedot.entities.impl;

import android.graphics.Canvas;
import android.graphics.PointF;

import cat.santi.mod.onedot.ai.AIModule;
import cat.santi.mod.onedot.entities.AbstractEntity;
import cat.santi.mod.onedot.managers.BitmapManager;

/**
 * Created by Quique on 15/05/15.
 */
public class Square extends Dot {

    public Square(PointF position, int size, AIModule aiModule) {
        super(position, size, aiModule);
    }

    @Override
    public void draw(Canvas canvas, BitmapManager bitmapManager) {
        drawInternal(canvas, null, AbstractEntity.SQUARE);
    }
}

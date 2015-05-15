package cat.santi.mod.onedot.entities.impl;

import android.graphics.Canvas;
import android.graphics.PointF;

import java.util.Random;

import cat.santi.mod.onedot.managers.BitmapManager;

/**
 *
 */
public class GreenBlood extends Skull {

    int mRandomInteger;

    public GreenBlood(PointF position) {
        super(position);
        Random rand = new Random();
        mRandomInteger = rand.nextInt(4) + 1;
    }

    @Override
    public void draw(Canvas canvas, BitmapManager bitmapManager) {
        drawInternal(canvas, bitmapManager.get(mRandomInteger));
    }
}

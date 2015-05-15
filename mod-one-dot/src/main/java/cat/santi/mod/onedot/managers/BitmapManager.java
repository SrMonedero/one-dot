package cat.santi.mod.onedot.managers;

import android.graphics.Bitmap;

/**
 *
 */
public interface BitmapManager {

    int BMP_INDEX_SKULL = 0;
    int BMP_INDEX_GREEN_BLOOD_1 = 0;
    int BMP_INDEX_GREEN_BLOOD_2 = 0;
    int BMP_INDEX_GREEN_BLOOD_3 = 0;
    int BMP_INDEX_GREEN_BLOOD_4 = 0;

    Bitmap get(int bitmapIndex);
}

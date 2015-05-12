package cat.santi.mod.onedot.ai.movements.impl;

import cat.santi.mod.onedot.utils.ConfigUtils;
import cat.santi.mod.onedot.utils.RandomUtils;

/**
 *
 */
public class Directioned extends AbstractMovement {

    public Directioned(int direction) {
        super(
                RandomUtils.nextVelocity((direction & ConfigUtils.LEFT) != 0 ? VELOCITY_MIN : 0f, (direction & ConfigUtils.RIGHT) != 0 ? VELOCITY_MAX : 0f),
                RandomUtils.nextVelocity((direction & ConfigUtils.UP) != 0 ? VELOCITY_MIN : 0f, (direction & ConfigUtils.DOWN) != 0 ? VELOCITY_MAX : 0f),
                RandomUtils.nextAcceleration((direction & ConfigUtils.LEFT) != 0 ? ACCELERATION_MIN : 0f, (direction & ConfigUtils.RIGHT) != 0 ? ACCELERATION_MAX : 0f),
                RandomUtils.nextAcceleration((direction & ConfigUtils.UP) != 0 ? ACCELERATION_MIN : 0f, (direction & ConfigUtils.DOWN) != 0 ? ACCELERATION_MAX : 0f),
                RandomUtils.nextDuration(DURATION_MIN, DURATION_MAX));
    }
}

package me.dawars.szakkor15;

/**
 * Created by dawars on 1/20/17.
 */

public class Vec2 {
    public float x, y;

    public Vec2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    // TODO copy constructor, debug obj ID
    public Vec2 copy() {
        return new Vec2(x, y);
    }

    public void add(Vec2 other) {
        // TODO + sign
        x += other.x;
        y += other.y;
    }
}

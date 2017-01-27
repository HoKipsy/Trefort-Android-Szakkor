package me.dawars.szakkor15;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

/**
 * Created by dawars on 1/20/17.
 */

public class Particle {


    private final Random rand = new Random();
    private Paint paint = new Paint(); // no static

    int size;
    Vec2 pos;
    Vec2 vel = new Vec2(0, -150); // velocity
    double acc = 10;// acceleration
    int color;
    // csinaljatok valtozot a sebessegnek es gyorsulasnak

    public Particle(Vec2 pos, int color) {
        this.pos = pos;
        this.size = 5;
        this.color = color;
        paint.setColor(0xff000000 | color); // alpha value
    }

    public void update() {
        vel.y += acc;
        pos.add(vel);
    }

    public void render(Canvas canvas) {
        // draw a point on the canvas at x, y
        canvas.drawCircle(pos.x, pos.y, size, paint);
    }

    public boolean isDead() {
        return pos.y >= 1000; // screen height
    }
}

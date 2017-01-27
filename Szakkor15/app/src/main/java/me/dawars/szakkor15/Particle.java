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
    private static Paint paint = new Paint();

    Vec2 pos;
    int color;
    int size;
    Vec2 vel = new Vec2(0, -150); // velocity
    double acc = -10;// acceleration

    // csinaljatok valtozot a sebessegnek es gyorsulasnak

    public Particle(Vec2 pos) {
        this.pos = pos;
        this.size = rand.nextInt(20) + 10;
        paint.setColor(Color.BLUE);
    }

    public void update() {
        vel.y += acc;

        pos.add(vel);

    }

    public void render(Canvas canvas) {
        // draw a point on the canvas at x, y

        canvas.drawCircle(pos.x, pos.y, size, paint);
    }
}

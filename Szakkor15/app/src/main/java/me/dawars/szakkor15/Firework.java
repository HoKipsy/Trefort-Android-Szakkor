package me.dawars.szakkor15;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by dawars on 1/13/17.
 */

public class Firework {

    private Paint paint = new Paint();

    double x, y;

    double vel = 150; // velocity
    double acc = -10;// acceleration

    // csinaljatok valtozot a sebessegnek es gyorsulasnak

    public Firework(double x, double y) {

        this.x = x;
        this.y = y;
        paint.setColor(Color.BLUE);
    }

    public void update() {
        vel += acc;

        y -= vel;

    }

    public void render(Canvas canvas) {
        // draw a point on the canvas at x, y

        canvas.drawCircle((float) x, (float) y, 10, paint);
    }
}

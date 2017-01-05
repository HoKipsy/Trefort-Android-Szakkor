package me.dawars.szakkor13;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dawars on 1/5/17.
 */

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private static final float RADIUS = 100;
    private final SurfaceHolder surfaceHolder;
    private final Paint paint = new Paint();

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(5);

        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        tick();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    List<PointF> objects = new LinkedList<>();

    private void tick() {

//        update(); // objectek frissitese

        // lockoljuk es lekerjuk a canvas-t, hogy mas ne ferjen hozza, amig hasznaljuk
        Canvas canvas = surfaceHolder.lockCanvas();

        if (canvas != null) {
            canvas.drawColor(Color.argb(255, 255, 0, 255));
            render(canvas); // rajzolunk
            // befejezzuk a rajzolast es odaadjuk a rendszernek megjelenitesre:
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }
/*  Needs game loop
    private void update() {
        for (PointF point : objects) { // ne hasznaljunk foreach-et ha torlunk a tombbol!
            point.set(point.x, point.y += 10);
        }
    }*/

    private void render(Canvas canvas) {
        for (PointF point : objects) {
            canvas.drawCircle(point.x, point.y, RADIUS, paint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // other gestures, multitouch?

        objects.add(new PointF(event.getX(), event.getY()));
        tick();
        return super.onTouchEvent(event);
    }

}

package me.dawars.szakkor14;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dawars on 1/6/17.
 */

public class GameThread extends Thread {
    private static final float RADIUS = 100;
    private final Paint paint = new Paint();

    private final SurfaceHolder holder;

    public GameThread(SurfaceHolder holder) {
        this.holder = holder;

        paint.setColor(Color.WHITE);
    }

    @Override
    public void run() {


        while (true) {
            Log.i("TAG", "game thread");

            update();

            Canvas canvas = holder.lockCanvas();

            if (canvas != null) {
                canvas.drawColor(Color.BLUE);
                render(canvas); // rajzolunk
                // befejezzuk a rajzolast es odaadjuk a rendszernek megjelenitesre:
                holder.unlockCanvasAndPost(canvas);
            }

            try {
                Thread.sleep(1000 / 30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // ide rakjuk az erinteseket
    List<Circle> objects = new LinkedList<>();

    /**
     * Updating game state
     */
    private void update() {
        // ne hasznaljunk foreach-et ha torlunk a tombbol!
        for (int i = 0; i < objects.size(); i++) {
            Circle point = objects.get(i);
            point.setY(point.y + 100);
        }
    }

    /**
     * Drawing game objects to screen
     */

    private void render(Canvas canvas) {
        for (int i = 0; i < objects.size(); i++) {

            canvas.drawCircle(objects.get(i).x, objects.get(i).y, RADIUS, paint);
        }
    }

    public void onTouchEvent(MotionEvent event) {

        Log.i("Tag", event.toString());

        objects.add(new Circle(event.getX(), event.getY()));
    }
}

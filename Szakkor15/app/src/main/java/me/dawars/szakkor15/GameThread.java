package me.dawars.szakkor15;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by dawars on 1/6/17.
 */

public class GameThread extends Thread {
    private static final float RADIUS = 100;
    private final Paint paint = new Paint();

    private final SurfaceHolder holder;

    private final Random rand = new Random();

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
                canvas.drawColor(Color.WHITE);
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
    List<Firework> objects = new LinkedList<>();

    /**
     * Updating game state
     */
    private void update() {
        if(rand.nextInt(10) == 0){ // random idokozonkent letrehoz egy tuzijatekot
            objects.add(new Firework(rand.nextInt(1080), rand.nextInt(1920))); // az x, y
        }

        for (int i = 0; i < objects.size(); i++) {
            Firework firework = objects.get(i);
            firework.update();
        }

        for (int i = objects.size() - 1; i >= 0; i--) {
            Firework firework = objects.get(i);
            if(firework.y > 10000){
                objects.remove(i);
            }
        }

        Log.i("log", "fireworks " + objects.size());
    }

    /**
     * Drawing game objects to screen
     */

    private void render(Canvas canvas) {
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).render(canvas);
        }
    }

    public void onTouchEvent(MotionEvent event) {

        Log.i("Tag", event.toString());

        objects.add(new Firework(event.getX(), event.getY()));
    }
}

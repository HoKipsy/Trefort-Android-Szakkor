package me.dawars.szakkor11;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by dawars on 12/18/16.
 */

public class MyView extends SurfaceView implements SurfaceHolder.Callback {

    Paint paint = new Paint();
    private SurfaceHolder surfaceHolder;


    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);

        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
    }


    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        // lockoljuk es lekerjuk a canvas-t, hogy mas ne ferjen hozza, amig hasznaljuk
        Canvas canvas = surfaceHolder.lockCanvas();

        if (canvas != null) {

            render(canvas); // rajzolunk
            // befejezzuk a rajzolast es odaadjuk a rendszernek megjelenitesre:
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }

    /**
     * A fuggveny, amiben tenylegesen rajzolunk a canvasra
     *
     * @param canvas
     */
    private void render(Canvas canvas) {
        canvas.drawRect(20, 10, 300, 200, paint);
        canvas.drawCircle(getWidth() / 2, 150, 100, paint);
        canvas.drawLine(350, 30, 400, 200, paint);

        // drawing a circle
        drawCircle(canvas, 300, getHeight() / 3, 250, paint);
        drawSpiral(canvas, 300, 2 * getHeight() / 3, 3 * 360, 5, paint);
    }

    /**
     * Kört rajzolunk a megadott parameterekkel
     *
     * @param canvas erre rajzolunk
     * @param cx     a kor kozepenek az X koordinataja
     * @param cy     a kor kozepenek az Y koordinataja
     * @param radius a kor sugara
     * @param paint  ezzel rajzoljuk
     */
    private void drawCircle(Canvas canvas, float cx, float cy, float radius, Paint paint) {
        float prevX = cx + radius;
        float prevY = cy;


        int resolution = 10; // hany fokonkent lepkedunk, kisebb szebb kort eredmenyez

        for (int degree = resolution; degree <= 360; degree += resolution) {
            // kiszamoljuk a korvonal adott pontjat a degree szognel
            float x = cx + radius * (float) Math.cos(Math.toRadians(degree));
            float y = cy + radius * (float) Math.sin(Math.toRadians(degree));

            canvas.drawLine(prevX, prevY, x, y, paint);

            // frissitjuk az elozo pont adatait
            prevX = x;
            prevY = y;
        }
    }

    /**
     * Spiralt rajzolunk a megadott parameterekkel
     *
     * @param canvas erre rajzolunk
     * @param cx     a spiral kozepenek az X koordinataja
     * @param cy     a spiral kozepenek az Y koordinataja
     * @param degree hany fokot rajzoljunk, 360 = 1 teljes fordulat
     * @param dRad   ennyivel noveljuk a sugarat
     * @param paint  ezzel rajzoljuk
     */
    private void drawSpiral(Canvas canvas, float cx, float cy, float degree, float dRad, Paint paint) {
        float prevX = cx;
        float prevY = cy;

        float radius = 0;

        int resolution = 15; // hany fokonkent lepkedunk, kisebb szebb kort eredmenyez

        for (int deg = resolution; deg <= degree; deg += resolution) {
            // kiszamoljuk a korvonal adott pontjat a deg szognel
            float x = cx + radius * (float) Math.cos(Math.toRadians(deg));
            float y = cy + radius * (float) Math.sin(Math.toRadians(deg));

            canvas.drawLine(prevX, prevY, x, y, paint);

            radius += dRad;

            // frissitjuk az elozo pont adatait
            prevX = x;
            prevY = y;
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}

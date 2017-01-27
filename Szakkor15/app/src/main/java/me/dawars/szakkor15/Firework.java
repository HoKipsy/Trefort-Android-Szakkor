package me.dawars.szakkor15;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by dawars on 1/13/17.
 */

public class Firework {

    private final Random rand = new Random();
    private final int color;

    List<Particle> particles = new ArrayList<>();
    Particle base;
    private boolean exploded = false;

    public Firework(Vec2 pos) {
        color = rand.nextInt(0xffffff);
        base = new Particle(pos, color);
    }

    public void update() {
        if (!exploded && base.vel.y >= 0) {
            explode();
            exploded = true;
        }

        base.update();

        for (int i = 0; i < particles.size(); i++) {
            particles.get(i).update();
        }
    }

    private void explode() {
        for (int i = 0; i < 20; i++) {
            Particle e = new Particle(base.pos.copy(), color);// copy

            double phase = Math.toRadians(rand.nextInt(360));// radians
            int radius = rand.nextInt(5) + 15;
            e.vel = new Vec2((float) Math.cos(phase) * radius, (float) Math.sin(phase) * radius);

            particles.add(e);
        }
    }


    public void render(Canvas canvas) {
        base.render(canvas);
        for (int i = 0; i < particles.size(); i++) {
            particles.get(i).render(canvas);
        }
    }

    public boolean isDead() {
        if (!exploded) return false;
        // FIXME
        for (int i = 0; i < particles.size(); i++) {
            if (!particles.get(i).isDead()) {
                return false;
            }
        }
        return true;
    }
}

package me.dawars.szakkor15;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by dawars on 1/13/17.
 */

public class Firework {

    private final Random rand = new Random();
    private static Paint paint = new Paint();

    List<Particle> particles = new ArrayList<>();
    Particle base;
    private boolean exploded = false;

    public Firework(Vec2 pos) {
        base = new Particle(pos);
    }

    public void update() {
        base.update();

        if (!exploded) {
            if (base.pos.y > 0) {
                explode();
            }
        } else {
            for (int i = 0; i < particles.size(); i++) {
                particles.get(i).update();
            }
        }
    }

    private void explode() {
        exploded = true;
        for (int i = 0; i < 10; i++) {

            Particle particle = new Particle(base.pos);
            particle.vel = new Vec2(rand.nextInt(300) - 150, rand.nextInt(300) - 150);

            particles.add(particle);
        }
    }

    public void render(Canvas canvas) {
        if (!exploded) {
            base.render(canvas);
        } else {
            for (int i = 0; i < particles.size(); i++) {
                particles.get(i).render(canvas);
            }
        }
    }

    public boolean isDead() {
        // FIXME
        return false;
    }
}

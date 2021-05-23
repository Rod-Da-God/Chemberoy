package com.sung.project;

import com.badlogic.gdx.Gdx;

public class Character extends  Main {
    int health;
int damage;
//мэин класс сделать чисто под методы и отрисовк, прогрузку ресурсов, а в этом классе уже все риссовать и менять экраны
    @Override
    public void render() {
        super.render();
        Sbatch.draw(Tgrass,34,315,235,235);
    }

    @Override
    void Overlaps() {
        super.Overlaps();
    }

    @Override
    void agroZombie() {
        super.agroZombie();

    }

    @Override
    void invisible2() {
        super.invisible2();
    }

    @Override
    void invisible() {
        super.invisible();
    }

    @Override
    void anamyWalk() {
        super.anamyWalk();
    }

    @Override
    void anamy2Walk() {
        super.anamy2Walk();
    }

    @Override
    void attack() {
        super.attack();
    }

    @Override
    void cleanMap() {
        super.cleanMap();
    }

    @Override
    void newLocation() {
        super.newLocation();
    }
}

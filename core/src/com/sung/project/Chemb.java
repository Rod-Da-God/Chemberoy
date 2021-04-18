package com.sung.project;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Chemb extends Game implements Screen {
    OrthographicCamera Ocamera;
    SpriteBatch Sbatch;
    Sprite Grass;
    Texture Tgrass;
    Sound bitSound;
    Sound MhitSound;
    Music backMusic;
    Vector3 vector3;
    Rectangle grass;


    @Override
    public void show() {

    }
    @Override
    public void create() {
        Ocamera = new OrthographicCamera();
        Ocamera = new OrthographicCamera();
        Ocamera.setToOrtho(false, 800, 480);
        Sbatch = new SpriteBatch();
        vector3 = new Vector3();



        Grass = new Sprite();
        Tgrass = new Texture("Grass.png");


        grass = new Rectangle();
        grass.x = 123;
        grass.y = 220;
        grass.height =64;
        grass.width = 200;


    }



    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Ocamera.update();
        Sbatch.setProjectionMatrix(Ocamera.combined);
        Sbatch.begin();
        Sbatch.draw(Tgrass,grass.x,grass.y,grass.width,grass.height);
        Sbatch.end();
    }

    @Override
    public void resize(int width, int height) {

    }


    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
    }


package com.sung.project;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

public class AllResources extends Main implements Screen {


    @Override
    public void create() {
        super.create();
        Ocamera = new OrthographicCamera();
        Ocamera = new OrthographicCamera();
        Ocamera.setToOrtho(false, 800, 480);
        Sbatch = new SpriteBatch();
        vector3 = new Vector3();
        scFont = new BitmapFont();
        sFont = new BitmapFont();
        color = new Color(Color.GREEN);
        _rectAn = new Array<Rectangle>();



        Grass = new Sprite ();
        Tgrass = new Texture("Grass.png");
        Player = new Texture("Player.png");
        LeftButton = new Texture("left.png");
        RightButton = new Texture("right.png");
        UpButton = new Texture("up.png");
        forest = new Texture("Back_forest.jpg");

        _Anamy = new Texture("enamy.png");
        _Attack = new Texture("attack.png");
        Ban = new Texture("ban1.jpg");
        Bull = new Texture("bull.png");
        hills = new Texture("Hills.png");
        Aid = new Texture("aid.png");
        Gears = new Texture("gear.png");
        Gears2 = new Texture("gear.png");
        flower = new Texture("flower.png");
        Bo$$ = new Texture("Boss.png");
        Speed = new Texture("speed.png");



        scFont.getData().setScale(1.2f);
        scFont.setColor(color);
        sFont.getData().setScale(1.2f);
        sFont.setColor(color);


        sprite = new Sprite(flower,10,40,120,150);
        sprite.setPosition(243, 40);
        sprite.setRotation(0);


        backMusic = Gdx.audio.newMusic(Gdx.files.internal("bombastic.mp3"));
        backMusic.setLooping(true);
        backMusic.setVolume(0.3f);
        backMusic.play();
        MhitSound = Gdx.audio.newSound(Gdx.files.internal("hit.wav"));


        flowers = Gdx.audio.newSound(Gdx.files.internal("flowers.mp3"));
        flowers.loop(0.001f);

        cyber = Gdx.audio.newMusic(Gdx.files.internal("Cyber.mp3"));
        cyber.setLooping(true);
        cyber.setVolume(0.3f);

        //MhitSound.loop(0.01f);


        grass = new Rectangle();
        grass.x = -23;
        grass.y = -26;
        grass.height = 70;
        grass.width = 250;


        gears = new Rectangle();
        gears.set(93,438,40,38);

        gears2 = new Rectangle();
        gears2.x = 1651;


        grass3 = new Rectangle();
        grass3.set(180, -26, 250, 90);


        speed = new Rectangle();
        speed.set(780,480,64,64);


        fl = new Rectangle();
        fl.set(350,50,5,5);

        player = new Rectangle();
        player.set(250,30,70,70);

        right = new Rectangle();
        right.set(60,64,90,80);


        left = new Rectangle();
        left.set(-10,64,90,80);


        up = new Rectangle();
        up.set(650,64,90,80);


        ship = new Rectangle();
        ship.set(-20,10,200,100);


        _anamy = new Rectangle();
        _anamy.set(650,80,95,60);
        playerHealth = String.valueOf(healthNow);
        gearStatus = String.valueOf(gear);
        anamyHealth = String.valueOf(anamyHealthNow);


        _attack = new Rectangle();
        _attack.set(720,70,90,80);


        ban = new Rectangle();
        ban.width = 500;
        ban.height = 800;

        bullet = new Rectangle();
        bullet.height = 25f;
        bullet.width = 25;

        XY = new Rectangle();
        XY.x = player.x;


        Tgrass2 = new Rectangle();
        Tgrass2.set(330,-50,500,180);

        _anamy2 = new Rectangle();
        _anamy2.set(610,80,95,80);


        Forest = new Rectangle();
        Forest.set(0, 0, 800, 500);


        Hills = new Rectangle();
        Hills.set(0, 0, 0, 0);

        aid = new Rectangle();
        aid.set(235, 320, 40, 40);


        boss = new Rectangle();
        boss.set(-561,-250,125,125);



    }

    @Override
    public void render() {
        super.render();
        Gdx.gl.glClearColor(1, 0, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Ocamera.update();
        Sbatch.setProjectionMatrix(Ocamera.combined);
        Sbatch.begin();
        Sbatch.draw(forest, Forest.x, Forest.y, Forest.width, Forest.height);
        Sbatch.draw(hills, Hills.x, Hills.y, Hills.width, Hills.height);
        Sbatch.draw(Tgrass, grass.x, grass.y, grass.width, grass.height);
        Sbatch.draw(Tgrass, grass3.x, grass3.y, grass3.width, grass3.height);
        Sbatch.draw(Tgrass, Tgrass2.x, Tgrass2.y, Tgrass2.width, Tgrass2.height);
        Sbatch.draw(Tgrass, 200, 300, 110, 30);
        //Sbatch.draw(Ship,ship.x,ship.y,ship.width,ship.height);


        Sbatch.draw(Player, player.x, player.y, player.width, player.height);
        Sbatch.draw(_Anamy, _anamy.x, _anamy.y, _anamy.width, _anamy.height);
        Sbatch.draw(_Anamy, _anamy2.x, _anamy2.y, _anamy2.width, _anamy2.height);
        Sbatch.draw(Bo$$, boss.x, boss.y, boss.width, boss.height);


        Sbatch.draw(RightButton, right.x, right.y, right.width, right.height);
        Sbatch.draw(LeftButton, left.x, left.y, left.width, left.height);
        attack();
        Sbatch.draw(UpButton, up.x, up.y, up.width, up.height);
        Sbatch.draw(_Attack, _attack.x, _attack.y, _attack.width, _attack.height);


        scFont.draw(Sbatch, playerHealth, 50, 460);
        sFont.draw(Sbatch, gearStatus, 135, 460);
        //scFont.draw(Sbatch, anamyHealth, 130, 460);


        Sbatch.draw(Player, 15, 440, 40, 40);
        // Sbatch.draw(_Anamy, 90, 440, 40, 40);
        Sbatch.draw(Gears, gears.x, gears.y, gears.width, gears.height);
        Sbatch.draw(Speed, speed.x, speed.y, speed.width, speed.height);
        Sbatch.draw(Gears2, gears2.x, gears2.y, gears.width, gears.height);


        Sbatch.draw(Aid, aid.x, aid.y, aid.width, aid.height);
        sprite.draw(Sbatch);

        {
            cleanMap();
            sdad();
            Grass();
            Overlaps();
            agroZombie();
            walkRightLeft();
            upTouch();
            anamyWalk();
            anamy2Walk();
            invisible();
            invisible2();
            speedBuster();
        }


        Sbatch.end();

        {
            if (Gdx.input.isTouched()) {
                vector3.set(Gdx.input.getX(), Gdx.input.getY(), 0);
                Ocamera.unproject(vector3);

            }


            if (this.player.x < 0) {
                player.x = 0;

            }

            if (anamyHealthNow > 0 && anamyHealthNow2 > 0) {
                if (player.x > 770) {
                    player.x = 770;
                }
            }


		/* if (player.x > 800 - 64){
			player.x = 0;
			player.y = grass.y - (grass.y * 2);
		}*/
            if (player.y > 427) {
                player.y = 427;
            }


            if (bullet.x >= player.x + 50) {
                bullet.x = player.x;
                bullet.y = player.y;

            }
        }




    }

    @Override
    public void dispose() {
        super.dispose();
    }
}

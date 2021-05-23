package com.sung.project;

//вообще весь класс перенести в другой , этот должен быть пустым или под уровни

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
import com.sung.project.Player;

public class Main extends ApplicationAdapter implements Screen {
    OrthographicCamera Ocamera;
    SpriteBatch Sbatch;
    BitmapFont scFont;
    BitmapFont sFont;
    Color color;
    boolean checker = false;
    boolean checkerBull;


    Texture img;
    Texture Bo$$;
    Texture Tgrass;
    Texture Player;
    Sprite Grass;
    Texture LeftButton;
    Texture RightButton;
    Texture UpButton;
    Texture forest;
    Texture Ship;
    Texture _Anamy;
    Texture _Attack;
    Texture Ban;
    Texture Bull;
    Texture hills;
    Texture Aid;
    Sprite sprite;
    Texture flower;
    Texture Speed;
    Texture Gears;
    Texture Gears2;

    Sound bitSound;
    Sound MhitSound;
    Music backMusic;
    Music cyber;
    Sound flowers;


    Vector3 vector3;//хрен знает зачем нужен...
    Rectangle grass;
    Rectangle player;
    Rectangle left;
    Rectangle right;
    Rectangle up;
    Rectangle ship;
    Rectangle _anamy;
    Rectangle _attack;
    Rectangle bullet;
    Rectangle ban;
    Array<Rectangle> _rectAn;
    Thread thread1;
    Thread thread = new Thread();
    Thread thread2 = new Thread();
    Rectangle XY;
    Rectangle Tgrass2;
    Rectangle _anamy2;
    Rectangle Forest;
    Rectangle Hills;
    Rectangle aid;
    Rectangle fl;
    Rectangle boss;
    Rectangle speed;
    Rectangle grass3;
    Rectangle gears;
    Rectangle gears2;


    public String playerHealth;
    public String gearStatus;
    public int healthShip = 30;
    public int healthNow = 1000;
    public String anamyHealth;
    public int anamyHealthNow = 20;
    public int anamyHealthNow2 = 20;
    public int gear = 0;

    @Override
    public void create() {


    }

    @Override
    public void render() {


    }

    void Grass() {
        if (!checker) {
            if (player.y < 33) {
                player.y = 33;

            } else player.y -= 50 * Gdx.graphics.getDeltaTime();
            //кусок земли по середнине работает не правильно, переделать

            if (player.y < 30 + (-grass.y * 2) && player.x >= 180 && player.x <= 290) {
                player.y = 50;
            } else player.y -= 50 * Gdx.graphics.getDeltaTime();

            if (player.y < 30 + (-grass.y * 2) && player.x >= 330) {
                player.y = 30 + (-grass.y * 2);
            }


//kustik player
            if (player.y < 30 + (-grass.y * 2) && player.x >= 290 && player.x <= 310) {

                player.y = (-grass.y * 2);
            }

            if (player.y < 30 + (-grass.y * 2) && player.x >= 310 && player.x <= 320) {

                player.y = (-grass.y * 2) + 10;
            }

            if (player.y < 30 + (-grass.y * 2) && player.x >= 320 && player.x <= 330) {

                player.y = (-grass.y * 2) + 30;
            }


//kustik zombie
            if (_anamy.y < 30 + (-grass.y * 2) && _anamy.x >= 290 && _anamy.x <= 310) {

                _anamy.y = (-grass.y * 2)
                        + 5;
            }

            if (_anamy2.y < 30 + (-grass.y * 2) && _anamy2.x >= 290 && _anamy2.x <= 310) {

                _anamy2.y = (-grass.y * 2) + 5;
            }


            if (_anamy.y < 30 + (-grass.y * 2) && _anamy.x >= 310 && _anamy.x <= 320) {

                _anamy.y = (-grass.y * 2) + 15;
            }
            if (_anamy2.y < 30 + (-grass.y * 2) && _anamy2.x >= 310 && _anamy2.x <= 320) {

                _anamy2.y = (-grass.y * 2) + 15;
            }


            if (_anamy.y < 30 + (-grass.y * 2) && _anamy.x >= 320 && _anamy.x <= 330) {

                _anamy.y = (-grass.y * 2) + 35;
            }
            if (_anamy2.y < 30 + (-grass.y * 2) && _anamy2.x >= 320 && _anamy2.x <= 330) {

                _anamy2.y = (-grass.y * 2) + 35;
            }


            //верхний блок , нижняя сторона
            if (player.x >= 180 && player.x <= 290 && (player.y >= 250 && player.y <= 260)) {
                player.y = 250;
            }
            //верхний блок , верхняя сторона
            if (player.x >= 180 && player.x <= 290 && (player.y >= 320 && player.y <= 330)) {
                player.y = 325;
                //player.y += 150 * Gdx.graphics.getDeltaTime();
            }

        }
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////


        void sdad () {


        // Second location
        if (checker == true) {
            if (player.y < 25) {
                player.y = 25;
            }
            if (player.y > 25) {
                player.y -= 80 * Gdx.graphics.getDeltaTime();
            }


            if (boss.y < 10) {
                boss.y = 10;
            }
            if (boss.y > 10) {
                boss.y -= 205 * Gdx.graphics.getDeltaTime();
            }


            if (player.x > 770) {
                player.x = 770;
            }
            {
                Tgrass2();
                Baffs2();
                boss();
                enemy();
            }
        }
    }


        void Tgrass2 () {
        //Tgrass2.set(-40, 350, 250, 30);

            //блок в воздухе слева , нижняя сторона
            if (player.x >= 0 && player.x <= 193 && player.y >= 305 && player.y <= 315){
                player.y = 305;
            }
            //блок в воздухе слева , верхняя сторона
            if (player.x >= 0 && player.x <= 193 && player.y >= 370 && player.y <= 380){
                player.y = 375;
            }


            //блок в воздухе справа , нижняя сторона
            if (player.x >= 600 && player.x <= 780 && player.y >= 305 && player.y <= 315){
                player.y = 305;
            }
            //блок в воздухе справа , верхняя сторона
            if (player.x >= 600 && player.x <= 780 && player.y >= 370 && player.y <= 380){
                player.y = 375;
            }




        }

        void Baffs2 () {

        if (player.overlaps(gears2)) {

            gears2.setPosition(-156, -161);
            gear = gear + 1;
            gearStatus = String.valueOf(gear);
        }
    }

    void enemy(){

    }


    void boss() {


        if (this.boss.x <= 0) {
            boss.x = 0;

        }

        if (boss.x > 800 - 64) {
            boss.x = 800 - 64;

        }


        if (player.y <= boss.y + 90) {
            if (player.x >= boss.x ) {

                boss.x += 170 * Gdx.graphics.getDeltaTime();
            }

            if (player.x <= boss.x) {
                if (boss.x >= player.x) {
                    boss.x -= 140 * Gdx.graphics.getDeltaTime();
                }
            }
        }
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////


    void Overlaps() {
        if (_anamy.overlaps(player)) {
            healthNow -= (0.1 - 0.01);
            playerHealth = String.valueOf(healthNow);
            player.x -= 2;
            //MhitSound.play(0.02f);

        }


        if (player.overlaps(gears2)) {
            gears2.setPosition(1080, 1080);
            gear = gear + 1;
            gearStatus = String.valueOf(gear);
        }


        if (player.overlaps(fl)) {

            for (int j = 0; j < 4; j++) {

                if (j >= 3) {

                    flowers.play(0.3f, 2.2f, 0);

                }

            }

            //flowers.play(0.3f, 2f, 0);
        }//else flowers.stop();


        if (_anamy2.overlaps(player)) {
            healthNow -= (0.1 - 0.01);
            playerHealth = String.valueOf(healthNow);
            player.x -= 2;
            //MhitSound.play(0.02f);

        }


        if (bullet.overlaps(_anamy)) {
            _anamy.setPosition(_anamy.x + 10, _anamy.y);
            anamyHealthNow -= 1;
            anamyHealth = String.valueOf(anamyHealthNow);
            bullet.x = player.x - 100;
            bullet.y = player.y + 10;
            if (anamyHealthNow <= 0) {
                _anamy.x = 0;
                _anamy.y = 148000;
            }
        }


        if (bullet.overlaps(_anamy2)) {
            _anamy2.setPosition(_anamy2.x + 10, _anamy2.y);
            anamyHealthNow2 -= 1;
            anamyHealth = String.valueOf(anamyHealthNow);
            bullet.x = player.x + 10;
            bullet.y = player.y + 10;
            if (anamyHealthNow2 <= 0) {
                _anamy2.x = 0;
                _anamy2.y = 148000;
            }
            if (anamyHealthNow2 == 1) {

                gears2.set(_anamy2.x, _anamy2.y, gears.width, gears.height);
            }
        }


        if (healthNow < 950) {
            if (player.overlaps(aid)) {
                aid.setPosition(1080, 1080);
                healthNow = healthNow + 50;
                playerHealth = String.valueOf(healthNow);
            }
        }
    }


    void agroZombie() {
        if (!checker) {

            if (player.y <= _anamy.y + 90) {
                if (player.x >= _anamy.x - 150) {

                    _anamy.x -= 140 * Gdx.graphics.getDeltaTime();
                }

                if (player.x >= _anamy.x) {
                    if (_anamy.x <= player.x) {
                        _anamy.x += 120 * Gdx.graphics.getDeltaTime();
                    }
                }
            }


//vtoroy zombik
            if (player.y <= _anamy2.y + 90) {
                if (player.x >= _anamy2.x - 150) {

                    _anamy2.x -= 120 * Gdx.graphics.getDeltaTime();
                }

                // if (player.x <= _anamy2.x + 150) {
                //while (_anamy2.x <= player.x) {
                //   _anamy2.x += 0.001;
                if (player.x >= _anamy2.x) {
                    if (_anamy2.x <= player.x) {
                        _anamy2.x += 120 * Gdx.graphics.getDeltaTime();
                        //}
                        // }
                    }
                }

            }
        }
    }


   // void rotate(Texture texture, float x, float y, float originX, float originY, float width, float height, float scaleX, float scaleY, float rotation, int srcX, int srcY, int srcWidth, int srcHeight, boolean flipX, boolean flipY) {
    //    Sbatch.draw(texture, x, y, originX, originY, width, height, scaleX, scaleY, rotation, srcX, srcY, srcWidth, srcHeight, flipX, flipY);

   // }


    void invisible2() {
        if (!checker) {
            if (this._anamy2.x <= 0) {
                _anamy2.x = 0;

            }

            if (_anamy2.x >= 800 - 64) {
                _anamy2.x = 800 - 64;

            }
        }
    }


    void invisible() {
        if (!checker) {
            if (this._anamy.x <= 0) {
                _anamy.x = 0;

            }

            if (_anamy.x >= 800 - 64) {
                _anamy.x = 800 - 64;

            }
        }
    }


    void walkRightLeft() {
        if (Gdx.input.isTouched(0)) {
            vector3.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            Ocamera.unproject(vector3);
            float touchX = vector3.x;
            float touchY = vector3.y;
            if ((touchX >= left.getX()) && touchX <= (left.getX() + left.getWidth()) && (touchY >= left.getY()) && touchY <= (left.getY() + left.getHeight())) {
                player.x -= 200 * Gdx.graphics.getDeltaTime();
            } else if ((touchX >= right.getX()) && touchX <= (right.getX() + right.getWidth()) && (touchY >= right.getY()) && touchY <= (right.getY() + right.getHeight())) {
                player.x += 200 * Gdx.graphics.getDeltaTime();
            }
            //else if ((touchX>=up.getX()) && touchX<= (up.getX()+up.getWidth()) && (touchY>=up.getY()) && touchY<=(up.getY()+up.getHeight()));
            //player.y += 200* Gdx.graphics.getDeltaTime();
        }

    }

    void anamyWalk() {
        if (!checker) {
            if (_anamy.y < 23) {
                _anamy.y = 23;

            } else _anamy.y -= 50 * Gdx.graphics.getDeltaTime();

            if (_anamy.y < 30 + (-grass.y * 2) && _anamy.x >= 160 && _anamy.x <= 290) {
                _anamy.y = 40;
            } else _anamy.y -= 50 * Gdx.graphics.getDeltaTime();

            if (_anamy.y < 30 + (-grass.y * 2) && _anamy.x >= 330) {
                _anamy.y = 30 + (-grass.y * 2);
            }
            if (_anamy.x >= 650 || _anamy.x <= 650) {
                if (_anamy.x >= 650) {
                    _anamy.x -= 10 * Gdx.graphics.getDeltaTime();
                }
                if (_anamy.x <= 650) {
                    _anamy.x += 30 * Gdx.graphics.getDeltaTime();
                }

            } else {
                _anamy.x = 650;


            }
        }
    }


    void anamy2Walk() {
        if (!checker) {
            if (_anamy2.y < 20) {
                _anamy2.y = 20;

            } else _anamy2.y -= 50 * Gdx.graphics.getDeltaTime();

            if (_anamy2.y < 30 + (-grass.y * 2) && _anamy2.x >= 160 && _anamy2.x <= 290) {
                _anamy2.y = 30;
            } else _anamy2.y -= 50 * Gdx.graphics.getDeltaTime();

            if (_anamy2.y < 30 + (-grass.y * 2) && _anamy2.x >= 330) {
                _anamy2.y = 30 + (-grass.y * 2);
            }
            if (_anamy2.x >= 610 || _anamy2.x <= 610) {
                if (_anamy2.x >= 610) {
                    _anamy2.x -= 10 * Gdx.graphics.getDeltaTime();
                }
                if (_anamy2.x <= 610) {
                    _anamy2.x += 30 * Gdx.graphics.getDeltaTime();
                }

            } else {
                _anamy2.x = 610;

            }
        }
    }


    //найти решение по поводу одновременного нажатия кнопки, если получится запилить мини джостик
    void upTouch() {
        if (Gdx.input.isTouched()) {
            vector3.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            Ocamera.unproject(vector3);
            float touchX = vector3.x;
            float touchY = vector3.y;
            if ((touchX >= up.getX()) && touchX <= (up.getX() + up.getWidth()) && (touchY >= up.getY()) && touchY <= (up.getY() + up.getHeight())) {
                player.y += 400 * Gdx.graphics.getDeltaTime();
            }
        }

    }


    void attack() {
        //может некоректно работать из за этого
        if (Gdx.input.isTouched()) {

            vector3.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            Ocamera.unproject(vector3);
            float touchX = vector3.x;
            float touchY = vector3.y;
            if ((touchX >= _attack.getX()) && touchX <= (_attack.getX() + _attack.getWidth()) && (touchY >= _attack.getY()) && touchY <= (_attack.getY() + _attack.getHeight())) {


                Sbatch.draw(Bull, player.x + 50, bullet.y);
                if (bullet.overlaps(_anamy)) {
                    XY.x = -546;
                } else {
                    bullet.x = player.x + 50;
                    ;
                    bullet.y = player.y;
                }

                //бавить кновку в правом левом углу с заменной оружия, где в батче будет пл.х += 200 * Gdx.graphics.getDeltaTime(); либо вот такое вот  += 200 * Gdx.graphics.getDeltaTime();
                //bullet.x += 200 * Gdx.graphics.getDeltaTime();

            }
        }
    }


    void speedBuster() {
        if (Gdx.input.isTouched()) {

            vector3.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            Ocamera.unproject(vector3);
            float touchX = vector3.x;
            float touchY = vector3.y;
            if ((touchX >= speed.getX()) && touchX <= (speed.getX() + speed.getWidth()) && (touchY >= speed.getY()) && touchY <= (speed.getY() + speed.getHeight())) {


                Sbatch.draw(Bull, player.x += 270 * Gdx.graphics.getDeltaTime(), bullet.y);

                // bullet.x = player.x + 50;
                ;
                bullet.y = player.y;


                //бавить кновку в правом левом углу с заменной оружия, где в батче будет пл.х += 200 * Gdx.graphics.getDeltaTime(); либо вот такое вот  += 200 * Gdx.graphics.getDeltaTime();
                bullet.x += 200 * Gdx.graphics.getDeltaTime();

            }
        }
    }

    void cleanMap() {
        if (anamyHealthNow <= 0 && anamyHealthNow2 <= 0) {


            if (player.x >= 799) {
                checker = true;

                grass.x = -125;
                grass.y = -161;
                grass.height = 0;
                grass.width = 0;


                player.x = 0;
                player.y = 0;
                player.height = 0;
                player.width = 0;


                ship.x = 0;
                ship.y = 0;
                ship.width = 0;
                ship.height = 0;


                _anamy.x = -65161;
                _anamy.y = -165156;
                playerHealth = String.valueOf(healthNow);


                grass3.set(-150, -150, 0, 0);


                ban.width = 0;
                ban.height = 0;


                XY.x = player.x;


                Tgrass2.x = -56465;
                Tgrass2.y = -5564165;
                Tgrass2.height = 0;
                Tgrass2.width = 0;


                _anamy2.x = -1566;
                _anamy2.y = -15416;
                _anamy2.width = 0;
                _anamy2.height = 0;

                Forest.x = -800;
                Forest.y = -800;
                Forest.width = 0;
                Forest.height = 0;
               // backMusic.stop();


                if (player.x > 400){
                    player.x = 400;
                }


                sprite.setPosition(-150, -5160);


                newLocation();
                // вот тут заново все рисовать и параметры настроить!!


            }
        }
    }


    void newLocation() {
        Hills.set(0,0,800,500);


        playerHealth = String.valueOf(healthNow);
        //cyber.play();

        player.set(50, 10, 40, 50);


        boss.set(250, 250, 420, 100);


        grass.set(-50, -12, 900, 45);

        gears2.setPosition(40,370);

        aid.set(0,370,30,30);

        Tgrass2.set(-40, 350, 250, 30);

        _anamy.set(729,365,50,50);

        grass3.set(600,350,250,30);




        speed.set(750, 430, 45, 45);




        ;




    }








    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        Sbatch.dispose();
        img.dispose();
        _Anamy.dispose();
        Ship.dispose();
        scFont.dispose();
        forest.dispose();
        Tgrass.dispose();
        UpButton.dispose();
        LeftButton.dispose();
        RightButton.dispose();
        Player.dispose();
        _Attack.dispose();

    }
}

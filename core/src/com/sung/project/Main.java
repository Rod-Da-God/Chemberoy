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

public class Main extends ApplicationAdapter implements Screen {
	OrthographicCamera Ocamera;
	SpriteBatch Sbatch;
	BitmapFont scFont;
	Color color;


	Texture img;
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



	Sound bitSound;
	Sound MhitSound;
	Music backMusic;


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



	public  String playerHealth;
	public int healthShip = 30;
	public int healthNow = 1000;
	
	@Override
	public void create () {

		Ocamera = new OrthographicCamera();
		Ocamera = new OrthographicCamera();
		Ocamera.setToOrtho(false, 800, 480);
		Sbatch = new SpriteBatch();
		vector3 = new Vector3();
		scFont = new BitmapFont();
		color = new Color(Color.GREEN);
		_rectAn = new Array<Rectangle>();
		Thread thread1 = new Thread();



		Grass = new Sprite();
		Tgrass = new Texture("Grass.png");
		Player = new Texture("Player.png");
		LeftButton = new Texture("left.png");
		RightButton = new Texture("right.png");
		UpButton = new Texture("up.png");
		forest = new Texture("Back_forest.jpg");
		Ship = new Texture("shipPng.png");
		_Anamy = new Texture("anamy-.png");
		_Attack = new Texture("attack.png");
		Ban = new Texture("ban1.jpg");
		Bull = new Texture("bull.png");
		scFont.getData().setScale(1.2f);
		scFont.setColor(color);



		backMusic = Gdx.audio.newMusic(Gdx.files.internal("bombastic.mp3"));
		backMusic.setLooping(true);
		backMusic.setVolume(0.3f);
		backMusic.play();
		MhitSound = Gdx.audio.newSound(Gdx.files.internal("hit.wav"));
	//MhitSound.loop(0.01f);


		grass = new Rectangle();
		grass.x = -23;
		grass.y = -26;
		grass.height =70;
		grass.width = 250;

		player = new Rectangle();
		player.x = 250;
		player.y = 30;
		player.height = 70;
		player.width = 70;

		right = new Rectangle();
		right.x = 60;
		right.y = 64;
		right.height = 80;
		right.width = 90;


		left = new Rectangle();
		left.x = -10;
		left.y = 64;
		left.height = 80;
		left.width = 90;


		up = new Rectangle();
		up.x = 650;
		up.y = 64;
		up.height = 80;
		up.width = 90;


		ship = new Rectangle();
		ship.x = -20;
		ship.y = 10;
		ship.width = 200;
		ship.height = 100;


		_anamy = new Rectangle();
		_anamy.x = 650;
		_anamy.y = 80;
		_anamy.width = 95;
		_anamy.height = 80;
		playerHealth = String.valueOf(healthNow);


		_attack = new Rectangle();
		_attack.x = 720 ;
		_attack.y = 70;
		_attack.height = 80;
		_attack.width = 90;


		ban = new Rectangle();
		ban.width = 500;
		ban.height = 800;

		bullet = new Rectangle();
		bullet.height = 0.001f;
		bullet.width = 0.001f;

	}

	@Override
	public void render () {
		//тут тоже попытаться, как то сократить отрисовку. мб в другом потоке
		Gdx.gl.glClearColor(1, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Ocamera.update();
		Sbatch.setProjectionMatrix(Ocamera.combined);
		Sbatch.begin();
		Sbatch.draw(forest, 0, 0, 800, 500);
		Sbatch.draw(Tgrass, grass.x, grass.y, grass.width, grass.height);
		Sbatch.draw(Tgrass, 180, -26, grass.width, 90);
		Sbatch.draw(Tgrass, 330, -50, 500, 180);
		//Sbatch.draw(Ship,ship.x,ship.y,ship.width,ship.height);
		Sbatch.draw(Player, player.x, player.y, player.width, player.height);
		Sbatch.draw(_Anamy, _anamy.x, _anamy.y, _anamy.width, _anamy.height);
		Sbatch.draw(RightButton, right.x, right.y, right.width, right.height);
		Sbatch.draw(LeftButton, left.x, left.y, left.width, left.height);
		attack();
		Sbatch.draw(UpButton, up.x, up.y, up.width, up.height);
		Sbatch.draw(_Attack, _attack.x, _attack.y, _attack.width, _attack.height);
		scFont.draw(Sbatch, playerHealth, 50, 460);
		Sbatch.draw(Player, 15, 440, 40, 40);


		walkRightLeft();
		upTouch();
		anamyWalk();

		Sbatch.end();


		if (Gdx.input.isTouched()) {
			vector3.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			Ocamera.unproject(vector3);

		}
		if (player.y < grass.y - (grass.y * 2)) {
			player.y = grass.y - (grass.y * 2);

		} else player.y -= 50 * Gdx.graphics.getDeltaTime();
		//кусок земли по середнине работает не правильно, переделать

		if (player.y < 30 + (-grass.y * 2) && player.x >= 180 && player.x <= 330) {
			player.y = (-grass.y * 2);
		} else player.y -= 50 * Gdx.graphics.getDeltaTime();

		if (player.y < 30 + (-grass.y * 2) && player.x >= 330) {
			player.y = 30 + (-grass.y * 2);
		}

//переделать это как метод, чтоб останавливать его и поворачивать после того, как он уткнется в стену


//эту хрень тоже переделать , особенно ходьбу назад
		if (player.x  >=  _anamy.x - 150 ){

				_anamy.x -= 120* Gdx.graphics.getDeltaTime();
			}

		if (player.x  <=  _anamy.x +  150 ){
			while (_anamy.x <= player.x ){
				_anamy.x += 0.001;
			}
		}






//вот это все тоже в метод
		 if (this.player.x < 0) {
			player.x = 800 - 64;
			player.y = 30 + (-grass.y * 2);
		}

		 if (player.x > 800 - 64){
			player.x = 0;
			player.y = grass.y - (grass.y * 2);
		}
		 if (player.y > 400){
		 	player.y = 400;
		 }

		if (this._anamy.x <= 0) {
			_anamy.x = 0;

		}

		if (_anamy.x >= 800 - 64){
			_anamy.x = 800 - 64;

		}


		if (bullet.x >= 800 -64){
			bullet.x = player.x;
			bullet.y = player.y;

		}
		//!!!!!!!!!!!!!!!!!!!!!!!!!!!
		//if (player.x != 250){
		//	player.x = player.x + 1;
		//}

/*if (_anamy.overlaps(player)) {
	healthNow -=(0.1 - 0.01);
	playerHealth = String.valueOf(healthNow);

}*/
if (_anamy.overlaps(player) ){
	healthNow -=(0.1 - 0.01);
	playerHealth = String.valueOf(healthNow);
	//MhitSound.play(0.02f);

}


if (bullet.overlaps(_anamy)){
	_anamy.setPosition(_anamy.x + 10,_anamy.y);
}


	}
private 	void walkRightLeft(){
		if(Gdx.input.isTouched(0)) {
			vector3.set(Gdx.input.getX(),Gdx.input.getY(), 0);
			Ocamera.unproject(vector3);
			float touchX = vector3.x;
			float touchY= vector3.y;
			if((touchX>=left.getX()) && touchX<= (left.getX()+left.getWidth()) && (touchY>=left.getY()) && touchY<=(left.getY()+left.getHeight()) ){
				player.x  -= 200 * Gdx.graphics.getDeltaTime();
			}
			else if((touchX>=right.getX()) && touchX<= (right.getX()+right.getWidth()) && (touchY>=right.getY()) && touchY<=(right.getY()+right.getHeight()) ){
				player.x += 200* Gdx.graphics.getDeltaTime();
			}
			//else if ((touchX>=up.getX()) && touchX<= (up.getX()+up.getWidth()) && (touchY>=up.getY()) && touchY<=(up.getY()+up.getHeight()));
			//player.y += 200* Gdx.graphics.getDeltaTime();
		}

	}

private 	void anamyWalk() {
		if (_anamy.y < grass.y - (grass.y * 2)) {
			_anamy.y = grass.y - (grass.y * 2);

		} else _anamy.y -= 50 * Gdx.graphics.getDeltaTime();

		if (_anamy.y < 30 + (-grass.y * 2) && _anamy.x >= 180 && _anamy.x <= 330) {
			_anamy.y = (-grass.y * 2);
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


	//найти решение по поводу одновременного нажатия кнопки, если получится запилить мини джостик
	private void upTouch() {
		if (Gdx.input.isTouched()) {
			vector3.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			Ocamera.unproject(vector3);
			float touchX = vector3.x;
			float touchY = vector3.y;
			if((touchX>=up.getX()) && touchX<= (up.getX()+up.getWidth()) && (touchY>=up.getY()) && touchY<=(up.getY()+up.getHeight()) ){
				player.y  += 400 * Gdx.graphics.getDeltaTime();
			}
		}
	
	}


private final void attack(){

			vector3.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			Ocamera.unproject(vector3);
			float touchX = vector3.x;
			float touchY = vector3.y;
			if ((touchX >= _attack.getX()) && touchX <= (_attack.getX() + _attack.getWidth()) && (touchY >= _attack.getY()) && touchY <= (_attack.getY() + _attack.getHeight())) {
				bullet.x = player.x;
				bullet.y = player.y;
				bullet.x += 200 * Gdx.graphics.getDeltaTime();

				Sbatch.draw(Bull, bullet.x, bullet.y);

			}
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
	public void dispose () {
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

	}
}

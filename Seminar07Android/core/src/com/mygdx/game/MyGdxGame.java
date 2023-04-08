package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Units.*;
import com.mygdx.game.ydd.ConsoleView;
import com.mygdx.game.ydd.Main;

import java.util.*;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture fon, lanceBearer, monk, peasant_d, peasant_w, robber, sniper, wizard, xBowMan;
	Music music;

	public static final int GANG_SIZE = 10;
	public static ArrayList<ClassUnit> darkSide;
	public static ArrayList<ClassUnit> whiteSide;
	public static ArrayList<ClassUnit> allUnits;
	public static int step = 0;
	private static float dx, dy;

	@Override
	public void create () {
		batch = new SpriteBatch();
		fon = new Texture("fons/" + String.valueOf(new Random().nextInt(5)) + ".png");
		music = Gdx.audio.newMusic(Gdx.files.internal("music/warcraft.mp3"));
		music.setVolume(.5f);
		music.setLooping(true);
		music.play();
		init();

		int my = 0;
		lanceBearer = new Texture("units/LanceBearer.png");
		my = lanceBearer.getHeight();
		monk = new Texture("units/Monk.png");
		if (my < monk.getHeight()) my = monk.getHeight();
		peasant_d = new Texture("units/Peasant_d.png");
		if (my < peasant_d.getHeight()) my = peasant_d.getHeight();
		peasant_w = new Texture("units/Peasant_w.png");
		if (my < peasant_w.getHeight()) my = peasant_w.getHeight();
		robber = new Texture("units/Robber.png");
		if (my < robber.getHeight()) my = robber.getHeight();
		sniper = new Texture("units/Sniper.png");
		if (my < sniper.getHeight()) my = sniper.getHeight();
		wizard = new Texture("units/Wizard.png");
		if (my < wizard.getHeight()) my = wizard.getHeight();
		xBowMan = new Texture("units/XBowMan.png");
		if (my < xBowMan.getHeight()) my = xBowMan.getHeight();
//		dy = my;
		dx = dy = Gdx.graphics.getHeight() / 8;
	}

	@Override
	public void render () {
		if (step == 0) {
			Gdx.graphics.setTitle("Первый ход.");
		} else {
			Gdx.graphics.setTitle("Ход " + step);
		}

		batch.begin();
		batch.draw(fon, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		darkSide.forEach(n -> {
			switch (n.getInfo()) {
				case "Peasant":	if (n.getHp() > 0) batch.draw(peasant_d, n.getPosition().getX()*dx, (n.getPosition().getY() - 1)*dy); break;
				case "Robber": if (n.getHp() > 0) batch.draw(robber, n.getPosition().getX()*dx, (n.getPosition().getY() - 1)*dy); break;
				case "Sniper": if (n.getHp() > 0) batch.draw(sniper, n.getPosition().getX()*dx, (n.getPosition().getY() - 1)*dy); break;
				case "Wizard": if (n.getHp() > 0) batch.draw(wizard, n.getPosition().getX()*dx, (n.getPosition().getY() - 1)*dy); break;
			}
		});
		whiteSide.forEach(n -> {
			switch (n.getInfo()) {
				case "Peasant":	if (n.getHp() > 0) batch.draw(peasant_w, n.getPosition().getX()*dx, (n.getPosition().getY() - 1)*dy); break;
				case "LanceBearer":	if (n.getHp() > 0) batch.draw(lanceBearer, n.getPosition().getX()*dx, (n.getPosition().getY() - 1)*dy); break;
				case "XBowMan":	if (n.getHp() > 0) batch.draw(xBowMan, n.getPosition().getX()*dx, (n.getPosition().getY() - 1)*dy); break;
				case "Monk": if (n.getHp() > 0) batch.draw(monk, n.getPosition().getX()*dx, (n.getPosition().getY() - 1)*dy); break;
			}
		});
		batch.end();

		if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
			step++;
			step();
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		fon.dispose();
	}


	private static void init() {
		darkSide = new ArrayList<>();
		whiteSide = new ArrayList<>();
		allUnits = new ArrayList<>();

		for (int i = GANG_SIZE; i >= 0; i--) {
			int num = new Random().nextInt(4);
			switch (num) {
				case 0:
					whiteSide.add(new Peasant(getName(), num, i));
					darkSide.add(new Peasant(getName(), GANG_SIZE - 1 - num, i));
					break;
				case 1:
					whiteSide.add(new Monk(getName(), num, i));
					darkSide.add(new Wizard(getName(), GANG_SIZE - 1 - num, i));
					break;
				case 2:
					whiteSide.add(new XBowMan(getName(), num, i));
					darkSide.add(new Sniper(getName(), GANG_SIZE - 1 - num, i));
					break;
				case 3:
					whiteSide.add(new LanceBearer(getName(), num, i));
					darkSide.add(new Robber(getName(), GANG_SIZE - 1 - num, i));
					break;
			}
		}

		allUnits.addAll(whiteSide);
		allUnits.addAll(darkSide);
		allUnits.sort(new Comparator<ClassUnit>() {
			@Override
			public int compare(ClassUnit u1, ClassUnit u2) {
				if (u2.getSpeed() == u1.getSpeed()) {
					return (int) u2.getHp() - (int) u1.getHp();
				}
				return u2.getSpeed() - u1.getSpeed();
			}
		});
	}

	private static String getName() {
		return EnumNames.values()[new Random().nextInt(EnumNames.values().length)].toString();
	}

	private static void step() {
		for (ClassUnit unit : allUnits) {
			if (whiteSide.contains(unit)) {
				unit.step(darkSide, whiteSide);
			} else {
				unit.step(whiteSide, darkSide);
			}
		}
	}
}

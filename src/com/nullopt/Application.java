package com.nullopt;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

class Application extends JFrame {

	private static final ArrayList<Car> PLAYERS = new ArrayList<>(2);

	Application() {
		this.initUI();

		Car PLAYER_ONE = new Car(0, new ImageIcon("Images/90.0car.png"), 90, new Vec2(380, 450));
		Car PLAYER_TWO = new Car(1, new ImageIcon("Images/90.0rac.png"), 90, new Vec2(380, 500));
		PLAYERS.add(PLAYER_ONE);
		PLAYERS.add(PLAYER_TWO);
	}

	private void initUI() {
		Board game = new Board(PLAYERS);
		game.addKeyListener(game);
		game.setFocusable(true);
		this.playSound("Sounds/CarStart.mp3");
		this.add(game);
		this.setSize(850, 650);
		this.setTitle("MultiCar");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}

	void playSound(String soundFile) {
		new javafx.embed.swing.JFXPanel(); // Creates new JFXPanel to force JFX initialization
		String uriString = new File(soundFile).toURI().toString();
		MediaPlayer player = new MediaPlayer(new Media(uriString));
		player.play();
	}
}

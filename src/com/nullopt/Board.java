package com.nullopt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;

public class Board extends JPanel implements KeyListener, ActionListener {

	private final ArrayList<Car> PLAYERS;
	private final ArrayList<Boolean> PRESSED_KEYS = new ArrayList<>(Collections.nCopies(8, false));

	Board(ArrayList<Car> players) {
		this.PLAYERS = players;
		this.initBoard();
	}

	/**
	 * Initializes the Board component
	 */
	private void initBoard() {
		this.setDoubleBuffered(true);

		Timer TIMER = new Timer(25, this);
		TIMER.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.createMap(g);
		this.createPlayers(g);
	}

	/**
	 * @param g Graphics Object
	 */
	private void createPlayers(Graphics g) {
		this.PLAYERS.forEach((x) -> g.drawImage(x.getImage(), x.getPosition().getX(), x.getPosition().getY(), null));
	}

	/**
	 * @param g Graphics Object
	 */
	private void createMap(Graphics g) {
		Color c1 = Color.green;
		g.setColor(c1);
		g.fillRect(150, 150, 550, 300); // grass
		Color c2 = Color.black;
		g.setColor(c2);
		g.drawRect(50, 50, 750, 500);  // outer edge
		g.drawRect(150, 150, 550, 300); // inner edge
		Color c3 = Color.yellow;
		g.setColor(c3);
		g.drawRect(100, 100, 650, 400); // mid - lane marker
		Color c4 = Color.white;
		g.setColor(c4);
		g.drawLine(425, 450, 425, 550); // start line
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// Do Nothing
	}

	/**
	 * @param e KeyEvent Object
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case 38: // up
				this.PRESSED_KEYS.set(0, true);
				break;
			case 40: // down
				this.PRESSED_KEYS.set(1, true);
				break;
			case 37: // left
				this.PRESSED_KEYS.set(2, true);
				break;
			case 39: // right
				this.PRESSED_KEYS.set(3, true);
				break;
			case 87:
				this.PRESSED_KEYS.set(4, true);
				break;
			case 83:
				this.PRESSED_KEYS.set(5, true);
				break;
			case 65:
				this.PRESSED_KEYS.set(6, true);
				break;
			case 68:
				this.PRESSED_KEYS.set(7, true);
				break;
		}
	}

	/**
	 * @param e KeyEvent Object
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
			case 38: // up
				this.PRESSED_KEYS.set(0, false);
				break;
			case 40: // down
				this.PRESSED_KEYS.set(1, false);
				break;
			case 37: // left
				this.PRESSED_KEYS.set(2, false);
				break;
			case 39: // right
				this.PRESSED_KEYS.set(3, false);
				break;
			case 87: // w
				this.PRESSED_KEYS.set(4, false);
				break;
			case 83: // s
				this.PRESSED_KEYS.set(5, false);
				break;
			case 65: // a
				this.PRESSED_KEYS.set(6, false);
				break;
			case 68: // d
				this.PRESSED_KEYS.set(7, false);
				break;
		}
		for (Car player :
				this.PLAYERS) {
			player.move(this.PRESSED_KEYS);
		}
		this.repaint();
	}

	/**
	 * @param e ActionEvent Object
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		for (Car player :
				this.PLAYERS) {
			player.move(this.PRESSED_KEYS);
		}
		this.repaint();
	}
}

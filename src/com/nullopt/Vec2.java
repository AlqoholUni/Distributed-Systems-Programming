package com.nullopt;

public class Vec2 {

	private int X;
	private int Y;

	/**
	 * @param x X coord
	 * @param y Y coord
	 */
	Vec2(int x, int y) {
		this.X = x;
		this.Y = y;
	}

	/**
	 * @return Returns X coord
	 */
	public int getX() {
		return this.X;
	}

	/**
	 * @return Returns Y coord
	 */
	public int getY() {
		return this.Y;
	}

	/**
	 * @param velx X Velocity
	 * @param vely Y Velocity
	 */
	public void move(float velx, float vely) {
		this.X += (int) velx;
		this.Y += (int) vely;
	}
}

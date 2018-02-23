package com.nullopt;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Car {

	private final int ID;
	private ImageIcon SPRITE;
	private float ROTATION;
	private final Vec2 POSITION;
	private final float VELOCITY = 4;

	Car(int id, ImageIcon sprite, float rotation, Vec2 position) {
		this.ID = id;
		this.SPRITE = sprite;
		this.ROTATION = rotation;
		this.POSITION = position;
	}

	/**
	 * @return Returns current image
	 */
	public Image getImage() {
		return this.SPRITE.getImage();
	}

	/**
	 * @param sprite ImageIcon to set
	 */
	private void setImage(ImageIcon sprite) {
		this.SPRITE = sprite;
	}

	/**
	 * @return Returns current rotation angle
	 */
	private float getRotation() {
		return this.ROTATION;
	}

	/**
	 * @param rot Rotation angle to be set
	 */
	private void setRotation(float rot) {
		this.ROTATION = rot;
	}

	/**
	 * @return Returns current position
	 */
	public Vec2 getPosition() {
		return this.POSITION;
	}

	/**
	 * @param pressedKeys Currently held keys
	 */
	public void move(ArrayList<Boolean> pressedKeys) {
		if (pressedKeys.get(0) && this.ID == 0) {
			float angle = this.getRotation();

			this.forward(angle);
		}

		if (pressedKeys.get(1) && this.ID == 0) {
			float angle = this.getRotation();

			this.backwards(angle);
		}

		if (pressedKeys.get(2) && this.ID == 0) {
			this.setRotation(this.getRotation() - 22.5f);
			if (this.getRotation() < 0f) {
				this.setRotation(360f - 22.5f);
			}
			this.changeImage(0);
		}

		if (pressedKeys.get(3) && this.ID == 0) {
			this.setRotation(this.getRotation() + 22.5f);
			if (this.getRotation() == 360f) {
				this.setRotation(0f);
			}
			if (this.getRotation() > 360f) {
				this.setRotation(22.5f);
			}
			this.changeImage(0);
		}

		if (pressedKeys.get(4) && this.ID == 1) {
			float angle = this.getRotation();

			this.forward(angle);
		}

		if (pressedKeys.get(5) && this.ID == 1) {
			float angle = this.getRotation();

			this.backwards(angle);
		}

		if (pressedKeys.get(6) && this.ID == 1) {
			this.setRotation(this.getRotation() - 22.5f);
			if (this.getRotation() < 0f) {
				this.setRotation(360f - 22.5f);
			}
			this.changeImage(1);
		}

		if (pressedKeys.get(7) && this.ID == 1) {
			this.setRotation(this.getRotation() + 22.5f);
			if (this.getRotation() == 360f) {
				this.setRotation(0f);
			}
			if (this.getRotation() > 360f) {
				this.setRotation(22.5f);
			}
			this.changeImage(1);
		}
	}

	/**
	 * @param angle Angle to extend on.
	 */
	private void backwards(float angle) {
		float yBias;
		float xBias;
		if (angle >= 0 && angle <= 90) {
			yBias = 1 - (angle / 90);
			xBias = 1 - yBias;
			this.getPosition().move((xBias * this.VELOCITY) * -1, yBias * this.VELOCITY);
		} else if (angle >= 91 && angle <= 180) {
			xBias = 1 - ((angle - 90) / 90);
			yBias = 1 - xBias;
			this.getPosition().move((xBias * this.VELOCITY) * -1, (yBias * this.VELOCITY) * -1);
		} else if (angle >= 181 && angle <= 270) {
			yBias = 1 - ((angle - 180) / 90);
			xBias = 1 - yBias;
			this.getPosition().move(xBias * this.VELOCITY, (yBias * this.VELOCITY) * -1);
		} else if (angle >= 271 && angle < 360) {
			xBias = 1 - ((angle - 270) / 90);
			yBias = 1 - xBias;
			this.getPosition().move(xBias * this.VELOCITY, yBias * this.VELOCITY);
		}
	}

	/**
	 * @param angle Angle to extend on
	 */
	private void forward(float angle) {
		float yBias;
		float xBias;
		if (angle >= 0 && angle <= 90) {
			yBias = 1 - (angle / 90);
			xBias = 1 - yBias;
			this.getPosition().move(xBias * this.VELOCITY, (yBias * this.VELOCITY) * -1);
		} else if (angle >= 91 && angle <= 180) {
			xBias = 1 - ((angle - 90) / 90);
			yBias = 1 - xBias;
			this.getPosition().move(xBias * this.VELOCITY, yBias * this.VELOCITY);
		} else if (angle >= 181 && angle <= 270) {
			yBias = 1 - ((angle - 180) / 90);
			xBias = 1 - yBias;
			this.getPosition().move((xBias * this.VELOCITY) * -1, yBias * this.VELOCITY);
		} else if (angle >= 271 && angle < 360) {
			xBias = 1 - ((angle - 270) / 90);
			yBias = 1 - xBias;
			this.getPosition().move((xBias * this.VELOCITY) * -1, (yBias * this.VELOCITY) * -1);
		}
	}

	/**
	 * @param playerId ID of Car
	 */
	private void changeImage(int playerId) {
		this.setImage(new ImageIcon("Images/" + this.getRotation() + (playerId == 0 ? "car.png" : "rac.png")));
	}

	/**
	 * @return Returns Car Width
	 */
	public int getWIDTH() {
		return 50;
	}

	/**
	 * @return Returns Car Height
	 */
	public int getHEIGHT() {
		return 50;
	}
}

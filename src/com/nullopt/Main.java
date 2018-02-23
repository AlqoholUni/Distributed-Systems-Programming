package com.nullopt;

import java.awt.*;

public class Main {

	public static void main(String[] args) {

		EventQueue.invokeLater(() -> {
			Application app = new Application();
			app.setVisible(true);
		});
	}
}

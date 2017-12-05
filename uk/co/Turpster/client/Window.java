package uk.co.Turpster.client;

import javax.swing.JFrame;

public class Window extends JFrame
{
	private static final long serialVersionUID = 1L;

	public Window(String[] args)
	{
		super("War Gauge");
		int width = 800, height = 600;
		
		this.setSize(width + 16, height + 39);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		WarGauge game = new WarGauge(args, width, height);
		this.add(game);
		this.setVisible(true);
		game.start();
	}
}
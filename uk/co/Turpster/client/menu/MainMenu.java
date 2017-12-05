package uk.co.Turpster.client.menu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import uk.co.Turpster.client.WarGauge;

public class MainMenu extends Menu
{
	@Override
	public void render(Graphics g)
	{
		LinkedList<Rectangle> renderRectangleList = new LinkedList<Rectangle>();

		Rectangle startGame = new Rectangle((WarGauge.WIDTH / 2) - 100, (WarGauge.HEIGHT / 2) - 65, 200, 30);
		Rectangle options = new Rectangle((WarGauge.WIDTH / 2) - 100, (WarGauge.HEIGHT / 2) - 15, 200, 30);
		Rectangle quit = new Rectangle((WarGauge.WIDTH / 2) - 100, (WarGauge.HEIGHT / 2) + 35, 200, 30);

		renderRectangleList.add(startGame);
		renderRectangleList.add(options);
		renderRectangleList.add(quit);
		
		Color oldColor = g.getColor();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WarGauge.WIDTH, WarGauge.HEIGHT);

		g.setColor(Color.white);
		for (Rectangle rectangle : renderRectangleList)
		{	
			
			g.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
		}
		g.setColor(oldColor);
	}

	@Override
	public void tick()
	{

	}
}

package uk.co.Turpster.client.menu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import uk.co.Turpster.client.WarGauge;

public class MainMenu extends Menu
{
	LinkedList<Button> renderRectangleList = new LinkedList<Button>();

	public MainMenu()
	{
		Button joinGame = new Button(new Rectangle((WarGauge.WIDTH / 2) - 100, (WarGauge.HEIGHT / 2) - 65, 200, 30));
		Button options = new Button(new Rectangle((WarGauge.WIDTH / 2) - 100, (WarGauge.HEIGHT / 2) - 15, 200, 30));
		Button quit = new Button(new Rectangle((WarGauge.WIDTH / 2) - 100, (WarGauge.HEIGHT / 2) + 35, 200, 30));
		
		joinGame.setText("Join");
		
		options.setText("Options");
		
		quit.setTextColor(new Color(155, 0, 0));
		quit.setText("Quit");
		
		renderRectangleList.add(joinGame);
		renderRectangleList.add(options);
		renderRectangleList.add(quit);
	}
	
	@Override
	public void render(Graphics g)
	{		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WarGauge.WIDTH, WarGauge.HEIGHT);

		for (Button button : renderRectangleList)
		{	
			button.render(g);
		}
			
	}

	@Override
	public void tick()
	{

	}
}

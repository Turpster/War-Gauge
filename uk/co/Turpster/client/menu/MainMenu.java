package uk.co.Turpster.client.menu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import uk.co.Turpster.client.WarGauge;

public class MainMenu extends Menu
{
	Button joinGame, options, quit;

	public MainMenu()
	{
		defineButtons();
	}

	@Override
	public void render(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WarGauge.WIDTH, WarGauge.HEIGHT);
		joinGame.render(g);
		options.render(g);
		quit.render(g);
	}

	@Override
	public void tick()
	{

	}

	public void click(MouseEvent e)
	{
		Point point = e.getPoint();

		Rectangle recPoint = new Rectangle(point.x, point.y, 1, 1);

		if (recPoint.intersects(joinGame.buttonHitbox))
		{
			JOptionPane.showMessageDialog(null, "Join");
		}
		if (recPoint.intersects(options.buttonHitbox))
		{
			JOptionPane.showMessageDialog(null, "Options");
		}
		if (recPoint.intersects(quit.buttonHitbox))
		{
			JOptionPane.showMessageDialog(null, "Quit");
		}

	}

	public void defineButtons() 
	{
		joinGame = new Button(new Rectangle((WarGauge.WIDTH / 2) - 100, (WarGauge.HEIGHT / 2) - 65, 200, 30));
		options = new Button(new Rectangle((WarGauge.WIDTH / 2) - 100, (WarGauge.HEIGHT / 2) - 15, 200, 30));
		quit = new Button(new Rectangle((WarGauge.WIDTH / 2) - 100, (WarGauge.HEIGHT / 2) + 35, 200, 30));

		joinGame.setText("Join");

		options.setText("Options");

		quit.setTextColor(new Color(155, 0, 0));
		quit.setText("Quit");
	}
}

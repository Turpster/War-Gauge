package uk.co.Turpster.client.menu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import uk.co.Turpster.client.WarGauge;

public class MainMenu extends Menu
{
	Button joinGame, options, quit;

	private Image background;
	private Image title;
	
	public MainMenu()
	{
		defineButtons();

		File backgroundFile = new File("C:\\Users\\dicky\\Desktop\\Main-Menu-Background.png");
		File titleFile = new File("C:\\Users\\dicky\\Desktop\\Title.png");
		
		try
		{
			background = ImageIO.read(backgroundFile);
		}
		catch (IOException e) 
		{
			//TODO CHANGE
			System.out.println(backgroundFile.getPath());
		}

		try
		{
			title = ImageIO.read(titleFile);
		}
		catch (IOException e) 
		{
			//TODO CHANGE
			System.out.println(backgroundFile.getPath());
		}

	}

	@Override
	public void render(Graphics g)
	{
		this.renderBackground(g);
		
		g.drawImage(title, (WarGauge.WIDTH / 2) - (title.getWidth(null) / 2), (WarGauge.HEIGHT / 2) - (title.getHeight(null) / 2) - 200, null);
		
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

	private void renderBackground(Graphics g)
	{
		if (background == null)
		{
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, WarGauge.WIDTH, WarGauge.HEIGHT);
		}
		else
		{
			int x = 0;
			int y = 0;
			
			while (x <= WarGauge.WIDTH && y <= WarGauge.HEIGHT)
			{
				g.drawImage(background, x, y, null);
				x += background.getWidth(null);
				if (x >= WarGauge.WIDTH)
				{
					x = 0;
					y += background.getHeight(null);
				}
			}
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

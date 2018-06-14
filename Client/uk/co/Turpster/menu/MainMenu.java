package uk.co.Turpster.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import uk.co.Turpster.WarGauge;
import uk.co.Turpster.menu.components.Button;
import uk.co.Turpster.user.Session;

public class MainMenu extends Menu
{
	Button joinGame, options, quit;

	private Image background;
	private Image title;

	private Session session;
	
	public MainMenu(MenuHandler handler, Session session)
	{
		super(handler);
		this.session = session;

		defineButtons();

		/*
		 * TODO
		 * CHANGE FILE LOCATION TO ASSET FOLDER
		 */
		File backgroundFile = null;
		File titleFile = null;
		backgroundFile = new File(WarGauge.assetsLoc + "\\Main-Menu-Background.png");
		titleFile = new File(WarGauge.assetsLoc + "\\Title.png");

		
		System.out.println(backgroundFile.getAbsolutePath());
		System.out.println(titleFile.getAbsolutePath());
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
		this.renderPlayerInfo(g);

		g.drawImage(title, (WarGauge.WIDTH / 2) - (title.getWidth(null) / 2), (WarGauge.HEIGHT / 2) - (title.getHeight(null) / 2) - 200, null);

		joinGame.render(g);
		options.render(g);
		quit.render(g);
	}

	@Override
	public void tick()
	{

	}

	public void mouseClick(MouseEvent e)
	{
		Point point = e.getPoint();

		Rectangle recPoint = new Rectangle(point.x, point.y, 1, 1);

		if (recPoint.intersects(joinGame.buttonHitbox))
		{
			handler.menuType = MenuType.NONE;
			JOptionPane.showMessageDialog(null, "Join");
		}
		if (recPoint.intersects(options.buttonHitbox))
		{
			MenuHandler.paused = true;
		}
		if (recPoint.intersects(quit.buttonHitbox))
		{
			/*
			 * TODO
			 * Tell if the user is sure he - she wants to exit
			 */
			System.exit(0);
		}
	}

	private void renderPlayerInfo(Graphics g)
	{
		/*
		 * TODO
		 * ADD PLAYER MODEL IMAGE
		 */

		Font oldFont = g.getFont();
		Color oldColor = g.getColor();

		g.setFont(new Font("DotumChe Pixel", Font.PLAIN, 13));
		g.setColor(Color.WHITE);
		g.drawString("You are logged into: ", (WarGauge.WIDTH) - 320, 25);
		if (session.validate())
		{
			g.setColor(new Color(100, 255, 155));
		}
		else
		{
			g.setColor(new Color(255, 155, 100));
		}
		
		WarGauge.drawCenteredString(g, session.username, new Rectangle(WarGauge.WIDTH - 281, 33, 100, 10), g.getFont(), g.getColor());
		g.setColor(oldColor);
		g.setFont(oldFont);
	}

	public void renderBackground(Graphics g)
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

			int widthMultiplier = 6;
			int heightMultiplier = 6;

			while (x <= WarGauge.WIDTH && y <= WarGauge.HEIGHT)
			{
				g.drawImage(background, x, y, background.getWidth(null) * widthMultiplier, background.getHeight(null) * heightMultiplier, null);
				x += background.getWidth(null) * widthMultiplier;
				if (x >= WarGauge.WIDTH)
				{
					x = 0;
					y += background.getHeight(null) * heightMultiplier;
				}
			}
		}
	}
	
	@Override
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

package uk.co.Turpster.menu.options;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import uk.co.Turpster.WarGauge;
import uk.co.Turpster.menu.Menu;
import uk.co.Turpster.menu.MenuHandler;
import uk.co.Turpster.menu.components.Button;
import uk.co.Turpster.user.Session;

public class OptionsMenuMain extends Menu
{
	Button gameplay, graphics, playerOptions, back;
	
	private Session session;
	private MenuHandler menuHandler;
	
	public OptionsMenuMain(MenuHandler menuHandler, Session session)
	{
		super(menuHandler);
		
		this.menuHandler = menuHandler;
		this.session = session;
		
		defineButtons();
	}
	
	@Override
	public void mouseClick(MouseEvent e) 
	{
		Rectangle point = new Rectangle(e.getX(), e.getY(), 1, 1);
		
		if (point.intersects(back.getButtonHitbox()))
		{
			MenuHandler.paused = false;
		}
		else if (point.intersects(playerOptions.getButtonHitbox()))
		{
			if (session.validate())
			{
				menuHandler.optionMenu = OptionsMenuType.PLAYEROPTIONS;
			}
			else
			{
				/*
				 * TODO
				 * Show JOptionPane in custom message window
				 */
				JOptionPane.showMessageDialog(null, "Your session is invalid, player settings are not found.", "Player", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if (point.intersects(gameplay.buttonHitbox))
		{
			menuHandler.optionMenu = OptionsMenuType.GAMEPLAY;
		}
		else if (point.intersects(graphics.buttonHitbox))
		{
			menuHandler.optionMenu = OptionsMenuType.GRAPHICS;
		}
	}
	@Override
	public void render(Graphics g) 
	{
		gameplay.render(g);
		graphics.render(g);
		playerOptions.render(g);
		back.render(g);
	}
	
	@Override
	public void tick() 
	{
		
	}

	@Override
	public void defineButtons()
	{
		gameplay = new Button(new Rectangle((WarGauge.WIDTH / 2) - 100, (WarGauge.HEIGHT / 2) - 95, 200, 30));
		graphics = new Button(new Rectangle((WarGauge.WIDTH / 2) - 100, (WarGauge.HEIGHT / 2) - 45, 200, 30));
		playerOptions = new Button(new Rectangle((WarGauge.WIDTH / 2) - 100, (WarGauge.HEIGHT / 2) + 5, 200, 30));
		back = new Button(new Rectangle((WarGauge.WIDTH / 2) - 100, (WarGauge.HEIGHT / 2) + 55, 200, 30));
		
		gameplay.setText("Gameplay");
		graphics.setText("Graphics");
		playerOptions.setText("Player Options");
		back.setText("Back");
		back.setTextColor(new Color(155, 0, 0));
	}
}

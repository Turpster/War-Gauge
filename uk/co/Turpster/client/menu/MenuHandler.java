package uk.co.Turpster.client.menu;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import uk.co.Turpster.client.Renderable;
import uk.co.Turpster.client.Tickable;
import uk.co.Turpster.client.WarGauge;
import uk.co.Turpster.client.menu.options.OptionsMenuGameplay;
import uk.co.Turpster.client.menu.options.OptionsMenuGraphics;
import uk.co.Turpster.client.menu.options.OptionsMenuMain;
import uk.co.Turpster.client.menu.options.OptionsMenuPlayerOptions;
import uk.co.Turpster.client.menu.options.OptionsMenuType;
import uk.co.Turpster.client.user.Session;

public class MenuHandler implements Renderable, Tickable 
{
	public MenuType menuType;
	public static boolean paused = false;
	MainMenu mainMenu;
	OptionsMenuMain optionsMenu;
		public OptionsMenuType optionMenu = OptionsMenuType.MAIN;
		OptionsMenuGameplay optionsGameplay;
		OptionsMenuGraphics optionsGraphics;
		OptionsMenuPlayerOptions optionsPlayerMenu;

	WarGauge warGuage;

	public MenuHandler(Session session, WarGauge warGuage) 
	{
		this.warGuage = warGuage;
		mainMenu = new MainMenu(this, session);
		optionsMenu = new OptionsMenuMain(this, session);
		optionsGameplay = new OptionsMenuGameplay(this);
		optionsGraphics = new OptionsMenuGraphics(this);
		optionsPlayerMenu = new OptionsMenuPlayerOptions(this);
		
		menuType = MenuType.MAIN;

	}

	@Override
	public void tick()
	{

	}

	@Override
	public void render(Graphics g) 
	{
		if (menuType == MenuType.MAIN)
		{
			if (paused)
			{
				if (optionMenu == OptionsMenuType.MAIN)
				{
					mainMenu.renderBackground(g);
					optionsMenu.render(g);
				}
				else if (optionMenu == OptionsMenuType.GAMEPLAY)
				{
					mainMenu.renderBackground(g);
					optionsGameplay.render(g);
				}
				else if (optionMenu == OptionsMenuType.GRAPHICS)
				{
					mainMenu.renderBackground(g);
					optionsGraphics.render(g);
				}
				else if (optionMenu == OptionsMenuType.PLAYEROPTIONS)
				{
					mainMenu.renderBackground(g);
					optionsPlayerMenu.render(g);
				}
			}
			else
			{
				mainMenu.render(g);
			}
		}
		else return;	
	}

	public void refreshSize()
	{
		mainMenu.defineButtons();
	}

	public void click(MouseEvent e) 
	{
		if (menuType == MenuType.MAIN)
		{
			if (paused)
			{
				if (optionMenu == OptionsMenuType.MAIN)
				{
					optionsMenu.click(e);
				}
				else if (optionMenu == OptionsMenuType.GAMEPLAY)
				{
					optionsGameplay.click(e);
				}
				else if (optionMenu == OptionsMenuType.GRAPHICS)
				{
					optionsGraphics.click(e);
				}
				else if (optionMenu == OptionsMenuType.PLAYEROPTIONS)
				{
					optionsPlayerMenu.click(e);
				}
			}
			else
			{
				mainMenu.click(e);
			}
		}
	}
}

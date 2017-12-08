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
	public OptionsMenuType optionMenu = OptionsMenuType.MAIN;
		OptionsMenuMain optionsMenu;
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

	public void mouseClick(MouseEvent e) 
	{
		if (menuType == MenuType.MAIN)
		{
			if (paused)
			{
				if (optionMenu == OptionsMenuType.MAIN)
				{
					optionsMenu.mouseClick(e);
				}
				else if (optionMenu == OptionsMenuType.GAMEPLAY)
				{
					optionsGameplay.mouseClick(e);
				}
				else if (optionMenu == OptionsMenuType.GRAPHICS)
				{
					optionsGraphics.mouseClick(e);
				}
				else if (optionMenu == OptionsMenuType.PLAYEROPTIONS)
				{
					optionsPlayerMenu.mouseClick(e);
				}
			}
			else
			{
				mainMenu.mouseClick(e);
			}
		}
	}
	
	public void mousePress(MouseEvent e)
	{
		if (menuType == MenuType.MAIN)
		{
			if (paused)
			{
				if (optionMenu == OptionsMenuType.MAIN)
				{
					optionsMenu.mousePress(e);
				}
				else if (optionMenu == OptionsMenuType.GAMEPLAY)
				{
					optionsGameplay.mousePress(e);
				}
				else if (optionMenu == OptionsMenuType.GRAPHICS)
				{
					optionsGraphics.mousePress(e);
				}
				else if (optionMenu == OptionsMenuType.PLAYEROPTIONS)
				{
					optionsPlayerMenu.mousePress(e);
				}
			}
			else
			{
				mainMenu.mousePress(e);
			}
		}
	}
	public void mouseReleased(MouseEvent e)
	{
		if (menuType == MenuType.MAIN)
		{
			if (paused)
			{
				if (optionMenu == OptionsMenuType.MAIN)
				{
					optionsMenu.mouseRelease(e);
				}
				else if (optionMenu == OptionsMenuType.GAMEPLAY)
				{
					optionsGameplay.mouseRelease(e);
				}
				else if (optionMenu == OptionsMenuType.GRAPHICS)
				{
					optionsGraphics.mouseRelease(e);
				}
				else if (optionMenu == OptionsMenuType.PLAYEROPTIONS)
				{
					optionsPlayerMenu.mouseRelease(e);
				}
			}
			else
			{
				mainMenu.mouseRelease(e);
			}
		}
	}
	public void mouseUpdate(MouseEvent e)
	{
		if (menuType == MenuType.MAIN)
		{
			if (paused)
			{
				if (optionMenu == OptionsMenuType.MAIN)
				{
					optionsMenu.mouseUpdate(e);
				}
				else if (optionMenu == OptionsMenuType.GAMEPLAY)
				{
					optionsGameplay.mouseUpdate(e);
				}
				else if (optionMenu == OptionsMenuType.GRAPHICS)
				{
					optionsGraphics.mouseUpdate(e);
				}
				else if (optionMenu == OptionsMenuType.PLAYEROPTIONS)
				{
					optionsPlayerMenu.mouseUpdate(e);
				}
			}
			else
			{
				mainMenu.mouseUpdate(e);
			}
		}
	}
	
}

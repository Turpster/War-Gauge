package uk.co.Turpster.client.menu;

import java.awt.Graphics;

import uk.co.Turpster.client.Renderable;
import uk.co.Turpster.client.Tickable;

public class MenuHandler implements Renderable, Tickable 
{
	MenuType menuType;
	
	MainMenu mainMenu;
	
	public MenuHandler() 
	{
		mainMenu = new MainMenu();
		menuType = MenuType.MAIN;
	}
	
	@Override
	public void tick()
	{

	}

	@Override
	public void render(Graphics g) 
	{
		switch(menuType)
		{
		case MAIN:
			mainMenu.tick();
			mainMenu.render(g);
		case PAUSE:
		
		case GRAPHICS:
		
		case OPTIONS:
			
		
		default:
			return;	
		}
	}

	public void refreshSize()
	{
		mainMenu.defineButtons();
	}
}

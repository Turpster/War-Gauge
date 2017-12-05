package uk.co.Turpster.client.menu;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import uk.co.Turpster.client.Renderable;
import uk.co.Turpster.client.Tickable;
import uk.co.Turpster.client.WarGauge;

public class MenuHandler implements Renderable, Tickable 
{
	MenuType menuType;
	
	MainMenu mainMenu;
	
	WarGauge warGuage;
	
	public MenuHandler(WarGauge warGuage) 
	{
		this.warGuage = warGuage;
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

	public void click(MouseEvent e) 
	{
		switch(menuType)
		{
		case MAIN:
			mainMenu.click(e);
		case PAUSE:
		
		case GRAPHICS:
		
		case OPTIONS:
			
		
		default:
			return;	
		}
	}
}

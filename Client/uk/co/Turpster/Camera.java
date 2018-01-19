package uk.co.Turpster;

import java.awt.Graphics;

import uk.co.Turpster.Renderable;
import uk.co.Turpster.Tickable;
import uk.co.Turpster.menu.MenuHandler;

public class Camera implements Renderable, Tickable
{
	MenuHandler menuManager;
	
	public Camera()
	{
		
	}
	
	@Override
	public void tick()
	{
		menuManager.tick();
	}
	@Override
	public void render(Graphics g)
	{
		menuManager.render(g);
	}
}

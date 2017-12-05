package uk.co.Turpster.client;

import java.awt.Graphics;

import uk.co.Turpster.client.menu.MenuHandler;

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
